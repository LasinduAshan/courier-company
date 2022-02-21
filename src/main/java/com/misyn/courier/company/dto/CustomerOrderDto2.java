package com.misyn.courier.company.dto;

import com.misyn.courier.company.enums.RecordStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CustomerOrderDto2 {
    private Long orderId;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private BigDecimal parcelWeight;
    private String orderCode;
    private String parcelType;
    private RecordStatus recordStatus;
    private LocalDateTime createdDate;

}
