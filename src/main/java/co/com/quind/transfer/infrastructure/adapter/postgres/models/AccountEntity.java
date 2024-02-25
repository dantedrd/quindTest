package co.com.quind.transfer.infrastructure.adapter.postgres.models;

import co.com.quind.transfer.domain.constants.StateAccount;
import co.com.quind.transfer.domain.constants.TypeAccounts;
import co.com.quind.transfer.domain.models.Account;
import co.com.quind.transfer.domain.utils.UtilFuntion;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account",uniqueConstraints = @UniqueConstraint(columnNames = "accountNumber"))
public class AccountEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountType;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    private String state;
    private Double amount;
    private Boolean GMFExempt;
    private String createAt;
    private String changeDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientsEntity client;


    @OneToMany(mappedBy = "account")
    private List<TransferEntity> transfers;


    public static AccountEntity fromDomain(Account account) {
        return AccountEntity.builder()
                .id(account.getId())
                .accountType(account.getAccountType().getTypeAccount())
                .accountNumber(account.getAccountNumber())
                .state(account.getState().getStateAccount())
                .amount(account.getAmount())
                .GMFExempt(account.getGMFExempt())
                .createAt(UtilFuntion.transformLocalDateTimeToString(account.getCreateAt()))
                .changeDate(UtilFuntion.transformLocalDateTimeToString(account.getChangeDate()))
                .build();
    }

    public Account toDomain() {
        return Account.builder()
                .id(this.id)
                .accountType(TypeAccounts.valueOf(this.accountType))
                .accountNumber(this.accountNumber)
                .state(StateAccount.valueOf(this.state))
                .amount(this.amount)
                .GMFExempt(this.GMFExempt)
                .createAt(UtilFuntion.transformStringToLocalDateTime(this.createAt))
                .changeDate(UtilFuntion.transformStringToLocalDateTime(this.changeDate))
                .client(this.client.toDomain())
                .build();
    }


}
