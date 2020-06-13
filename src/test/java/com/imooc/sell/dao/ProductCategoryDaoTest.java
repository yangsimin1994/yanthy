package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryDaoTest {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Test
    public void test01(){
        System.out.println("111111111111");
        log.info("info");
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory);
    }
}