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
public class BasePlusPO extends BasePO {

    /** 备注 */
    private String              remark;

    private Integer              createType;

    /** 创建者id */
    private Long              createId;

    /** 创建者 */
    private String              createName;

    /** 创建者部门id */
    private Long              createDeptId;

    /** 创建者部门 */
    private String              createDeptName;

    /** 创建时间 */
    private Date createTime;

    private Integer              modifyType;

    /** 更新者id */
    private Long              modifyId;

    /** 更新者 */
    private String              modifyName;

    /** 更新者部门id */
    private Long              modifyDeptId;

    /** 更新者部门 */
    private String              modifyDeptName;

    /** 更新时间 */
    private Date modifyTime;

}
