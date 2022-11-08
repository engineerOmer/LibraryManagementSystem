package com.engineeromer.librarymanagementsystem.service;


import com.engineeromer.librarymanagementsystem.dto.request.categoryRequest.DeleteCategoryRequestDto;
import com.engineeromer.librarymanagementsystem.dto.request.categoryRequest.SaveCategoryRequestDto;
import com.engineeromer.librarymanagementsystem.dto.response.categoryResponse.CategoryResponseDto;
import com.engineeromer.librarymanagementsystem.entity.Category;
import com.engineeromer.librarymanagementsystem.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryResponseDto saveCategory(SaveCategoryRequestDto saveCategoryRequestDto) {
        Category category = modelMapper.map(saveCategoryRequestDto, Category.class);
        categoryRepository.save(category);
        return modelMapper.map(saveCategoryRequestDto, CategoryResponseDto.class);
    }
    public boolean deleteCategory(DeleteCategoryRequestDto deleteCategoryRequestDto){
        int id = deleteCategoryRequestDto.getId();
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(category.getId());
        return !categoryRepository.existsById(id);
    }
    public List<CategoryResponseDto> getAllCategories(){
        return categoryRepository.findAll().stream().map(item ->modelMapper.map(item,CategoryResponseDto.class)).toList();
    }

    public Category findById(int id){
        return categoryRepository.findById(id).orElseThrow();
    }
}