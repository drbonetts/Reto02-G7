package com.Reto2_G7.repository.crud;

import com.Reto2_G7.model.Accessory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Diego
 */
public interface AccessoryCrudRepository extends MongoRepository<Accessory, String> {
    
}
