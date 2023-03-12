package org.example.dto.responses;

import lombok.*;
import org.example.enums.CardType;
import org.example.models.User;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CardResponseDto {
    private UUID id;
    private String cardType;
    private String password;
    private double balance;
    private User owner;
}
