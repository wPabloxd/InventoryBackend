package com.pablosoft.inventory.services;

import com.pablosoft.inventory.dao.ICategoryDao;
import com.pablosoft.inventory.model.Category;
import com.pablosoft.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
