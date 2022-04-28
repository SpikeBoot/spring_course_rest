package org.spikeboot.spring.rest.exceptions;

public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
