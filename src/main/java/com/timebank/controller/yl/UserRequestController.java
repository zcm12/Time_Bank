package com.timebank.controller.yl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timebank.appmodel.ReqestApp;
import com.timebank.appmodel.ResultModel;
import com.timebank.domain.*;
import com.timebank.mapper.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Controller
public class UserRequestController {
    @Autowired
    private ReqestMapper reqestMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private RespondMapper respondMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private WeightMapper weightMapper;
    @Autowired
    private CommunityMapper communityMapper;

    // 请求的guid
    String updateRequestGuid = null;

    private Users GetCurrentUsers(String message){

        UsersExample usersExample=new UsersExample();
        Users users=null;
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";
        if(message.matches(ph)){
            usersExample.or().andUserPhoneEqualTo(message);
            List<Users> usersList = usersMapper.selectByExample(usersExample);
            users = usersList.get(0);

        }else if( message.matches(em)){
            usersExample.or().andUserMailEqualTo(message);
            List<Users> usersList = usersMapper.selectByExample(usersExample);
            users = usersList.get(0);
        } else {
            usersExample.or().andUserAccountEqualTo(message);
            List<Users> usersList = usersMapper.selectByExample(usersExample);
            users = usersList.get(0);
        }
        return users;
    }
    /**********************************发布需求**************************************************/
    //besepage页面的发布请求
    @RequestMapping(value = "/createRequestByUserView")
    public String userApply(Model model)
    {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);
        if(role.equals("USE")){
        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGroupIdEqualTo(4);
        List<Type> types = typeMapper.selectByExample(typeExample);
        model.addAttribute("types",types);
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGroupIdEqualTo(5);
        List<Type> typex = typeMapper.selectByExample(typeExample);
        model.addAttribute("typex",typex);
            insertReqType(model,true);
        //判断是否只有一条请求正在处理
            int flag=2;
            String GUID=users1.getUserGuid();
            ReqestExample reqestExample=new ReqestExample();
            List<Reqest> reqests=reqestMapper.selectByExample(reqestExample);
            for(Reqest it:reqests) {
                //判断自己发布的请求
                if (it.getReqIssueUserGuid().equals(GUID)) {
                    //排除已完成 未完成 撤销的请求
                    if (!(it.getReqTypeGuidProcessStatus().equals("33333333-94E3-4EB7-AAD3-555555555555")
                            || it.getReqTypeGuidProcessStatus().equals("33333333-94E3-4EB7-AAD3-666666666666")
                            || it.getReqTypeGuidProcessStatus().equals("33333333-94E3-4EB7-AAD3-444444444444")
                            || it.getReqTypeGuidProcessStatus().equals("33333333-94E3-4EB7-AAD3-777777777777"))) {
                        flag = 1;
                        break;
                    }
                }
            }
            System.out.println(flag);
            model.addAttribute("message",flag);
        return "apply";
        }else{
            //所属小区
            CommunityExample communityExample = new CommunityExample();
            List<Community> communities = communityMapper.selectByExample(communityExample);
            model.addAttribute("communities",communities);
//            model.addAttribute("users",users1);
            //加载性别
            TypeExample typeExample = new TypeExample();
            typeExample.or().andTypeGroupIdEqualTo(1);
            List<Type> types = typeMapper.selectByExample(typeExample);
            model.addAttribute("types",types);
            //处理时间格式
            if (users1.getUserBirthdate()!=null)
            {
                java.util.Date d=new java.util.Date (users1.getUserBirthdate().getTime());
                model.addAttribute("date",d);
                SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
                f.format(d);
                System.out.println(d);
            }
            model.addAttribute("users", users1);
            model.addAttribute("message","请先完善个人信息");
            if(users1.getUserBirthdate()!=null){
                model.addAttribute("message1",users1.getUserIdimage());
            }else{
                model.addAttribute("message1","/img/qie.jpg");
            }

            return "updateUserInformation";
        }
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    private TypeExample insertReqType(Model model,boolean showProAndAppStatus) throws Exception{
        TypeExample typeExample = new TypeExample();
        if (showProAndAppStatus) {
            //请求处理状态
            typeExample.or().andTypeGroupIdEqualTo(3);
            List<Type> type1 = typeMapper.selectByExample(typeExample);
            model.addAttribute("type1", type1);

            typeExample.clear();
            //请求批准状态
            typeExample.or().andTypeGroupIdEqualTo(8);
            List<Type> type4 = typeMapper.selectByExample(typeExample);
            model.addAttribute("type4", type4);
        }
        typeExample.clear();
        //请求分类
        typeExample.or().andTypeGroupIdEqualTo(4);
        List<Type> type2 = typeMapper.selectByExample(typeExample);
        model.addAttribute("type2", type2);

        typeExample.clear();
        //请求紧急程度
        typeExample.or().andTypeGroupIdEqualTo(5);
        List<Type> type3 = typeMapper.selectByExample(typeExample);
        model.addAttribute("type3", type3);

        //请求权重
        WeightExample weightExample = new WeightExample();
        List<Weight> weights = weightMapper.selectByExample(weightExample);
        model.addAttribute("weights", weights);

        return typeExample;
    }


