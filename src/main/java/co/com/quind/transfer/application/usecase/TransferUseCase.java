package co.com.quind.transfer.application.usecase;

import co.com.quind.transfer.application.port.out.TransferRepository;
import co.com.quind.transfer.domain.models.Transfer;
import co.com.quind.transfer.domain.service.TransferService;
import co.com.quind.transfer.domain.constants.TypeTransfer;

public class TransferUseCase {
    TransferService service;
    TransferRepository repository;

    public TransferUseCase(TransferRepository repository,TransferService service) {
        this.repository=repository;
        this.service = service;
    }

    public Transfer proccess(Transfer transfer){
        Transfer transferResult=null;
        switch (transfer.getTypeTransfer()){
            case CONSIGNMENT->{
                transferResult=this.service.transferConsignment(transfer);
            }
            case WITHDRAWAL -> {
                transferResult=this.service.withDrawal(transfer);
            }
            case MOVEMENT -> {
                transferResult=this.service.consignament(transfer);
            }
        }
        return this.repository.saveTransfer(transferResult);
    }


}
