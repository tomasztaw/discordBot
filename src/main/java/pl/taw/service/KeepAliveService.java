/**
 * Created by tomasz_taw
 * Date: 31.10.2023
 * Time: 09:23
 * Project Name: discordBot
 * Description:
 */
package pl.taw.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KeepAliveService {

    @Scheduled(fixedRate = 1 * 1000 * 60) // 1 minute
    public void reportCurrentTime() {
        System.out.println(System.currentTimeMillis());
    }
}
