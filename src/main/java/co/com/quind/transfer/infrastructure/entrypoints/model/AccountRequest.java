package co.com.quind.transfer.infrastructure.entrypoints.model;

import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.domain.constants.StateAccount;
import co.com.quind.transfer.domain.constants.TypeAccounts;
import co.com.quind.transfer.domain.models.Account;
import co.com.quind.transfer.domain.models.Client;
import lombok.*;

import static co.com.quind.transfer.config.exception.SPError.STATE_ACCOUNT_NOT_VALID;
import static co.com.quind.transfer.config.exception.SPError.TYPE_ACCOUNT_NOT_VALID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequest {
    Long id;
    String accountType;
    String accountNumber;
    String state;
    Double amount;
    Boolean GMFExempt;
    Long clientId;

    public Account toDomain(){
        return Account.builder()
                .id(this.id)
                .accountType(getAccount(this.accountType))
                .accountNumber(this.accountNumber)
                .state(getStateAccount(this.state))
                .amount(this.amount)
                .GMFExempt(this.GMFExempt)
                .client(Client.builder().id(this.clientId).build())
                .build();
    }

    public TypeAccounts getAccount(String account){
        try{
            return TypeAccounts.valueOf(account);
        }catch (Exception exception){
            throw new CustomException(TYPE_ACCOUNT_NOT_VALID.getErrorCode(),TYPE_ACCOUNT_NOT_VALID.getErrorMessage());
        }

    }

    public StateAccount getStateAccount(String state){
        try{
            return StateAccount.valueOf(state);
        }catch (Exception exception){
            throw new CustomException(STATE_ACCOUNT_NOT_VALID.getErrorCode(),STATE_ACCOUNT_NOT_VALID.getErrorMessage());
        }
    }


}
