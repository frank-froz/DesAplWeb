package com.tecsup.prj_spring_boot_security_ii.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {

    @GetMapping("/locale")
    public String locale(HttpServletRequest request) {
        String ultimaUrl = request.getHeader("referer");
        return "redirect:" + (ultimaUrl != null ? ultimaUrl : "/");
    }
}