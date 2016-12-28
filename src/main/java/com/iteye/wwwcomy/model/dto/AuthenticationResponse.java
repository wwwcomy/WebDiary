package com.iteye.wwwcomy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("deprecation")
@JsonRootName("validationError")
@JsonPropertyOrder({ "code", "detail", "field" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AuthenticationResponse {

    private boolean success;
    private String message;

    public AuthenticationResponse(boolean success) {
        this.success = success;
    }

    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
