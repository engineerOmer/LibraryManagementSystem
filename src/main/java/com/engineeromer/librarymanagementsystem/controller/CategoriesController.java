package com.engineeromer.librarymanagementsystem.controller;


import com.engineeromer.librarymanagementsystem.dto.request.categoryRequest.DeleteCategoryRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.categoryRequest.SaveCategoryRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.categoryResponse.CategoryResponseDto;
import com.engineeromer.librarymanagementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoriesController {
    private final CategoryService categoryService;


    @PostMapping("/saveCategory")
    public ResponseEntity<CategoryResponseDto> saveCategory(@RequestBody SaveCategoryRequestDto saveCategoryRequestDto){
        return new ResponseEntity<>(categoryService.saveCategory(saveCategoryRequestDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteCategory")
    public ResponseEntity<Boolean> deleteCategory(@RequestBody DeleteCategoryRequestDto deleteCategoryRequestDto){
        return new ResponseEntity<>(categoryService.deleteCategory(deleteCategoryRequestDto),HttpStatus.OK);
    }
    @GetMapping("/categoryList")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }

}
