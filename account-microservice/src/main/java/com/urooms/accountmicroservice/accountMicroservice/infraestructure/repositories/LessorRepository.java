package com.urooms.accountmicroservice.accountMicroservice.infraestructure.repositories;

import com.urooms.accountmicroservice.accountMicroservice.domain.entities.Lessor;
import org.springframework.data.repository.CrudRepository;

public interface LessorRepository extends CrudRepository<Lessor, Integer> {

    Lessor getLessorById (int id);

}
