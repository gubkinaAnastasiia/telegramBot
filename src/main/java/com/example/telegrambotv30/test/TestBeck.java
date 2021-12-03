package com.example.telegrambotv30.test;

import com.example.telegrambotv30.botAPI.ButtonState;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBeck implements Test{

    int MAX_QUEST = 2;
    int current_quest = 0;
    int result = 0;

    List<String> quest = Arrays.asList(
            "Вопрос 1.\n" +
                    "1. Я не чувствую себя несчастным\n" +
                    "2. Я чувствую себя несчастным\n" +
                    "3. Я все время несчастен и не могу освободиться от этого чувства\n" +
                    "4. Я настолько несчастен и опечален, что не могу этого вынести",

            "Вопрос 2.\n" +
                    "1. Думая о будущем, я не чувствую себя особенно разочарованным\n" +
                    "2. Думая о будущем, я чувствую себя разочарованным\n" +
                    "3. Я чувствую, что мне нечего ждать в будущем\n" +
                    "4. Я чувствую, что будущее безнадежно и ничего не изменится к лучшему",

            "Вопрос 3.\n" +
                    "1. Я не чувствую себя неудачником."+
                    "2. Я чувствую, что у меня было больше неудач, чем у большинства других людей\n" +
                    "3. Когда я оглядываюсь на прожитую жизнь, все, что я вижу, это череды неудач\n" +
                    "4. Я чувствую себя полным неудачником.",

            "Вопрос 4.\n" +
                    "1. Я получаю столько же удовольствия от жизни, как и раньше.\n" +
                    "2. Я не получаю столько же удовольствия от жизни, как и раньше.\n" +
                    "3. Я не получаю настоящего удовлетворения от чего бы то ни было\n" +
                    "4. Я всем неудовлетворен, и мне все надоело",

            "Вопрос 5.\n" +
                    "1. Я не чувствую себя особенно виноватым.\n" +
                    "2. Довольно часто я чувствую себя виноватым.\n" +
                    "3. Почти всегда я чувствую себя виноватым.\n" +
                    "4. Я чувствую себя виноватым все время.",

            "Вопрос 6.\n" +
                    "1. Я не чувствую, что меня за что-то наказывают\n" +
                    "2. Я чувствую, что могу быть наказан за что-то\n" +
                    "3. Я ожидаю, что меня накажут\n" +
                    "4. Я чувствую, что меня наказывают за что-то",

            "Вопрос 7.\n" +
                    "1. Я не испытываю разочарование в себе.\n" +
                    "2. Я разочарован в себе.\n" +
                    "3. Я внушаю себе отвращение.\n" +
                    "4. Я ненавижу себя.",

            "Вопрос 8.\n" +
                    "1. У меня нет чувства, что я в чем-то хуже других.\n" +
                    "2. Я самокритичен и признаю свои слабости и ошибки.\n" +
                    "3. Я все время виню себя за свои ошибки.\n" +
                    "4. Я виню себя за все плохое, что происходит.",

            "Вопрос 9.\n" +
                    "1. У меня нет мыслей о том, чтобы покончить с собой.\n" +
                    "2. У меня есть мысли о том, чтобы покончить с собой, но я этого не делаю.\n" +
                    "3. Я хотел бы покончить жизнь самоубийством.\n" +
                    "4. Я бы покончил с собой, если бы представился удобный случай.",

            "Вопрос 10.\n" +
                    "1. Я плачу не больше, чем обычно.\n" +
                    "2. Сейчас я плачу больше обычного.\n" +
                    "3. Я теперь все время плачу.\n" +
                    "4. Раньше я еще мог плакать, но теперь не смогу, даже если захочу.",

            "Вопрос 11.\n" +
                    "1. Сейчас я не более раздражителен, чем обычно.\n" +
                    "2. Я раздражаюсь легче, чем раньше, даже по пустякам.\n" +
                    "3. Сейчас я все время раздражен.\n" +
                    "4. Меня уже ничто не раздражает, потому что все стало безразлично.",

            "Вопрос 12.\n" +
                    "1. Я не потерял интереса к другим людям.\n" +
                    "2. У меня меньше интереса к другим людям, чем раньше.\n" +
                    "3. Я почти утратил интерес к другим людям.\n" +
                    "4. Я потерял всякий интерес к другим людям.",

            "Вопрос 13.\n" +
                    "1. Я способен принимать решения так же, как всегда.\n" +
                    "2. Я откладываю принятие решений чаще, чем обычно.\n" +
                    "3. Я испытываю больше трудностей в принятии решений, чем прежде.\n" +
                    "4. Я больше не могу принимать каких-либо решений.",

            "Вопрос 14.\n" +
                    "1. Я не чувствую, что я выгляжу хуже, чем обычно.\n" +
                    "2. Я обеспокоен, что выгляжу постаревшим и непривлекательным.\n" +
                    "3. Я чувствую, что изменения, происходящие в моей внешности, сделали меня непривлекательным.\n" +
                    "4. Я уверен, что выгляжу безобразным.",

            "Вопрос 15.\n" +
                    "1. Я могу работать так же, как раньше.\n" +
                    "2. Мне надо приложить дополнительные усилия, чтобы начать что-либо делать.\n" +
                    "3. Я с большим трудом заставляю себя что-либо сделать.\n" +
                    "4. Я вообще не могу работать.",

            "Вопрос 16.\n" +
                    "1. Я могу спать так же хорошо, как и обычно.\n" +
                    "2. Я сплю не так хорошо, как всегда.\n" +
                    "3. Я просыпаюсь на 1-2 часа раньше, чем обычно и с трудом могу заснуть снова.\n" +
                    "4. Я просыпаюсь на несколько часов раньше обычного и не могу снова заснуть.",

            "Вопрос 17.\n" +
                    "1. Я устаю не больше обычного.\n" +
                    "2. Я устаю легче обычного.\n" +
                    "3. Я устаю почти от всего того, что делаю.\n" +
                    "4. Я слишком устал, чтобы делать что бы то ни было.",

            "Вопрос 18.\n" +
                    "1. Мой аппетит не хуже, чем обычно.\n" +
                    "2. У меня не такой хороший аппетит, как был раньше.\n" +
                    "3. Сейчас мой аппетит стал намного хуже.\n" +
                    "4. Я вообще потерял аппетит.",

            "Вопрос 19.\n" +
                    "1. Если в последнее время я и потерял в весе, то очень немного.\n" +
                    "2. Я потерял в весе более 2 кг.\n" +
                    "3. Я потерял в весе более 4 кг.\n" +
                    "4. Я потерял в весе более 6 кг.",

            "Вопрос 20.\n" +
                    "1. Я беспокоюсь о своем здоровье не больше, чем обычно.\n" +
                    "2. Меня беспокоят такие проблемы, как различные боли, расстройства желудка, запоры.\n" +
                    "3. Я настолько обеспокоен своим здоровьем, что мне даже трудно думать о чем-нибудь другом.\n" +
                    "4. Я до такой степени обеспокоен своим здоровьем, что вообще ни о чем не могу думать.",

            "Вопрос 21.\n" +
                    "1. Я не замечал каких-либо изменений в моих сексуальных интересах.\n" +
                    "2. Я меньше, чем обычно интересуюсь сексом.\n" +
                    "3. Сейчас я намного меньше интересуюсь сексом.\n" +
                    "4. Я совершенно утратил интерес к сексу."
    );


    @Override
    public String getStartMessage() {
        return "Вы выбирали тест Бека.\n" +
                "В этом тесте вам понадобится выбирать варианты ответа, наиболее близкие к вам.\n" +
                "Всего будет 21 вопрос" +
                "Начнем тест?";
    }

    public boolean hasNextQuest() {
        return current_quest < MAX_QUEST;
    }

    public String getQuest() {
        return quest.get(current_quest);
    }

    public void setResult(String answer) {
        switch (answer) {
            case "TEST_1": case "1": result += 0; break;
            case "TEST_2": case "2": result +=1; break;
            case "TEST_3": case "3": result +=2; break;
            case "TEST_4": case "4": result += 3; break;
        }
        current_quest += 1;
    }

    public String getResult() {
        if (result>=30) {
            return "Симптомы тяжелой депрессии. Это последняя, самая опасная стадия депрессии, с которой не получится справиться в одиночку. Необходимо в срочном порядке обратиться за помощью к психотерапевту.";
        } else if (result>=20) {
            return "Признаки выраженной депрессии (средней тяжести). Депрессия на этой стадии создает преграды для нормальной жизни и легко может перейти в тяжелую депрессию. Такое состояние нельзя оставлять без внимания и медицинского контроля, необходимо в обязательном порядке обратиться за консультацией к психотерапевту.";
        } else if (result>=16) {
            return "Симптомы умеренной депрессии. Депрессия на данном этапе создает определенные трудности для нормальной жизни и опасна быстрым переходом на следующую стадию. Необходимо обратиться за помощью к психотерапевту.";
        } else if (result>=10) {
            return "Признаки легкой депрессии (субдепрессии). Пора задуматься о воем психическом здоровье и обратиться за консультацией к психотерапевту.";
        } else {
            return "Симптомы депрессии отсутствуют, Ваше психоэмоциональное состояние в норме и не вызывает никаких опасений.";
        }
    }

    @Override
    public boolean checkAnswer(String answer) {
        switch (answer) {
            case "TEST_1": case "1":
            case "TEST_2": case "2":
            case "TEST_3": case "3":
            case "TEST_4": case "4":
                return true;
            default: return false;
        }
    }

    @Override
    public InlineKeyboardMarkup getKeybord() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton().setText("1");
        button1.setCallbackData(ButtonState.TEST_1.name());
        InlineKeyboardButton button2 = new InlineKeyboardButton().setText("2");
        button2.setCallbackData(ButtonState.TEST_2.name());
        InlineKeyboardButton button3 = new InlineKeyboardButton().setText("3");
        button3.setCallbackData(ButtonState.TEST_3.name());
        InlineKeyboardButton button4 = new InlineKeyboardButton().setText("4");
        button4.setCallbackData(ButtonState.TEST_4.name());


        List<InlineKeyboardButton> keyboardButtonList1 = new ArrayList<>();
        keyboardButtonList1.add(button1);
        keyboardButtonList1.add(button2);
        List<InlineKeyboardButton> keyboardButtonList2 = new ArrayList<>();
        keyboardButtonList2.add(button3);
        keyboardButtonList2.add(button4);

        List<List<InlineKeyboardButton>> keyboardButtonList = new ArrayList<>();
        keyboardButtonList.add(keyboardButtonList1);
        keyboardButtonList.add(keyboardButtonList2);
        inlineKeyboardMarkup.setKeyboard(keyboardButtonList);

        return inlineKeyboardMarkup;
    }

    @Override
    public void rollbackQuest() {
        --current_quest;
    }

}
