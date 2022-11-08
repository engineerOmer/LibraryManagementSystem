package com.engineeromer.librarymanagementsystem.controller;

import com.engineeromer.librarymanagementsystem.dto.request.userRequest.DeleteUserRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.userRequest.SaveUserRequsetDto;
import com.engineeromer.librarymanagementsystem.dto.response.userResponse.UserHaveBookResponseDto;
import com.engineeromer.librarymanagementsystem.dto.response.userResponse.UserResponseDto;
import com.engineeromer.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UsersController {

    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody SaveUserRequsetDto saveUserRequestDto){
        return new ResponseEntity<>(userService.saveUser(saveUserRequestDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody DeleteUserRequestDto deleteUserRequestDto){
        return new ResponseEntity<>(userService.deleteUser(deleteUserRequestDto),HttpStatus.OK);
    }
    @GetMapping("/userList")
    public ResponseEntity<List<UserResponseDto>> getUserList(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    @GetMapping("/userHaveBookList")
    public ResponseEntity<List<UserHaveBookResponseDto>> getAllUserHaveBookList(){
        return new ResponseEntity<>(userService.getAllUserHaveBook(),HttpStatus.OK);
    }

}
