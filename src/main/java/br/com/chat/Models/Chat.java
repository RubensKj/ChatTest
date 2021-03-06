package br.com.chat.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Message> messages;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> users;

    public Chat() {
    }

    public Chat(List<Message> messages, List<String> users) {
        this.messages = messages;
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<String> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }
}
