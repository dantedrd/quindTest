package co.com.quind.transfer.infrastructure.adapter.postgres;

import co.com.quind.transfer.application.port.out.TransferRepository;
import co.com.quind.transfer.domain.models.Transfer;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.AccountEntity;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.TransferEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class TransferPostgresqlAdapter implements TransferRepository {

    private static final Logger logger = LoggerFactory.getLogger(AccountPostgresqlAdapter.class);

    private final TransferDbRepository transferDbRepository;
    private final AccountDbRepository accountDbRepository;


    /**
     * Constructor for dependency injection of the TransferPostgresqlAdapter.
     * @param transferDbRepository The transfer repository interface for crud.
     */
    public TransferPostgresqlAdapter(TransferDbRepository transferDbRepository,AccountDbRepository accountDbRepository) {
        this.transferDbRepository=transferDbRepository;
        this.accountDbRepository=accountDbRepository;
    }

    @Override
    public Transfer saveTransfer(Transfer transfer) {
        AccountEntity accountEntity=this.accountDbRepository.findByAccountNumber(transfer.getAccount().getAccountNumber()).get();
        TransferEntity transferEntity=TransferEntity.fromDomain(transfer);
        transferEntity.setAccount(accountEntity);

        if(Objects.nonNull(transfer.getAccountReceptor())){
            AccountEntity accountReceptorEntity=this.accountDbRepository.findByAccountNumber(transfer.getAccountReceptor().getAccountNumber()).get();
            transferEntity.setAccountReceptor(accountReceptorEntity);
        }

        return this.transferDbRepository.save(transferEntity).toDomain();
    }
}
