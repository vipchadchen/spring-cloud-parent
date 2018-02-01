package opst.we.model;

import java.util.ArrayList;
import java.util.List;

public class StWjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StWjExample() {
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

        public Criteria andDescstIsNull() {
            addCriterion("descst is null");
            return (Criteria) this;
        }

        public Criteria andDescstIsNotNull() {
            addCriterion("descst is not null");
            return (Criteria) this;
        }

        public Criteria andDescstEqualTo(String value) {
            addCriterion("descst =", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstNotEqualTo(String value) {
            addCriterion("descst <>", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstGreaterThan(String value) {
            addCriterion("descst >", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstGreaterThanOrEqualTo(String value) {
            addCriterion("descst >=", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstLessThan(String value) {
            addCriterion("descst <", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstLessThanOrEqualTo(String value) {
            addCriterion("descst <=", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstLike(String value) {
            addCriterion("descst like", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstNotLike(String value) {
            addCriterion("descst not like", value, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstIn(List<String> values) {
            addCriterion("descst in", values, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstNotIn(List<String> values) {
            addCriterion("descst not in", values, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstBetween(String value1, String value2) {
            addCriterion("descst between", value1, value2, "descst");
            return (Criteria) this;
        }

        public Criteria andDescstNotBetween(String value1, String value2) {
            addCriterion("descst not between", value1, value2, "descst");
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

        public Criteria andCostEqualTo(String value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(String value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(String value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(String value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(String value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(String value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLike(String value) {
            addCriterion("cost like", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotLike(String value) {
            addCriterion("cost not like", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<String> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<String> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(String value1, String value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(String value1, String value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andJlIsNull() {
            addCriterion("jl is null");
            return (Criteria) this;
        }

        public Criteria andJlIsNotNull() {
            addCriterion("jl is not null");
            return (Criteria) this;
        }

        public Criteria andJlEqualTo(String value) {
            addCriterion("jl =", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlNotEqualTo(String value) {
            addCriterion("jl <>", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlGreaterThan(String value) {
            addCriterion("jl >", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlGreaterThanOrEqualTo(String value) {
            addCriterion("jl >=", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlLessThan(String value) {
            addCriterion("jl <", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlLessThanOrEqualTo(String value) {
            addCriterion("jl <=", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlLike(String value) {
            addCriterion("jl like", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlNotLike(String value) {
            addCriterion("jl not like", value, "jl");
            return (Criteria) this;
        }

        public Criteria andJlIn(List<String> values) {
            addCriterion("jl in", values, "jl");
            return (Criteria) this;
        }

        public Criteria andJlNotIn(List<String> values) {
            addCriterion("jl not in", values, "jl");
            return (Criteria) this;
        }

        public Criteria andJlBetween(String value1, String value2) {
            addCriterion("jl between", value1, value2, "jl");
            return (Criteria) this;
        }

        public Criteria andJlNotBetween(String value1, String value2) {
            addCriterion("jl not between", value1, value2, "jl");
            return (Criteria) this;
        }

        public Criteria andMnIsNull() {
            addCriterion("mn is null");
            return (Criteria) this;
        }

        public Criteria andMnIsNotNull() {
            addCriterion("mn is not null");
            return (Criteria) this;
        }

        public Criteria andMnEqualTo(String value) {
            addCriterion("mn =", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotEqualTo(String value) {
            addCriterion("mn <>", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnGreaterThan(String value) {
            addCriterion("mn >", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnGreaterThanOrEqualTo(String value) {
            addCriterion("mn >=", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLessThan(String value) {
            addCriterion("mn <", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLessThanOrEqualTo(String value) {
            addCriterion("mn <=", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLike(String value) {
            addCriterion("mn like", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotLike(String value) {
            addCriterion("mn not like", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnIn(List<String> values) {
            addCriterion("mn in", values, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotIn(List<String> values) {
            addCriterion("mn not in", values, "mn");
            return (Criteria) this;
        }

        public Criteria andMnBetween(String value1, String value2) {
            addCriterion("mn between", value1, value2, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotBetween(String value1, String value2) {
            addCriterion("mn not between", value1, value2, "mn");
            return (Criteria) this;
        }

        public Criteria andGjIsNull() {
            addCriterion("gj is null");
            return (Criteria) this;
        }

        public Criteria andGjIsNotNull() {
            addCriterion("gj is not null");
            return (Criteria) this;
        }

        public Criteria andGjEqualTo(String value) {
            addCriterion("gj =", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotEqualTo(String value) {
            addCriterion("gj <>", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjGreaterThan(String value) {
            addCriterion("gj >", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjGreaterThanOrEqualTo(String value) {
            addCriterion("gj >=", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjLessThan(String value) {
            addCriterion("gj <", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjLessThanOrEqualTo(String value) {
            addCriterion("gj <=", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjLike(String value) {
            addCriterion("gj like", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotLike(String value) {
            addCriterion("gj not like", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjIn(List<String> values) {
            addCriterion("gj in", values, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotIn(List<String> values) {
            addCriterion("gj not in", values, "gj");
            return (Criteria) this;
        }

        public Criteria andGjBetween(String value1, String value2) {
            addCriterion("gj between", value1, value2, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotBetween(String value1, String value2) {
            addCriterion("gj not between", value1, value2, "gj");
            return (Criteria) this;
        }

        public Criteria andGcIsNull() {
            addCriterion("gc is null");
            return (Criteria) this;
        }

        public Criteria andGcIsNotNull() {
            addCriterion("gc is not null");
            return (Criteria) this;
        }

        public Criteria andGcEqualTo(String value) {
            addCriterion("gc =", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotEqualTo(String value) {
            addCriterion("gc <>", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcGreaterThan(String value) {
            addCriterion("gc >", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcGreaterThanOrEqualTo(String value) {
            addCriterion("gc >=", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcLessThan(String value) {
            addCriterion("gc <", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcLessThanOrEqualTo(String value) {
            addCriterion("gc <=", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcLike(String value) {
            addCriterion("gc like", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotLike(String value) {
            addCriterion("gc not like", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcIn(List<String> values) {
            addCriterion("gc in", values, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotIn(List<String> values) {
            addCriterion("gc not in", values, "gc");
            return (Criteria) this;
        }

        public Criteria andGcBetween(String value1, String value2) {
            addCriterion("gc between", value1, value2, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotBetween(String value1, String value2) {
            addCriterion("gc not between", value1, value2, "gc");
            return (Criteria) this;
        }

        public Criteria andFyIsNull() {
            addCriterion("fy is null");
            return (Criteria) this;
        }

        public Criteria andFyIsNotNull() {
            addCriterion("fy is not null");
            return (Criteria) this;
        }

        public Criteria andFyEqualTo(String value) {
            addCriterion("fy =", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyNotEqualTo(String value) {
            addCriterion("fy <>", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyGreaterThan(String value) {
            addCriterion("fy >", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyGreaterThanOrEqualTo(String value) {
            addCriterion("fy >=", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyLessThan(String value) {
            addCriterion("fy <", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyLessThanOrEqualTo(String value) {
            addCriterion("fy <=", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyLike(String value) {
            addCriterion("fy like", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyNotLike(String value) {
            addCriterion("fy not like", value, "fy");
            return (Criteria) this;
        }

        public Criteria andFyIn(List<String> values) {
            addCriterion("fy in", values, "fy");
            return (Criteria) this;
        }

        public Criteria andFyNotIn(List<String> values) {
            addCriterion("fy not in", values, "fy");
            return (Criteria) this;
        }

        public Criteria andFyBetween(String value1, String value2) {
            addCriterion("fy between", value1, value2, "fy");
            return (Criteria) this;
        }

        public Criteria andFyNotBetween(String value1, String value2) {
            addCriterion("fy not between", value1, value2, "fy");
            return (Criteria) this;
        }

        public Criteria andSdIsNull() {
            addCriterion("sd is null");
            return (Criteria) this;
        }

        public Criteria andSdIsNotNull() {
            addCriterion("sd is not null");
            return (Criteria) this;
        }

        public Criteria andSdEqualTo(String value) {
            addCriterion("sd =", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotEqualTo(String value) {
            addCriterion("sd <>", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdGreaterThan(String value) {
            addCriterion("sd >", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdGreaterThanOrEqualTo(String value) {
            addCriterion("sd >=", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdLessThan(String value) {
            addCriterion("sd <", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdLessThanOrEqualTo(String value) {
            addCriterion("sd <=", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdLike(String value) {
            addCriterion("sd like", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotLike(String value) {
            addCriterion("sd not like", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdIn(List<String> values) {
            addCriterion("sd in", values, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotIn(List<String> values) {
            addCriterion("sd not in", values, "sd");
            return (Criteria) this;
        }

        public Criteria andSdBetween(String value1, String value2) {
            addCriterion("sd between", value1, value2, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotBetween(String value1, String value2) {
            addCriterion("sd not between", value1, value2, "sd");
            return (Criteria) this;
        }

        public Criteria andZfIsNull() {
            addCriterion("zf is null");
            return (Criteria) this;
        }

        public Criteria andZfIsNotNull() {
            addCriterion("zf is not null");
            return (Criteria) this;
        }

        public Criteria andZfEqualTo(String value) {
            addCriterion("zf =", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotEqualTo(String value) {
            addCriterion("zf <>", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfGreaterThan(String value) {
            addCriterion("zf >", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfGreaterThanOrEqualTo(String value) {
            addCriterion("zf >=", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfLessThan(String value) {
            addCriterion("zf <", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfLessThanOrEqualTo(String value) {
            addCriterion("zf <=", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfLike(String value) {
            addCriterion("zf like", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotLike(String value) {
            addCriterion("zf not like", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfIn(List<String> values) {
            addCriterion("zf in", values, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotIn(List<String> values) {
            addCriterion("zf not in", values, "zf");
            return (Criteria) this;
        }

        public Criteria andZfBetween(String value1, String value2) {
            addCriterion("zf between", value1, value2, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotBetween(String value1, String value2) {
            addCriterion("zf not between", value1, value2, "zf");
            return (Criteria) this;
        }

        public Criteria andCjIsNull() {
            addCriterion("cj is null");
            return (Criteria) this;
        }

        public Criteria andCjIsNotNull() {
            addCriterion("cj is not null");
            return (Criteria) this;
        }

        public Criteria andCjEqualTo(String value) {
            addCriterion("cj =", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotEqualTo(String value) {
            addCriterion("cj <>", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjGreaterThan(String value) {
            addCriterion("cj >", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjGreaterThanOrEqualTo(String value) {
            addCriterion("cj >=", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLessThan(String value) {
            addCriterion("cj <", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLessThanOrEqualTo(String value) {
            addCriterion("cj <=", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLike(String value) {
            addCriterion("cj like", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotLike(String value) {
            addCriterion("cj not like", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjIn(List<String> values) {
            addCriterion("cj in", values, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotIn(List<String> values) {
            addCriterion("cj not in", values, "cj");
            return (Criteria) this;
        }

        public Criteria andCjBetween(String value1, String value2) {
            addCriterion("cj between", value1, value2, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotBetween(String value1, String value2) {
            addCriterion("cj not between", value1, value2, "cj");
            return (Criteria) this;
        }

        public Criteria andRef1IsNull() {
            addCriterion("ref1 is null");
            return (Criteria) this;
        }

        public Criteria andRef1IsNotNull() {
            addCriterion("ref1 is not null");
            return (Criteria) this;
        }

        public Criteria andRef1EqualTo(String value) {
            addCriterion("ref1 =", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1NotEqualTo(String value) {
            addCriterion("ref1 <>", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1GreaterThan(String value) {
            addCriterion("ref1 >", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1GreaterThanOrEqualTo(String value) {
            addCriterion("ref1 >=", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1LessThan(String value) {
            addCriterion("ref1 <", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1LessThanOrEqualTo(String value) {
            addCriterion("ref1 <=", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1Like(String value) {
            addCriterion("ref1 like", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1NotLike(String value) {
            addCriterion("ref1 not like", value, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1In(List<String> values) {
            addCriterion("ref1 in", values, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1NotIn(List<String> values) {
            addCriterion("ref1 not in", values, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1Between(String value1, String value2) {
            addCriterion("ref1 between", value1, value2, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef1NotBetween(String value1, String value2) {
            addCriterion("ref1 not between", value1, value2, "ref1");
            return (Criteria) this;
        }

        public Criteria andRef2IsNull() {
            addCriterion("ref2 is null");
            return (Criteria) this;
        }

        public Criteria andRef2IsNotNull() {
            addCriterion("ref2 is not null");
            return (Criteria) this;
        }

        public Criteria andRef2EqualTo(String value) {
            addCriterion("ref2 =", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2NotEqualTo(String value) {
            addCriterion("ref2 <>", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2GreaterThan(String value) {
            addCriterion("ref2 >", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2GreaterThanOrEqualTo(String value) {
            addCriterion("ref2 >=", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2LessThan(String value) {
            addCriterion("ref2 <", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2LessThanOrEqualTo(String value) {
            addCriterion("ref2 <=", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2Like(String value) {
            addCriterion("ref2 like", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2NotLike(String value) {
            addCriterion("ref2 not like", value, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2In(List<String> values) {
            addCriterion("ref2 in", values, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2NotIn(List<String> values) {
            addCriterion("ref2 not in", values, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2Between(String value1, String value2) {
            addCriterion("ref2 between", value1, value2, "ref2");
            return (Criteria) this;
        }

        public Criteria andRef2NotBetween(String value1, String value2) {
            addCriterion("ref2 not between", value1, value2, "ref2");
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