package com.example.demo.controller;

import com.example.demo.entities.Cajero;
import com.example.demo.services.CajeroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cajero")
@AllArgsConstructor
public class CajeroController {

    private CajeroService cajeroService;

    @PostMapping
    public String retiroDinero(@RequestParam Double monto){
        boolean retiro = cajeroService.retiro(monto);
        if (retiro) {
            return "Si se retiro";
        } else {
            return "No se hizo el retiro";
        }
    }

    @GetMapping
    public Double restante(){
        return cajeroService.restante();
    }

    @GetMapping("/{id}")
    public Cajero detalle(@PathVariable Integer id){
        return cajeroService.detalle(id);
    }
}
