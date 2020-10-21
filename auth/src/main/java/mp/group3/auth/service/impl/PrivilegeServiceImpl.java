package mp.group3.auth.service.impl;

import mp.group3.auth.entity.Privilege;
import mp.group3.auth.repository.PrivilegeRepository;
import mp.group3.auth.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    private PrivilegeRepository privilegeRepository;

    @Autowired
    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public List<Privilege> getAll() {
        return privilegeRepository.findAll();
    }

    @Override
    public List<Privilege> getByRole(Long id) {
        return privilegeRepository.findAllByRolesIs(id);
    }

}