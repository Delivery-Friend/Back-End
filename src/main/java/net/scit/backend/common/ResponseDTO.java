package net.scit.backend.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    private String message;
    private T data;

}
