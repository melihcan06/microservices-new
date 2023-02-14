package com.mck.productservice.repository;

import com.mck.productservice.model.*;
import org.springframework.data.mongodb.repository.*;

public interface ProductRepository extends MongoRepository<Product, String > {

}
