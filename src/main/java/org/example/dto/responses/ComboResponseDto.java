package org.example.dto.responses;

import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ComboResponseDto {
    private UUID id;
    private List <UUID> foods;
    private List<UUID> drinks;
    private double price;
}
