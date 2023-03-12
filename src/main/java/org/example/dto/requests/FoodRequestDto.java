package org.example.dto.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FoodRequestDto {
    private String name;
    private String type;
    private double price;
    private String preparationTime;
}
