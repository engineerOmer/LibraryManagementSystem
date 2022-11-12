package com.engineeromer.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@ToString
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "edition_date")
    private LocalDate editionDate;

    @Column(name = "add_library_date")
    private LocalDate addLibraryDate;

    @Column(name = "unit_in_stock")
    private int unitInStock;

    public Book(String bookName, LocalDate editionDate, int unitInStock ) {
        this.bookName = bookName;
        this.editionDate = editionDate;
        this.unitInStock = unitInStock;

    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "BOOKS_CATEGORIES",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonManagedReference
    private Set<Category> categories = new HashSet<>();

    public void addCategory (Category category){
        categories.add(category);
    }

    @JoinColumn(name = "author_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;


    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<User> users = new HashSet<>();

}
