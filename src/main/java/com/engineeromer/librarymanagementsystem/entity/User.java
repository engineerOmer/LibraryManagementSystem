package com.engineeromer.librarymanagementsystem.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Column(name = "tckn")
    private String tckn;

    @ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        books.add(book);
    }
}
