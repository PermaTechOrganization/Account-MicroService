package com.urooms.accountmicroservice.accountMicroservice.aplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "gender is required")
    private String gender;

    @NotBlank(message = "DNI is required")
    private String dni;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Photo URL is required")
    private String photoUrl;

    @NotBlank(message = "Account is required")
    private int account;

}
