package com.engineeromer.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "USER_BOOK",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @JsonManagedReference
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        books.add(book);
    }
}
