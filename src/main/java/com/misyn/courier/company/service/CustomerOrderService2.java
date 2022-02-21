package com.misyn.courier.company.service;

import com.misyn.courier.company.dto.CustomerOrderDto;
import com.misyn.courier.company.dto.CustomerOrderDto2;

import java.util.List;

public interface CustomerOrderService2 {
    public CustomerOrderDto2 saveOrder(CustomerOrderDto2 customerOrderDto);
    public CustomerOrderDto2 updateOrder(CustomerOrderDto2 customerOrderDto);
    public CustomerOrderDto2 searchOrder(Long orderId);
    public void deleteOrder(Long orderId);
    public List<CustomerOrderDto2> getAllOrders();
}
