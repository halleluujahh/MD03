package org.com.dto.response;

import lombok.*;
import org.com.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRes {
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;
    private boolean status;
    private Date createdAt;
    private Category category;
}
