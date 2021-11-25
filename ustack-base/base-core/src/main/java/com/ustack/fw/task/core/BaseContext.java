package com.ustack.fw.task.core;

import java.util.Date;

/**
 * Description: 任务上下文
 *
 * @author ferris
 * @date 2018/4/26 16:55
 */
public class BaseContext implements IContext {

    private Boolean result = Boolean.TRUE;

    private Date _beginTime;
    private Date _endTime;


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Date get_beginTime() {
        return _beginTime;
    }

    public void set_beginTime(Date _beginTime) {
        this._beginTime = _beginTime;
    }

    public Date get_endTime() {
        return _endTime;
    }

    public void set_endTime(Date _endTime) {
        this._endTime = _endTime;
    }
}
