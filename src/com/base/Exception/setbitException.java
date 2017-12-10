package com.base.Exception;

public class setbitException extends Exception {
    private String errorMessage;
    public setbitException(String Message)
    {
        errorMessage=Message;
    }
    @Override
    public String toString() {
        return errorMessage;
    }
}
