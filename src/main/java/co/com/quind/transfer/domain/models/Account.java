package co.com.quind.transfer.domain.models;


import co.com.quind.transfer.domain.constants.StateAccount;
import co.com.quind.transfer.domain.constants.TypeAccounts;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    Long id;
    TypeAccounts accountType;
    String accountNumber;
    StateAccount state;
    Double amount;
    Boolean GMFExempt;
    LocalDateTime createAt;
    LocalDateTime changeDate;
    private Client client;
    private List<Transfer> transfers;

}
