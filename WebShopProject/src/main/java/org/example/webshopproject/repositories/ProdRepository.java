package org.example.webshopproject.repositories;

import org.example.webshopproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdRepository extends CrudRepository<Product,Long> {
    //CrudRepository
Product findOneByTitle(String title);
}
