package org.example.dto.requests;

import lombok.*;
import org.example.enums.CardType;
import org.example.models.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CardRequest {
    private String cardType;
    private String password;
    private double balance;
    private User owner;
}
