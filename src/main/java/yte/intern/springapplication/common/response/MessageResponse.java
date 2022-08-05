package yte.intern.springapplication.common.response;

public record MessageResponse(
        ResponseType responseType,
        String message
) {
}
