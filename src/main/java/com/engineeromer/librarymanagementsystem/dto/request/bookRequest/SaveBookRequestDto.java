package com.engineeromer.librarymanagementsystem.dto.request.bookRequest;

import com.engineeromer.librarymanagementsystem.entity.Category;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaveBookRequestDto {

    private String bookName;

    private LocalDate editionDate;

    private int unitInStock;

    private int authorId;

    private List<Integer> categoryId;

}