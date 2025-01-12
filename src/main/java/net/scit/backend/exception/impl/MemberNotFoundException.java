package net.scit.backend.exception.impl;

import net.scit.backend.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

    @Override
    public String getMessage() {
        return "해당 멤버를 찾을 수 없습니다.";
    }
}
