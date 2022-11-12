package com.engineeromer.librarymanagementsystem.controller;

import com.engineeromer.librarymanagementsystem.dto.request.bookRequest.DeleteBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.bookRequest.SaveBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.bookResponse.BookResponseDto;
import com.engineeromer.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BooksController {
    private final BookService bookService;

    @PostMapping("/saveBook")
    public ResponseEntity<BookResponseDto> saveBook(@RequestBody SaveBookRequestDto saveBookRequestDto) throws Exception {
        return new ResponseEntity<>(bookService.saveBook(saveBookRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<Boolean> deleteBook(@RequestParam (name = "id") int id,@RequestParam (name = "unitInStock") int unitInStock){
        return new ResponseEntity<>(bookService.deleteBook(id,unitInStock),HttpStatus.OK);
    }
    @GetMapping("/bookList")
    public ResponseEntity<List<BookResponseDto>> getBookList(){
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
    }

    @PutMapping("/stockUpdate")
    public ResponseEntity<Boolean> stockUpdateBook(@RequestParam (name = "id") int id,@RequestParam (name = "unitInStock") int unitInStock){
        return new ResponseEntity<>(bookService.stockUpdate(id,unitInStock),HttpStatus.OK);
    }
}