package ra.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;
    @Column(name = "dept_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String deptName;
    @Column(name = "dept_description", columnDefinition = "text")
    private String description;
    @Column(name = "dept_status")
    private boolean status;
    @OneToMany(mappedBy = "department")
    private List<Employee> listEmployees = new ArrayList<Employee>();
}
