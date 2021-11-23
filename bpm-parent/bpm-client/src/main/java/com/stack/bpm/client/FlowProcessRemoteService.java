package com.stack.bpm.client;

import com.stack.bpm.domain.req.ProcessStartReq;

/**
 * Description: ProcessClient
 *
 * @author Ferris
 * @date 2021/11/12 17:20
 * @Version 1.0
 */
public interface FlowProcessRemoteService {

    void start(ProcessStartReq req);

    void reject(ProcessStartReq req);
}
