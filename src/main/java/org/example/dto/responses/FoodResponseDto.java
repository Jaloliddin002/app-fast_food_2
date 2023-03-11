package org.example.dto.responses;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FoodResponseDto {
    private UUID id;
    private String name;
    private String type;
    private double price;
    private String preparationTime;
}
