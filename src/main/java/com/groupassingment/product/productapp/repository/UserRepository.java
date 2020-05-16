package com.groupassingment.product.productapp.repository;

import com.groupassingment.product.productapp.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel , String> {
    UserModel findByEmail(String email);
}
