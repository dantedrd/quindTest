package co.com.quind.transfer.infrastructure.adapter.postgres;

import co.com.quind.transfer.infrastructure.adapter.postgres.models.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferDbRepository extends JpaRepository<TransferEntity, Long> {
}
