package mp.group3.auth.repository;

import mp.group3.auth.entity.Privilege;

import java.util.List;

public interface PrivilegeRepository extends BaseRepository<Privilege, Long> {
    Privilege findByName(String name);
    List<Privilege> findAllByRolesIs(Long id);
}
