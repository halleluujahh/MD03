package org.com.session16.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BookType")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Type_id")
    private int id;
    @Column(name = "Type_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String typeName;
    @Column(name = "Type_description", columnDefinition = "text")
    private String description;
    @Column(name = "Type_status", columnDefinition = "bit")
    private boolean typeStatus;
    @OneToMany(mappedBy = "booktype")
    List<Book> books = new ArrayList<Book>();
}
