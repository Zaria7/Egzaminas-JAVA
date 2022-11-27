package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.istaigos.IstaiguReopzitorija;
import com.example.BaigiamasisDarbas.dao.vakcinos.VakcinuReopzitorija;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import com.example.BaigiamasisDarbas.dto.Vakcina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VakcinuController {
    private VakcinuReopzitorija vakcinuReopzitorija;

    public VakcinuController(@Autowired VakcinuReopzitorija vakcinuReopzitorija) {
        this.vakcinuReopzitorija = vakcinuReopzitorija;
    }

    @PostMapping("/api/vakcinos")
    public Optional<Vakcina> sukurtiVakcina(@RequestBody Vakcina vakcina) {
        vakcinuReopzitorija.sukurtiVakcina(vakcina);
        return vakcinuReopzitorija.gautiVakcinaPagalId(vakcina.getId());
    }

    @GetMapping("/api/vakcinos")
    public List<Vakcina> gautiVakcinas() { return vakcinuReopzitorija.gautiVisasVakcinas();}
}
