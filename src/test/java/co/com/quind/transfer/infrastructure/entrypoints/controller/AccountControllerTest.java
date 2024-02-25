package co.com.quind.transfer.infrastructure.entrypoints.controller;

import co.com.quind.transfer.application.usecase.AccountUseCase;
import co.com.quind.transfer.domain.constants.StateAccount;
import co.com.quind.transfer.domain.constants.TypeAccounts;
import co.com.quind.transfer.domain.models.Account;
import co.com.quind.transfer.infrastructure.entrypoints.model.AccountRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {
    @Mock
    AccountUseCase accountUseCase;
    @InjectMocks
    AccountController accountController;


    @BeforeEach
    public void init(){
        this.accountController=new AccountController(accountUseCase);
    }

    @Test
    public void shouldCreatedAccount(){
        AccountRequest accountRequest=AccountRequest
                .builder()
                .accountType(TypeAccounts.CHECKING_ACCOUNT.getTypeAccount())
                .state(StateAccount.ACTIVE.getStateAccount())
                .GMFExempt(true)
                .build();
        Account account=new Account();

        Mockito.when(this.accountUseCase.createAccount(Mockito.any(Account.class))).thenReturn(account);

        ResponseEntity<Object> result=this.accountController.createClient(accountRequest);

        assertNotNull(result);
    }

    @Test
    public void shouldUpdateAccount(){
        AccountRequest accountRequest=AccountRequest
                .builder()
                .accountNumber("4345345")
                .accountType(TypeAccounts.CHECKING_ACCOUNT.getTypeAccount())
                .state(StateAccount.ACTIVE.getStateAccount())
                .GMFExempt(true)
                .build();
        Account account=new Account();

        Mockito.when(this.accountUseCase.findAccountById(Mockito.anyString())).thenReturn(account);
        Mockito.when(this.accountUseCase.updatedAccount(Mockito.any(Account.class))).thenReturn(account);


        ResponseEntity<Object> result=this.accountController.updateAccount(accountRequest);

        assertNotNull(result);
    }

    @Test
    public void shouldDeletedAccount(){

        Mockito.doNothing().when(this.accountUseCase).deleteAccount(Mockito.anyString());

        ResponseEntity<Object> result=this.accountController.deleteAccount("234454");

        assertNotNull(result);
    }

}