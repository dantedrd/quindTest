package co.com.quind.transfer.infrastructure.adapter.postgres;

import co.com.quind.transfer.infrastructure.adapter.postgres.models.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDbRepository extends JpaRepository<EmployeeEntity, Long> {
    @Modifying
    @Query("delete from EmployeeEntity b where b.id=:id")
    void  deleteEmployee(@Param("id") Long id);
}
