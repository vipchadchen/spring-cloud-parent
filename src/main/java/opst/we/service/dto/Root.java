package opst.we.service.dto;

import opst.we.model.StHero;

/**
 * @author: chgj
 * @description:
 * @date: create in 2018/2/11 11:02
 * @modified:
 */
public class Root {
    //武将信息
    private StHero hero;
    //信息成功
    private String message;
    //状态 ok
    private String status;

    public StHero getHero() {
        return hero;
    }

    public void setHero(StHero hero) {
        this.hero = hero;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }


}
