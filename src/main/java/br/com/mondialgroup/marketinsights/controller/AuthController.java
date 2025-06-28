package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.security.TokenService;
import br.com.mondialgroup.marketinsights.dto.request.LoginRequest;
import br.com.mondialgroup.marketinsights.dto.request.UserRequest;
import br.com.mondialgroup.marketinsights.dto.response.LoginResponse;
import br.com.mondialgroup.marketinsights.dto.response.UserResponse;
import br.com.mondialgroup.marketinsights.exception.InvalidCredentialsException;
import br.com.mondialgroup.marketinsights.mapper.UserMapper;
import br.com.mondialgroup.marketinsights.model.User;
import br.com.mondialgroup.marketinsights.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest request) {
        User user = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.username(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            User user = (User) authenticate.getPrincipal();
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException ex) {
            throw new InvalidCredentialsException("Usuário e/ou senha inválidos");
        }
    }
}
