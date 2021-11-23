package com.stack.bpm.module.flow.po;

import com.stack.bpm.base.domain.BasePO;
import lombok.Data;

import java.util.Date;

/**
 * Description: FlowDeployPO
 *
 * @author Ferris
 * @date 2021/11/12 17:33
 * @Version 1.0
 */
@Data
public class FlowDeployPO extends BasePO {

    private Long id;

    private String deployId;

    private String modelKey;

    private Date deployTime;
}
