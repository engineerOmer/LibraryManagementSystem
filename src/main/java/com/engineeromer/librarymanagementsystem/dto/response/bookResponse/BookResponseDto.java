package com.engineeromer.librarymanagementsystem.dto.response.bookResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDto {
    private String bookName;
    private int unitInStock;
    private LocalDate editionDate;
}