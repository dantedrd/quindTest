package co.com.quind.transfer.infrastructure.adapter.postgres.models;

import co.com.quind.transfer.domain.models.Position;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "position")
    private List<EmployeeEntity> employeeEntity;

    public static PositionEntity fromDomain(Position domain) {
        return PositionEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public static Position toDomain(PositionEntity domain) {
        return Position.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
}
