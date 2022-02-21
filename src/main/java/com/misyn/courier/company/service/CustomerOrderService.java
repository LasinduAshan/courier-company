package com.misyn.courier.company.service;

import com.misyn.courier.company.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {
    public CustomerOrderDto saveOrder(CustomerOrderDto customerOrderDto);
    public CustomerOrderDto updateOrder(CustomerOrderDto customerOrderDto);
    public CustomerOrderDto searchOrder(Long orderId);
    public void deleteOrder(Long orderId);
    public List<CustomerOrderDto> getAllOrders();
}
