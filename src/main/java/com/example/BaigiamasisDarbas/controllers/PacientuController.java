package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.istaigos.IstaiguReopzitorija;
import com.example.BaigiamasisDarbas.dao.pacientai.PacientuJpa;
import com.example.BaigiamasisDarbas.dao.pacientai.PacientuReopzitorija;
import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PacientuController {
    private PacientuReopzitorija pacientuReopzitorija;

    public PacientuController(@Autowired PacientuReopzitorija pacientuReopzitorija) {
        this.pacientuReopzitorija = pacientuReopzitorija;
    }

    @GetMapping("/api/pacientai")
    public List<Pacientas> gautiPacientus() {
        return pacientuReopzitorija.gautiVisusPacientus();
    }

}
