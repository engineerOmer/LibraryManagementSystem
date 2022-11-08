package com.engineeromer.librarymanagementsystem.dto.response.userResponse;

import com.engineeromer.librarymanagementsystem.dto.response.bookResponse.BookResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserHaveBookResponseDto {
    private String firstName;
    private List<BookResponseDto> bookResponseDtos;
}