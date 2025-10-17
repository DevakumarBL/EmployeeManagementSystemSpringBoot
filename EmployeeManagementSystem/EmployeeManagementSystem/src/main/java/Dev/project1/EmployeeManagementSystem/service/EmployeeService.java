package Dev.project1.EmployeeManagementSystem.service;

import Dev.project1.EmployeeManagementSystem.entity.EmployeeEntity;
import Dev.project1.EmployeeManagementSystem.exception.ResourceNotfoundException;
import Dev.project1.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee(){
        return this.employeeRepository.findAll();
    }

    public EmployeeEntity employeeGetById(long id) {
        return this.employeeRepository.findById(id).orElseThrow(()->new ResourceNotfoundException("id not found"));
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity createEmpPayload){
        return this.employeeRepository.save(createEmpPayload);
    }

    public EmployeeEntity updateEmployee(long id,EmployeeEntity updateEmployeePayload){
        EmployeeEntity existingEmp = employeeGetById(id);

        if (existingEmp != null){
            existingEmp.setEmpFirstName(updateEmployeePayload.getEmpFirstName());
            existingEmp.setEmpLastName(updateEmployeePayload.getEmpLastName());
            existingEmp.setEmpDesignation(updateEmployeePayload.getEmpDesignation());
            existingEmp.setEmpSalary(updateEmployeePayload.getEmpSalary());
            existingEmp.setEmpCompanyName(updateEmployeePayload.getEmpCompanyName());
            existingEmp.setEmpCompanyLocation(updateEmployeePayload.getEmpCompanyLocation());
        }else {
            System.out.println("error");
        }

            return this.employeeRepository.save(existingEmp);
    }

    public void deleteEmployee(long id){
          this.employeeRepository.deleteById(id);
    }
}
