package co.com.quind.transfer.application.usecase;

import co.com.quind.transfer.application.port.out.EmployerRepository;
import co.com.quind.transfer.domain.models.Employee;
import co.com.quind.transfer.domain.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployerCrudUseCase {
    private static final Logger logger = LoggerFactory.getLogger(EmployerCrudUseCase.class);
    private final EmployerRepository repository;

    private final ImageService imageService;

    /**
     * Constructs a new instance of {@code EmployerUserCase} with the given storage repository
     * @param repository The storage repository used for persisting operation results.
     */
    public EmployerCrudUseCase(EmployerRepository repository,ImageService imageService) {
        this.repository = repository;
        this.imageService=imageService;
    }

    /**
     * Performs the saved of employer
     * data of  employer provided in the {@link Employee}. This method also
     * persists the result and returns the updated domain entity.
     *
     * @param domain An instance of {@link Employee} containing the data of employer.
     * @return The updated {@link Employee} instance with the employer saved.
     //* @throws CustomException If an error occurs during the calculation or data persistence.
     */
    public Employee saveEmployee(Employee domain) {
        logger.info("Employee to save: {}", domain);
        return repository.saveEmployee(domain);
    }

    /**
     * Performs the results of employees
     * @return A {@code List} of {@link Employee} instances, each representing a stored employees result.
    //* @throws CustomException If an error occurs during the calculation or data persistence.
     */
    public List<Employee> getEmployees() {
        logger.info("get all employees");
        return repository.getEmployees();
    }

    public void deleteEmployee(Long id) {
        logger.info("get all employees");
        repository.deleteEmployer(id);
    }
}
