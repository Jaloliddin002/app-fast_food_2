package org.example.dto.responses;

import lombok.*;
import org.example.models.UserEntity;

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
    private UserEntity owner;
}
