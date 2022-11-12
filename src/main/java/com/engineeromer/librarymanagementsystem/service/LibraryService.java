package com.engineeromer.librarymanagementsystem.service;

import com.engineeromer.librarymanagementsystem.dto.request.libraryRequest.TakeBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.libraryResponseDto.LibraryResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Book;
import com.engineeromer.librarymanagementsystem.entity.User;
import com.engineeromer.librarymanagementsystem.repository.BookRepository;
import com.engineeromer.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private final BookService bookService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public LibraryResponseDto takeBook(TakeBookRequestDto takeBookRequestDto) throws Exception {

        User user = userService.findById(takeBookRequestDto.getUserId());
        List<Integer> bookId = takeBookRequestDto.getBookId();
        LibraryResponseDto libraryResponseDto = new LibraryResponseDto();
        for (Integer integer : bookId) {
            Book book = bookService.findById(integer);
            if (book.getUnitInStock()<1){
                throw new Exception("Elimizde bu kiptan kalmadi: "+book.getBookName());
            }
            book.setUnitInStock(book.getUnitInStock()-1);
            user.addBook(book);
            libraryResponseDto.addBook(book.getBookName());
        }
        userRepository.save(user);
        return libraryResponseDto;
    }

    public LibraryResponseDto giveBackBook(TakeBookRequestDto takeBookRequestDto){
        User user = userService.findById(takeBookRequestDto.getUserId());
        List<Integer> bookId = takeBookRequestDto.getBookId();
        LibraryResponseDto libraryResponseDto = new LibraryResponseDto();
        Set<Book> books = user.getBooks();
        for (Integer integer : bookId) {
            Book book = bookService.findById(integer);
            book.setUnitInStock(book.getUnitInStock()+1);
            libraryResponseDto.addBook(book.getBookName());
            books.remove(book);
        }
        user.setBooks(books);
        userRepository.save(user);
        return libraryResponseDto;
    }
}
