package com.pablosoft.inventory.controller;

import com.pablosoft.inventory.response.CategoryResponse;
import com.pablosoft.inventory.response.CategoryResponseRest;
import com.pablosoft.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;
    /*
    * Get all the categories
    * @return
    */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        return  service.search();
    }
    /*
     * Get category by ID
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        return  service.searchById(id);
    }
}
