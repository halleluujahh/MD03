package org.com.session16.dto.request;

import lombok.*;
import org.com.session16.entity.BookType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookDTO {
    @NotBlank(message = "Mã sách không được để trống")
    @NotNull(message = "Mã sách không được để trống")
    @Pattern(regexp = "[B\\d]{4}", message = "Mã sách nhập sai định dạng (B[0-9], tối đa 4 ký tự)")
    private String id;
    @NotBlank(message = "Tên sách không được để trống")
    @NotNull(message = "Tên sách không được để trống")
    private String name;
    @Min(value = 1, message = "Giá phải lớn hơn không")
    private float price;
    @NotBlank(message = "Nội dung không được để trống")
    @NotNull(message = "Nội dung không được để trống")
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create;
    @NotBlank(message = "Tên tác giả không được để trống")
    @NotNull(message = "Tên tác giả không được để trống")
    private String author;
    @NotNull(message = "Trạng thái không được để trống")
    private boolean status;
    @NotNull(message = "Thể loại sách không được để trống")
    private Integer bookTypeId;
}
