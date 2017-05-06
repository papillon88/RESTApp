package com.eightyeight.papillon.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by papillon on 5/6/2017.
 */
@XmlRootElement
public class ErrorMessage {

    private String errorMessage;
    private int errorCode;
    private String documentation;

    public ErrorMessage(String errorMessage, int errorCode, String documentation) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documentation = documentation;
    }

    public ErrorMessage(){}

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}
