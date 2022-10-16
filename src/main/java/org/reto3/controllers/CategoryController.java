package org.reto3.controllers;

import org.reto3.entities.Category;
import org.reto3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    //Attributes
    @Autowired
    CategoryService categoryService;

    //Constructor
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<List<Category>>(this.categoryService.getListCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Category>  getCategoryById(@PathVariable("id") int id) {
        return new ResponseEntity<Category>(this.categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody Category categ){
        this.categoryService.createCategory(categ);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateCategory(@RequestBody Category category){
        System.out.println("Inpt  attriubutes");
        System.out.println("id: " + category.getId());
        System.out.println("name: " + category.getName());
        System.out.println("description " + category.getDescription());
        this.categoryService.updateCategory(category.getId(), category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<String>("Category has been deleted", HttpStatus.NO_CONTENT);
    }
}
