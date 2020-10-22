package mp.group3.auth.repository;

import mp.group3.auth.entity.Privilege;
import mp.group3.auth.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
    Role findRoleByName(String name);
}
