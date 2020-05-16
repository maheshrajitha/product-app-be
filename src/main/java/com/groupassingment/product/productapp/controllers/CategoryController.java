package com.groupassingment.product.productapp.controllers;

import com.groupassingment.product.productapp.annotations.AuthenticetionScope;
import com.groupassingment.product.productapp.dtos.CategoryDto;
import com.groupassingment.product.productapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController implements Controller {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @AuthenticetionScope(3)
    public ResponseEntity<?> addNewCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.addNewCategory(categoryDto));
    }

    @GetMapping("/my-categories")
    @AuthenticetionScope(3)
    public ResponseEntity<?> getMyCategories(){
        return ResponseEntity.ok(categoryService.getCategoryByOwner());
    }

    @DeleteMapping("/delete/{category}")
    @AuthenticetionScope(3)
    public ResponseEntity<?> deleteCategory(@PathVariable("category") String category){
        return ResponseEntity.ok(categoryService.deleteCategory(category));
    }
}
