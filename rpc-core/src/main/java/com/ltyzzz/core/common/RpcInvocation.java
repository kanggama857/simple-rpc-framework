package com.ltyzzz.core.common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RpcInvocation implements Serializable {

    private static final long serialVersionUID = 8447213193317732435L;
    // 目标方法
    private String targetMethod;
    // 目标服务
    private String targetServiceName;
    // 调用方法参数
    private Object[] args;
    // 请求id，⽤于区分每次请求
    private String uuid;
    //
    private Object response;
    //
    private Throwable e;
    // 是否重试
    private int retry;

    private Map<String,Object> attachments = new HashMap<>();

    @Override
    public String toString() {
        return "RpcInvocation{" +
                "targetMethod='" + targetMethod + '\'' +
                ", targetServiceName='" + targetServiceName + '\'' +
                ", args=" + Arrays.toString(args) +
                ", uuid='" + uuid + '\'' +
                ", response=" + response +
                '}';
    }

    public Throwable getE() {
        return e;
    }

    public void setE(Throwable e) {
        this.e = e;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public Map<String, Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, Object> attachments) {
        this.attachments = attachments;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public String getTargetServiceName() {
        return targetServiceName;
    }

    public void setTargetServiceName(String targetServiceName) {
        this.targetServiceName = targetServiceName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
