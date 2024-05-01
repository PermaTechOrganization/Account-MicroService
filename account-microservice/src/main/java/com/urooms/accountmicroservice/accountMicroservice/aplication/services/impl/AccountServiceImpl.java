package com.urooms.accountmicroservice.accountMicroservice.aplication.services.impl;

import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.request.AccountRequestDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.dto.response.AccountResponseDTO;
import com.urooms.accountmicroservice.accountMicroservice.aplication.services.AccountService;
import com.urooms.accountmicroservice.accountMicroservice.domain.entities.Account;
import com.urooms.accountmicroservice.accountMicroservice.infraestructure.repositories.AccountRepository;
import com.urooms.accountmicroservice.accountMicroservice.infraestructure.repositories.RoleRepository;
import com.urooms.accountmicroservice.shared.model.dto.response.ApiResponse;
import com.urooms.accountmicroservice.shared.model.enums.Estatus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public ApiResponse<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO) {

        var account = modelMapper.map(accountRequestDTO, Account.class);
        account.setRole(roleRepository.getRoleById(accountRequestDTO.getRole()));
        accountRepository.save(account);

        var response = modelMapper.map(account, AccountResponseDTO.class);

        return new ApiResponse<>("Account created successfully", Estatus.SUCCESS, response);
    }

    @Override
    public ApiResponse<AccountResponseDTO> updateAccount(int id, AccountRequestDTO accountRequestDTO) {

        Optional<Account> accountOptional = accountRepository.findById(id);

        if (accountOptional.isEmpty()) {
            return new ApiResponse<>("Account not found", Estatus.ERROR, null);
        }else {
            Account account = accountOptional.get();
            modelMapper.map(accountRequestDTO, account);
            account.setRole(roleRepository.getRoleById(accountRequestDTO.getRole()));
            accountRepository.save(account);
            AccountResponseDTO response = modelMapper.map(account, AccountResponseDTO.class);
            return new ApiResponse<>("Account updated successfully", Estatus.SUCCESS, response);
        }
    }

    @Override
    public ApiResponse<Void> deleteAccount(int id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            return new ApiResponse<>("Account not found", Estatus.ERROR, null);
        }else {
            accountRepository.deleteById(id);
            return new ApiResponse<>("Account deleted successfully", Estatus.SUCCESS, null);
        }
    }

    @Override
    public Account getAccountById(int id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElse(null);
    }
}
