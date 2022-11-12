package com.engineeromer.librarymanagementsystem.service;

import com.engineeromer.librarymanagementsystem.dto.converter.BookConverter;
import com.engineeromer.librarymanagementsystem.dto.request.bookRequest.DeleteBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.bookRequest.SaveBookRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.bookResponse.BookResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Author;
import com.engineeromer.librarymanagementsystem.entity.Book;
import com.engineeromer.librarymanagementsystem.entity.Category;
import com.engineeromer.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BookService {
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookConverter bookConverter;

    public BookResponseDto saveBook(SaveBookRequestDto saveBookRequestDto) throws Exception {
        Book book1 = bookRepository.findByBookName(saveBookRequestDto.getBookName()).orElse(null);
        if (book1==null) {

            Book book = bookConverter.saveBookRequestDtoToBook(saveBookRequestDto);
            Author author = authorService.findById(saveBookRequestDto.getAuthorId());
            book.setAuthor(author);
            List<Integer> categoryId = saveBookRequestDto.getCategoryId();
            for (Integer integer : categoryId) {
                Category category = categoryService.findById(integer);
                book.addCategory(category);
            }
            book.setAddLibraryDate(LocalDate.now());

            bookRepository.save(book);
        }else {
            book1.setUnitInStock(book1.getUnitInStock()+ saveBookRequestDto.getUnitInStock());
            bookRepository.save(book1);
        }

        return modelMapper.map(saveBookRequestDto,BookResponseDto.class);
    }

    public boolean deleteBook(int id,int unitInStock){
        Book book = bookRepository.findById(id).orElseThrow();
        if (book.getUnitInStock()> 1){
            book.setUnitInStock(book.getUnitInStock()-unitInStock);
            bookRepository.save(book);
        }else {
            bookRepository.deleteById(id);
        }
        return !bookRepository.existsById(id);
    }

    public boolean stockUpdate(int id,int unitInStock){
        Book book = bookRepository.findById(id).orElseThrow();
        book.setUnitInStock(book.getUnitInStock()+unitInStock);
        bookRepository.save(book);
        return true;
    }

    public List<BookResponseDto> getAllBook(){
        return bookRepository.findAll().stream().map(item -> modelMapper
                .map(item,BookResponseDto.class)).toList();
    }
    public Book findById(int id){
        return bookRepository.findById(id).orElseThrow();
    }

}