    //发布需求保存按钮
    @RequestMapping(value = "/applySubmit")
    public String applySubmit(Reqest reqest, Model model,String jd,String wd)
    {
        try{

        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);
        System.out.println(jd);
        System.out.println(wd);
        //经纬度不为空，不为null
        if(!(jd!=null||wd!=null)){
            return "apply";
        }
        if(jd.length()==0||wd.length()==0){
            return "apply";
        }
        //请求提交
        UUID guid=randomUUID();
        reqest.setReqGuid(guid.toString());
        reqest.setReqIssueUserGuid(users1.getUserGuid());
        reqest.setReqProcessUserGuid(users1.getUserGuid());
        //请求提出的时间设定为当前时间
        Date date = new Date();
        reqest.setReqIssueTime(date);
        reqest.setReqDispatchTime(date);

        //将请求批准状态先置为待审核
        Type type = typeMapper.selectByPrimaryKey("88888888-94e3-4eb7-aad3-333333333333");
        reqest.setReqTypeApproveStatus(type.getTypeGuid());
        //将请求处理状态先置为未启动
        Type type1 = typeMapper.selectByPrimaryKey("33333333-94e3-4eb7-aad3-111111111111");
        //设置请求处理人（用户发布需求后 默认请求处理人为NULL 防止出现空指针异常）
        reqest.setReqTypeGuidProcessStatus(type1.getTypeGuid());

        //从前端获取 估计消耗的时间币/
        Users users2=usersMapper.selectByPrimaryKey(users1.getUserGuid());
        double premoney=reqest.getReqPreCunsumeCurrency();
        double userOwnCurrency = users2.getUserOwnCurrency();
//        double userOwnCurrency = users1.getUserOwnCurrency();
        if (userOwnCurrency<0) {
            return "wrongCurrency";
        }else {
            //如果时间币大于0，就先从用户拥有时间币中扣除估计消耗的时间币/
//            System.out.println("是否进入判断？？？？？？？？？");
            Double newuserOwnCurrency=userOwnCurrency-premoney;
//            System.out.println("此时的时间币因该是？"+newuserOwnCurrency);
            //将扣除后的时间币设置到用户的拥有时间币中/
            users2.setUserOwnCurrency(newuserOwnCurrency);
            usersMapper.updateByPrimaryKeySelective(users2);


        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(jd);
        stringBuilder.append(",");
        stringBuilder.append(wd);
        stringBuilder.append(",");
        stringBuilder.append(reqest.getReqAddress());
        String add=""+stringBuilder;
        reqest.setReqAddress(add);
        reqestMapper.insert(reqest);
        return "applyListView";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

/**********************查看我的需求*******************************/
    //导航栏左边 查看我的需求
    @RequestMapping(value = "/requestListByUserView")
    public String requestListByUserView(Model model)
    {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        return "applyListView";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    //查看需求界面加载数据 从数据库加载数据
    @RequestMapping(value="/getREQESTListJsonData",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJsonDataFromReqest(@RequestParam int offset, int limit, String sortName,String sortOrder, String searchText){
        //获得当前用户
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
//        String role=users11.getUserRole();
//        model.addAttribute("role",role);

        /**10.9添加*/
        if (searchText == "") {
            searchText = null;
        }
        /**10.9添加*/

        ReqestExample reqestExample=new ReqestExample();
        reqestExample.clear();
        //处理排序信息
        if(sortName!=null){
            //拼接字符串
            String order= GetDatabaseFileName(sortName)+" "+sortOrder;
            //将排序信息添加到example中
            reqestExample.setOrderByClause(order);
        }
        //获取当前登陆者id 判断时候否为自己发布的需求
        String userID =users11.getUserGuid();
        reqestExample.or().andReqIssueUserGuidEqualTo(userID);
        List<Reqest> reqests=reqestMapper.selectByExample(reqestExample);
        List<Reqest> reqestRecordList=new ArrayList<>();
//        for(int i=offset;i< offset+limit&&i < reqests.size();i++){
        for(int i=0;i < reqests.size();i++){
            Reqest reqest1=reqests.get(i);
            TypeExample typeExample = new TypeExample();
            String reqTypeGuidClass=reqest1.getReqTypeGuidClass();
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(reqTypeGuidClass);
            List<Type> types = typeMapper.selectByExample(typeExample);
            reqest1.setReqTypeGuidClass(types.get(0).getTypeTitle());
            String reqTypeGuidUrgency=reqest1.getReqTypeGuidUrgency();
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(reqTypeGuidUrgency);
            List<Type> types1 = typeMapper.selectByExample(typeExample);
            reqest1.setReqTypeGuidUrgency(types1.get(0).getTypeTitle());
            //处理请求处理状态
            String approveId = reqest1.getReqTypeApproveStatus();
            if (approveId != null)
            {
                typeExample.clear();
                typeExample.or().andTypeGuidEqualTo(approveId);
                List<Type> types2 = typeMapper.selectByExample(typeExample);
                reqest1.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            }
            //处理请求批准状态
            String processId = reqest1.getReqTypeGuidProcessStatus();
            if (processId != null)
            {
                typeExample.clear();
                typeExample.or().andTypeGuidEqualTo(processId);
                List<Type> types2 = typeMapper.selectByExample(typeExample);
                reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
            }
//            reqestRecordList.add(reqest1);

            /**10.9添加*/
            if (searchText != null) {
                String reqTitle = reqest1.getReqTitle();//标题搜索
                if(!(reqTitle!=null)){
                    reqTitle="";
                }
                String reqUserAccount = reqest1.getReqIssueUserGuid();//账户搜索
                if(!(reqUserAccount!=null)){
                    reqUserAccount="";
                }
                String reqAddress = reqest1.getReqAddress();//地址搜索
                if(!(reqAddress!=null)){
                    reqAddress="";
                }
                String reqClass=reqest1.getReqTypeGuidClass();//请求分类搜索
                if(!(reqClass!=null)){
                    reqClass="";
                }
                String reqUrgent=reqest1.getReqTypeGuidUrgency();//紧急程度搜索
                if(!(reqUrgent!=null)){
                    reqUrgent="";
                }
                String reqDescribe=reqest1.getReqDesp();//描述搜索
                if(!(reqDescribe!=null)){
                    reqDescribe="";
                }
                String reqComm=reqest1.getReqComment();//补充搜索
                if(!(reqComm!=null)){
                    reqComm="";
                }
                if (reqTitle.contains(searchText) || reqUserAccount.contains(searchText) || reqAddress.contains(searchText)||reqClass.contains(searchText)||reqUrgent.contains(searchText)||reqDescribe.contains(searchText)||reqComm.contains(searchText)) {
                    reqestRecordList.add(reqest1);
                }
            } else {
                reqestRecordList.add(reqest1);
            }
            /**10.9添加*/
        }

        /**10.9添加*/
        List<Reqest> reqestsReturn = new ArrayList<>();
        for (int i = offset;i<offset+limit&&i<reqestRecordList.size();i++){
            reqestsReturn.add(reqestRecordList.get(i));
        }

        /**10.9添加*/


        //全部符合要求的数据的数量
//        int total=reqests.size();
        int total=reqestRecordList.size();
        //将所得集合打包
        ObjectMapper mapper = new ObjectMapper();
//        TableRecordsJson tableRecordsJson=new TableRecordsJson(reqestRecordList,total);
        TableRecordsJson tableRecordsJson=new TableRecordsJson(reqestsReturn,total);
        //将实体类转换成json数据并返回
        try {
            String json1 = mapper.writeValueAsString(tableRecordsJson);
            // System.out.println(json1);
            return json1;
        }catch (Exception e){
            return null;
        }
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    private String GetDatabaseFileName(String str) throws Exception
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();++i)
        {
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
            {
                sb.append('_');
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //我的需求中的查看详情
    @RequestMapping(value = "/listREQESTModel/{reqGuid}")
    public String listREQESTModel (@PathVariable String reqGuid , UpdateList updateList, Model model) {
      try{
        model.addAttribute("reqGuid",reqGuid);
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid);

        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidClass());
        List<Type> types = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidClass(types.get(0).getTypeTitle());
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidUrgency());
        List<Type> typex = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidUrgency(typex.get(0).getTypeTitle());
        //处理请求批准状态
        String approveId = reqest.getReqTypeApproveStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (approveId != null)
        {
            System.out.println("进入查看详情判断请求批准状态");
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(approveId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //处理请求处理状态
        //String approveId = reqest.getReqTypeApproveStatus();
        String processId = reqest.getReqTypeGuidProcessStatus();
        if (processId != null)
        {
            System.out.println("进入查看详情判断请求处理状态");
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(processId); //筛选
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            //reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            reqest.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //TODO 请求批准状态为待审核
        if (approveId.equals("88888888-94E3-4EB7-AAD3-333333333333") )
        {
            System.out.println("逻辑判断请求批准状态为待审核");
            updateList.setUpdateId(1);
            updateList.setDeletaId(1);
            updateList.setStartId(0);
            updateList.setViewVolId(0);
            updateList.setFinishId(0);
            updateList.setUnFinishId(0);
            updateList.setWaitId(0);
            updateList.setEvaluateId(0);
            model.addAttribute("updateList",updateList);
        }else if(approveId.equals("88888888-94E3-4EB7-AAD3-222222222222"))
        {
            System.out.println("逻辑判断请求批准状态为驳回");
            //TODO 请求批准状态为驳回
            updateList.setUpdateId(0);
            updateList.setDeletaId(1);
            updateList.setStartId(0);
            updateList.setViewVolId(0);
            updateList.setFinishId(0);
            updateList.setUnFinishId(0);
            updateList.setWaitId(0);
            updateList.setEvaluateId(0);
            model.addAttribute("updateList",updateList);
        }else if (approveId.equals("88888888-94E3-4EB7-AAD3-111111111111"))
        {
//            System.out.println("逻辑判断请求批准状态为通过");
//            //TODO 请求批准状态为通过
//            updateList.setUpdateId(1);
//            updateList.setDeletaId(1);
//            updateList.setStartId(0);
//            updateList.setViewVolId(1);
//            updateList.setFinishId(0);
//            updateList.setUnFinishId(0);
//            updateList.setWaitId(1);
//            updateList.setEvaluateId(0);
//            model.addAttribute("updateList",updateList);
//        }
//        else {
            if (processId.equals("33333333-94E3-4EB7-AAD3-666666666666"))
            {
                System.out.println("逻辑判断请求处理状态为撤销");
                //TODO 请求处理状态为撤销
                updateList.setUpdateId(0);
                updateList.setDeletaId(0);
                updateList.setStartId(0);
                updateList.setViewVolId(1);
                updateList.setFinishId(0);
                updateList.setUnFinishId(0);
                updateList.setWaitId(0);
                updateList.setEvaluateId(0);
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-111111111111")){
                System.out.println("逻辑判断请求处理状态为未启动");
                //TODO 请求处理状态为未启动
                updateList.setUpdateId(0);//更新
                updateList.setDeletaId(1);//撤销
                updateList.setStartId(0);//启动
                updateList.setViewVolId(0);//查看志愿者
                updateList.setFinishId(0);//完成
                updateList.setUnFinishId(0);//未完成
                updateList.setWaitId(1);//待启动
                updateList.setEvaluateId(0);//评价
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-222222222222")){
                System.out.println("逻辑判断请求处理状态为待启动");
                //TODO 请求处理状态为待启动
                updateList.setUpdateId(0);
                updateList.setDeletaId(1);
                updateList.setStartId(1);
                updateList.setViewVolId(1);
                updateList.setFinishId(0);
                updateList.setUnFinishId(0);
                updateList.setWaitId(0);
                updateList.setEvaluateId(0);
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-333333333333")) {
                //TODO 请求处理状态为启动
                updateList.setUpdateId(0);
                updateList.setDeletaId(1);
                updateList.setStartId(0);
                updateList.setViewVolId(1);
                updateList.setFinishId(1);
                updateList.setUnFinishId(1);
                updateList.setWaitId(0);
                updateList.setEvaluateId(0);
                model.addAttribute("updateList",updateList);

            }  else if (processId.equals("33333333-94E3-4EB7-AAD3-555555555555")) {
                //TODO 请求处理状态为未完成
                updateList.setUpdateId(0);
                updateList.setDeletaId(1);
                updateList.setStartId(0);
                updateList.setViewVolId(1);
                updateList.setFinishId(0);
                updateList.setUnFinishId(0);
                updateList.setWaitId(0);
                updateList.setEvaluateId(0);
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-444444444444")) {
                //TODO 请求处理状态为已完成
                updateList.setUpdateId(0);
                updateList.setDeletaId(1);
                updateList.setStartId(0);
                updateList.setViewVolId(1);
                updateList.setFinishId(0);
                updateList.setUnFinishId(0);
                updateList.setWaitId(0);
                updateList.setEvaluateId(1);
                model.addAttribute("updateList",updateList);
            }
            else if (processId.equals("33333333-94E3-4EB7-AAD3-777777777777")) {
                //TODO 请求处理状态为已完成未评价
                updateList.setUpdateId(0);
                updateList.setDeletaId(1);
                updateList.setStartId(0);
                updateList.setViewVolId(1);
                updateList.setFinishId(0);
                updateList.setUnFinishId(0);
                updateList.setWaitId(0);
                updateList.setEvaluateId(1);
                model.addAttribute("updateList",updateList);
            }
        }
        model.addAttribute("reqest",reqest);

        return "listRequestModel";
      }catch(Exception e){
          e.printStackTrace();
          return "fail";
      }
    }
        ///********10.19添加修改*************/
        //查看我的服务列表中的查看详情
        @RequestMapping(value = "/listREQESTModel22/{reqGuid}")
        public String listREQESTModel22 (@PathVariable String reqGuid , UpdateList updateList, Model model) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid);

        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidClass());
        List<Type> types = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidClass(types.get(0).getTypeTitle());
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidUrgency());
        List<Type> typex = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidUrgency(typex.get(0).getTypeTitle());
        //处理请求批准状态
        String approveId = reqest.getReqTypeApproveStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (approveId != null)
        {
            System.out.println("进入查看详情判断请求批准状态");
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(approveId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //处理请求处理状态
        //String approveId = reqest.getReqTypeApproveStatus();
        String processId = reqest.getReqTypeGuidProcessStatus();
        if (processId != null)
        {
            System.out.println("进入查看详情判断请求处理状态");
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(processId); //筛选
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            //reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            reqest.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
//        //TODO 请求批准状态为待审核
        if (approveId.equals("88888888-94E3-4EB7-AAD3-333333333333") )
        {
            System.out.println("逻辑判断请求批准状态为待审核");
            updateList.setDeletaId(0);
            model.addAttribute("updateList",updateList);
        }else if(approveId.equals("88888888-94E3-4EB7-AAD3-222222222222"))
        {
            System.out.println("逻辑判断请求批准状态为驳回");
            //TODO 请求批准状态为驳回
            updateList.setDeletaId(0);
            model.addAttribute("updateList",updateList);
        }else
          if (approveId.equals("88888888-94E3-4EB7-AAD3-111111111111"))
        {
            if (processId.equals("33333333-94E3-4EB7-AAD3-666666666666"))
            {
                System.out.println("逻辑判断请求处理状态为撤销");
                //TODO 请求处理状态为撤销
                updateList.setDeletaId(0);
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-111111111111")){
                System.out.println("逻辑判断请求处理状态为未启动");
                //TODO 请求处理状态为未启动
                updateList.setDeletaId(0);//撤销
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-222222222222")){
                System.out.println("逻辑判断请求处理状态为待启动");
                //TODO 请求处理状态为待启动
                updateList.setDeletaId(1);
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-333333333333")) {
                //TODO 请求处理状态为启动
                updateList.setDeletaId(0);
                model.addAttribute("updateList",updateList);

            }  else if (processId.equals("33333333-94E3-4EB7-AAD3-555555555555")) {
                //TODO 请求处理状态为未完成
                updateList.setDeletaId(0);
                model.addAttribute("updateList",updateList);
            }else if (processId.equals("33333333-94E3-4EB7-AAD3-444444444444")) {
                //TODO 请求处理状态为已完成
                updateList.setDeletaId(0);
                model.addAttribute("updateList",updateList);
            }
            else if (processId.equals("33333333-94E3-4EB7-AAD3-777777777777")) {
                //TODO 请求处理状态为已完成未评价
                updateList.setDeletaId(0);
                model.addAttribute("updateList",updateList);
            }
        }
        model.addAttribute("reqest",reqest);
        return "listRequestModel22";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
//    /*********************/
    //查看详情界面中的更新请求
    @RequestMapping(value = "/updateREQEST")
    public String updateREQEST (UpdateList updateList,Model model,String reqGuid2) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        //TODO 根据传递过来的reqGuid
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid2);
        model.addAttribute("reqest",reqest);

        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGroupIdEqualTo(5);
        List<Type> typex = typeMapper.selectByExample(typeExample);
        model.addAttribute("types",typex);
        typeExample.clear();
        typeExample.or().andTypeGroupIdEqualTo(4);
        List<Type> types = typeMapper.selectByExample(typeExample);
        model.addAttribute("types1",types);
        //TODO 点击更新请求按钮以后
        updateList.setUpdateId(0);
        updateList.setDeletaId(1);
        updateList.setStartId(0);
        updateList.setViewVolId(1);
        updateList.setFinishId(0);
        updateList.setUnFinishId(0);
        updateList.setWaitId(1);
        updateList.setEvaluateId(0);
        model.addAttribute("updateList",updateList);
        return "updateReqestView";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping(value = "/updateREQESTSave")
    public String updateREQESTSave(Reqest reqest, Model model){
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);

        reqestMapper.updateByPrimaryKeySelective(reqest);
        return "applyListView";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    //老人进行撤单操作
    @RequestMapping(value = "/deleteREQEST")
    public String deleteRESPOND (UpdateList updateList,Model model,String reqGuid4) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid4);
        //更新请求表
        reqest.setReqTypeGuidProcessStatus("33333333-94E3-4EB7-AAD3-666666666666");
        reqestMapper.updateByPrimaryKeySelective(reqest);
        //TODO 老人进行了撤单的同时，将所有申请过这个单的志愿者的状态也改为撤单，这个撤单是老人的撤单，不是志愿者的撤单
        RespondExample respondExample = new RespondExample();
        respondExample.or().andResReqGuidEqualTo(reqGuid4);
        List<Respond> responds = respondMapper.selectByExample(respondExample);
        if (responds!=null && responds.size()!=0)
        {
            for (Respond respondAfter : responds)
            {
//                respondAfter.setResTypeGuidProcessStatus("33333333-94E3-4EB7-AAD3-666666666666");
                respondAfter.setResTypeGuidProcessStatus("77777777-94E3-4EB7-AAD3-555555555555");
                respondMapper.updateByPrimaryKey(respondAfter);
            }
        }
        //TODO 点击撤销按钮以后
        updateList.setUpdateId(0);
        updateList.setDeletaId(0);
        updateList.setStartId(0);
        updateList.setViewVolId(1);
        updateList.setFinishId(0);
        updateList.setUnFinishId(0);
        updateList.setWaitId(0);
        updateList.setEvaluateId(0);
        model.addAttribute("updateList",updateList);

        return "applyListView";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    //查看志愿者接单情况
    @RequestMapping(value = "/volunteerListOfApply")
    public String volunteerListOfApply (Model model,String reqGuid3) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);

        System.out.println("SDFS"+reqGuid3);
        model.addAttribute("message",reqGuid3);
//        reqGuidOfVol = reqGuid6;
        return "volunteerList";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    //查看志愿者接单情况 从后台获取数据
    @RequestMapping(value="/getVolunteerListJsonData",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getVolunteerListJsonData(@RequestParam int offset, int limit, String sortName, String sortOrder, String reqGuid){
        //删除按钮再次跳到这个界面  为什么没有记录了
        try {
            System.out.println(reqGuid + 11111);
            RespondExample respondExample = new RespondExample();
            respondExample.clear();
            //处理排序信息
            if (sortName != null) {
                //拼接字符串
                String order = GetDatabaseFileName(sortName) + " " + sortOrder;
                //将排序信息添加到example中
                respondExample.setOrderByClause(order);
            }
            Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid);
            respondExample.clear();
            respondExample.or().andResReqGuidEqualTo(reqGuid);
//        respondExample.or().andResReqGuidEqualTo();
            List<Respond> responds = respondMapper.selectByExample(respondExample);
            List<Respond> respondRecordList = new ArrayList<>();
            //判断用户是否被删除
//        for(Respond it:responds){
//            it.getResTypeGuidProcessStatus().equals("88888888-94e3-4eb7-aad3-222222222222");
//        }

            for (int i = offset; i < offset + limit && i < responds.size(); i++) {
                Respond respond1 = responds.get(i);
                /************10.17添加关于信用度显示****************/
                String userResID = respond1.getResUserGuid();
//            System.out.println("查信用度的用户是："+userResID);
                RespondExample respondExample1 = new RespondExample();
                respondExample1.or().andResUserGuidEqualTo(userResID);
                List<Respond> respondList = respondMapper.selectByExample(respondExample1);
                int credit = 0;
                int totalScore = 0;
                int count = 0;
                for (Respond res : respondList) {
                    String userResListId = res.getResUserGuid();
                    if (userResID.equals(userResListId)) {
                        if (res.getResEvaluate() != null) {
                            totalScore += res.getResEvaluate();
//                        System.out.println("该用户的分数累加为："+totalScore);
                            count++;
//                        System.out.println("该用户在响应列表中的累加计数为："+count);
                        }
                    }
                }
                if (count != 0) {
                    credit = totalScore / count;
                }
                Users userSearch = usersMapper.selectByPrimaryKey(userResID);
                userSearch.setUserCredit(credit);
                usersMapper.updateByPrimaryKeySelective(userSearch);
                respond1.setResReqStartUserAccount(credit + "");

                /*******************/
                TypeExample typeExample = new TypeExample();
                String resUserGuid = respond1.getResUserGuid();
                UsersExample usersExample = new UsersExample();
                usersExample.or().andUserGuidEqualTo(resUserGuid);
                List<Users> users = usersMapper.selectByExample(usersExample);
                respond1.setResUserGuid(users.get(0).getUserAccount());
                String resTypeGuidProcessStatus = respond1.getResTypeGuidProcessStatus();
                typeExample.clear();
                typeExample.or().andTypeGuidEqualTo(resTypeGuidProcessStatus);
                List<Type> types = typeMapper.selectByExample(typeExample);
                respond1.setResTypeGuidProcessStatus(types.get(0).getTypeTitle());
                respond1.setResReqTitle(reqest.getReqTitle());
                respondRecordList.add(respond1);

            }
            //全部符合要求的数据的数量
            int total = responds.size();
            //将所得集合打包
            ObjectMapper mapper = new ObjectMapper();
            TableRecordsJson tableRecordsJson = new TableRecordsJson(respondRecordList, total);
            //将实体类转换成json数据并返回
            try {
                String json1 = mapper.writeValueAsString(tableRecordsJson);
                // System.out.println(json1);
                return json1;
            } catch (Exception e) {
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    //查看详情界面中的  申请待启动按钮
    @RequestMapping(value = "/waitRequest")
    public String waitRequest (UpdateList updateList, Model model,String reqGuid6) {
//        System.out.println(updateRequestGuid);
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        System.out.println("sad"+reqGuid6);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid6);
        //设置请求处理状态为待启动
        reqest.setReqTypeGuidProcessStatus("33333333-94E3-4EB7-AAD3-222222222222");
        reqestMapper.updateByPrimaryKey(reqest);
        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidClass());
        List<Type> types = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidClass(types.get(0).getTypeTitle());
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidUrgency());
        List<Type> typex = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidUrgency(typex.get(0).getTypeTitle());
        //处理请求处理状态
        String approveId = reqest.getReqTypeApproveStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (approveId != null)
        {

            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(approveId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //处理请求批准状态
        String processId = reqest.getReqTypeGuidProcessStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (processId != null)
        {
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(processId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        model.addAttribute("reqest",reqest);
        //TODO 点击待启动按钮之后
        updateList.setUpdateId(0);
        updateList.setDeletaId(1);
        updateList.setStartId(1);
        updateList.setViewVolId(1);
        updateList.setFinishId(0);
        updateList.setUnFinishId(0);
        updateList.setWaitId(0);
        updateList.setEvaluateId(0);
        model.addAttribute("updateList",updateList);
        return "listRequestModel";
    }

    //查看详情界面中的  申请启动按钮
    @RequestMapping(value = "/startRequest")
    public String startRequest (UpdateList updateList, Model model,String reqGuid5) {
        System.out.println(reqGuid5);
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid5);
        //设置请求处理状态为启动
        reqest.setReqTypeGuidProcessStatus("33333333-94E3-4EB7-AAD3-333333333333");
        //设置请求开始时间为现在
        Date startDate = new Date();
//        dateStart =startDate;
        reqest.setReqStartTime(startDate);
        reqestMapper.updateByPrimaryKey(reqest);
        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidClass());
        List<Type> types = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidClass(types.get(0).getTypeTitle());
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidUrgency());
        List<Type> typex = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidUrgency(typex.get(0).getTypeTitle());
        //处理请求处理状态
        String approveId = reqest.getReqTypeApproveStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (approveId != null)
        {

            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(approveId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //处理请求批准状态
        String processId = reqest.getReqTypeGuidProcessStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (processId != null)
        {
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(processId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        model.addAttribute("reqest",reqest);
        //TODO 点击启动按钮之后
        updateList.setUpdateId(0);
        updateList.setDeletaId(1);
        updateList.setStartId(0);
        updateList.setViewVolId(1);
        updateList.setFinishId(1);
        updateList.setUnFinishId(1);
        updateList.setWaitId(0);
        updateList.setEvaluateId(0);
        model.addAttribute("updateList",updateList);
        return "listRequestModel";
    }
    //查看详情界面中的申请已完成按钮
    @RequestMapping(value = "/endRequest")
    public String endRequest (UpdateList updateList, Model model,String reqGuid7) {
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid7);
        //设置请求处理状态为已完成
        reqest.setReqTypeGuidProcessStatus("33333333-94E3-4EB7-AAD3-444444444444");
        //设置请求结束时间为现在
        Date endDate = new Date();
        reqest.setReqEndTime(endDate);
        //设置请求持续时间，单位为分钟 结束的时间
        long endMiles = endDate.getTime();
        System.out.println("结束时间即现在时间"+endDate);
        //获取启动时候的时间
        System.out.println("数据库中存的开始时间"+reqest.getReqAvailableStartTime());
        long startMiles=reqest.getReqAvailableStartTime().getTime();
        long durTime = (endMiles-startMiles)/(60*1000);
        System.out.println("持续的时间为"+durTime);
        reqest.setReqActualDurationTime(new Long(durTime).intValue());
        reqestMapper.updateByPrimaryKey(reqest);
        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidClass());
        List<Type> types = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidClass(types.get(0).getTypeTitle());
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidUrgency());
        List<Type> typex = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidUrgency(typex.get(0).getTypeTitle());
        //处理请求处理状态
        String approveId = reqest.getReqTypeApproveStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (approveId != null)
        {
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(approveId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //处理请求批准状态
        String processId = reqest.getReqTypeGuidProcessStatus();
        if (processId != null)
        {
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(processId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
            /**********************10.15完成状态下时间币的处理情况*******************************/
            List<Users> userListreq=new ArrayList<>();

            RespondExample respondExample=new RespondExample();
            respondExample.or().andResReqGuidEqualTo(reqest.getReqGuid());
            List<Respond> responds=respondMapper.selectByExample(respondExample);
            int totalNum=0;
            for (Respond respond:responds) {
                Users users3=usersMapper.selectByPrimaryKey(respond.getResUserGuid());
                userListreq.add(users3);
                totalNum++;
            }
            Double totalMoney=reqest.getReqPreCunsumeCurrency();
            Double shouldDeMoney=totalMoney/totalNum;
            for (Users user4:userListreq) {
                double didMoney=user4.getUserOwnCurrency();
                Double newMoney=didMoney+shouldDeMoney;
                user4.setUserOwnCurrency(newMoney);
                usersMapper.updateByPrimaryKeySelective(user4);
            }
/**********************************************************/
        }
        model.addAttribute("reqest",reqest);
        //TODO 点击已完成按钮之后
        updateList.setUpdateId(0);
        updateList.setDeletaId(1);
        updateList.setStartId(0);
        updateList.setViewVolId(1);
        updateList.setFinishId(0);
        updateList.setUnFinishId(0);
        updateList.setWaitId(0);
        updateList.setEvaluateId(1);
        model.addAttribute("updateList",updateList);
        return "listRequestModel";
    }
    //查看详情界面中的申请未完成按钮
    @RequestMapping(value = "/unEndRequest")
    public String unEndRequest (UpdateList updateList, Model model,String reqGuid8) {
        System.out.println(reqGuid8);
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(reqGuid8);
        reqest.setReqTypeGuidProcessStatus("33333333-94E3-4EB7-AAD3-555555555555");
        reqestMapper.updateByPrimaryKey(reqest);
        //请求分类
        TypeExample typeExample = new TypeExample();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidClass());
        List<Type> types = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidClass(types.get(0).getTypeTitle());
        //选择请求紧急程度
        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(reqest.getReqTypeGuidUrgency());
        List<Type> typex = typeMapper.selectByExample(typeExample);
        reqest.setReqTypeGuidUrgency(typex.get(0).getTypeTitle());
        //处理请求处理状态
        String approveId = reqest.getReqTypeApproveStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (approveId != null)
        {
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(approveId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeApproveStatus(types2.get(0).getTypeTitle());

            /**********************10.15添加关于未完成状态下关于时间币的返回**********************/
            String reqIssueUserID=reqest.getReqIssueUserGuid();
            double preTimeMoney=reqest.getReqPreCunsumeCurrency();
//            System.out.println("未完成状态下获取估计的时间币："+preTimeMoney);
            Users users1=usersMapper.selectByPrimaryKey(reqIssueUserID);
            double userOwnMoney=users1.getUserOwnCurrency();
            double newUserOwnMoney=0.0;
            newUserOwnMoney=userOwnMoney+preTimeMoney;
            users1.setUserOwnCurrency(newUserOwnMoney);
            usersMapper.updateByPrimaryKeySelective(users1);

            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        //处理请求批准状态
        String processId = reqest.getReqTypeGuidProcessStatus();
        //String processId = reqest1.getReqTypeGuidProcessStatus();
        if (processId != null)
        {
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(processId);
            List<Type> types2 = typeMapper.selectByExample(typeExample);
            reqest.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
            //reqest1.setReqTypeGuidProcessStatus(types2.get(0).getTypeTitle());
        }
        model.addAttribute("reqest",reqest);
        //TODO 点击未完成按钮之后
        updateList.setUpdateId(0);
        updateList.setDeletaId(1);
        updateList.setStartId(0);
        updateList.setViewVolId(1);
        updateList.setFinishId(1);
        updateList.setUnFinishId(0);
        updateList.setWaitId(0);
        updateList.setEvaluateId(1);
        model.addAttribute("updateList",updateList);
        return "listRequestModel";
    }
    //申请需求  查询按钮 ajax
    @RequestMapping("/css/testajax")
    @ResponseBody
    public String AAAA(String jd,String wd,Model model) throws JsonProcessingException {
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        double JD=Double.parseDouble(jd);
        double WD=Double.parseDouble(wd);
        UpdateList updateList=new UpdateList();
        ReqestExample reqestExample=new ReqestExample();
        //得到所有的请求
        List<Reqest> reqestList=reqestMapper.selectByExample(reqestExample);
        List<Reqest> reqestList1=new ArrayList<>();
        List<Reqest> reqestList2=new ArrayList<>();
        //筛选通过  待启动
        for(Reqest it:reqestList){

            /**10.23添加关于一个人申请服务次数**/

            /********************/
            if(it.getReqTypeApproveStatus().equals("88888888-94E3-4EB7-AAD3-111111111111")&&it.getReqTypeGuidProcessStatus().equals("33333333-94E3-4EB7-AAD3-222222222222")){
                reqestList2.add(it);
            }

        }
        int num=0;
        for(Reqest it:reqestList2){
            if(it.getReqAddress()!=null) {
                String Address = it.getReqAddress();
                String[] parts = Address.split(",");
                double dbowd = Double.parseDouble(parts[0]);
                double dbojd = Double.parseDouble(parts[1]);
                double d=GetDistance(JD, WD, dbojd, dbowd);
                if (d <= 10) {
                    reqestList1.add(it);
                    num++;
                }
            }
        }

        //将类的集合封装成json
        ObjectMapper mapper = new ObjectMapper();
        com.timebank.controller.sxq.TableRecordsJson tableRecordsJson = new com.timebank.controller.sxq.TableRecordsJson(reqestList1, num);
        String json1 = mapper.writeValueAsString(tableRecordsJson);
        System.out.println(json1);
        return json1;
    }
    /*计算经纬度距离*/
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double GetDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        return s; //单位km
    }
    //申请请求界面  查看详情按钮
    @RequestMapping(value="/css1/aaa/{message}")
    public String chaKanXiangQing(Model model, @PathVariable String message){
        //用户guid
        System.out.println(11111);
        System.out.println(message);
        //请求
        Subject account = SecurityUtils.getSubject();
        String message1=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message1);
        String role=users11.getUserRole();
        model.addAttribute("role",role);
        Reqest reqest = reqestMapper.selectByPrimaryKey(message);
        /***********10.24添加*****/

        /***************/
        int flag=1;
        //验证自己不能申请自己的请求
        String guid=reqest.getReqIssueUserGuid();
        String userGuid=users11.getUserGuid();
        if(guid.equals(userGuid)){
            flag=2;
        }
        //处理紧急状态
        String urgencyId = reqest.getReqTypeGuidUrgency();
        Type type = typeMapper.selectByPrimaryKey(urgencyId);
        reqest.setReqTypeGuidUrgency(type.getTypeTitle());
        //处理选择分类
        String typeId = reqest.getReqTypeGuidClass();
        Type type1 = typeMapper.selectByPrimaryKey(typeId);
        reqest.setReqTypeGuidClass(type1.getTypeTitle());
        model.addAttribute("reqest",reqest);
        //只能申请一次
        RespondExample respondExample=new RespondExample();
        respondExample.or().andResReqGuidEqualTo(message);
        List<Respond> respondList=respondMapper.selectByExample(respondExample);
        int count=0;
        for(Respond it:respondList){
            //判断没有删除字段 统计报名人数
            if(it.getResTypeGuidProcessStatus().equals("88888888-94E3-4EB7-AAD3-111111111111")){
                count++;
            }
            //人数限制  遍历所有申请的人数
            if(it.getResUserGuid().equals(users11.getUserGuid())||count>=reqest.getReqPersonNum()){
                flag=2;
            }
        }
        model.addAttribute("message",flag);
        model.addAttribute("personNumber",count);
        return "detailsViewOfVolunteer";
    }
}
