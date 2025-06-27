package org.chintanpatel.springbootapp.employee;

import jakarta.validation.Valid;
import org.chintanpatel.springbootapp.department.Department;
import org.chintanpatel.springbootapp.department.DepartmentService;
import org.chintanpatel.springbootapp.designation.Designation;
import org.chintanpatel.springbootapp.designation.DesignationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final DesignationService designationService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, DesignationService designationService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.designationService = designationService;
    }

    @GetMapping("/employees/listEmployee")
    public String listEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployeeList();
        model.addAttribute("employeeList", employeeList);
        return "employee/employee-list";
    }

    @GetMapping("/employees/showEmployeeForm")
    public String showEmployeeForm(Model model) {
        Employee employee = new Employee();
        List<Department> departmentList = departmentService.getAllDepartmentList();
        List<Designation> designationList = designationService.getAllDesignationList();
        model.addAttribute("employee", employee);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("designationList", designationList);
        return "employee/employee-form";
    }

    @PostMapping("/employees/insertOrUpdateEmployee")
    public String insertOrUpdateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Department> departmentList = departmentService.getAllDepartmentList();
            List<Designation> designationList = designationService.getAllDesignationList();
            model.addAttribute("departmentList", departmentList);
            model.addAttribute("designationList", designationList);
            return "employee/employee-form";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employees/listEmployee";
    }

    @GetMapping("/employees/manageEmployee/{employeeId}")
    public String manageEmployee(@PathVariable Long employeeId, Model model){
        if (employeeId != null){
            Employee employee = employeeService.getEmployeeById(employeeId);
            List<Department> departmentList = departmentService.getAllDepartmentList();
            List<Designation> designationList = designationService.getAllDesignationList();
            model.addAttribute("employee", employee);
            model.addAttribute("departmentList", departmentList);
            model.addAttribute("designationList", designationList);
        }
        return "employee/employee-form";
    }

    @GetMapping("/employees/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId){
        if (employeeId != null){
            employeeService.deleteEmployeeById(employeeId);
        }
        return "redirect:/employees/listEmployee";
    }
}
