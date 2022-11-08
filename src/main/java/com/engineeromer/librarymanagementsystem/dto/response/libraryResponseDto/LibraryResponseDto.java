package com.engineeromer.librarymanagementsystem.dto.response.libraryResponseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryResponseDto {
    private List<String> bookName = new ArrayList<>();

    public void addBook(String book){
        bookName.add(book);
    }
}
