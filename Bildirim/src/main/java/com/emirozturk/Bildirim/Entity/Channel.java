package com.emirozturk.Bildirim.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Document("channels")
public class Channel {
    @Id
    private String id;
    @NotNull
    @Min(2)
    private String name;
    @NotNull
    private LocalDateTime CreationDate;
    @NotNull
    private User owner;
    private List<User> users;
    private List<Message> messages;
}
