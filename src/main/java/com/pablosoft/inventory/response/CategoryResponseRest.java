package com.pablosoft.inventory.response;

public class CategoryResponseRest extends ResponseRest {

    private CategoryResponse categoryResponse = new CategoryResponse();

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }
}
