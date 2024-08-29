package org.com.session16.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookTypeDTO {
    private Integer id;
    @NotBlank(message = "Tên loại sách không được để trống")
    @NotNull(message = "Tên loại sách không được để trống")
    private String typeName;
    @NotBlank(message = "Mô tả không được để trống")
    @NotNull(message = "Mô tả không được để trống")
    private String description;
    @NotNull(message = "Trạng thái không được để trống")
    private boolean typeStatus;
}
