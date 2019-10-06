package br.com.chat.Controllers.Chat;

import br.com.chat.ChatTest.ChatTestApplication;
import br.com.chat.Models.Chat;
import br.com.chat.Models.Error;
import br.com.chat.Services.ChatService;
import br.com.chat.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.25.17:3000"})
@RestController
@RequestMapping("/api")
public class ChatCrudController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/chat")
    public ResponseEntity<Chat> createNewChat(@RequestBody Chat chat) {
//        chat.getMessages().forEach(message -> {
//            messageService.save(message);
//        });

        chatService.save(chat);
        return ResponseEntity.ok(chat);
    }

    @GetMapping("/chat/{id}")
    public ResponseEntity<?> findChatById(@PathVariable("id") long id) {
        Chat chat = chatService.findById(id);
        return ResponseEntity.ok(Objects.requireNonNullElseGet(chat, () -> new Error("Ocorreu algum erro ao buscar o chat.", ChatTestApplication.version)));
    }

    @PostMapping("/chat/{id}")
    public ResponseEntity<?> joiningIntoChat(@PathVariable("id") long id, @RequestBody String username) {
        Chat chat = chatService.findById(id);
        if (chat != null) {
            if (!chat.getUsers().contains(username)) {
                chat.getUsers().add(username);
                chatService.save(chat);
                return ResponseEntity.ok(chat);
            } else {
//                return ResponseEntity.ok(new Error("O usuário já está no chat", ChatTestApplication.version));
                return ResponseEntity.ok(chat);
            }
        } else {
            return ResponseEntity.ok(new Error("Ocorreu algum erro ao buscar o chat.", ChatTestApplication.version));
        }
    }
}
