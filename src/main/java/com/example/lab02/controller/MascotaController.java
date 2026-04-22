package com.example.lab02.controller;

import com.example.lab02.repository.MascotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    final MascotaRepository mascotaRepository;
    public MascotaController(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }
}
