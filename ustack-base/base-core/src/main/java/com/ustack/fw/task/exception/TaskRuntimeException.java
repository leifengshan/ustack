package com.ustack.fw.task.exception;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

/**
 * @author ferris
 * @date 2018/8/14 19:22
 */
public class TaskRuntimeException extends RuntimeException {

    private int code = -1;
    private String msg = "任务异常";
    private String[] vars = {};

    public TaskRuntimeException() {
    }

    public TaskRuntimeException(int code, String msg, String... vars) {
        this.code = code;
        this.msg = msg;
        this.vars = vars;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        if (StringUtils.isNotEmpty(msg) && vars.length > 0) {
            return MessageFormat.format(msg, vars);
        } else {
            return msg;
        }
    }

    public TaskRuntimeException(String message) {
        super(message);
    }

    public TaskRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskRuntimeException(Throwable cause) {
        super(cause);
    }

    public static void main(String[] args) {
        TaskRuntimeException e = new TaskRuntimeException(1, "rewrw{0}33");
        System.out.println(e.getMsg());
    }
}
