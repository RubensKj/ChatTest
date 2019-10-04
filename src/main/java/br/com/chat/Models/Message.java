package br.com.chat.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicInsert
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String chatId;

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
