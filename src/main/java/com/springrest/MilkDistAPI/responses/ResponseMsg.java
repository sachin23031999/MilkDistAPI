package com.springrest.MilkDistAPI.responses;

public class ResponseMsg {
    private String message;
    private String errors;

    public ResponseMsg(String message, String errorMsg) {
        this.message = message;
        this.errors = errorMsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
