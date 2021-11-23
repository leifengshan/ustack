package com.stack.bpm.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Description: BasePlusPO 基类
 *
 * @author ferris
 * @date 2021/7/7 12:12
 * @Version 1.0
 */
@Setter
@Getter
public class BaseDatePO extends BasePO {

    /** 备注 */
    private String              remark;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date modifyTime;

}
