package com.engineeromer.librarymanagementsystem.service;

import com.engineeromer.librarymanagementsystem.dto.request.userRequest.DeleteUserRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.userRequest.SaveUserRequsetDto;
import com.engineeromer.librarymanagementsystem.dto.response.bookResponse.BookResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.userResponse.UserHaveBookResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.userResponse.UserResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Book;
import com.engineeromer.librarymanagementsystem.entity.User;
import com.engineeromer.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponseDto saveUser(SaveUserRequsetDto saveUserRequsetDto){
        User user = modelMapper.map(saveUserRequsetDto,User.class);
        user.setCreatedDate(LocalDate.now());
        userRepository.save(user);
        return modelMapper.map(saveUserRequsetDto,UserResponseDto.class);
    }

    public boolean deleteUser(DeleteUserRequestDto deleteUserRequestDto){
        int id = deleteUserRequestDto.getId();
        User user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(user.getId());
        return !userRepository.existsById(id);
    }



    public List<UserResponseDto> getAllUser(){
        return userRepository.findAll().stream().map(item->modelMapper.map(item,UserResponseDto.class)).toList();
    }

    public List<UserHaveBookResponseDto> getAllUserHaveBook(){
        return userRepository.findAll().stream().map(
                        user -> UserHaveBookResponseDto.builder()
                                .firstName(user.getFirstName())
                                .bookResponseDtos(user.getBooks().stream().map(t -> modelMapper.map(t, BookResponseDto.class)).toList()
                                ).build())
                .toList();
    }
    public User findById(int id){
        return userRepository.findById(id).orElseThrow();
    }







}