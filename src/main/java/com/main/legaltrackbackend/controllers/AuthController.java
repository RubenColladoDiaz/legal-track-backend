package com.main.legaltrackbackend.controllers;

import com.main.legaltrackbackend.models.auth.User;
import com.main.legaltrackbackend.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legaltrack/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    @Autowired
    private AuthRepository authRepository;

    @GetMapping(path = "/login")
    public @ResponseBody String Login(@RequestParam String username, @RequestParam String password) {
        User user = authRepository.findByUsername(username);
        if (user == null) {
            return "Usuario " + username + " no encontrado";
        }
        if(!user.getPassword().equals(password)) {
            return "Contraseña incorrecta para " + username;
        }
        return username + " logeado correctamente";
    }
}
