package com.engineeromer.librarymanagementsystem.controller;

import com.engineeromer.librarymanagementsystem.dto.request.authorRequest.SaveAuthorRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.authorResponse.AuthorResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.authorResponse.AuthorWriteAllBookResponseDto;
import com.engineeromer.librarymanagementsystem.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorsController {
    private final AuthorService authorService;

    @PostMapping("/saveAuthor")
    public ResponseEntity<AuthorResponseDto> saveAuthor(@RequestBody SaveAuthorRequestDto saveAuthorRequestDto){
        return new ResponseEntity<>(authorService.saveAuthor(saveAuthorRequestDto), HttpStatus.CREATED);
    }
    @GetMapping("/authorList")
    public ResponseEntity<List<AuthorResponseDto>> getAuthorList(){
        return new ResponseEntity<>(authorService.getAllAuthor(),HttpStatus.OK);
    }
    @GetMapping("/authorBooks")
    public ResponseEntity<List<AuthorWriteAllBookResponseDto>> getAllAuthorBookList(){
        return new ResponseEntity<>(authorService.getAllAuthorBook(),HttpStatus.OK);
    }

}