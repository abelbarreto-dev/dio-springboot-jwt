package dio.abel.springboot_jwt.repository;

import dio.abel.springboot_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select e from User e join fetch e.roles where e.username= (:username)")
    User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
