package com.alt.entity;

import com.alt.util.EmployeeType;
import com.alt.util.ProductType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name="employee")
public class EmployeeEntity {
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
