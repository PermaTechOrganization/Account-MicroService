package com.urooms.accountmicroservice.accountMicroservice.aplication.services.impl;

import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.request.RoleRequestDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response.RoleResponseDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.services.RoleService;
import com.urooms.accountmicroservice.accountMicroservice.domain.entities.Role;
import com.urooms.accountmicroservice.accountMicroservice.infraestructure.repositories.RoleRepository;
import com.urooms.accountmicroservice.shared.model.dto.response.ApiResponse;
import com.urooms.accountmicroservice.shared.model.enums.Estatus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.getRoleById(id);
    }

    @Override
    public ApiResponse<RoleResponseDTO> createRole(RoleRequestDTO roleRequestDTO) {
        var role = modelMapper.map(roleRequestDTO, Role.class);
        roleRepository.save(role);
        var response = modelMapper.map(role, RoleResponseDTO.class);
        return new ApiResponse<>("Role created successfully", Estatus.SUCCESS, response);
    }

    @Override
    public ApiResponse<RoleResponseDTO> updateRole(int id, RoleRequestDTO roleRequestDTO) {
        Optional<Role> roleOptional = roleRepository.findById(id);

        if (roleOptional.isEmpty()) {
            return new ApiResponse<>("Role not found", Estatus.ERROR, null);
        } else {
            Role role = roleOptional.get();
            modelMapper.map(roleRequestDTO, role);
            roleRepository.save(role);
            RoleResponseDTO response = modelMapper.map(role, RoleResponseDTO.class);
            return new ApiResponse<>("Role updated successfully", Estatus.SUCCESS, response);
        }
    }

    @Override
    public ApiResponse<Void> deleteRole(int id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isEmpty()) {
            return new ApiResponse<>("Role not found", Estatus.ERROR, null);
        } else {
            roleRepository.delete(roleOptional.get());
            return new ApiResponse<>("Role deleted successfully", Estatus.SUCCESS, null);
        }
    }

    @Override
    public boolean existRole(int id) {
        return roleRepository.existsById(id);
    }

}
