package com.example.demo.services;

import com.example.demo.entities.Cajero;
import com.example.demo.repositories.CajeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class CajeroServiceImpl implements CajeroService{

    private CajeroRepository cajeroRepository;
    @Override
    public boolean retiro(Double monto) {
        var cajero = cajeroRepository.findById(1).get();

        if(monto > cajero.getMonto_inicial()){
            return false;
        }
        int montoRestante = (int)(monto * 100);

        int bill1000Utilizado = Math.min(montoRestante/100000, cajero.getBill_1000());
        montoRestante -= bill1000Utilizado * 100000;
        int bill500Utilizado = Math.min(montoRestante/50000, cajero.getBill_500());
        montoRestante -= bill500Utilizado * 50000;
        int bill200Utilizado = Math.min(montoRestante/20000, cajero.getBill_200());
        montoRestante -= bill200Utilizado * 20000;
        int bill100Utilizado = Math.min(montoRestante/10000, cajero.getBill_100());
        montoRestante -= bill100Utilizado * 10000;
        int bill50Utilizado = Math.min(montoRestante/5000, cajero.getBill_50());
        montoRestante -= bill50Utilizado * 5000;
        int bill20Utilizado = Math.min(montoRestante/2000, cajero.getBill_20());
        montoRestante -= bill500Utilizado * 2000;
        int mon10Utilizado = Math.min(montoRestante/1000, cajero.getMon_10());
        montoRestante -= mon10Utilizado * 1000;
        int mon5Utilizado = Math.min(montoRestante/500, cajero.getMon_5());
        montoRestante -= mon5Utilizado * 500;
        int mon2Utilizado = Math.min(montoRestante/200, cajero.getMon_2());
        montoRestante -= mon2Utilizado * 200;
        int mon1Utilizado = Math.min(montoRestante/100, cajero.getMon_1());
        montoRestante -= mon1Utilizado * 100;
        int mon50CUtilizado = Math.min(montoRestante/50, cajero.getMon_50C());
        montoRestante -= mon50CUtilizado * 50;

        cajero.setBill_1000(cajero.getBill_1000() - bill1000Utilizado);
        cajero.setBill_500(cajero.getBill_500() - bill500Utilizado);
        cajero.setBill_200(cajero.getBill_200() - bill200Utilizado);
        cajero.setBill_100(cajero.getBill_100() - bill100Utilizado);
        cajero.setBill_50(cajero.getBill_50() - bill50Utilizado);
        cajero.setBill_20(cajero.getBill_20() - bill20Utilizado);
        cajero.setMon_10(cajero.getMon_10() - mon10Utilizado);
        cajero.setMon_5(cajero.getMon_5() - mon5Utilizado);
        cajero.setMon_2(cajero.getMon_2() - mon2Utilizado);
        cajero.setMon_1(cajero.getMon_1() - mon1Utilizado);
        cajero.setMon_50C(cajero.getMon_50C() - mon50CUtilizado);

        cajero.setMonto_inicial(cajero.getMonto_inicial() - monto);

        cajeroRepository.save(cajero);

        return true;
    }

    @Override
    public Double restante() {
        var cajero = cajeroRepository.findById(1).get();
        return cajero.getMonto_inicial();
    }

    @Override
    public Cajero detalle(Integer id) {
        var detalleDenominacion = cajeroRepository.findById(id).get();

        detalleDenominacion.setBill_1000(2- detalleDenominacion.getBill_1000());
        detalleDenominacion.setBill_500(5- detalleDenominacion.getBill_500());
        detalleDenominacion.setBill_200(10- detalleDenominacion.getBill_200());
        detalleDenominacion.setBill_100(20- detalleDenominacion.getBill_100());
        detalleDenominacion.setBill_50(30- detalleDenominacion.getBill_50());
        detalleDenominacion.setBill_20(40- detalleDenominacion.getBill_20());
        detalleDenominacion.setMon_10(50- detalleDenominacion.getMon_10());
        detalleDenominacion.setMon_5(100- detalleDenominacion.getMon_5());
        detalleDenominacion.setMon_2(200- detalleDenominacion.getMon_2());
        detalleDenominacion.setMon_1(300- detalleDenominacion.getMon_1());
        detalleDenominacion.setMon_50C(100- detalleDenominacion.getMon_50C());

        return detalleDenominacion;
    }
}
