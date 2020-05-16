package com.groupassingment.product.productapp.repository;

import com.groupassingment.product.productapp.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel , String> {

    List<ProductModel> findAllByOwnerId(String ownerId);
}
