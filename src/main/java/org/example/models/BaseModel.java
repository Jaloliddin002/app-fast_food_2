package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class BaseModel {
    private UUID Id = UUID.randomUUID();
    private Date date = new Date();
}
