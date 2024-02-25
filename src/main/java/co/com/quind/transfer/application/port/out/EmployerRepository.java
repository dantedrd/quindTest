package co.com.quind.transfer.application.port.out;

import co.com.quind.transfer.domain.models.Employee;

import java.util.List;

public interface EmployerRepository {
     Employee saveEmployee(Employee employee);
     List<Employee> getEmployees();
     void deleteEmployer(Long id);



}
