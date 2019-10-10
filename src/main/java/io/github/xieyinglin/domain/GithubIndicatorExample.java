package io.github.xieyinglin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GithubIndicatorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GithubIndicatorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("userId like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("userId not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("projectName is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("projectName is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("projectName =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("projectName <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("projectName >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("projectName >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("projectName <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("projectName <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("projectName like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("projectName not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("projectName in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("projectName not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("projectName between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("projectName not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andWatchIsNull() {
            addCriterion("watch is null");
            return (Criteria) this;
        }

        public Criteria andWatchIsNotNull() {
            addCriterion("watch is not null");
            return (Criteria) this;
        }

        public Criteria andWatchEqualTo(Integer value) {
            addCriterion("watch =", value, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchNotEqualTo(Integer value) {
            addCriterion("watch <>", value, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchGreaterThan(Integer value) {
            addCriterion("watch >", value, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("watch >=", value, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchLessThan(Integer value) {
            addCriterion("watch <", value, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchLessThanOrEqualTo(Integer value) {
            addCriterion("watch <=", value, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchIn(List<Integer> values) {
            addCriterion("watch in", values, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchNotIn(List<Integer> values) {
            addCriterion("watch not in", values, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchBetween(Integer value1, Integer value2) {
            addCriterion("watch between", value1, value2, "watch");
            return (Criteria) this;
        }

        public Criteria andWatchNotBetween(Integer value1, Integer value2) {
            addCriterion("watch not between", value1, value2, "watch");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(Integer value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(Integer value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(Integer value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(Integer value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(Integer value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<Integer> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<Integer> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(Integer value1, Integer value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(Integer value1, Integer value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andIssuesIsNull() {
            addCriterion("issues is null");
            return (Criteria) this;
        }

        public Criteria andIssuesIsNotNull() {
            addCriterion("issues is not null");
            return (Criteria) this;
        }

        public Criteria andIssuesEqualTo(Integer value) {
            addCriterion("issues =", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesNotEqualTo(Integer value) {
            addCriterion("issues <>", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesGreaterThan(Integer value) {
            addCriterion("issues >", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesGreaterThanOrEqualTo(Integer value) {
            addCriterion("issues >=", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesLessThan(Integer value) {
            addCriterion("issues <", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesLessThanOrEqualTo(Integer value) {
            addCriterion("issues <=", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesIn(List<Integer> values) {
            addCriterion("issues in", values, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesNotIn(List<Integer> values) {
            addCriterion("issues not in", values, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesBetween(Integer value1, Integer value2) {
            addCriterion("issues between", value1, value2, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesNotBetween(Integer value1, Integer value2) {
            addCriterion("issues not between", value1, value2, "issues");
            return (Criteria) this;
        }

        public Criteria andForkIsNull() {
            addCriterion("fork is null");
            return (Criteria) this;
        }

        public Criteria andForkIsNotNull() {
            addCriterion("fork is not null");
            return (Criteria) this;
        }

        public Criteria andForkEqualTo(Integer value) {
            addCriterion("fork =", value, "fork");
            return (Criteria) this;
        }

        public Criteria andForkNotEqualTo(Integer value) {
            addCriterion("fork <>", value, "fork");
            return (Criteria) this;
        }

        public Criteria andForkGreaterThan(Integer value) {
            addCriterion("fork >", value, "fork");
            return (Criteria) this;
        }

        public Criteria andForkGreaterThanOrEqualTo(Integer value) {
            addCriterion("fork >=", value, "fork");
            return (Criteria) this;
        }

        public Criteria andForkLessThan(Integer value) {
            addCriterion("fork <", value, "fork");
            return (Criteria) this;
        }

        public Criteria andForkLessThanOrEqualTo(Integer value) {
            addCriterion("fork <=", value, "fork");
            return (Criteria) this;
        }

        public Criteria andForkIn(List<Integer> values) {
            addCriterion("fork in", values, "fork");
            return (Criteria) this;
        }

        public Criteria andForkNotIn(List<Integer> values) {
            addCriterion("fork not in", values, "fork");
            return (Criteria) this;
        }

        public Criteria andForkBetween(Integer value1, Integer value2) {
            addCriterion("fork between", value1, value2, "fork");
            return (Criteria) this;
        }

        public Criteria andForkNotBetween(Integer value1, Integer value2) {
            addCriterion("fork not between", value1, value2, "fork");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIsNull() {
            addCriterion("fetchTime is null");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIsNotNull() {
            addCriterion("fetchTime is not null");
            return (Criteria) this;
        }

        public Criteria andFetchTimeEqualTo(Date value) {
            addCriterion("fetchTime =", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotEqualTo(Date value) {
            addCriterion("fetchTime <>", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeGreaterThan(Date value) {
            addCriterion("fetchTime >", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fetchTime >=", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeLessThan(Date value) {
            addCriterion("fetchTime <", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeLessThanOrEqualTo(Date value) {
            addCriterion("fetchTime <=", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIn(List<Date> values) {
            addCriterion("fetchTime in", values, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotIn(List<Date> values) {
            addCriterion("fetchTime not in", values, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeBetween(Date value1, Date value2) {
            addCriterion("fetchTime between", value1, value2, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotBetween(Date value1, Date value2) {
            addCriterion("fetchTime not between", value1, value2, "fetchTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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