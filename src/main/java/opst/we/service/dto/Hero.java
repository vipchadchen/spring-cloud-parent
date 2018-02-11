package opst.we.service.dto;

import java.util.List;

/**
 * @author: chgj
 * @description: 武将信息
 * @date: create in 2018/2/11 11:07
 * @modified:
 */
public class Hero {
    //攻击成长
    private double attGrow;
    //攻击
    private int attack;
    //阵营
    private String contory;
    //cost
    private double cost;
    //防御
    private int def;
    //防御成长
    private double defGrow;
    //描述
    private String desc;
    //距离
    private int distance;
    //组合属性
    private String groudArr;
    //null
    private String groupName;
    //组合
    private List<Groups> groups ;
    //图片
    private String icon;
    //id
    private int id;
    //战法描述
    private String methodDesc;
    //拆解战法描述
    private String methodDesc1;
    //null
    private String methodDesc2;
    //战法详情
    private MethodDetail methodDetail;
    //拆解战法详情
    private MethodDetail1 methodDetail1;
    //null
    private String methodDetail2;
    //战法ID
    private int methodId;
    //拆解战法ID
    private int methodId1;
    //null
    private String methodId2;
    //战法名称
    private String methodName;
    //战法名称
    private String methodName1;
    //战法ID
    private String methodName2;
    //武将名称
    private String name;
    //星级
    private int quality;
    //谋略
    private int ruse;
    //谋略成长
    private double ruseGrow;
    //性别
    private String sex;
    //攻城
    private int siege;
    //攻城成长
    private double siegeGrow;
    //速度
    private int speed;
    //速度成长
    private double speedGrow;
    //兵种
    private String type;
    //名字
    private String uniqueName;

    public void setAttGrow(double attGrow){
        this.attGrow = attGrow;
    }
    public double getAttGrow(){
        return this.attGrow;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getAttack(){
        return this.attack;
    }
    public void setContory(String contory){
        this.contory = contory;
    }
    public String getContory(){
        return this.contory;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public double getCost(){
        return this.cost;
    }
    public void setDef(int def){
        this.def = def;
    }
    public int getDef(){
        return this.def;
    }
    public void setDefGrow(double defGrow){
        this.defGrow = defGrow;
    }
    public double getDefGrow(){
        return this.defGrow;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return this.desc;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
    public int getDistance(){
        return this.distance;
    }
    public void setGroudArr(String groudArr){
        this.groudArr = groudArr;
    }
    public String getGroudArr(){
        return this.groudArr;
    }
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
    public String getGroupName(){
        return this.groupName;
    }
    public void setGroups(List<Groups> groups){
        this.groups = groups;
    }
    public List<Groups> getGroups(){
        return this.groups;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return this.icon;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setMethodDesc(String methodDesc){
        this.methodDesc = methodDesc;
    }
    public String getMethodDesc(){
        return this.methodDesc;
    }
    public void setMethodDesc1(String methodDesc1){
        this.methodDesc1 = methodDesc1;
    }
    public String getMethodDesc1(){
        return this.methodDesc1;
    }
    public void setMethodDesc2(String methodDesc2){
        this.methodDesc2 = methodDesc2;
    }
    public String getMethodDesc2(){
        return this.methodDesc2;
    }
    public void setMethodDetail(MethodDetail methodDetail){
        this.methodDetail = methodDetail;
    }
    public MethodDetail getMethodDetail(){
        return this.methodDetail;
    }
    public void setMethodDetail1(MethodDetail1 methodDetail1){
        this.methodDetail1 = methodDetail1;
    }
    public MethodDetail1 getMethodDetail1(){
        return this.methodDetail1;
    }
    public void setMethodDetail2(String methodDetail2){
        this.methodDetail2 = methodDetail2;
    }
    public String getMethodDetail2(){
        return this.methodDetail2;
    }
    public void setMethodId(int methodId){
        this.methodId = methodId;
    }
    public int getMethodId(){
        return this.methodId;
    }
    public void setMethodId1(int methodId1){
        this.methodId1 = methodId1;
    }
    public int getMethodId1(){
        return this.methodId1;
    }
    public void setMethodId2(String methodId2){
        this.methodId2 = methodId2;
    }
    public String getMethodId2(){
        return this.methodId2;
    }
    public void setMethodName(String methodName){
        this.methodName = methodName;
    }
    public String getMethodName(){
        return this.methodName;
    }
    public void setMethodName1(String methodName1){
        this.methodName1 = methodName1;
    }
    public String getMethodName1(){
        return this.methodName1;
    }
    public void setMethodName2(String methodName2){
        this.methodName2 = methodName2;
    }
    public String getMethodName2(){
        return this.methodName2;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setQuality(int quality){
        this.quality = quality;
    }
    public int getQuality(){
        return this.quality;
    }
    public void setRuse(int ruse){
        this.ruse = ruse;
    }
    public int getRuse(){
        return this.ruse;
    }
    public void setRuseGrow(double ruseGrow){
        this.ruseGrow = ruseGrow;
    }
    public double getRuseGrow(){
        return this.ruseGrow;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }
    public void setSiege(int siege){
        this.siege = siege;
    }
    public int getSiege(){
        return this.siege;
    }
    public void setSiegeGrow(double siegeGrow){
        this.siegeGrow = siegeGrow;
    }
    public double getSiegeGrow(){
        return this.siegeGrow;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeedGrow(double speedGrow){
        this.speedGrow = speedGrow;
    }
    public double getSpeedGrow(){
        return this.speedGrow;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setUniqueName(String uniqueName){
        this.uniqueName = uniqueName;
    }
    public String getUniqueName(){
        return this.uniqueName;
    }
}
