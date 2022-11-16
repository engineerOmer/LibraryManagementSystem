package com.engineeromer.librarymanagementsystem.dto.response.authorResponse;

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
public class AuthorWriteAllBookResponseDto {

    private String firstName;
    private List<BookResponseDto> bookResponseDtos;
}
