package com.urooms.accountmicroservice.accountMicroservice.infraestructure.repositories;

import com.urooms.accountmicroservice.accountMicroservice.domain.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role getRoleById (int id);

    boolean existsById(int id);

}
