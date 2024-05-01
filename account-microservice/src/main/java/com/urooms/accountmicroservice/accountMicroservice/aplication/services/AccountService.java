package com.urooms.accountmicroservice.accountMicroservice.aplication.services;

import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.request.AccountRequestDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response.AccountResponseDTO;
import com.urooms.accountmicroservice.accountMicroservice.domain.entities.Account;
import com.urooms.accountmicroservice.shared.model.dto.response.ApiResponse;

public interface AccountService {

    Account getAccountById (int id);

    ApiResponse<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO);

    ApiResponse<AccountResponseDTO> updateAccount(int id, AccountRequestDTO accountRequestDTO);

    ApiResponse<Void> deleteAccount(int id);

}
