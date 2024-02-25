package co.com.quind.transfer.infrastructure.adapter.postgres;

import co.com.quind.transfer.application.port.out.AccountRepository;
import co.com.quind.transfer.config.exception.NotFoundException;
import co.com.quind.transfer.config.exception.SPError;
import co.com.quind.transfer.domain.models.Account;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.AccountEntity;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.ClientsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class AccountPostgresqlAdapter implements AccountRepository {

    private static final Logger logger = LoggerFactory.getLogger(AccountPostgresqlAdapter.class);

    private final AccountDbRepository accountDbRepository;
    private final ClientDbRepository clientDbRepository;


    /**
     * Constructor for dependency injection of the ClientDbRepository.
     * @param clientDbRepository The Employer repository interface for crud.
     */
    public AccountPostgresqlAdapter(AccountDbRepository accountDbRepository,ClientDbRepository clientDbRepository) {
        this.accountDbRepository=accountDbRepository;
        this.clientDbRepository = clientDbRepository;
    }


    @Override
    public Account saveAccount(Account account) {
        Optional<ClientsEntity> clientsEntity=this.clientDbRepository.findById(account.getClient().getId());
        if(clientsEntity.isPresent()){
            AccountEntity accountEntity=AccountEntity.fromDomain(account);
            accountEntity.setClient(clientsEntity.get());
            return this.accountDbRepository.save(accountEntity).toDomain();
        }
        throw new NotFoundException(SPError.INVALID_USER_NOT_EXIST.getErrorCode(),SPError.INVALID_USER_NOT_EXIST.getErrorMessage());
    }

    @Override
    public Optional<Account> findAccountById(String accountNumber) {
        return this.accountDbRepository.findByAccountNumber(accountNumber)
                .map(AccountEntity::toDomain);
    }

    @Override
    public void deleteAccount(String accountNumber) {
        this.accountDbRepository.deleteAccount(accountNumber);
    }
}
