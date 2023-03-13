package org.example.models;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentEntity extends BaseModel{
    private List<UUID> foods;
    private UUID cardId;
    private double amount;
    private Date date;
    private double cashBack;
}
