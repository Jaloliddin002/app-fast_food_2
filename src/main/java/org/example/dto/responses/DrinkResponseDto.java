package org.example.dto.responses;

import lombok.*;
import org.example.enums.DrinkType;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DrinkResponseDto {
    private UUID id;
    private String name;
    private double price;
    private DrinkType drinkType;
}
