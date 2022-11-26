package com.example.BaigiamasisDarbas.dao.istaigos;

import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;

import java.util.List;
import java.util.Optional;

public interface IstaiguDAO {
    SkiepijimoIstaiga atnaujintiSkiepijimoIstaiga(SkiepijimoIstaiga skiepijimoIstaiga);
    SkiepijimoIstaiga sukurtiSkiepijimoIstaiga(SkiepijimoIstaiga skiepijimoIstaiga);
    Optional<SkiepijimoIstaiga> gautiSkiepijimoIstaigaPagalId(long id);
    List<SkiepijimoIstaiga> gautiVisasSkiepijimoIstaigas();
    List<Optional<Pacientas>> gautiPacientusPagalIstaiga(long id);
    List<Long> gautiPacientuIdPagalIstaiga(long id);
    void istringiSkiepijimoIstaiga(long id);
    boolean arYraVakcinaIstaigojePagalId(long istaigosId, long vakcinosId);
}
