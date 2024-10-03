package org.example.bt_buoi5_jpa.repositories;

import org.example.bt_buoi5_jpa.entities.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryPaging extends PagingAndSortingRepository<Products,Long> {
    @Query("select count(p) from product p")
    int getTotalRecords();
}
