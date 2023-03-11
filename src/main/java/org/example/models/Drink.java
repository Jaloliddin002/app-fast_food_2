package org.example.models;

import lombok.*;
import org.example.enums.DrinkType;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Drink extends BaseModel{
    private String name;
    private double price;
    private DrinkType drinkType;
}
