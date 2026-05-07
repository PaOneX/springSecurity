package edu.icet.controller;

import edu.icet.model.User;
import edu.icet.service.MyUserServiceDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final MyUserServiceDetails service;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        service.save(user);
    }

}
