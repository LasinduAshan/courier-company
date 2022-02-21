package com.misyn.courier.company.controller;

import com.misyn.courier.company.dto.CustomerOrderDto2;
import com.misyn.courier.company.service.CustomerOrderService2;
import com.misyn.courier.company.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/order-service")
public class CustomerOrderController2 {

    private final CustomerOrderService2 customerOrderService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody CustomerOrderDto2 customerOrderDto) {
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse(200, "Success",
                customerOrderService.saveOrder(customerOrderDto)));
    }

    @DeleteMapping(params = {"orderId"})
    public ResponseEntity<StandardResponse> deleteOrder(@RequestParam Long orderId) {
        customerOrderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse(200, "Success", null));
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateOrder(@RequestBody CustomerOrderDto2 customerOrderDto) {
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse(200, "Success",
                customerOrderService.updateOrder(customerOrderDto)));
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<StandardResponse> searchOrder(@PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse(200, "Success",
                customerOrderService.searchOrder(orderId)));
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(new StandardResponse(200, "Success",
                customerOrderService.getAllOrders()));
    }

}
