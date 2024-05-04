package com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessorResponseDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String dni;

    private String phone;

    private String photoUrl;

    private AccountResponseDTO account;
}
