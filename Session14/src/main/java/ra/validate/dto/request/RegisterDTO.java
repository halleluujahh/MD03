package ra.validate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDTO {
    @Size(min = 6, message = "Tên đăng nhập tối thiểu 6 ký tự")
    private String userName;
    @Size(min = 8, message = "Mật khẩu tối thiểu 8 ký tự")
    private String password;
    @NotBlank(message = "Tên người dùng không được trống")
    private String fullName;
    @Email(message = "Không đúng định dạng email")
    private String email;
    @Pattern(regexp = "(03|05|08|09)+([0|1|2|5|6|8])+(\\d{7})", message = "Không đúng định dạng số điện thoại VN")
    private String phone;
    private boolean sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @NotEmpty(message = "Địa chỉ người dùng không được trống")
    private String address;
}
