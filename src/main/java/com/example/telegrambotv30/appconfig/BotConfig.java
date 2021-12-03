package com.example.telegrambotv30.appconfig;

import com.example.telegrambotv30.Bot;
import com.example.telegrambotv30.botAPI.TelegramFacade;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Setter
@Getter
@Configuration
public class BotConfig {
    private String webHookPath="https://telegram-bot-ps.herokuapp.com";
    private String botUserName="@testDepressionTestBot";
    private String botToken="2109324716:AAEwCc1-hPo0jpIU2ksXAq0A5BUNaTnZFOY";

    @Bean
    public Bot myBot(TelegramFacade telegramFacade) {
        Bot mySuperTelegramBot = new Bot(telegramFacade);
        mySuperTelegramBot.setBotUserName(botUserName);
        mySuperTelegramBot.setBotToken(botToken);
        mySuperTelegramBot.setWebHookPath(webHookPath);

        return mySuperTelegramBot;
    }
}
