package pl.naukaspringboota.springboottutorial.service;

import pl.naukaspringboota.springboottutorial.entity.Department;
import pl.naukaspringboota.springboottutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DeparmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
