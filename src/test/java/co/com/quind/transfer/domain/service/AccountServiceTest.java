package co.com.quind.transfer.domain.service;

import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.domain.constants.TypeAccounts;
import co.com.quind.transfer.domain.models.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @InjectMocks
    AccountService accountService;

    @BeforeEach
    public void init(){
        this.accountService=new AccountService();
    }

    @Test
    public void shouldGenerateExceptionAmount(){
        Account domain=new Account();
        domain.setAmount(-3.0);
        assertThrows(CustomException.class,()->{
            this.accountService.validate(domain);
        });
    }

    @Test
    public void shouldGenerateNumberCheckingAccount(){
        Account domain=new Account();
        domain.setAmount(-3.0);
        domain.setAccountType(TypeAccounts.CHECKING_ACCOUNT);

        String number=this.accountService.generateNumber(domain);

        assertNotNull(number);
    }

    @Test
    public void shouldGenerateNumberSavingsAccount(){
        Account domain=new Account();
        domain.setAmount(-3.0);
        domain.setAccountType(TypeAccounts.SAVINGS_ACCOUNT);

        String number=this.accountService.generateNumber(domain);

        assertNotNull(number);
    }


}