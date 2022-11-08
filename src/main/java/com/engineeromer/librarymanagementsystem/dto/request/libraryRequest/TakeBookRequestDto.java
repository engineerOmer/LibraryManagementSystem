package com.engineeromer.librarymanagementsystem.dto.request.libraryRequest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TakeBookRequestDto {
    private int userId;
    private List<Integer> bookId = new ArrayList<>();


}
