package co.com.quind.transfer.infrastructure.adapter.postgres.models;

import co.com.quind.transfer.domain.models.Employee;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employer")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nit;
    private String name;
    private String photo;
    private String dateEntry;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private PositionEntity position;

    /**
     * Converts a {@link Employee} object to an {@link EmployeeEntity}.
     *
     * @param domain The OperationDomain object to convert.
     * @return The corresponding OperationEntity object.
     */
    public static EmployeeEntity fromDomain(Employee domain) {
        return EmployeeEntity.builder()
                .id(domain.getId())
                .nit(domain.getNit())
                .name(domain.getName())
                .name(domain.getName())
                .photo(domain.getPhoto())
                .dateEntry(domain.getDateEntry())
                .build();
    }

    /**
     * Converts this entity to its domain representation.
     *
     * @return The corresponding OperationDomain object.
     */
    public Employee toDomain() {
        return new Employee(this.id,this.nit, this.name,this.photo, this.dateEntry,PositionEntity.toDomain(this.position));
    }
}
