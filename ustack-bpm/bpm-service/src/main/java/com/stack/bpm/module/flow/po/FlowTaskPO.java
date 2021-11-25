package com.stack.bpm.module.flow.po;

import com.stack.bpm.base.domain.BasePO;
import lombok.Data;

import java.util.Date;

/**
 * Description: FlowTaskPO
 *
 * @author Ferris
 * @date 2021/11/12 17:44
 * @Version 1.0
 */
@Data
public class FlowTaskPO extends BasePO {

    private Long id;

    private String assignee;

    private String candidate;

    private Date startTime;

    private Date endTime;

    private Integer taskStatus;

    private Integer approved;

}
