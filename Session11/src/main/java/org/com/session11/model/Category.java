package org.com.session11.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int id;

    @Column(name = "catalog_name", nullable = false, unique = true)
    private String name;

    @Column(name = "catalog_description")
    private String description;

    @Column(name = "catalog_status")
    private boolean status;

    @OneToMany(mappedBy = "category")
    List<Product> products = new ArrayList<Product>();
}
