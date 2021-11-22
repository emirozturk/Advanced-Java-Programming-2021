package com.emirozturk.Bildirim.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Document("messages")
public class Message {
    @Id
    private String id;
    private LocalDateTime postDateTime;
    private String content;
}
