package mp.group3.auth.service;

import mp.group3.auth.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAll();
    public Role getById(Long id);
    public Role update(Role role);
    public void safeDelete(Long id);
}