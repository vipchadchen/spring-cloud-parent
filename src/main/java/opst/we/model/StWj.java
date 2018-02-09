package opst.we.model;

import java.math.BigDecimal;
import java.util.Date;

public class StWj {
    private Integer id;

    private String name;

    private String xj;

    private BigDecimal cost;

    private String bz;

    private BigDecimal jl;

    private BigDecimal mn;

    private BigDecimal gj;

    private BigDecimal gc;

    private BigDecimal fy;

    private BigDecimal sd;

    private String zf;

    private String cj;

    private Date createdate;

    private String ref1;

    private String ref2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getXj() {
        return xj;
    }

    public void setXj(String xj) {
        this.xj = xj == null ? null : xj.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public BigDecimal getJl() {
        return jl;
    }

    public void setJl(BigDecimal jl) {
        this.jl = jl;
    }

    public BigDecimal getMn() {
        return mn;
    }

    public void setMn(BigDecimal mn) {
        this.mn = mn;
    }

    public BigDecimal getGj() {
        return gj;
    }

    public void setGj(BigDecimal gj) {
        this.gj = gj;
    }

    public BigDecimal getGc() {
        return gc;
    }

    public void setGc(BigDecimal gc) {
        this.gc = gc;
    }

    public BigDecimal getFy() {
        return fy;
    }

    public void setFy(BigDecimal fy) {
        this.fy = fy;
    }

    public BigDecimal getSd() {
        return sd;
    }

    public void setSd(BigDecimal sd) {
        this.sd = sd;
    }

    public String getZf() {
        return zf;
    }

    public void setZf(String zf) {
        this.zf = zf == null ? null : zf.trim();
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj == null ? null : cj.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1 == null ? null : ref1.trim();
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2 == null ? null : ref2.trim();
    }
}