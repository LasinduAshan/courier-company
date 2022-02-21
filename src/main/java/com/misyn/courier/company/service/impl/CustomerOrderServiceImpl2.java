package com.misyn.courier.company.service.impl;

import com.misyn.courier.company.dto.CustomerOrderDto;
import com.misyn.courier.company.dto.CustomerOrderDto2;
import com.misyn.courier.company.entity.CustomerOrder;
import com.misyn.courier.company.enums.RecordStatus;
import com.misyn.courier.company.repository.CustomerOrderRepository;
import com.misyn.courier.company.service.CustomerOrderService2;
import com.misyn.courier.company.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl2 implements CustomerOrderService2 {

    private final CustomerOrderRepository customerOrderRepository;
    private final ModelMapper mapper;
    private final SendEmailService sendEmailService;

    @Override
    public CustomerOrderDto2 saveOrder(CustomerOrderDto2 customerOrderDto) {
        customerOrderDto.setCreatedDate(LocalDateTime.now());
        customerOrderDto.setRecordStatus(RecordStatus.ACTIVE);
        CustomerOrder saveOrder = customerOrderRepository.save(mapper.map(customerOrderDto, CustomerOrder.class));
        if (null != saveOrder){
            sendEmailService.sendEmail(saveOrder.getReceiverAddress(),"Order",saveOrder.getOrderCode());
        }
        return mapper.map(saveOrder, CustomerOrderDto2.class);
    }

    @Override
    public CustomerOrderDto2 updateOrder(CustomerOrderDto2 customerOrderDto) {
        CustomerOrder updateOrder;
        if (customerOrderRepository.existsById(customerOrderDto.getOrderId())) {
            updateOrder = customerOrderRepository.save(mapper.map(customerOrderDto, CustomerOrder.class));
        } else {
            throw new RuntimeException("No such order for update..!");
        }
        return mapper.map(updateOrder, CustomerOrderDto2.class);
    }

    @Override
    public CustomerOrderDto2 searchOrder(Long orderId) {
        Optional<CustomerOrder> order = customerOrderRepository.findById(orderId);
        if (order.isPresent()) {
            return mapper.map(order.get(), CustomerOrderDto2.class);
        } else {
            throw new RuntimeException("No order for id " + orderId);
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (customerOrderRepository.existsById(orderId)) {
            CustomerOrder customerOrder = customerOrderRepository.getById(orderId);
            customerOrder.setRecordStatus(RecordStatus.DELETED);
            customerOrderRepository.save(customerOrder);
        } else {
            throw new RuntimeException("No Order for the Delete ID " + orderId);
        }
    }

    @Override
    public List<CustomerOrderDto2> getAllOrders() {
        List<CustomerOrder> customerOrderList = customerOrderRepository.findAll();
        List<CustomerOrder> orderList = new ArrayList<>();
        customerOrderList.forEach(customerOrder -> {
            if (customerOrder.getRecordStatus().equals(RecordStatus.ACTIVE)) {
                orderList.add(customerOrder);
            }
        });
        return mapper.map(orderList, new TypeToken<List<CustomerOrderDto>>() {
        }.getType());
    }
}
