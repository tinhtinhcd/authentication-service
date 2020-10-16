package mp.group3.auth.repository;

import mp.group3.auth.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);
    Optional<User> findUsersByUsername(String username);

}
