package com.example.demo.services;

import com.example.demo.entities.Cajero;

public interface CajeroService {

    boolean retiro(Double monto);
    Double restante();

    Cajero detalle(Integer id);
}
