package com.erp.web4j.bean;

import javax.validation.constraints.NotNull;

public class Work {
    @NotNull(message = "作业编号不能为空")
    private String workId;

    @NotNull(message = "工序号不能为空")
    private String processNumber;

    @NotNull(message = "产品不能为空")
    private String productId;

    @NotNull(message = "工序不能为空")
    private String processId;

    @NotNull(message = "设备不能为空")
    private String deviceId;

    private Integer rating;

    private Product product;

    private Device device;

    private Process process;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber == null ? null : processNumber.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId='" + workId + '\'' +
                ", processNumber='" + processNumber + '\'' +
                ", productId='" + productId + '\'' +
                ", processId='" + processId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", rating=" + rating +
                ", product=" + product +
                ", device=" + device +
                ", process=" + process +
                '}';
    }
}