package com.ri.mycarservice.exceptions;

public class CarNotFoundOrWrongIdException extends RuntimeException {

    public CarNotFoundOrWrongIdException() {
        super();
    }

    public CarNotFoundOrWrongIdException(String message) {
        super(message);
    }

}
