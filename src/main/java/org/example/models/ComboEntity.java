package org.example.models;

import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComboEntity extends BaseModel{
    private List<UUID> foods;
    private List<UUID> drinks;
    private double price;
}
