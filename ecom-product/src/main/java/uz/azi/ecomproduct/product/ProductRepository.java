package uz.azi.ecomproduct.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.azi.ecomproduct.product.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query(value = "update Product set deleted =true where id=:id")
    void softDelete(Long id);

    Optional<Product> findByName(String name);
}
