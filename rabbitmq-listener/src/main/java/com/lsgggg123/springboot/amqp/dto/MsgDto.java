package com.lsgggg123.springboot.amqp.dto;

/**
 * Created by liushun on 16/5/23.
 */
public class MsgDto {
    private String msg;
    private Integer length;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "MsgDto{" +
                "msg='" + msg + '\'' +
                ", length=" + length +
                '}';
    }
}
