package com.example1.mongoDB.respository;

import com.example1.mongoDB.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, Integer> {
}
