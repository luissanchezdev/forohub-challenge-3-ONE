package com.luissdev.forohub.auth;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            // Crear una instancia de AuthResponse con un mensaje de error
            AuthResponse errorResponse = new AuthResponse("Verificar los datos proporcionados");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            // Crear una instancia de AuthResponse con un mensaje de error
            AuthResponse errorResponse = new AuthResponse("Verificar los datos proporcionados");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return ResponseEntity.ok(authService.login(request));
    }
}
