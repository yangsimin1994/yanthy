package com.imooc.sell.service.Impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1234";

    private final String ORDER_ID = "1593336679371722654";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("yanthy");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("13437862629");

        List<OrderDetail> list = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("2");
        o1.setProductQuantity(1);
        list.add(o1);
        orderDTO.setOrderDetailList(list);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result = {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID,orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancle() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}