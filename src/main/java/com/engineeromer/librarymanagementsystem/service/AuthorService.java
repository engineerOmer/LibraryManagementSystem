package com.engineeromer.librarymanagementsystem.service;

import com.engineeromer.librarymanagementsystem.dto.request.authorRequest.DeleteAuthorRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.authorRequest.SaveAuthorRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.authorResponse.AuthorResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Author;
import com.engineeromer.librarymanagementsystem.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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


    public Author findById(int id){
        return authorRepository.findById(id).orElseThrow();
    }
}