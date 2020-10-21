package mp.group3.auth.service;

import mp.group3.auth.entity.Privilege;

import java.util.List;

public interface PrivilegeService {
    public List<Privilege> getAll();
    public List<Privilege> getByRole(Long id);
}