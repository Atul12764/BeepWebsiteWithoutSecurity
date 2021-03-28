package com.checkbeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.checkbeep.model.ProductDetails;


@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
