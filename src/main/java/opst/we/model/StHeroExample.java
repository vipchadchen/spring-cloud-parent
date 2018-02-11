package opst.we.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StHeroExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StHeroExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAttackIsNull() {
            addCriterion("attack is null");
            return (Criteria) this;
        }

        public Criteria andAttackIsNotNull() {
            addCriterion("attack is not null");
            return (Criteria) this;
        }

        public Criteria andAttackEqualTo(Integer value) {
            addCriterion("attack =", value, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackNotEqualTo(Integer value) {
            addCriterion("attack <>", value, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackGreaterThan(Integer value) {
            addCriterion("attack >", value, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackGreaterThanOrEqualTo(Integer value) {
            addCriterion("attack >=", value, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackLessThan(Integer value) {
            addCriterion("attack <", value, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackLessThanOrEqualTo(Integer value) {
            addCriterion("attack <=", value, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackIn(List<Integer> values) {
            addCriterion("attack in", values, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackNotIn(List<Integer> values) {
            addCriterion("attack not in", values, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackBetween(Integer value1, Integer value2) {
            addCriterion("attack between", value1, value2, "attack");
            return (Criteria) this;
        }

        public Criteria andAttackNotBetween(Integer value1, Integer value2) {
            addCriterion("attack not between", value1, value2, "attack");
            return (Criteria) this;
        }

        public Criteria andAttgrowIsNull() {
            addCriterion("attGrow is null");
            return (Criteria) this;
        }

        public Criteria andAttgrowIsNotNull() {
            addCriterion("attGrow is not null");
            return (Criteria) this;
        }

        public Criteria andAttgrowEqualTo(BigDecimal value) {
            addCriterion("attGrow =", value, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowNotEqualTo(BigDecimal value) {
            addCriterion("attGrow <>", value, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowGreaterThan(BigDecimal value) {
            addCriterion("attGrow >", value, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("attGrow >=", value, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowLessThan(BigDecimal value) {
            addCriterion("attGrow <", value, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("attGrow <=", value, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowIn(List<BigDecimal> values) {
            addCriterion("attGrow in", values, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowNotIn(List<BigDecimal> values) {
            addCriterion("attGrow not in", values, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attGrow between", value1, value2, "attgrow");
            return (Criteria) this;
        }

        public Criteria andAttgrowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attGrow not between", value1, value2, "attgrow");
            return (Criteria) this;
        }

        public Criteria andContoryIsNull() {
            addCriterion("contory is null");
            return (Criteria) this;
        }

        public Criteria andContoryIsNotNull() {
            addCriterion("contory is not null");
            return (Criteria) this;
        }

        public Criteria andContoryEqualTo(String value) {
            addCriterion("contory =", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryNotEqualTo(String value) {
            addCriterion("contory <>", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryGreaterThan(String value) {
            addCriterion("contory >", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryGreaterThanOrEqualTo(String value) {
            addCriterion("contory >=", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryLessThan(String value) {
            addCriterion("contory <", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryLessThanOrEqualTo(String value) {
            addCriterion("contory <=", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryLike(String value) {
            addCriterion("contory like", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryNotLike(String value) {
            addCriterion("contory not like", value, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryIn(List<String> values) {
            addCriterion("contory in", values, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryNotIn(List<String> values) {
            addCriterion("contory not in", values, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryBetween(String value1, String value2) {
            addCriterion("contory between", value1, value2, "contory");
            return (Criteria) this;
        }

        public Criteria andContoryNotBetween(String value1, String value2) {
            addCriterion("contory not between", value1, value2, "contory");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andDefIsNull() {
            addCriterion("def is null");
            return (Criteria) this;
        }

        public Criteria andDefIsNotNull() {
            addCriterion("def is not null");
            return (Criteria) this;
        }

        public Criteria andDefEqualTo(Integer value) {
            addCriterion("def =", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotEqualTo(Integer value) {
            addCriterion("def <>", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefGreaterThan(Integer value) {
            addCriterion("def >", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefGreaterThanOrEqualTo(Integer value) {
            addCriterion("def >=", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefLessThan(Integer value) {
            addCriterion("def <", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefLessThanOrEqualTo(Integer value) {
            addCriterion("def <=", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefIn(List<Integer> values) {
            addCriterion("def in", values, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotIn(List<Integer> values) {
            addCriterion("def not in", values, "def");
            return (Criteria) this;
        }

        public Criteria andDefBetween(Integer value1, Integer value2) {
            addCriterion("def between", value1, value2, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotBetween(Integer value1, Integer value2) {
            addCriterion("def not between", value1, value2, "def");
            return (Criteria) this;
        }

        public Criteria andDefgrowIsNull() {
            addCriterion("defGrow is null");
            return (Criteria) this;
        }

        public Criteria andDefgrowIsNotNull() {
            addCriterion("defGrow is not null");
            return (Criteria) this;
        }

        public Criteria andDefgrowEqualTo(BigDecimal value) {
            addCriterion("defGrow =", value, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowNotEqualTo(BigDecimal value) {
            addCriterion("defGrow <>", value, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowGreaterThan(BigDecimal value) {
            addCriterion("defGrow >", value, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("defGrow >=", value, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowLessThan(BigDecimal value) {
            addCriterion("defGrow <", value, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("defGrow <=", value, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowIn(List<BigDecimal> values) {
            addCriterion("defGrow in", values, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowNotIn(List<BigDecimal> values) {
            addCriterion("defGrow not in", values, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("defGrow between", value1, value2, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDefgrowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("defGrow not between", value1, value2, "defgrow");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andGroudarrIsNull() {
            addCriterion("groudArr is null");
            return (Criteria) this;
        }

        public Criteria andGroudarrIsNotNull() {
            addCriterion("groudArr is not null");
            return (Criteria) this;
        }

        public Criteria andGroudarrEqualTo(String value) {
            addCriterion("groudArr =", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrNotEqualTo(String value) {
            addCriterion("groudArr <>", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrGreaterThan(String value) {
            addCriterion("groudArr >", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrGreaterThanOrEqualTo(String value) {
            addCriterion("groudArr >=", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrLessThan(String value) {
            addCriterion("groudArr <", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrLessThanOrEqualTo(String value) {
            addCriterion("groudArr <=", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrLike(String value) {
            addCriterion("groudArr like", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrNotLike(String value) {
            addCriterion("groudArr not like", value, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrIn(List<String> values) {
            addCriterion("groudArr in", values, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrNotIn(List<String> values) {
            addCriterion("groudArr not in", values, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrBetween(String value1, String value2) {
            addCriterion("groudArr between", value1, value2, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroudarrNotBetween(String value1, String value2) {
            addCriterion("groudArr not between", value1, value2, "groudarr");
            return (Criteria) this;
        }

        public Criteria andGroupnameIsNull() {
            addCriterion("groupName is null");
            return (Criteria) this;
        }

        public Criteria andGroupnameIsNotNull() {
            addCriterion("groupName is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnameEqualTo(String value) {
            addCriterion("groupName =", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotEqualTo(String value) {
            addCriterion("groupName <>", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThan(String value) {
            addCriterion("groupName >", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThanOrEqualTo(String value) {
            addCriterion("groupName >=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThan(String value) {
            addCriterion("groupName <", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThanOrEqualTo(String value) {
            addCriterion("groupName <=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLike(String value) {
            addCriterion("groupName like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotLike(String value) {
            addCriterion("groupName not like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameIn(List<String> values) {
            addCriterion("groupName in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotIn(List<String> values) {
            addCriterion("groupName not in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameBetween(String value1, String value2) {
            addCriterion("groupName between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotBetween(String value1, String value2) {
            addCriterion("groupName not between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andMethoddescIsNull() {
            addCriterion("methodDesc is null");
            return (Criteria) this;
        }

        public Criteria andMethoddescIsNotNull() {
            addCriterion("methodDesc is not null");
            return (Criteria) this;
        }

        public Criteria andMethoddescEqualTo(String value) {
            addCriterion("methodDesc =", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescNotEqualTo(String value) {
            addCriterion("methodDesc <>", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescGreaterThan(String value) {
            addCriterion("methodDesc >", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescGreaterThanOrEqualTo(String value) {
            addCriterion("methodDesc >=", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescLessThan(String value) {
            addCriterion("methodDesc <", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescLessThanOrEqualTo(String value) {
            addCriterion("methodDesc <=", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescLike(String value) {
            addCriterion("methodDesc like", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescNotLike(String value) {
            addCriterion("methodDesc not like", value, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescIn(List<String> values) {
            addCriterion("methodDesc in", values, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescNotIn(List<String> values) {
            addCriterion("methodDesc not in", values, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescBetween(String value1, String value2) {
            addCriterion("methodDesc between", value1, value2, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddescNotBetween(String value1, String value2) {
            addCriterion("methodDesc not between", value1, value2, "methoddesc");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1IsNull() {
            addCriterion("methodDesc1 is null");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1IsNotNull() {
            addCriterion("methodDesc1 is not null");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1EqualTo(String value) {
            addCriterion("methodDesc1 =", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1NotEqualTo(String value) {
            addCriterion("methodDesc1 <>", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1GreaterThan(String value) {
            addCriterion("methodDesc1 >", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1GreaterThanOrEqualTo(String value) {
            addCriterion("methodDesc1 >=", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1LessThan(String value) {
            addCriterion("methodDesc1 <", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1LessThanOrEqualTo(String value) {
            addCriterion("methodDesc1 <=", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1Like(String value) {
            addCriterion("methodDesc1 like", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1NotLike(String value) {
            addCriterion("methodDesc1 not like", value, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1In(List<String> values) {
            addCriterion("methodDesc1 in", values, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1NotIn(List<String> values) {
            addCriterion("methodDesc1 not in", values, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1Between(String value1, String value2) {
            addCriterion("methodDesc1 between", value1, value2, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc1NotBetween(String value1, String value2) {
            addCriterion("methodDesc1 not between", value1, value2, "methoddesc1");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2IsNull() {
            addCriterion("methodDesc2 is null");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2IsNotNull() {
            addCriterion("methodDesc2 is not null");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2EqualTo(String value) {
            addCriterion("methodDesc2 =", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2NotEqualTo(String value) {
            addCriterion("methodDesc2 <>", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2GreaterThan(String value) {
            addCriterion("methodDesc2 >", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2GreaterThanOrEqualTo(String value) {
            addCriterion("methodDesc2 >=", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2LessThan(String value) {
            addCriterion("methodDesc2 <", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2LessThanOrEqualTo(String value) {
            addCriterion("methodDesc2 <=", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2Like(String value) {
            addCriterion("methodDesc2 like", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2NotLike(String value) {
            addCriterion("methodDesc2 not like", value, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2In(List<String> values) {
            addCriterion("methodDesc2 in", values, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2NotIn(List<String> values) {
            addCriterion("methodDesc2 not in", values, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2Between(String value1, String value2) {
            addCriterion("methodDesc2 between", value1, value2, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddesc2NotBetween(String value1, String value2) {
            addCriterion("methodDesc2 not between", value1, value2, "methoddesc2");
            return (Criteria) this;
        }

        public Criteria andMethoddetailIsNull() {
            addCriterion("methodDetail is null");
            return (Criteria) this;
        }

        public Criteria andMethoddetailIsNotNull() {
            addCriterion("methodDetail is not null");
            return (Criteria) this;
        }

        public Criteria andMethoddetailEqualTo(String value) {
            addCriterion("methodDetail =", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailNotEqualTo(String value) {
            addCriterion("methodDetail <>", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailGreaterThan(String value) {
            addCriterion("methodDetail >", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailGreaterThanOrEqualTo(String value) {
            addCriterion("methodDetail >=", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailLessThan(String value) {
            addCriterion("methodDetail <", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailLessThanOrEqualTo(String value) {
            addCriterion("methodDetail <=", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailLike(String value) {
            addCriterion("methodDetail like", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailNotLike(String value) {
            addCriterion("methodDetail not like", value, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailIn(List<String> values) {
            addCriterion("methodDetail in", values, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailNotIn(List<String> values) {
            addCriterion("methodDetail not in", values, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailBetween(String value1, String value2) {
            addCriterion("methodDetail between", value1, value2, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetailNotBetween(String value1, String value2) {
            addCriterion("methodDetail not between", value1, value2, "methoddetail");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1IsNull() {
            addCriterion("methodDetail1 is null");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1IsNotNull() {
            addCriterion("methodDetail1 is not null");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1EqualTo(String value) {
            addCriterion("methodDetail1 =", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1NotEqualTo(String value) {
            addCriterion("methodDetail1 <>", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1GreaterThan(String value) {
            addCriterion("methodDetail1 >", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1GreaterThanOrEqualTo(String value) {
            addCriterion("methodDetail1 >=", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1LessThan(String value) {
            addCriterion("methodDetail1 <", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1LessThanOrEqualTo(String value) {
            addCriterion("methodDetail1 <=", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1Like(String value) {
            addCriterion("methodDetail1 like", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1NotLike(String value) {
            addCriterion("methodDetail1 not like", value, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1In(List<String> values) {
            addCriterion("methodDetail1 in", values, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1NotIn(List<String> values) {
            addCriterion("methodDetail1 not in", values, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1Between(String value1, String value2) {
            addCriterion("methodDetail1 between", value1, value2, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail1NotBetween(String value1, String value2) {
            addCriterion("methodDetail1 not between", value1, value2, "methoddetail1");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2IsNull() {
            addCriterion("methodDetail2 is null");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2IsNotNull() {
            addCriterion("methodDetail2 is not null");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2EqualTo(String value) {
            addCriterion("methodDetail2 =", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2NotEqualTo(String value) {
            addCriterion("methodDetail2 <>", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2GreaterThan(String value) {
            addCriterion("methodDetail2 >", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2GreaterThanOrEqualTo(String value) {
            addCriterion("methodDetail2 >=", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2LessThan(String value) {
            addCriterion("methodDetail2 <", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2LessThanOrEqualTo(String value) {
            addCriterion("methodDetail2 <=", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2Like(String value) {
            addCriterion("methodDetail2 like", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2NotLike(String value) {
            addCriterion("methodDetail2 not like", value, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2In(List<String> values) {
            addCriterion("methodDetail2 in", values, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2NotIn(List<String> values) {
            addCriterion("methodDetail2 not in", values, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2Between(String value1, String value2) {
            addCriterion("methodDetail2 between", value1, value2, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethoddetail2NotBetween(String value1, String value2) {
            addCriterion("methodDetail2 not between", value1, value2, "methoddetail2");
            return (Criteria) this;
        }

        public Criteria andMethodidIsNull() {
            addCriterion("methodId is null");
            return (Criteria) this;
        }

        public Criteria andMethodidIsNotNull() {
            addCriterion("methodId is not null");
            return (Criteria) this;
        }

        public Criteria andMethodidEqualTo(String value) {
            addCriterion("methodId =", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidNotEqualTo(String value) {
            addCriterion("methodId <>", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidGreaterThan(String value) {
            addCriterion("methodId >", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidGreaterThanOrEqualTo(String value) {
            addCriterion("methodId >=", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidLessThan(String value) {
            addCriterion("methodId <", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidLessThanOrEqualTo(String value) {
            addCriterion("methodId <=", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidLike(String value) {
            addCriterion("methodId like", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidNotLike(String value) {
            addCriterion("methodId not like", value, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidIn(List<String> values) {
            addCriterion("methodId in", values, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidNotIn(List<String> values) {
            addCriterion("methodId not in", values, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidBetween(String value1, String value2) {
            addCriterion("methodId between", value1, value2, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodidNotBetween(String value1, String value2) {
            addCriterion("methodId not between", value1, value2, "methodid");
            return (Criteria) this;
        }

        public Criteria andMethodid1IsNull() {
            addCriterion("methodId1 is null");
            return (Criteria) this;
        }

        public Criteria andMethodid1IsNotNull() {
            addCriterion("methodId1 is not null");
            return (Criteria) this;
        }

        public Criteria andMethodid1EqualTo(String value) {
            addCriterion("methodId1 =", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1NotEqualTo(String value) {
            addCriterion("methodId1 <>", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1GreaterThan(String value) {
            addCriterion("methodId1 >", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1GreaterThanOrEqualTo(String value) {
            addCriterion("methodId1 >=", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1LessThan(String value) {
            addCriterion("methodId1 <", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1LessThanOrEqualTo(String value) {
            addCriterion("methodId1 <=", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1Like(String value) {
            addCriterion("methodId1 like", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1NotLike(String value) {
            addCriterion("methodId1 not like", value, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1In(List<String> values) {
            addCriterion("methodId1 in", values, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1NotIn(List<String> values) {
            addCriterion("methodId1 not in", values, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1Between(String value1, String value2) {
            addCriterion("methodId1 between", value1, value2, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid1NotBetween(String value1, String value2) {
            addCriterion("methodId1 not between", value1, value2, "methodid1");
            return (Criteria) this;
        }

        public Criteria andMethodid2IsNull() {
            addCriterion("methodId2 is null");
            return (Criteria) this;
        }

        public Criteria andMethodid2IsNotNull() {
            addCriterion("methodId2 is not null");
            return (Criteria) this;
        }

        public Criteria andMethodid2EqualTo(String value) {
            addCriterion("methodId2 =", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2NotEqualTo(String value) {
            addCriterion("methodId2 <>", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2GreaterThan(String value) {
            addCriterion("methodId2 >", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2GreaterThanOrEqualTo(String value) {
            addCriterion("methodId2 >=", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2LessThan(String value) {
            addCriterion("methodId2 <", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2LessThanOrEqualTo(String value) {
            addCriterion("methodId2 <=", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2Like(String value) {
            addCriterion("methodId2 like", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2NotLike(String value) {
            addCriterion("methodId2 not like", value, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2In(List<String> values) {
            addCriterion("methodId2 in", values, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2NotIn(List<String> values) {
            addCriterion("methodId2 not in", values, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2Between(String value1, String value2) {
            addCriterion("methodId2 between", value1, value2, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodid2NotBetween(String value1, String value2) {
            addCriterion("methodId2 not between", value1, value2, "methodid2");
            return (Criteria) this;
        }

        public Criteria andMethodnameIsNull() {
            addCriterion("methodName is null");
            return (Criteria) this;
        }

        public Criteria andMethodnameIsNotNull() {
            addCriterion("methodName is not null");
            return (Criteria) this;
        }

        public Criteria andMethodnameEqualTo(String value) {
            addCriterion("methodName =", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotEqualTo(String value) {
            addCriterion("methodName <>", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameGreaterThan(String value) {
            addCriterion("methodName >", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameGreaterThanOrEqualTo(String value) {
            addCriterion("methodName >=", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLessThan(String value) {
            addCriterion("methodName <", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLessThanOrEqualTo(String value) {
            addCriterion("methodName <=", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLike(String value) {
            addCriterion("methodName like", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotLike(String value) {
            addCriterion("methodName not like", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameIn(List<String> values) {
            addCriterion("methodName in", values, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotIn(List<String> values) {
            addCriterion("methodName not in", values, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameBetween(String value1, String value2) {
            addCriterion("methodName between", value1, value2, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotBetween(String value1, String value2) {
            addCriterion("methodName not between", value1, value2, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodname1IsNull() {
            addCriterion("methodName1 is null");
            return (Criteria) this;
        }

        public Criteria andMethodname1IsNotNull() {
            addCriterion("methodName1 is not null");
            return (Criteria) this;
        }

        public Criteria andMethodname1EqualTo(String value) {
            addCriterion("methodName1 =", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1NotEqualTo(String value) {
            addCriterion("methodName1 <>", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1GreaterThan(String value) {
            addCriterion("methodName1 >", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1GreaterThanOrEqualTo(String value) {
            addCriterion("methodName1 >=", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1LessThan(String value) {
            addCriterion("methodName1 <", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1LessThanOrEqualTo(String value) {
            addCriterion("methodName1 <=", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1Like(String value) {
            addCriterion("methodName1 like", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1NotLike(String value) {
            addCriterion("methodName1 not like", value, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1In(List<String> values) {
            addCriterion("methodName1 in", values, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1NotIn(List<String> values) {
            addCriterion("methodName1 not in", values, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1Between(String value1, String value2) {
            addCriterion("methodName1 between", value1, value2, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname1NotBetween(String value1, String value2) {
            addCriterion("methodName1 not between", value1, value2, "methodname1");
            return (Criteria) this;
        }

        public Criteria andMethodname2IsNull() {
            addCriterion("methodName2 is null");
            return (Criteria) this;
        }

        public Criteria andMethodname2IsNotNull() {
            addCriterion("methodName2 is not null");
            return (Criteria) this;
        }

        public Criteria andMethodname2EqualTo(String value) {
            addCriterion("methodName2 =", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2NotEqualTo(String value) {
            addCriterion("methodName2 <>", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2GreaterThan(String value) {
            addCriterion("methodName2 >", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2GreaterThanOrEqualTo(String value) {
            addCriterion("methodName2 >=", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2LessThan(String value) {
            addCriterion("methodName2 <", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2LessThanOrEqualTo(String value) {
            addCriterion("methodName2 <=", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2Like(String value) {
            addCriterion("methodName2 like", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2NotLike(String value) {
            addCriterion("methodName2 not like", value, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2In(List<String> values) {
            addCriterion("methodName2 in", values, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2NotIn(List<String> values) {
            addCriterion("methodName2 not in", values, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2Between(String value1, String value2) {
            addCriterion("methodName2 between", value1, value2, "methodname2");
            return (Criteria) this;
        }

        public Criteria andMethodname2NotBetween(String value1, String value2) {
            addCriterion("methodName2 not between", value1, value2, "methodname2");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andRuseIsNull() {
            addCriterion("ruse is null");
            return (Criteria) this;
        }

        public Criteria andRuseIsNotNull() {
            addCriterion("ruse is not null");
            return (Criteria) this;
        }

        public Criteria andRuseEqualTo(Integer value) {
            addCriterion("ruse =", value, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseNotEqualTo(Integer value) {
            addCriterion("ruse <>", value, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseGreaterThan(Integer value) {
            addCriterion("ruse >", value, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("ruse >=", value, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseLessThan(Integer value) {
            addCriterion("ruse <", value, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseLessThanOrEqualTo(Integer value) {
            addCriterion("ruse <=", value, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseIn(List<Integer> values) {
            addCriterion("ruse in", values, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseNotIn(List<Integer> values) {
            addCriterion("ruse not in", values, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseBetween(Integer value1, Integer value2) {
            addCriterion("ruse between", value1, value2, "ruse");
            return (Criteria) this;
        }

        public Criteria andRuseNotBetween(Integer value1, Integer value2) {
            addCriterion("ruse not between", value1, value2, "ruse");
            return (Criteria) this;
        }

        public Criteria andRusegrowIsNull() {
            addCriterion("ruseGrow is null");
            return (Criteria) this;
        }

        public Criteria andRusegrowIsNotNull() {
            addCriterion("ruseGrow is not null");
            return (Criteria) this;
        }

        public Criteria andRusegrowEqualTo(BigDecimal value) {
            addCriterion("ruseGrow =", value, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowNotEqualTo(BigDecimal value) {
            addCriterion("ruseGrow <>", value, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowGreaterThan(BigDecimal value) {
            addCriterion("ruseGrow >", value, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ruseGrow >=", value, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowLessThan(BigDecimal value) {
            addCriterion("ruseGrow <", value, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ruseGrow <=", value, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowIn(List<BigDecimal> values) {
            addCriterion("ruseGrow in", values, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowNotIn(List<BigDecimal> values) {
            addCriterion("ruseGrow not in", values, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ruseGrow between", value1, value2, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andRusegrowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ruseGrow not between", value1, value2, "rusegrow");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSiegeIsNull() {
            addCriterion("siege is null");
            return (Criteria) this;
        }

        public Criteria andSiegeIsNotNull() {
            addCriterion("siege is not null");
            return (Criteria) this;
        }

        public Criteria andSiegeEqualTo(Integer value) {
            addCriterion("siege =", value, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeNotEqualTo(Integer value) {
            addCriterion("siege <>", value, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeGreaterThan(Integer value) {
            addCriterion("siege >", value, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeGreaterThanOrEqualTo(Integer value) {
            addCriterion("siege >=", value, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeLessThan(Integer value) {
            addCriterion("siege <", value, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeLessThanOrEqualTo(Integer value) {
            addCriterion("siege <=", value, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeIn(List<Integer> values) {
            addCriterion("siege in", values, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeNotIn(List<Integer> values) {
            addCriterion("siege not in", values, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeBetween(Integer value1, Integer value2) {
            addCriterion("siege between", value1, value2, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegeNotBetween(Integer value1, Integer value2) {
            addCriterion("siege not between", value1, value2, "siege");
            return (Criteria) this;
        }

        public Criteria andSiegegrowIsNull() {
            addCriterion("siegeGrow is null");
            return (Criteria) this;
        }

        public Criteria andSiegegrowIsNotNull() {
            addCriterion("siegeGrow is not null");
            return (Criteria) this;
        }

        public Criteria andSiegegrowEqualTo(BigDecimal value) {
            addCriterion("siegeGrow =", value, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowNotEqualTo(BigDecimal value) {
            addCriterion("siegeGrow <>", value, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowGreaterThan(BigDecimal value) {
            addCriterion("siegeGrow >", value, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("siegeGrow >=", value, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowLessThan(BigDecimal value) {
            addCriterion("siegeGrow <", value, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("siegeGrow <=", value, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowIn(List<BigDecimal> values) {
            addCriterion("siegeGrow in", values, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowNotIn(List<BigDecimal> values) {
            addCriterion("siegeGrow not in", values, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("siegeGrow between", value1, value2, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSiegegrowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("siegeGrow not between", value1, value2, "siegegrow");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Integer value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Integer value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Integer value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Integer value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Integer> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Integer> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Integer value1, Integer value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowIsNull() {
            addCriterion("speedGrow is null");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowIsNotNull() {
            addCriterion("speedGrow is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowEqualTo(BigDecimal value) {
            addCriterion("speedGrow =", value, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowNotEqualTo(BigDecimal value) {
            addCriterion("speedGrow <>", value, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowGreaterThan(BigDecimal value) {
            addCriterion("speedGrow >", value, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("speedGrow >=", value, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowLessThan(BigDecimal value) {
            addCriterion("speedGrow <", value, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("speedGrow <=", value, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowIn(List<BigDecimal> values) {
            addCriterion("speedGrow in", values, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowNotIn(List<BigDecimal> values) {
            addCriterion("speedGrow not in", values, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("speedGrow between", value1, value2, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andSpeedgrowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("speedGrow not between", value1, value2, "speedgrow");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUniquenameIsNull() {
            addCriterion("uniqueName is null");
            return (Criteria) this;
        }

        public Criteria andUniquenameIsNotNull() {
            addCriterion("uniqueName is not null");
            return (Criteria) this;
        }

        public Criteria andUniquenameEqualTo(String value) {
            addCriterion("uniqueName =", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameNotEqualTo(String value) {
            addCriterion("uniqueName <>", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameGreaterThan(String value) {
            addCriterion("uniqueName >", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameGreaterThanOrEqualTo(String value) {
            addCriterion("uniqueName >=", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameLessThan(String value) {
            addCriterion("uniqueName <", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameLessThanOrEqualTo(String value) {
            addCriterion("uniqueName <=", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameLike(String value) {
            addCriterion("uniqueName like", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameNotLike(String value) {
            addCriterion("uniqueName not like", value, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameIn(List<String> values) {
            addCriterion("uniqueName in", values, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameNotIn(List<String> values) {
            addCriterion("uniqueName not in", values, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameBetween(String value1, String value2) {
            addCriterion("uniqueName between", value1, value2, "uniquename");
            return (Criteria) this;
        }

        public Criteria andUniquenameNotBetween(String value1, String value2) {
            addCriterion("uniqueName not between", value1, value2, "uniquename");
            return (Criteria) this;
        }

        public Criteria andSdateIsNull() {
            addCriterion("sdate is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("sdate is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(Date value) {
            addCriterion("sdate =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(Date value) {
            addCriterion("sdate <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(Date value) {
            addCriterion("sdate >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(Date value) {
            addCriterion("sdate >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(Date value) {
            addCriterion("sdate <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(Date value) {
            addCriterion("sdate <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<Date> values) {
            addCriterion("sdate in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<Date> values) {
            addCriterion("sdate not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(Date value1, Date value2) {
            addCriterion("sdate between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(Date value1, Date value2) {
            addCriterion("sdate not between", value1, value2, "sdate");
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