package com.imooc.coupon.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

/**
 * ClassName: ValidationTest
 * Description: 验证测试类
 * Author: Leo
 * Date: 2020/3/2-21:59
 * email 1437665365@qq.com
 */
public class ValidationTest {
    //验证器对象
    private Validator validator;
    //待验证对象
    private UserInfo userInfo;
    //验证结果集合
    private Set<ConstraintViolation<UserInfo>> set;
    //验证结果集合
    private Set<ConstraintViolation<UserInfoService>> otherSet;

    /**
     * 初始化操作
     */
    @Before
    public void init(){
        //初始化验证器
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        //初始化待验证对象 -用户信息
        userInfo = new UserInfo();
        userInfo.setUserId("xzc5521");
        userInfo.setUserName("xuzhongchun");
        userInfo.setPassword("123xu1225..");
//        userInfo.setEmail("146@xinncdv.com");
        userInfo.setAge(20);
        userInfo.setPhone("15544oojnbvv");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,2,1);
        userInfo.setBirthday(calendar.getTime());
        UserInfo friends = new UserInfo();
        friends.setUserId("ABC123");
        friends.setUserName("ZGRM123");
        friends.setPassword("xzv11742");
        friends.setEmail("15466@asa.com");
        userInfo.setFirends(new ArrayList(){{add(friends);} });




    }

    /**
     * 结果打印
     */
    @After
    public void print(){
        //防止Stream 流为null
//        Optional.ofNullable(list).map(List::stream)
//                .orElseGet(Stream::empty)
//                .forEach(System.out::println);
        set.forEach(x->{
            //输出验证错误信息
            System.out.println(x.getMessage());
        });
//        otherSet.forEach(x->{
//            System.out.println(x.getMessage());
//        });

    }

    @Test
    public void nullValidation(){
        //使用验证器对对象进行验证
        set = validator.validate(userInfo);

    }

    /**
     * 级联验证测试方法
     * @Vaild
     */
    @Test
    public void graphValidationTest(){
        set = validator.validate(userInfo);

    }
    /**
     * 分组验证测试方法
     * @Vaild
     */
    @Test
    public void groupValidationTest(){
        set = validator.validate(userInfo,UserInfo.LoginGroup.class);
        set = validator.validate(userInfo, UserInfo.RegisterGroup.class, UserInfo.LoginGroup.class);

    }

    /**
     *组序列测试
     */
    @Test
    public void groupSequenceValidation(){
        set = validator.validate(userInfo,UserInfo.Group.class);
    }

    /**
     * 对方法输入参数进行约束注解效验
     */
    @Test
    public void paramValidation() throws NoSuchMethodException {
        //获取校验执行器
        ExecutableValidator executables = validator.forExecutables();
        // 待验证对象
        UserInfoService service = new UserInfoService();
        // 待验证方法
        Method method = service.getClass().getMethod("setUserInfo", UserInfo.class);
        // 待验证参数
        Object[] parameterValues = new Object[]{new UserInfo()};
        // 对方法的输入参数进行校验
         otherSet = executables.validateParameters(service, method, parameterValues);
    }
    //对方法返回值进行约束注解效验
    @Test
    public void returnValueValidation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取效验执行器
        ExecutableValidator executables = validator.forExecutables();
        //构造要验证的方法对象
        UserInfoService service = new UserInfoService();
        Method method = service.getClass().getMethod("getUserInfo");
        //调用方法得到返回值
        Object returnValue = method.invoke(service);
        //效验方法返回值是否符合约束
        otherSet = executables.validateReturnValue(service, method, returnValue);

    }

    @Test
    public void constructorValidation() throws NoSuchMethodException {
        //获取验证执行器
        ExecutableValidator executables = validator.forExecutables();
        //获取构造函数
        Constructor<UserInfoService> constructor = UserInfoService.class.getConstructor(UserInfo.class);
        Object[] parameterValues = new Object[]{new UserInfo()};
        //效验构造函数
        otherSet = executables.validateConstructorParameters(constructor,parameterValues);

    }


}
