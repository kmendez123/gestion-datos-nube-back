package com.proyecto.api.controllers;

import com.proyecto.api.mongo.LogCambioStock;
import com.proyecto.api.mongo.LogCambioStockRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@CrossOrigin
public class LogCambioStockController {

    private final LogCambioStockRepository logRepo;

    public LogCambioStockController(LogCambioStockRepository logRepo) {
        this.logRepo = logRepo;
    }

    // Obtener todos los logs
    @GetMapping
    public List<LogCambioStock> obtenerTodos() {
        return logRepo.findAll();
    }

    // Obtener logs por ID de producto
    @GetMapping("/producto/{id}")
    public List<LogCambioStock> obtenerPorProducto(@PathVariable Long id) {
        return logRepo.findByProductoId(id);
    }
}
