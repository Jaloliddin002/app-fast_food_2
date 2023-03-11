package org.example.dto.requests;

import lombok.*;
import org.example.enums.Role;
import org.example.models.Card;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserRequestDto {
    private String name;
    private String password;
    private String role;
    private UUID cardId;
    private double balance;
    private String phoneNumber;
}
