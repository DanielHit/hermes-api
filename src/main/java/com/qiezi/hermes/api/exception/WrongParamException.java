package com.qiezi.hermes.api.exception;

/**
 * Created by Daniel on 3/7/16.
 */
public class WrongParamException extends Exception {
    private static final long serialVersionUID = -6369701412225512706L;

    public WrongParamException() {
    }

    public WrongParamException(String message) {
        super(message);
    }
}
