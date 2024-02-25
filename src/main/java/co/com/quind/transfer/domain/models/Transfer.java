package co.com.quind.transfer.domain.models;

import co.com.quind.transfer.domain.constants.TypeTransfer;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {
    Long id;
    Double amount;
    TypeTransfer typeTransfer;
    LocalDateTime createAt;
    private Account account;
    private Account accountReceptor;
}
