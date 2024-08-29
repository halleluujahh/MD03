package org.com.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String name;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "status", columnDefinition = "bit default 1")
    private boolean status;
}
