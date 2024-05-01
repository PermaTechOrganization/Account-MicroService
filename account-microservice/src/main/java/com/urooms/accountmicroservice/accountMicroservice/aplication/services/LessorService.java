package com.urooms.accountmicroservice.accountMicroservice.aplication.services;

import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.request.LessorRequestDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response.LessorResponseDTO;
import com.urooms.accountmicroservice.shared.model.dto.response.ApiResponse;

import java.util.List;

public interface LessorService {

    ApiResponse<List<LessorResponseDTO>> getLessors();

    ApiResponse<LessorResponseDTO> getLessorById(int id);

    ApiResponse<Void> deleteLessor(int id);

    ApiResponse<LessorResponseDTO> createLessor(LessorRequestDTO lessorRequestDTO);

    ApiResponse<LessorResponseDTO> updateLessor(int id, LessorRequestDTO lessorRequestDTO);

}
