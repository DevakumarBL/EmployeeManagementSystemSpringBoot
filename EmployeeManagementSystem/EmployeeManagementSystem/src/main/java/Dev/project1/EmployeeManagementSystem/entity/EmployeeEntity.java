package Dev.project1.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @NotBlank(message = "First name is required")
    @Column(name = "emp_Firstname", nullable = false)
    private String empFirstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "emp_Lastname", nullable = false)
    private String empLastName;

    @NotBlank(message = "Designation is required")
    @Column(name = "emp_Designation", nullable = false)
    private String empDesignation;

    @NotNull(message = "Salary must not be null")
    @Column(name = "emp_Salary", nullable = false)
    private Integer empSalary;

    @NotBlank(message = "Company name is required")
    @Column(name ="emp_CompanyName", nullable = false)
    private String empCompanyName;

    @NotBlank(message = "Company location is required")
    @Column(name = "emp_CompanyLocation", nullable = false)
    private String empCompanyLocation;
}
