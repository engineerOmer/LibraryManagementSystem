package com.engineeromer.librarymanagementsystem.dto.request.authorRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveAuthorRequestDto {
    private String firstName;

    private String lastName;

    private LocalDate birthDay;
}