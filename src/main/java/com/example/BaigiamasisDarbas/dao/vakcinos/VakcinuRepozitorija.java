package com.example.BaigiamasisDarbas.dao.vakcinos;

import com.example.BaigiamasisDarbas.dto.Vakcina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VakcinuRepozitorija implements VakcinuDAO {
    private final VakcinuJpa vakcinuJpa;

    public VakcinuRepozitorija(@Autowired VakcinuJpa vakcinuJpa) {
        this.vakcinuJpa = vakcinuJpa;
    }

    @Override
    public Vakcina issaugotiVakcina(Vakcina atnaujinamaVakcina) {
        return vakcinuJpa.save(atnaujinamaVakcina);
    }

    @Override
    public String sukurtiVakcina(Vakcina vakcina) {
        var naujasId = vakcina.getId();
        boolean ifExists = gautiVisasVakcinas()
                .stream()
                .mapToLong(Vakcina::getId)
                .anyMatch(id -> naujasId == id);
        if(ifExists) {
            return "Toks įrašas jau yra";
        } else {
            vakcinuJpa.save(vakcina);
            return "Vakcina sėkmingai sukurta";
        }
    }

    @Override
    public Optional<Vakcina> gautiVakcinaPagalId(long id) {
        return vakcinuJpa.findById(id);
    }

    @Override
    public List<Vakcina> gautiVisasVakcinas() {
        return vakcinuJpa.findAll();
    }

    @Override
    public void istringiVakcina(long id) {
        vakcinuJpa.deleteById(id);
    }
}
