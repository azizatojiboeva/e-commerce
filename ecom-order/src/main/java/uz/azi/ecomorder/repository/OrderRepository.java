package uz.azi.ecomorder.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.azi.ecomorder.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
