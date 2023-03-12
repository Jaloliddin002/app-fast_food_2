package org.example.models;

import lombok.*;
import org.example.enums.CardType;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Card extends BaseModel{
    private CardType cardType;
    private String password;
    private double balance;
    private User owner;
}
