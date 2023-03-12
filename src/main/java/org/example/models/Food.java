package org.example.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Food extends BaseModel{
    private String name;
    private String type;
    private double price;
    private String preparationTime;
}
