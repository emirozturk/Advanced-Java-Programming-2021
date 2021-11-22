package com.emirozturk.Bildirim.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;
    private String mail;
    private String name;
    private String password;
    private Boolean enabled;
    private List<Channel> channels;
    private List<Role> roles;
}
