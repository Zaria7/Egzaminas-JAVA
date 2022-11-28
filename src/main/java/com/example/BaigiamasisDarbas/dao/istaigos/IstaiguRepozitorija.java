package com.example.BaigiamasisDarbas.dao.istaigos;

import com.example.BaigiamasisDarbas.dao.pacientai.PacientuJpa;
import com.example.BaigiamasisDarbas.dao.vakcinos.VakcinuJpa;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IstaiguRepozitorija implements IstaiguDAO{
    private final IstaiguJpa istaiguJpa;

    public IstaiguRepozitorija(
        @Autowired IstaiguJpa istaiguJpa
    ) {
        this.istaiguJpa = istaiguJpa;
    }

    @Override
    public SkiepijimoIstaiga atnaujintiSkiepijimoIstaiga(SkiepijimoIstaiga skiepijimoIstaiga) {
        return istaiguJpa.save(skiepijimoIstaiga);
    }

    @Override
    public String sukurtiSkiepijimoIstaiga(SkiepijimoIstaiga skiepijimoIstaiga) {
        var naujasId = skiepijimoIstaiga.getId();
        boolean ifExists = gautiVisasSkiepijimoIstaigas()
                .stream()
                .mapToLong(SkiepijimoIstaiga::getId)
                .anyMatch(id -> naujasId == id);
        if(ifExists) {
            return "Toks įrašas jau yra";
        } else {
            istaiguJpa.save(skiepijimoIstaiga);
            return "Vakcina sėkmingai sukurta";
        }
    }

    @Override
    public Optional<SkiepijimoIstaiga> gautiSkiepijimoIstaigaPagalId(long id) {
        return istaiguJpa.findById(id);
    }

    @Override
    public List<SkiepijimoIstaiga> gautiVisasSkiepijimoIstaigas() {
        return istaiguJpa.findAll();
    }

    @Override
    public void istringiSkiepijimoIstaiga(long id) {
        istaiguJpa.deleteById(id);
    }
}
