package com.ustack.fw.task;

import com.ustack.fw.task.core.BaseContext;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TaskContext
 *
 * @author Ferris
 * @date 2021/11/19 11:46
 * @Version 1.0
 */
public class TaskContext extends BaseContext {

    private Map<String, String> keyMap = new HashMap<>();

    public void putKeyMap(String key, String value) {
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
            keyMap.put(key, value);
        }
    }

    public Map<String, String> getKeyMap() {
        return keyMap;
    }
}
