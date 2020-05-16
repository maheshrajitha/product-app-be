package com.groupassingment.product.productapp.repository;

import com.groupassingment.product.productapp.models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel , String> {

    List<CategoryModel> findAllByOwnerId(String ownerId);
}
