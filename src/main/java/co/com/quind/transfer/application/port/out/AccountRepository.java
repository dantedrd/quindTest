package co.com.quind.transfer.application.port.out;

import co.com.quind.transfer.domain.models.Account;

import java.util.Optional;

public interface AccountRepository {
    Account saveAccount(Account account);

    Optional<Account> findAccountById(String accountNumber);

    void deleteAccount(String accountNumber);
}
