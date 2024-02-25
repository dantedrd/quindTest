package co.com.quind.transfer.application.port.out;

import co.com.quind.transfer.domain.models.Transfer;

public interface TransferRepository {
    Transfer saveTransfer(Transfer transfer) ;
}
