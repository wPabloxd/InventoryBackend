package com.pablosoft.inventory.services;

import com.pablosoft.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoryResponseRest> search();
}
