package yte.intern.springapplication.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yte.intern.springapplication.common.enums.MessageType;

@Getter
@RequiredArgsConstructor
public class MessageResponse {
    private final MessageType messageResponse;
    private final String message;
}
