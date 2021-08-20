package yte.intern.springapplication.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageResponse {

    private final String message;
    private final MessageType messageType;
}
