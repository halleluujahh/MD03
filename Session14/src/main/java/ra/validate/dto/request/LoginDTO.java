package ra.validate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String userName;
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;
}
