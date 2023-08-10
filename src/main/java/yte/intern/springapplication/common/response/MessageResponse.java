package yte.intern.springapplication.common.response;

public record MessageResponse(
        String message,
        MessageType messageType
) {
}
