package com.engineeromer.librarymanagementsystem.controller;

import com.engineeromer.librarymanagementsystem.dto.request.libraryRequest.TakeBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.libraryResponseDto.LibraryResponseDto;
import com.engineeromer.librarymanagementsystem.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/takeBook")
    public ResponseEntity<LibraryResponseDto> takeBook(@RequestBody TakeBookRequestDto takeBookRequestDto) throws Exception {
        return new ResponseEntity<>(libraryService.takeBook(takeBookRequestDto), HttpStatus.OK);
    }
    @PostMapping("/returnBook")
    public ResponseEntity<LibraryResponseDto> giveBackBook(@RequestBody TakeBookRequestDto takeBookRequestDto){
        return new ResponseEntity<>(libraryService.giveBackBook(takeBookRequestDto), HttpStatus.OK);
    }
}
