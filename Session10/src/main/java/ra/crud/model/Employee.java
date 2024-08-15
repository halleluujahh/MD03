package ra.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "emp_id", columnDefinition = "char(5)")
    private String empId;
    @Column(name = "emp_name", columnDefinition = "varchar(150)", nullable = false)
    private String empName;
    @Column(name = "emp_age", nullable = false)
    private int age;
    @Column(name = "emp_dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Column(name = "emp_salary")
    private float salary;
    @Column(name = "emp_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
    private Department department;
}
