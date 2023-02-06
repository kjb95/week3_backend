package com.example.exception;

public class InvalidPersonIdException extends InvalidInputException {
    public InvalidPersonIdException() {
        super("존재하지 않는 사람 아이디 입니다.");
    }
}
