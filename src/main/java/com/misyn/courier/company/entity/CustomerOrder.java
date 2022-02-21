package com.misyn.courier.company.entity;



import com.misyn.courier.company.enums.RecordStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long orderId;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private BigDecimal parcelWeight;
    private String orderCode;
    private String parcelType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;
    @CreationTimestamp
    @Column
    private LocalDateTime createdDate;

}
