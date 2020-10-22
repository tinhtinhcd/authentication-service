package mp.group3.auth.repository;

import mp.group3.auth.entity.Privilege;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends BaseRepository<Privilege, Long> {
    Privilege findByName(String name);
}
