package com.stack.bpm.module.user;

import java.util.List;

/**
 * Description: JFlowTaskCallBack
 *
 * @author Ferris
 * @date 2021/11/11 16:42
 * @Version 1.0
 */
public interface JFlowTaskCallBack {

    List<Long> getUserId(String serviceGroupId, String processKey, String taskKey);
}
