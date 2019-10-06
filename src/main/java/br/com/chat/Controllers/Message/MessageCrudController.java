package br.com.chat.Controllers.Message;

import br.com.chat.ChatTest.ChatTestApplication;
import br.com.chat.Models.Chat;
import br.com.chat.Models.Error;
import br.com.chat.Models.Message;
import br.com.chat.Services.ChatService;
import br.com.chat.Services.MessageService;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.25.17:3000"})
@RestController
@RequestMapping("/api")
public class MessageCrudController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/chat-message/{id}")
    public ResponseEntity<?> createMessage(@PathVariable("id") long id, @RequestBody Message message) {
        Chat chat = chatService.findById(id);
        if (chat != null) {
            chat.getMessages().add(message);
            messageService.save(message);
            chatService.save(chat);

            Pusher pusher = new Pusher("874102", "55323f709121b5910325", "2e47c9a1cafe277b167c");
            pusher.setCluster("us2");
            pusher.setEncrypted(true);

            pusher.trigger("chat-" + chat.getId(), "new-message", Collections.singletonMap("chat", chat));

            return ResponseEntity.ok(chat);
        } else {
            return ResponseEntity.ok(new Error("Ocorreu algum erro ao buscar o chat.", ChatTestApplication.version));
        }
    }
}
