package com.mljr.demo.bean;

import com.mljr.demo.bean.em.UserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ASUS on 2016/8/18.
 */
@ApiModel
public class User {

    @ApiModelProperty("ID")
    Long id;

    @ApiModelProperty("姓名")
    String name;

    @ApiModelProperty("密码")
    String password;

    @ApiModelProperty("头像")
    String avator;

    @ApiModelProperty("状态")
    UserStatus status;

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
