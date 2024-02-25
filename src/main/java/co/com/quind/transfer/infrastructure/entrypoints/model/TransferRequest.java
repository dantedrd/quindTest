package co.com.quind.transfer.infrastructure.entrypoints.model;

import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.domain.constants.TypeTransfer;
import co.com.quind.transfer.domain.models.Account;
import co.com.quind.transfer.domain.models.Transfer;
import co.com.quind.transfer.config.exception.SPError;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferRequest {
    private Long id;
    private Double amount;
    private String typeTransfer;
    private String createAt;
    private String accountId;
    private String accountReceptorId;

    public Transfer toDomain(){
        return Transfer.builder()
                .id(this.id)
                .amount(this.amount)
                .typeTransfer(typeTransfer(this.typeTransfer))
                .account(Account.builder().accountNumber(this.accountId).build())
                .accountReceptor(Objects.nonNull(this.accountReceptorId)?
                        Account.builder().accountNumber(this.accountReceptorId).build():null)
                .build();
    }

    private TypeTransfer typeTransfer(String typeTransfer){
        try{
            return TypeTransfer.valueOf(typeTransfer);
        }catch (Exception exception){
            throw new CustomException(SPError.TYPE_TRANSFER_NOT_VALID.getErrorCode(), SPError.TYPE_TRANSFER_NOT_VALID.getErrorMessage());
        }
    }
}
