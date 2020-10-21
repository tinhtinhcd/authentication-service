package mp.group3.auth.repository;

import mp.group3.auth.entity.Role;
public interface RoleRepository extends BaseRepository<Role, Long> {
    Role findRoleByName(String name);
}
