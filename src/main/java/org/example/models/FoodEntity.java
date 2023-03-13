package org.example.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FoodEntity extends BaseModel{
    private String name;
    private String type;
    private double price;
    private String preparationTime;
}
