package org.springframework.samples.petclinic.product;

import java.util.Collection;

import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Integer> {

    Collection<Product> findAll();

	Product findById(Integer testId);


}
