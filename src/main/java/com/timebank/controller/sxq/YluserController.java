package com.timebank.controller.sxq;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timebank.domain.*;
import com.timebank.mapper.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;


@Controller
public class YluserController {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private WeightMapper weightMapper;
    @Autowired
    private ReqestMapper reqestMapper;

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
    @RequestMapping(value = "/getUSERSListJsonData")
    @ResponseBody
    public String userList(Model model, @RequestParam int offset, int limit, String sortName, String sortOrder) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);


        UsersExample usersExample = new UsersExample();
        RoleExample roleExample = new RoleExample();
        TypeExample typeExample = new TypeExample();
        CommunityExample communityExample = new CommunityExample();
        //处理排序信息
        if (sortName != null) {
            //拼接字符串
            String order = GetDatabaseFileName(sortName) + " " + sortOrder;
            //将排序信息添加到example中
            usersExample.setOrderByClause(order);
        }
        List<Users> users = usersMapper.selectByExample(usersExample);
        List<Users> usersList = new ArrayList<Users>();

        for (int i = offset; i < offset + limit && i < users.size(); i++) {
            Users user = users.get(i);

            String userRole = user.getUserFromRoleGuid();
            roleExample.clear();
            roleExample.or().andRoleGuidEqualTo(userRole);
            List<Role> userrole1 = roleMapper.selectByExample(roleExample);
            user.setUserFromRoleGuid(userrole1.get(0).getRoleTitle());

            String userGender = user.getUserTypeGuidGender();
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(userGender);
            List<Type> gender = typeMapper.selectByExample(typeExample);
            user.setUserTypeGuidGender(gender.get(0).getTypeTitle());

            String userStatus = user.getUserTypeAccountStatus();
            typeExample.clear();
            typeExample.or().andTypeGuidEqualTo(userStatus);
            List<Type> userstatus = typeMapper.selectByExample(typeExample);
            user.setUserTypeAccountStatus(userstatus.get(0).getTypeTitle());

            String userCommunicity = user.getUserCommGuid();
            communityExample.clear();
            communityExample.or().andCommGuidEqualTo(userCommunicity);
            List<Community> usercommunicity = communityMapper.selectByExample(communityExample);
            user.setUserCommGuid(usercommunicity.get(0).getCommTitle());

            usersList.add(user);
        }
//全部符合要求的数据的数量
        int total = users.size();
        System.out.println("总数：" + total);
        //将所得集合打包
        ObjectMapper mapper = new ObjectMapper();
        TableRecordsJson tableRecordsJson = new TableRecordsJson(usersList, total);
        //将实体类转换成json数据并返回
        try {
            String json1 = mapper.writeValueAsString(tableRecordsJson);
            System.out.println(json1);
            return json1;
        } catch (Exception e) {
            return null;
        }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    private String GetDatabaseFileName(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append('_');
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    @RequestMapping(value = "volunteerchoose")
    public String volchoose(Model model) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);
        return "volunteerchoose";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/volunteer/{userid}")
    public String volunteerdetail(Model model, @PathVariable String userid) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);

        Users users = usersMapper.selectByPrimaryKey(userid);
        model.addAttribute("users", users);

        TypeExample typeExample = new TypeExample();
        UsersExample usersExample = new UsersExample();
        RoleExample roleExample = new RoleExample();
//        CommunityExample communityExample = new CommunityExample();

        roleExample.clear();
        roleExample.or().andRoleGuidEqualTo(users.getUserFromRoleGuid());
        List<Role> userrole = roleMapper.selectByExample(roleExample);
        users.setUserFromRoleGuid(userrole.get(0).getRoleTitle());

        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(users.getUserTypeGuidGender());
        List<Type> usergender = typeMapper.selectByExample(typeExample);
        users.setUserTypeGuidGender(usergender.get(0).getTypeTitle());

        typeExample.clear();
        typeExample.or().andTypeGuidEqualTo(users.getUserTypeAccountStatus());
        List<Type> userstatus = typeMapper.selectByExample(typeExample);
        users.setUserTypeAccountStatus(userstatus.get(0).getTypeTitle());
        return "volunteerdetail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/setId")
    public String setData(Reqest reqest, String reqTargetsUserGuid, Model model, String reqGuid) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);
        Reqest request = reqestMapper.selectByPrimaryKey(reqGuid);
//        //后台把内容保存到数据库字段里
        request.setReqTargetsUserGuid(reqTargetsUserGuid);
        reqestMapper.updateByPrimaryKeySelective(request);
        //跳转到checkProjectView.html页面
        return "reqlistprocess";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
/*****************前端拾取坐标*******************************/
    @RequestMapping(value = "/mybank")
    public String demomapp(Model model) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);
        model.addAttribute("guid",users1.getUserGuid());

        return "demo_map1";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /*******************平台管理员代发请求获取地图*********************/
    @RequestMapping(value = "/mybankAD")
    public String demomappAD(Model model) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users1=GetCurrentUsers(message);
        String role=users1.getUserRole();
        model.addAttribute("role",role);
        System.out.println(users1.getUserGuid());
        model.addAttribute("guid",users1.getUserGuid());

        return "demo_map1admin";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    //将经纬度提交到后台
   @RequestMapping(value = "/aass")
    public String SDAS(String jd,String wd,String savecityName,String Guid,Model  model){
        try{
       Subject account = SecurityUtils.getSubject();
       String message=(String) account.getPrincipal();
       Users users1=GetCurrentUsers(message);
       String role=users1.getUserRole();
       model.addAttribute("role",role);
       StringBuilder stringBuilder=new StringBuilder();
       stringBuilder.append(jd);
       stringBuilder.append(",");
       stringBuilder.append(wd);
       stringBuilder.append(",");
       stringBuilder.append(savecityName);
       System.out.println("拼接完成："+stringBuilder);
        String address=""+stringBuilder;
       String[] parts = address.split(",");
       model.addAttribute("address",parts[2]);
       model.addAttribute("jd",parts[0]);
       model.addAttribute("wd",parts[1]);
       //插入type和weight
       insertReqType(model,true);
        return  "apply";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/createRequestByAdminViewAS")
    public String createRequestByAdminView(String jd,String wd,String savecityName,String Guid,Model model) {
        try{
        Subject account = SecurityUtils.getSubject();
        String message=(String) account.getPrincipal();
        Users users11=GetCurrentUsers(message);
        String role=users11.getUserRole();
        model.addAttribute("role",role);


        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(jd);
        stringBuilder.append(",");
        stringBuilder.append(wd);
        stringBuilder.append(",");
        stringBuilder.append(savecityName);
        System.out.println("拼接完成："+stringBuilder);
        String address=""+stringBuilder;
        String[] parts = address.split(",");
        model.addAttribute("address",parts[2]);
        model.addAttribute("jd",parts[0]);
        model.addAttribute("wd",parts[1]);


        //插入type和weight
        insertReqType(model,true);
        return "createRequestByAdminView";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    private TypeExample insertReqType(Model model,boolean showProAndAppStatus) {
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
}
