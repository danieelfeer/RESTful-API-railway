package com.cloud.rest_api_railway.service.exception;

import java.io.Serial;

public class BusinessException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public BusinessException(String message){
        super(message);
    }

}