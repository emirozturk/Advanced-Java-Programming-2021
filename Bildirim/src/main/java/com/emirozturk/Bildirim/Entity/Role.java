package com.emirozturk.Bildirim.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("roles")
public class Role {
    @Id
    private String id;
    private String role;
}
