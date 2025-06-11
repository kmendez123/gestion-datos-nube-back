package com.proyecto.api.services;

import com.proyecto.api.entity.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> listar();
    Producto guardar(Producto p);
    void eliminar(Long id);
    Producto buscarPorId(Long id);
}