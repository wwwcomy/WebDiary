package com.iteye.wwwcomy.model;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Representation of validation error. Commonly used return well-formed validation errors from an API layer.
 */
@SuppressWarnings("deprecation")
@JsonRootName("validationError")
@JsonPropertyOrder({ "code", "detail", "field" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ValidationErrorMessage {

    private String code, detail, field;

    /**
     * Constructs an empty {@link ValidationErrorMessage}. Required for Jackson.
     */
    public ValidationErrorMessage() {
    }

    /**
     * Constructs a {@link ValidationErrorMessage} representing a general error with the entity and not a specific field.
     * 
     * @param code documented error code representing a validation error
     * @param detail human-readable English description of the validation error
     */
    public ValidationErrorMessage(String code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    /**
     * Constructs a {@link ValidationErrorMessage} representing an error with a specific field.
     * 
     * @param code documented error code representing a validation error
     * @param detail human-readable English description of the validation error
     * @param field name of the field that caused validation to fail
     */
    public ValidationErrorMessage(String code, String detail, String field) {
        this.code = code;
        this.detail = detail;
        this.field = field;
    }

    /**
     *
     * @return A documented error code representing a validation error.
     */
    @XmlAttribute(name = "code")
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return A human-readable English description of the reason for the error. Expected to be used purely for debugging and not required to be
     *         translatable.
     */
    @XmlAttribute(name = "detail")
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     *
     * @return The name of the field that caused the validation error. May be <tt>null</tt>.
     */
    @XmlAttribute(name = "field")
    @JsonProperty("field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
