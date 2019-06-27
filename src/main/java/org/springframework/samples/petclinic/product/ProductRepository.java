package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.owner.Owner;


public interface ProductRepository extends Repository<Product, Integer> {

    Collection<Product> findAll();
   	Optional<Product> findById(Integer id);
    //Product findById(@Param("id") Integer id);
}
