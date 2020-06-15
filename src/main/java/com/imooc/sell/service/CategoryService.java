package com.imooc.sell.service;

import com.imooc.sell.entity.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer categoryType);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
