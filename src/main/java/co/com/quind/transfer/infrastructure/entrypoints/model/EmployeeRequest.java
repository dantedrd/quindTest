package co.com.quind.transfer.infrastructure.entrypoints.model;

import co.com.quind.transfer.domain.models.Employee;
import co.com.quind.transfer.domain.models.Position;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class EmployeeRequest {
    private Long id;
    private Long nit;
    private String name;
    private MultipartFile photo;
    private String dateEntry;
    private Position position;

    public Employee toDomain(String idPhoto){
       return new Employee(this.id,this.nit,this.name,idPhoto,this.dateEntry,this.position);
    }
}
