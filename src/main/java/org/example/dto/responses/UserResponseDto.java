package org.example.dto.responses;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserResponseDto {
    private UUID id;
    private String name;
    private String password;
    private String role;
    private UUID cardId;
    private double balance;
    private String phoneNumber;
}
