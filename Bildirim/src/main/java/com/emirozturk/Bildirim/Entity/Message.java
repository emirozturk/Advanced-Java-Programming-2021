package com.emirozturk.Bildirim.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Document("messages")
public class Message {
    @Id
    private String id;
    @NotNull
    private LocalDateTime postDateTime;
    @NotNull
    private String content;
}
