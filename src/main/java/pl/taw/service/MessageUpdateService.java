/**
 * Created by tomasz_taw
 * Date: 31.10.2023
 * Time: 09:19
 * Project Name: discordBot
 * Description:
 */
package pl.taw.service;

import discord4j.core.event.domain.message.MessageUpdateEvent;
import org.springframework.stereotype.Service;
import pl.taw.listeners.EventListener;
import pl.taw.listeners.MessageListener;
import reactor.core.publisher.Mono;

@Service
public class MessageUpdateService extends MessageListener implements EventListener<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getEventType() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageUpdateEvent event) {
        return Mono.just(event)
                .filter(MessageUpdateEvent::isContentChanged)
                .flatMap(MessageUpdateEvent::getMessage)
                .flatMap(super::processMessage);
    }
}
