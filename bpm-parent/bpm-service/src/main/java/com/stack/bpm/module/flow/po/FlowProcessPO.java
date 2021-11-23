package com.stack.bpm.module.flow.po;

import com.stack.bpm.base.domain.BasePO;
import lombok.Data;

import java.util.Date;

/**
 * Description: FlowProcessPO
 *
 * @author Ferris
 * @date 2021/11/12 17:38
 * @Version 1.0
 */
@Data
public class FlowProcessPO extends BasePO {

    private Long id;

    private String processId;

    private String businessCode;

    private String modelKey;

    private String deployId;

    private Integer processStatus;

    private String applyUserId;

    private String variables;

    private Date applyTime;
}
