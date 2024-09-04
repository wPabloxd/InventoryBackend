package com.pablosoft.inventory.services;

import com.pablosoft.inventory.dao.ICategoryDao;
import com.pablosoft.inventory.model.Category;
import com.pablosoft.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServicesImp implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
        CategoryResponseRest response = new CategoryResponseRest();
        try{
            List<Category> category = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Response ok", "00", "Correct response");
        } catch (Exception e){
            e.getStackTrace();
            response.setMetadata("Response not ok", "-1", "Error response");
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();
        try{
            Optional<Category> category = categoryDao.findById(id);
            if(category.isPresent()){
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Response ok", "-00", "Category found");
            } else {
                response.setMetadata("Response not ok", "-1", "Category not found");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            e.getStackTrace();
            response.setMetadata("Response not ok", "-1", "Error id response");
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();
        try{
            Category categorySaved = categoryDao.save(category);
            if(categorySaved != null){
                list.add(categorySaved);
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Response ok", "00", "Category saved");
            } else {
                response.setMetadata("Response not ok", "-1", "Category not saved");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            e.getStackTrace();
            response.setMetadata("Response not ok", "-1", "Saving error");
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
}
