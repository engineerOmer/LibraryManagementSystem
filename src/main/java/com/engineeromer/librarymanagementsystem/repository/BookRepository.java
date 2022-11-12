package com.engineeromer.librarymanagementsystem.repository;

import com.engineeromer.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book>  findByBookName(String bookName);


}
