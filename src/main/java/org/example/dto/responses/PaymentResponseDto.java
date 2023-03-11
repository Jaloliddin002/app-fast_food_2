package org.example.dto.responses;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PaymentResponseDto {
    private UUID id;
    private List <UUID> foods;
    private UUID cardId;
    private double amount;
    private Date date;
    private double cashBack;
}
