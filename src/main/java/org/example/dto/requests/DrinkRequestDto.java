package org.example.dto.requests;

import lombok.*;
import org.example.enums.DrinkType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DrinkRequestDto {
    private String name;
    private double price;
    private String drinkType;
}
