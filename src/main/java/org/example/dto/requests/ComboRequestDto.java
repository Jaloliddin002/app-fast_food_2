package org.example.dto.requests;

import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ComboRequestDto {
    private List <UUID> foods;
    private List<UUID> drinks;
    private double price;
}
