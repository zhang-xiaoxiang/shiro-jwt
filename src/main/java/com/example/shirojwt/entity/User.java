package com.example.shirojwt.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户端用户表
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键ID
     */
    @TableId
    private String userId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户登录密码
     */
    private String userPassword;

    /**
     * 用户头像
     */
    private String userIcon;

    /**
     * 用户邮箱地址
     */
    private String userEmail;

    /**
     * 用户身份认证 (0未认证,1已认证)
     */
    private Integer userAutonym;

    /**
     * 用户地址
     */
    private String userSite;

    /**
     * 用户性别( 0女,1男)
     */
    private Integer userSex;

    /**
     * 用户出生日期
     */
    private LocalDateTime userDateBirth;

    /**
     * 用户个性签名
     */
    private String userSignature;

    /**
     * 是否导游
     */
    private Integer userGuide;

    /**
     * 用户是否会员 ( 0否1是)
     */
    private Integer userVip;

    /**
     * 用户积分
     */
    private Integer userIntegral;

    /**
     * 移动设备唯一cid
     */
    private String cId;

    /**
     * 用户注册时间
     */
    private Date createTime;

    /**
     * 微信openID
     */
    private String wxOpenid;

    /**
     * 微信头像
     */
    private String wxIcon;

    /**
     * QQopenID
     */
    private String qqOpenid;

    /**
     * QQ头像
     */
    private String qqIcon;


}
