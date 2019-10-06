package br.com.chat.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String chatId;

    @Column(name = "message", columnDefinition = "LONGTEXT")
    private String message;

    private String username;

    public Message() {
    }

    public Message(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
