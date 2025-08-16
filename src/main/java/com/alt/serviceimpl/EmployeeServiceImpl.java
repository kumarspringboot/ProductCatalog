package com.alt.serviceimpl;

import com.alt.dto.EmployeeDTO;
import com.alt.entity.EmployeeEntity;
import com.alt.repository.EmployeeRepository;
import com.alt.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO registerEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        EmployeeEntity save = employeeRepository.save(employeeEntity);
        BeanUtils.copyProperties(employee, save);
        return employee;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void deleteEmployee(long id) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return List.of();
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesByDepartment(String department) {
        return List.of();
    }

    @Override
    public EmployeeDTO getEmployee(long id) {
        return null;
    }
}
