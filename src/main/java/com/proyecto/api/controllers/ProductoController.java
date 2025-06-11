package com.proyecto.api.controllers;

import com.proyecto.api.entity.Producto;
import com.proyecto.api.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return service.listar();
    }

    @PostMapping("/guardar")
    public Producto guardar(@RequestBody Producto p) {
        // Toda la lógica de creación o modificación, 
        // incluyendo el log en Mongo, ya está en el service
        return service.guardar(p);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public Producto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
