package year2019;

import lombok.Getter;
import lombok.Setter;

/**
 * 创建分机返回结果
 * @package com.weimob.scrm.bo.external.callCenter
 * @Author: likun
 * @Date: 2019/11/19
 */
@Getter
@Setter
public class ExtResponse {

    /**
     * 分机账号
     */
    private String voipAccount;

    /**
     * 分机密码
     */
    private String voipPwd;

    /**
     * 企业id
     */
    private String companyId;

    /**
     * 应用id
     */
    private String appId;

}
