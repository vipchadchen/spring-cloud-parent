package opst.we.service.dto;

/**
 * @author: chgj
 * @description:武将组合
 * @date: create in 2018/2/11 11:07
 * @modified:
 */
public class Groups {
    //加成内容
    private String attr;
    //加成武将
    private String members;
    //组合名称
    private String name;

    public void setAttr(String attr){
        this.attr = attr;
    }
    public String getAttr(){
        return this.attr;
    }
    public void setMembers(String members){
        this.members = members;
    }
    public String getMembers(){
        return this.members;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
