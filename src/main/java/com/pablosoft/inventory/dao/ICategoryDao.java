package com.pablosoft.inventory.dao;

import com.pablosoft.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {


}
