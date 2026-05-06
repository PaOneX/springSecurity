package edu.icet.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class AuthController {
    @GetMapping("/customer")
    @PreAuthorize("hasRole('USER')")
    public String sayHelloForCustomer() {
        return "hello customer";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHelloForAdmin() {
        return "hello admin";
    }
}
