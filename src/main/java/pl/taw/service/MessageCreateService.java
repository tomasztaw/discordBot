/**
 * Created by tomasz_taw
 * Date: 31.10.2023
 * Time: 09:15
 * Project Name: discordBot
 * Description:
 */
package pl.taw.service;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Service;
import pl.taw.listeners.EventListener;
import pl.taw.listeners.MessageListener;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateService extends MessageListener implements EventListener<MessageCreateEvent> {

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processMessage(event.getMessage());
    }
}
