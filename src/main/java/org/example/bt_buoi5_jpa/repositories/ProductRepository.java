package org.example.bt_buoi5_jpa.repositories;

import org.example.bt_buoi5_jpa.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products,Long> {
}
