package br.com.chat.Controllers.Chat;

import br.com.chat.ChatTest.ChatTestApplication;
import br.com.chat.Models.Chat;
import br.com.chat.Models.Error;
import br.com.chat.Services.ChatService;
import br.com.chat.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class ChatCrudController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/chat")
    public ResponseEntity<Chat> createNewChat(@RequestBody Chat chat) {
        chat.getMessages().forEach(message -> {
            messageService.save(message);
        });

        chatService.save(chat);
        return ResponseEntity.ok(chat);
    }

    @GetMapping("/chat/{id}")
    public ResponseEntity<?> findChatById(@PathVariable("id") long id) {
        Chat chat = chatService.findById(id);
        if (chat != null) {
            return ResponseEntity.ok(chat);
        } else {
            return ResponseEntity.ok(new Error("Ocorreu algum erro ao buscar o chat.", ChatTestApplication.version));
        }
    }
}
