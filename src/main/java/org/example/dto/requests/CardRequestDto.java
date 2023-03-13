package org.example.dto.requests;

import lombok.*;
import org.example.models.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CardRequestDto {
    private String cardType;
    private String password;
    private double balance;
    private UserEntity owner;
}
