package edu.icet.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class AuthController {

    @GetMapping("/customer")
    public String sayHelloForCustomer() {
        return "hello customer";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHelloForAdmin() {
        return "hello admin";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String sayHelloForManager() {
        return "hello manager";
    }

    @GetMapping("/cashier")
    public String sayHelloForCashier() {
        return "hello cashier";
    }

    @GetMapping("/staff")
    public String sayHelloForStaff() {
        return "hello Staff";
    }
}
