package pl.naukaspringboota.springboottutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.naukaspringboota.springboottutorial.entity.Department;
import pl.naukaspringboota.springboottutorial.error.DepartmentNotFoundException;
import pl.naukaspringboota.springboottutorial.service.DeparmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final DeparmentService deparmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DeparmentService deparmentService) {
        this.deparmentService = deparmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return deparmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return deparmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return deparmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        deparmentService.deleteDepartmentById(departmentId);
        return "Deleted (id=" + departmentId + ") successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return deparmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return deparmentService.fetchDepartmentByName(departmentName);
    }
}
