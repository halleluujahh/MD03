package org.com.session11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name", nullable = false,unique = true, columnDefinition = "varchar(100)")
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Float price;

    @Column(name = "product_created", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @Column(name = "product_view", nullable = false)
    private Integer view;

    @Column(name = "product_title", nullable = false)
    private String title;

    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "product_status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Category category;
}
