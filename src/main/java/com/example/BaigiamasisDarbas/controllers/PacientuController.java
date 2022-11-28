package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.pacientai.PacientuRepozitorija;
import com.example.BaigiamasisDarbas.dto.Pacientas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PacientuController {
    private PacientuRepozitorija pacientuRepozitorija;

    public PacientuController(@Autowired PacientuRepozitorija pacientuRepozitorija) {
        this.pacientuRepozitorija = pacientuRepozitorija;
    }

    @PostMapping("/api/pacientai")
    public Optional<Pacientas> sukurtiPacienta(@RequestBody Pacientas pacientas) {
        System.out.println(pacientuRepozitorija.sukurtiPacienta(pacientas));
        return pacientuRepozitorija.gautiPacientaPagalId(pacientas.getId());
    }

    @GetMapping("/api/pacientai")
    public List<Pacientas> gautiPacientus() {
        return pacientuRepozitorija.gautiVisusPacientus();
    }

    @GetMapping("/api/pacientai/{id}")
    public Optional<Pacientas> gautiPacientaPagalId(@PathVariable Long id){
        return pacientuRepozitorija.gautiPacientaPagalId(id);
    }

    @DeleteMapping("/api/pacientai/{id}")
    public void istrintiPacienta(@PathVariable(name = "id") Long id) {
        pacientuRepozitorija.istringiPacienta(id);
        System.out.println("deleted where id: " + id);
    }

    @PutMapping("/api/pacientai/{id}")
    public Optional<Pacientas> atnaujintiPacienta (
        @PathVariable Long id,
        @RequestBody Pacientas naujiDomenys
    ) {
        var naujianmasIrasas = pacientuRepozitorija.gautiPacientaPagalId(id)
                .orElseThrow(() -> new RuntimeException("Nera tokio paciento su id: " + id));
        naujianmasIrasas.setId(id);
        naujianmasIrasas.setVardas(naujiDomenys.getVardas());
        naujianmasIrasas.setPavarde(naujiDomenys.getPavarde());
        naujianmasIrasas.setAmzius(naujiDomenys.getAmzius());
        naujianmasIrasas.setPirmaDoze(naujiDomenys.getPirmaDoze());
        naujianmasIrasas.setAntraDoze(naujiDomenys.getAntraDoze());
        naujianmasIrasas.setTreciaDoze(naujiDomenys.getTreciaDoze());

        return pacientuRepozitorija.gautiPacientaPagalId(id);
    }

}
