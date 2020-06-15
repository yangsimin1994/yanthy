package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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
        log.debug("debug");
        log.error("error");
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void test02(){
        ProductCategory one = productCategoryDao.findOne(3);
        one.setCategoryType(8);
        productCategoryDao.save(one);
    }

    @Test
    @Transactional
    public void test03(){
        ProductCategory pc = new ProductCategory("咩咩最爱", 4);
        ProductCategory save = productCategoryDao.save(pc);
        Assert.assertNotNull(save);
    }

    @Test
    public void test04(){
        List<Integer> types = Arrays.asList(2, 3);
        List<ProductCategory> list = productCategoryDao.findByCategoryTypeIn(types);
        Assert.assertNotEquals(0,list.size());
    }
}