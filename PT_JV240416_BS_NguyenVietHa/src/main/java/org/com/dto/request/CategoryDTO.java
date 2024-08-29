package org.com.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {
    private Integer id;
    @NotNull(message = "Không được để trống trên thể loại")
    @NotBlank(message = "Không được để trống trên thể loại")
    private String name;
    private String description;
    private boolean status;
}
