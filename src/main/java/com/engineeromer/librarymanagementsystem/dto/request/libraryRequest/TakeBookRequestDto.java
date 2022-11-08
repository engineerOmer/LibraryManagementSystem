package com.engineeromer.librarymanagementsystem.dto.request.libraryRequest;

import lombok.Data;


import java.util.List;

@Data
public class TakeBookRequestDto {
    private int userId;
    private List<Integer> bookId;


}
