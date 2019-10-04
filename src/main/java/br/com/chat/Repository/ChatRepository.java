package br.com.chat.Repository;

import br.com.chat.Models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findChatById(long id);
}
