package backend.hoaxify.dataAcces.abstracts;

import backend.hoaxify.entities.concretes.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
