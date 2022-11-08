package com.engineeromer.librarymanagementsystem.controller;

import com.engineeromer.librarymanagementsystem.dto.request.libraryRequest.TakeBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.libraryResponseDto.LibraryResponseDto;
import com.engineeromer.librarymanagementsystem.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/takeBook")
    public ResponseEntity<LibraryResponseDto> takeBook(@RequestBody TakeBookRequestDto takeBookRequestDto){
        return new ResponseEntity<>(libraryService.takeBook(takeBookRequestDto), HttpStatus.OK);
    }
}
