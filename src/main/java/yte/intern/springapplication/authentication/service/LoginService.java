package yte.intern.springapplication.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.authentication.controller.request.LoginRequest;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResponseType;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;

    public MessageResponse login(LoginRequest loginRequest) {
        var preAuthentication = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        try {
            Authentication postAuthentication = authenticationManager.authenticate(preAuthentication);
            SecurityContext newContext = SecurityContextHolder.createEmptyContext();
            newContext.setAuthentication(postAuthentication);
            SecurityContextHolder.setContext(newContext);

            return new MessageResponse(ResponseType.SUCCESS, "Login is successful");
        } catch (AuthenticationException e) {
            return new MessageResponse(ResponseType.ERROR, "Authentication exception: %s".formatted(e.getMessage()));
        }
    }
}
