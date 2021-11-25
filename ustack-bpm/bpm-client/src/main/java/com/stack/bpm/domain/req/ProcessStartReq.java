package com.stack.bpm.domain.req;

import com.stack.bpm.base.BaseReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Description: ProcessStartReq
 *
 * @author Ferris
 * @date 2021/11/12 18:14
 * @Version 1.0
 */
@Getter
@Setter
public class ProcessStartReq extends BaseReq {

    private String modelProcessKey;

    private String businessCode;

    private String applyUserId;

    private Map<String, String> variables;
}
