package dev.julia.truekepop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.julia.truekepop.models.Trueke;
import dev.julia.truekepop.services.TruekeService;

@RestController
@RequestMapping("/api/trueke")
public class TruekeController {

    @Autowired
    private TruekeService truekeService;

    @GetMapping
    public List<Trueke> getAllTruekes() {
        return truekeService.getAllTruekes();
    }
}