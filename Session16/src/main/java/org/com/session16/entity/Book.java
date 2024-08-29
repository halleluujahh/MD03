package org.com.session16.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    @Id
    @Column(name = "Book_id", columnDefinition = "char(5)")
    private String id;
    @Column(name = "Book_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String name;
    @Column(name = "Book_Price", columnDefinition = "Float", nullable = false)
    private float price;
    @Column(name = "Book_Content", columnDefinition = "Text", nullable = false)
    private String content;
    @Column(name = "Book_create", columnDefinition = "Date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create;
    @Column(name = "Book_Author", columnDefinition = "varchar(100)", nullable = false)
    private String author;
    @Column(name = "Book_status", columnDefinition = "bit")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "Type_id", referencedColumnName = "Type_id")
    private BookType booktype;
}
