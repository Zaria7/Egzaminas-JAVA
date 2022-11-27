package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.istaigos.IstaiguReopzitorija;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class IstaiguController {
    private IstaiguReopzitorija istaiguReopzitorija;

    public IstaiguController(@Autowired IstaiguReopzitorija istaiguReopzitorija) {
        this.istaiguReopzitorija = istaiguReopzitorija;
    }

    @PostMapping("/api/istaigos")
    public Optional<SkiepijimoIstaiga> sukurtiIstaiga(@RequestBody SkiepijimoIstaiga istaiga) {
        istaiguReopzitorija.sukurtiSkiepijimoIstaiga(istaiga);
        return istaiguReopzitorija.gautiSkiepijimoIstaigaPagalId(istaiga.getId());
    }

    @GetMapping("/api/istaigos")
    public List<SkiepijimoIstaiga> gautiIstaigas() { return istaiguReopzitorija.gautiVisasSkiepijimoIstaigas();}
}
