package com.hillel.service;

import com.hillel.dao.RoleDao;
import com.hillel.dto.RoleDto;
import com.hillel.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleService {
    private final RoleDao roleDao;

    public RoleService() {
        roleDao = new RoleDao();
    }

    public List<RoleDto> findAllRoles() {
        List<Role> roles = roleDao.findAllRoles();
        List<RoleDto> result = new ArrayList<>();

        for (Role role : roles) {
            RoleDto dto = new RoleDto();
            dto.setId(role.getId());
            dto.setName(role.getName());
            result.add(dto);
        }

        return result;
    }

}
