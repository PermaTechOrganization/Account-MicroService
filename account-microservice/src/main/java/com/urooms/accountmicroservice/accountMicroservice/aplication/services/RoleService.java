package com.urooms.accountmicroservice.accountMicroservice.aplication.services;

import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.request.RoleRequestDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response.RoleResponseDTO;
import com.urooms.accountmicroservice.accountMicroservice.domain.entities.Role;
import com.urooms.accountmicroservice.shared.model.dto.response.ApiResponse;

public interface RoleService {

    Role getRoleById(int id);

    ApiResponse<RoleResponseDTO> createRole(RoleRequestDTO roleRequestDTO);

    ApiResponse<RoleResponseDTO> updateRole(int id, RoleRequestDTO roleRequestDTO);

    ApiResponse<Void> deleteRole(int id);

    boolean existRole(int id);

}
