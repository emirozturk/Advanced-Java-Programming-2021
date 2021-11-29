package com.emirozturk.Bildirim.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;
    @Email
    private String mail;
    @Min(2)
    @Max(50)
    private String name;
    @Min(8)
    @Max(50)
    private String password;
    private Boolean enabled;
    private List<Channel> channels;
    private List<Role> roles;
}
