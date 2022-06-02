package uz.azi.ecomusers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.azi.ecomusers.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    @Modifying
    @Query(value = "update users u set u.deleted =true where u.id=:id", nativeQuery = true)
    void softDelete(Long id);
}
