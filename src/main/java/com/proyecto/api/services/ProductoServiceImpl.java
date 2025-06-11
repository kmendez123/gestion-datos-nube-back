package com.proyecto.api.services;

import com.proyecto.api.entity.Producto;
import com.proyecto.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository repo;

    @Autowired
    private LoggerService loggerService;

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto guardar(Producto p) {
        boolean esModificacion = false;
        Producto existente = null;

        if (p.getId() != null) {
            existente = repo.findById(p.getId()).orElse(null);
            esModificacion = existente != null;
        }

        Producto guardado = repo.save(p);

        int cambio = p.getStock();

        if (esModificacion) {
            if (existente.getStock() != p.getStock()) {
                cambio = p.getStock() - existente.getStock();
            }
            loggerService.guardarCambioStock(guardado, cambio, "admin", "modificacion");
        } else {
            loggerService.guardarCambioStock(guardado, cambio, "admin", "creacion");
        }

        return guardado;
    }


    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
