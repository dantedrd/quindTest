package co.com.quind.transfer.infrastructure.entrypoints.controller;

import co.com.quind.transfer.application.usecase.AccountUseCase;
import co.com.quind.transfer.domain.models.Account;
import co.com.quind.transfer.infrastructure.entrypoints.model.AccountRequest;
import co.com.quind.transfer.infrastructure.entrypoints.model.GenericResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    AccountUseCase accountUseCase;

    public AccountController(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody AccountRequest account){
        Account responseAccount=this.accountUseCase.createAccount(account.toDomain());
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(GenericResponse.of(HttpStatus.CREATED.value(),"Cuenta creada correctamente",responseAccount));
    }

    @PutMapping
    public ResponseEntity<Object> updateAccount(@Valid @RequestBody AccountRequest account){
        Account responseAccount=this.accountUseCase.findAccountById(account.getAccountNumber());
        responseAccount.setState(account.getStateAccount(account.getState()));
        responseAccount.setGMFExempt(Objects.nonNull(account.getGMFExempt())?account.getGMFExempt():responseAccount.getGMFExempt());
        Account responseUpdatedAccount=this.accountUseCase.updatedAccount(responseAccount);
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(GenericResponse.of(HttpStatus.CREATED.value(),"Cuenta creada correctamente",responseUpdatedAccount));
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Object> deleteAccount(@PathVariable String accountNumber){
        this.accountUseCase.deleteAccount(accountNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(GenericResponse.of(HttpStatus.CREATED.value(),"cuenta eliminada correctamente",null));
    }
}
