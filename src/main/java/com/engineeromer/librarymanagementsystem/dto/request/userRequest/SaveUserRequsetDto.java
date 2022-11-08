package com.engineeromer.librarymanagementsystem.dto.request.userRequest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveUserRequsetDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String tckn;
}