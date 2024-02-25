package co.com.quind.transfer.infrastructure.adapter.postgres;

import co.com.quind.transfer.application.port.out.EmployerRepository;
import co.com.quind.transfer.domain.models.Employee;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.EmployeeEntity;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.PositionEntity;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployerPostgresqlAdapter implements EmployerRepository {

    private static final Logger logger = LoggerFactory.getLogger(EmployerPostgresqlAdapter.class);
    private final EmployerDbRepository employerDbRepository;


    /**
     * Constructor for dependency injection of the EmployerPostgresqlAdapter.
     * @param employerDbRepository The Employer repository interface for crud.
     */
    public EmployerPostgresqlAdapter(EmployerDbRepository employerDbRepository) {
        this.employerDbRepository = employerDbRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        logger.info("Attempting to save employer: {}", employee);
        EmployeeEntity entity = EmployeeEntity.fromDomain(employee);
        EmployeeEntity savedEntity = employerDbRepository.save(entity);
        PositionEntity positionEntity= new PositionEntity();
        positionEntity.setId(employee.getPosition().getId());
        positionEntity.setName(employee.getPosition().getName());
        savedEntity.setPosition(positionEntity);
        employerDbRepository.save(savedEntity);
        logger.info("Operation saved successfully: {}", savedEntity.toDomain());
        return savedEntity.toDomain();
    }

    @Override
    public List<Employee> getEmployees() {
        logger.info("Retrieving all employer from the database");
        return employerDbRepository.findAll().stream()
                .map(EmployeeEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteEmployer(Long id) {
        employerDbRepository.deleteEmployee(id);
    }
}
