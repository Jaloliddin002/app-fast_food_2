package org.example.models;

import lombok.*;
import org.example.enums.Role;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseModel{
    private String name;
    private String password;
    private Role role;
    private Card card;
    private double balance;
    private String phoneNumber;


}
