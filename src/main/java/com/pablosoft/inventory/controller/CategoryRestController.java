package com.pablosoft.inventory.controller;

import com.pablosoft.inventory.model.Category;
import com.pablosoft.inventory.response.CategoryResponse;
import com.pablosoft.inventory.response.CategoryResponseRest;
import com.pablosoft.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;
    /**
    * Get all the categories
    * @return
    */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        return  service.search();
    }
    /**
     * Get category by ID
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        return  service.searchById(id);
    }
    /**
     * Creates and saves a category
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){
        return  service.save(category);
    }
    /**
     * Update a category by ID
     * @param category
     * @param id
     * @return
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id){
        return  service.update(category, id);
    }

    /**
     * Deletes a category by ID
     * @param id
     * @return
     */
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id){
        return  service.delete(id);
    }
}
