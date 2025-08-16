package com.alt.service;

import com.alt.dto.EmployeeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
public interface EmployeeService {
public EmployeeDTO registerEmployee(EmployeeDTO employeeDTO);
public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
public void deleteEmployee(long id);
public List<EmployeeDTO> getAllEmployees();
public List<EmployeeDTO> getAllEmployeesByDepartment(String department);
public EmployeeDTO getEmployee(long id);
}
