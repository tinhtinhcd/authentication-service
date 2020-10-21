package mp.group3.auth.service.impl;

import mp.group3.auth.entity.Role;
import mp.group3.auth.repository.RoleRepository;
import mp.group3.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role update(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public void safeDelete(Long id) {
        roleRepository.delete(roleRepository.findById(id).get());
    }

}

