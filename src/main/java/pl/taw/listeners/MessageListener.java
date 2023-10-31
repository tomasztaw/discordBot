/**
 * Created by tomasz_taw
 * Date: 31.10.2023
 * Time: 09:08
 * Project Name: discordBot
 * Description:
 */
package pl.taw.listeners;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {

    private String author = "UNKNOWN";

    public Mono<Void> processMessage(final Message eventMessage) {
        return Mono.just(eventMessage)
                .filter(message -> {
                    final Boolean isNotBot = message.getAuthor()
                            .map(user -> !user.isBot())
                            .orElse(false);
                    if (isNotBot) {
                        message.getAuthor().ifPresent(user -> author = user.getUsername());
                    }
                    return isNotBot;
                })
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(String.format("Siemanko '%s'!", author)))
                .then();
    }
}
