package com.pablosoft.inventory.response;

import com.pablosoft.inventory.model.Category;

import java.util.List;

public class CategoryResponse {

    private List<Category> category;

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
