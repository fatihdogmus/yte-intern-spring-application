package yte.intern.springapplication.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.authentication.controller.request.LoginRequest;
import yte.intern.springapplication.authentication.service.LoginService;
import yte.intern.springapplication.common.response.MessageResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public MessageResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);

    }
}
