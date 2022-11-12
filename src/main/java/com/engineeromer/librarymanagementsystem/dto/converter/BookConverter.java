package com.engineeromer.librarymanagementsystem.dto.converter;

import com.engineeromer.librarymanagementsystem.dto.request.bookRequest.SaveBookRequestDto;
import com.engineeromer.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public Book saveBookRequestDtoToBook(SaveBookRequestDto saveBookRequestDto){
        return new Book(
                saveBookRequestDto.getBookName(),
                saveBookRequestDto.getEditionDate(),
                saveBookRequestDto.getUnitInStock());

    }
}
