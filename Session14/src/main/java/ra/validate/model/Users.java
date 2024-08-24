package ra.validate.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "App_User")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String userName;
    @Column(name = "user_pass", columnDefinition = "varchar(50)", nullable = false)
    private String password;
    @Column(name = "user_fullname", columnDefinition = "varchar(100)", nullable = false)
    private String fullName;
    @Column(name = "user_email", columnDefinition = "varchar(100)", nullable = false)
    private String email;
    @Column(name = "user_phone", columnDefinition = "char(10)", nullable = false)
    private String phone;
    @Column(name = "user_sex")
    private boolean sex;
    @Column(name = "user_dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Column(name = "user_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "user_address", columnDefinition = "text", nullable = false)
    private String address;
    @Column(name = "user_status")
    private boolean status;
}
