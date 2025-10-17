package Dev.project1.EmployeeManagementSystem.repository;

import Dev.project1.EmployeeManagementSystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
