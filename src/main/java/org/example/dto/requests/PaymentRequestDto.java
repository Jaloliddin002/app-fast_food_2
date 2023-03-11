package org.example.dto.requests;

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
public class PaymentRequestDto {
    private List <UUID> foods;
    private UUID cardId;
    private double amount;
    private double cashBack;
}
