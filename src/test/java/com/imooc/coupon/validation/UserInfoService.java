package com.imooc.coupon.validation;

import javax.validation.Valid;

/**
 * ClassName: UserInfoService
 * Description: 用户信息服务类
 * Author: Leo
 * Date: 2020/3/3-20:54
 * email 1437665365@qq.com
 */
public class UserInfoService {

    /**
     * UserInfo 作为输出参数
     * @param userInfo
     */
    public void setUserInfo(@Valid UserInfo userInfo){

    }

    /**
     * UserInfo 作为输出参数
     * @return
     */
    public @Valid UserInfo getUserInfo(){
        return new UserInfo();
    }

    /**
     * 空的构造
     */
    public UserInfoService() {
    }

    /**
     * 接收userInfo作为参数的构造函数
     * @param userInfo
     */
    public UserInfoService(@Valid UserInfo userInfo) {
    }


}
