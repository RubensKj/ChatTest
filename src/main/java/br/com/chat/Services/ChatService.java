package br.com.chat.Services;

import br.com.chat.Models.Chat;
import br.com.chat.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public void save(Chat chat) {
        chatRepository.save(chat);
    }

    public Chat findById(long id) {
        if (chatRepository.findById(id).isPresent()) {
            return chatRepository.findById(id).get();
        } else {
            return new Chat();
        }
    }
}
