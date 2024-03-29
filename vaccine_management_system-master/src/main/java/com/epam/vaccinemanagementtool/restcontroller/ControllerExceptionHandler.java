package com.epam.vaccinemanagementtool.restcontroller;

public class ControllerExceptionHandler {
    String timestamp;

    String error;

    String status;

    String path;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ControllerExceptionHandler [timestamp=" + timestamp + ", error=" + error + ", status=" + status + ", path="
                + path + "]";
    }


}
