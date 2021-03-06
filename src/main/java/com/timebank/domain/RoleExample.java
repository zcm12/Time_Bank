package com.timebank.domain;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public RoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRoleGuidIsNull() {
            addCriterion("ROLE_GUID is null");
            return (Criteria) this;
        }

        public Criteria andRoleGuidIsNotNull() {
            addCriterion("ROLE_GUID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleGuidEqualTo(String value) {
            addCriterion("ROLE_GUID =", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidNotEqualTo(String value) {
            addCriterion("ROLE_GUID <>", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidGreaterThan(String value) {
            addCriterion("ROLE_GUID >", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_GUID >=", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidLessThan(String value) {
            addCriterion("ROLE_GUID <", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidLessThanOrEqualTo(String value) {
            addCriterion("ROLE_GUID <=", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidLike(String value) {
            addCriterion("ROLE_GUID like", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidNotLike(String value) {
            addCriterion("ROLE_GUID not like", value, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidIn(List<String> values) {
            addCriterion("ROLE_GUID in", values, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidNotIn(List<String> values) {
            addCriterion("ROLE_GUID not in", values, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidBetween(String value1, String value2) {
            addCriterion("ROLE_GUID between", value1, value2, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleGuidNotBetween(String value1, String value2) {
            addCriterion("ROLE_GUID not between", value1, value2, "roleGuid");
            return (Criteria) this;
        }

        public Criteria andRoleTitleIsNull() {
            addCriterion("ROLE_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andRoleTitleIsNotNull() {
            addCriterion("ROLE_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTitleEqualTo(String value) {
            addCriterion("ROLE_TITLE =", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleNotEqualTo(String value) {
            addCriterion("ROLE_TITLE <>", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleGreaterThan(String value) {
            addCriterion("ROLE_TITLE >", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_TITLE >=", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleLessThan(String value) {
            addCriterion("ROLE_TITLE <", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleLessThanOrEqualTo(String value) {
            addCriterion("ROLE_TITLE <=", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleLike(String value) {
            addCriterion("ROLE_TITLE like", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleNotLike(String value) {
            addCriterion("ROLE_TITLE not like", value, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleIn(List<String> values) {
            addCriterion("ROLE_TITLE in", values, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleNotIn(List<String> values) {
            addCriterion("ROLE_TITLE not in", values, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleBetween(String value1, String value2) {
            addCriterion("ROLE_TITLE between", value1, value2, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleTitleNotBetween(String value1, String value2) {
            addCriterion("ROLE_TITLE not between", value1, value2, "roleTitle");
            return (Criteria) this;
        }

        public Criteria andRoleValueIsNull() {
            addCriterion("ROLE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRoleValueIsNotNull() {
            addCriterion("ROLE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleValueEqualTo(Integer value) {
            addCriterion("ROLE_VALUE =", value, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueNotEqualTo(Integer value) {
            addCriterion("ROLE_VALUE <>", value, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueGreaterThan(Integer value) {
            addCriterion("ROLE_VALUE >", value, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_VALUE >=", value, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueLessThan(Integer value) {
            addCriterion("ROLE_VALUE <", value, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_VALUE <=", value, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueIn(List<Integer> values) {
            addCriterion("ROLE_VALUE in", values, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueNotIn(List<Integer> values) {
            addCriterion("ROLE_VALUE not in", values, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_VALUE between", value1, value2, "roleValue");
            return (Criteria) this;
        }

        public Criteria andRoleValueNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_VALUE not between", value1, value2, "roleValue");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.ROLE
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.ROLE
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}