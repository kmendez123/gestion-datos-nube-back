package com.proyecto.api.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LogCambioStockRepository extends MongoRepository<LogCambioStock, String> {
    List<LogCambioStock> findByProductoId(Long productoId);
}