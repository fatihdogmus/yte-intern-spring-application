package yte.intern.springapplication.authentication.controller.request;

import javax.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
