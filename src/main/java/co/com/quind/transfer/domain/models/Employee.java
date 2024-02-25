package co.com.quind.transfer.domain.models;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Employee {
    private Long id;
    private Long nit;
    private String name;
    private String photo;
    private String dateEntry;
    private Position position;
}
