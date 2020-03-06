package com.imooc.coupon.entry;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CouponTemplate implements Serializable {

    private static final long serialVersionUID = -8045163739483634032L;

    //按ctrl-alt+shift+u转换 驼峰
    private String username = "xu-zhong-chun";
    /**
     * 自增主键
     */

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 是否是可用状态
     */
    @Column(name = "available", nullable = false)
    private Boolean available;

    /**
     * 是否过期
     */
    @Column(name = "expired", nullable = false)
    private Boolean expired;

    /**
     * 优惠券名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 优惠券 logo
     */
    @Column(name = "logo", nullable = false)
    private String logo;

    /**
     * 优惠券描述
     */
    @Column(name = "intro", nullable = false)
    private String desc;





    /**
     * 总数
     */
    @Column(name = "coupon_count", nullable = false)
    private Integer count;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /**
     * 创建用户
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 优惠券模板的编码
     */
    @Column(name = "template_key", nullable = false)
    private String key;







}
