package com.groupassingment.product.productapp.services.servicesimpl;

import com.groupassingment.product.productapp.dtos.CategoryDto;
import com.groupassingment.product.productapp.repository.CategoryRepository;
import com.groupassingment.product.productapp.services.CategoryService;
import com.groupassingment.product.productapp.util.ActiveUser;
import com.groupassingment.product.productapp.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ActiveUser activeUser;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mapper mapper;

    @Override
    public CategoryDto addNewCategory(CategoryDto categoryDto) {
        log.info("User ID {}",activeUser.getId());
        categoryDto.setOwnerId(activeUser.getId());
        categoryRepository.save(mapper.mapCategoryDtoToCategoryModel(categoryDto));
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getCategoryByOwner(){
        return categoryRepository.findAllByOwnerId(activeUser.getId()).stream().map(categoryModel -> mapper.mapCategoryModelToCategoryDto(new CategoryDto(),categoryModel)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }
}
