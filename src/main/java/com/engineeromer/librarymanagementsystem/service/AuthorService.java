package com.engineeromer.librarymanagementsystem.service;

import com.engineeromer.librarymanagementsystem.dto.request.authorRequest.DeleteAuthorRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.authorRequest.SaveAuthorRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.authorResponse.AuthorResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.authorResponse.AuthorWriteAllBookResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.bookResponse.BookResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Author;
import com.engineeromer.librarymanagementsystem.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;


    public AuthorResponseDto saveAuthor(SaveAuthorRequestDto saveAuthorRequestDto){
        Author author = modelMapper.map(saveAuthorRequestDto, Author.class);
        authorRepository.save(author);
        return modelMapper.map(author,AuthorResponseDto.class);
    }
    public boolean deleteUser(DeleteAuthorRequestDto deleteAuthorRequestDto){
        int id = deleteAuthorRequestDto.getId();
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.deleteById(author.getId());
        return !authorRepository.existsById(id);
    }
    public List<AuthorResponseDto> getAllAuthor(){
        return authorRepository.findAll().stream().map(item -> modelMapper
                .map(item,AuthorResponseDto.class)).toList();
    }

    public List<AuthorWriteAllBookResponseDto> getAllAuthorBook(){
        return authorRepository.findAll().stream().map(
                author -> AuthorWriteAllBookResponseDto.builder()
                        .firstName(author.getFirstName())
                        .bookResponseDtos(author.getBooks().stream().map(t->modelMapper.map(t,BookResponseDto.class)).toList()
                        ).build())
                .toList();
    }

    public Author findById(int id){
        return authorRepository.findById(id).orElseThrow();
    }
}