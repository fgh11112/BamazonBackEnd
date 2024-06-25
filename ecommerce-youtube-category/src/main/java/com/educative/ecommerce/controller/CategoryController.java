package com.educative.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educative.ecommerce.common.ApiResponse;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/catgory")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "success";
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> listCategory() {
        return new ResponseEntity<>(new ApiResponse(true, "a new category created"), HttpStatus.CREATED);
    }
    
    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable int categoryId, @RequestBody Category category ) {
    	System.out.println("category id " + categoryId);
    	if(!categoryService.findById(categoryId)) {
            return new ResponseEntity<>(new ApiResponse(true, "category does not exist"), HttpStatus.NOT_FOUND);
    	}
    	categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true, "category has been updated"), HttpStatus.OK);
    }
    
}
