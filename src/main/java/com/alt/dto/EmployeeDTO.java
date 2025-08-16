package com.alt.dto;

import com.alt.util.EmployeeType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fname;
    private String lname;
    private String gender;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    private LocalDate joiningDate;

}
