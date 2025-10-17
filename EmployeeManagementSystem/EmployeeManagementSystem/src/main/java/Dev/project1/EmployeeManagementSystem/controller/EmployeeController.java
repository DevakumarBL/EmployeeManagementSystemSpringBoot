package Dev.project1.EmployeeManagementSystem.controller;

import Dev.project1.EmployeeManagementSystem.entity.EmployeeEntity;
import Dev.project1.EmployeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("allEmployees")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        return new ResponseEntity<>(this.employeeService.getAllEmployee(), HttpStatus.ACCEPTED);
    }



    @GetMapping("getById/{id}")
    public ResponseEntity<EmployeeEntity>  employeeGetById(@PathVariable long id ){
        return new ResponseEntity<>(this.employeeService.employeeGetById(id),HttpStatus.ACCEPTED);
    }

    @PostMapping("addNewEmployee")
    public ResponseEntity<EmployeeEntity> addNewEmployee(
            @Valid
            @RequestBody EmployeeEntity newEmployeePayload
    ){
        return new ResponseEntity<>(this.employeeService.createNewEmployee(newEmployeePayload),HttpStatus.CREATED);
    }

    @PutMapping("updateEmployee/{id}")
    public  ResponseEntity<EmployeeEntity> updateEmployee(
            @PathVariable long id,
            @RequestBody EmployeeEntity updateEmployeePayload
    ){
        return  new ResponseEntity<>(this.employeeService.updateEmployee(id,updateEmployeePayload),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        this.employeeService.deleteEmployee(id);
        return ResponseEntity.ok("your Employee id: "+id +" is"+ " deleted successfully");
    }
}
