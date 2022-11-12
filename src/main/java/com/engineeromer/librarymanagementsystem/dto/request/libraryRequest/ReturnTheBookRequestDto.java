package com.engineeromer.librarymanagementsystem.dto.request.libraryRequest;

import lombok.Data;

@Data
public class ReturnTheBookRequestDto {
    private int userId;
    private int bookId;
}
