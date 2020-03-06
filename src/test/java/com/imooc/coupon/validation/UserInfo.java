package com.imooc.coupon.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * ClassName: UserInfo
 * Description: 待验证对象实体类
 * Author: Leo
 * Date: 2020/3/2-21:58
 * email 1437665365@qq.com
 */
@Data
public class UserInfo {
    /**
     * 分组验证
     */
    //登录场景
    public interface LoginGroup{};
    //注册场景
    public interface RegisterGroup{};
    /**
     * 组排序场景
     * 按顺序执行
     */
    @GroupSequence({
            Default.class,
            RegisterGroup.class,
            LoginGroup.class
    })
    public interface Group{}


    //不能为空
    @NotNull(message = "用户id不能为空",groups = LoginGroup.class)
    private String userId;
    @NotEmpty(message = "用户名称不能为空")
    private String userName;
    //NotBlank 会自动去掉字符串前后空格后 验证是否为空
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6,max = 20,message = "密码长度不能少于6位,多于20位")

    private String password;
    @NotBlank(message = "邮箱不能为空",groups = RegisterGroup.class)
    @Email(message = "邮箱必须为有效的邮箱")
    private String email;
    @Pattern(regexp = "^(\\d{3,4}-)?\\d{7,8}$|(1[3|5|7|8]\\d{9})",message = "手机或电话不规范")
    @Phone(message = "手机号或者电话不规范")
    //Phone是自定义注解
    private String phone;
    @Min(value = 0,message = "年龄不能小于0岁")
    @Max(value = 150,message = "年龄不能大于150岁")
    private Integer age;
    //对过去时间点
    @Past(message = "生日不能为未来时间")
    private Date birthday;
    //好友列表
    //对集合个数进行限制
    @Size(min = 1,message = "不能少于1个好友")
    private List<@Valid  UserInfo> firends;
}
