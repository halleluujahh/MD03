package org.com.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name", columnDefinition = "varchar(100)", nullable = false)
    private String name;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price", columnDefinition = "double check(price > 0)", nullable = false)
    private double price;
    @Column(name = "image_url", columnDefinition = "varchar(255)")
    private String image;
    @Column(name = "status", columnDefinition = "bit default 1")
    private boolean status;
    @Column(name = "created_at", columnDefinition = "datetime")
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;
}
