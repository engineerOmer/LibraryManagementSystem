package com.engineeromer.librarymanagementsystem.service;

import com.engineeromer.librarymanagementsystem.dto.request.libraryRequest.TakeBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.libraryResponseDto.LibraryResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.userResponse.UserHaveBookResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Book;
import com.engineeromer.librarymanagementsystem.entity.User;
import com.engineeromer.librarymanagementsystem.repository.BookRepository;
import com.engineeromer.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final UserService userService;
    private final UserRepository userRepository;

    public LibraryResponseDto takeBook(TakeBookRequestDto takeBookRequestDto){
        User user = userService.findById(takeBookRequestDto.getUserId());
        List<Integer> bookId = takeBookRequestDto.getBookId();
        LibraryResponseDto libraryResponseDto = new LibraryResponseDto();
        for (Integer integer : bookId) {
            Book book = bookService.findById(integer);
            book.setUnitInStock(book.getUnitInStock()-1);
            user.addBook(book);
            libraryResponseDto.addBook(book.getBookName());
            bookRepository.save(book);
        }




        return libraryResponseDto;


    }
}
