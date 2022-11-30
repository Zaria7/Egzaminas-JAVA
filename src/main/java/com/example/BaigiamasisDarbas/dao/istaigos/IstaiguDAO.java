package com.example.BaigiamasisDarbas.dao.istaigos;

import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IstaiguDAO {
    SkiepijimoIstaiga atnaujintiSkiepijimoIstaiga(SkiepijimoIstaiga skiepijimoIstaiga);
    String sukurtiSkiepijimoIstaiga(SkiepijimoIstaiga skiepijimoIstaiga);
    Optional<SkiepijimoIstaiga> gautiSkiepijimoIstaigaPagalId(long id);
    List<SkiepijimoIstaiga> gautiVisasSkiepijimoIstaigas();
    void istringiSkiepijimoIstaiga(long id);
}
