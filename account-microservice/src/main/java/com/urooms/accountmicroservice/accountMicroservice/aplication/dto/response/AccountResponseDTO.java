package com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {

    private String userName;

    private String email;

    private String password;

    private RoleResponseDTO role;

}