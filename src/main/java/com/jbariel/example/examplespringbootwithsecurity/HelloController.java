package com.jbariel.example.examplespringbootwithsecurity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/canary")
    public String canary() {
        return "Tweet";
    }

    @Secured("ROLE_USER")
    @GetMapping("/")
    public String coolKid() {
        return "Hi cool kid, you authed!";
    }

    // @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    // @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/admin")
    public String reallyCoolKid() {
        return "Hi you cool admin creature you!";
    }
}