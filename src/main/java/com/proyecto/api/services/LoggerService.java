package com.proyecto.api.services;

import com.proyecto.api.entity.Producto;
import com.proyecto.api.mongo.LogCambioStock;
import com.proyecto.api.mongo.LogCambioStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggerService {

    @Autowired
    private LogCambioStockRepository logRepo;

    public void guardarCambioStock(Producto producto, int cambio, String usuario, String accion) {
        LogCambioStock log = new LogCambioStock();
        log.setProductoId(producto.getId());
        log.setNombreProducto(producto.getNombre());
        log.setCambio(cambio);
        log.setUsuario(usuario);
        log.setAccion(accion); // ✅ aquí se establece la acción
        log.setFecha(LocalDateTime.now());

        // Impresión en consola para verificar
        System.out.println("🟢 Guardando en Mongo Atlas: "
                + log.getNombreProducto()
                + " | ID: " + log.getProductoId()
                + " | Cambio de stock: " + cambio
                + " | Usuario: " + usuario
                + " | Acción: " + accion
                + " | Fecha: " + log.getFecha());

        logRepo.save(log);
    }
}
