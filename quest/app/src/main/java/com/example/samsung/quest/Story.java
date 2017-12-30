package com.example.samsung.quest;

/**
 * Created by Bober on 30.12.2017.
 */

import java.io.*;
import java.util.*;

public class Story {

    public Situation current_situation;
    private Situation start_story;

    Story() {
        start_story = new Situation(
                "Автоваз.Контрольный тест при приеме на работу(28.12.2017.)",
                "Запомните,Ваши действия не должны развалить компанию!!! \n"+
                        "Перед тем,чтобы продовать что-нибудь ненужное -надо купить что-нибудь ненужное\n"
                        + "(1)Купить подержанные машины(12000 моделей)\n" +
                        "на китайском рынке,после отремонтировать их\n"
                        + "и продать дочерним концернам в России\n"
                        + "(2)Перекупить у компании AUDI новую линейку машин AUDI Q2(2017г.)\n"
                        + "(3)Модернизировать Lada Priora до 2018 года и объявить об выходе\n "
                        +"Lada Priora Extreme",
                3, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "Первый день и вот так сразу уволите?",
                "Продержался один день ,до аванса еще 17 дней...\n"
                        +"P.S. Мащины не купили\n"
                        +"(1) Настоять на покупке китайских машин\n"
                        +"(2) Не выйти на работу,сказать ,что сегодня сессия\n"
                        +"(3) Предложить провести рекламную акцию в крупных городах\n" +
                        "нашей необъятной родины",
                3, 0, -80, 0);

        start_story.direction[0].direction[0] = new Situation(
                "У МЕНЯ 12'000 КИТАЙСКИХ МАШИН,Куда их девать!??? ",
                "(1)Уволиться.\n"
                        +"(2)Отправить машины на дочерние концерны\n"
                        +"(3)Отправить машины на ремонт\n",
                3, 0, 0, -20);
        start_story.direction[0].direction[0].direction[0] = new Situation(
                "Автоваз возбудил иск по статье мошеничество в особо крупных размерах ",
                "(1)Уволился.Поработал.GAME OVER.\n",
                0, -1, -20, -30);
        start_story.direction[0].direction[0].direction[1]=new Situation(
                "Дочерние концерны не нуждаются в китайских машнинах",
                "Game over",
                0, -1, -20, -30);
        start_story.direction[0].direction[0].direction[2]=new Situation(
                "Банкрот",
                "ремонт 12000 Китайских машин нам не по карману\n",
                0,0,0,0);
        start_story.direction[0].direction[1] = new Situation(
                "Был уволен по статье",
                "Game over",
                0, -1, -20, -30);

        start_story.direction[0].direction[2] = new Situation(
                "Отличное решение,сегодня меня похвалил начальник",
                "Также в скором времени будет очень важная сделка\n" +
                        ",буду на ней присутстовать\n"
                        + "Сегодня можно развлечься! Новый год!!! Даже я не работаю в это время\n "
                        +"(1) Отметить в тихом узком кругу\n" +
                        "(2) Отпразновать вместе с начальником\n" +
                        "(3) Лечь спать \n",
                3, 0, 0, +10);

        start_story.direction[0].direction[2].direction[0] = new Situation(
                "Хорошо праздную",
                "С новым годом всех\n"
                        +"(1) Выйти на работу,дойти пешком\n"
                        +"(2) Сказать,что сегодня сессия\n"
                        +"(3) Выйти на работу,доехать на машине\n",
                3, 0, 0, +10);
        start_story.direction[0].direction[2].direction[0].direction[1]=start_story.direction[0].direction[1];

        start_story.direction[0].direction[2].direction[1]=start_story.direction[0].direction[2].direction[0];

        start_story.direction[0].direction[2].direction[2]=start_story.direction[0].direction[2].direction[0];

        start_story.direction[0].direction[2].direction[0].direction[0] = new Situation(
                "Вы на работе",
                "(1) Купить китайские машины\n"
                        +"(2) Сделать вид,что работаешь\n"
                        +"(3)Модернизировать Lada Priora до 2018 года и объявить об выходе\n" +
                        "Lada Priora Extreme\n",
                3,0,0,+10);
//при третьем варианте проигрывать третий вариант
        start_story.direction[0].direction[2].direction[0].direction[0].direction[0]=new Situation(
                "Фирма обанкротилась",
                "У фирмы закончились активы ",
                0,0,0,0);
        start_story.direction[0].direction[2].direction[0].direction[0].direction[1]=start_story.direction[0].direction[1];

        start_story.direction[0].direction[2].direction[0].direction[2]=start_story.direction[0].direction[2].direction[0].direction[0];

        start_story.direction[0].direction[2].direction[0].direction[0].direction[2]=new Situation(
                "Я стал конструктором автоваза",
                "И теперь корректирую уже выпущенные линейки машин\n",
                0,+4,+1000,+100);

        start_story.direction[1] = new Situation(
                "Сейчас проходит совещание,кажись боссу понравилась моя идея",
                "Сегодня будет совещание, меня неожиданно вызвали,\n"
                + "есть сведения, что босс доволен сегодняшней сделкой.\n" +
                "Сегодня можно поработать(1) или уйти домой(2)\n",
                2, 0, 0, +10);
        start_story.direction[1].direction[0] = new Situation(
                "Продолжаю работать в офисе",
                "Кто-то звонит по телефону\n"
                        +"хм..Возможно начальство\n" +
                        "(1) Снять трубку\n"+
                        "(2) Игнорировать\n",
                2, 0, +3, +10);
        start_story.direction[1].direction[0].direction[0]= new Situation(
                "Звонил начальник",
                "Предложил должность зам.директора\n"
                        +"(1)Согласиться\n"+
                        "(2) Отказаться\n",
                2,+1,0,0);
        start_story.direction[1].direction[0].direction[1]=new Situation(
                "Вы не ответели на звонок",
                "Были уволены\n"+
                        "P.S. У начальника плохой настроение",0,-1,-93,-70);
        start_story.direction[1].direction[0].direction[0].direction[0]=new Situation(
                "Завтра сделка",
                "(1) Подготовиться\n"
                        +"(2) Лечь спать\n",
                2,0,+5,+10);

        start_story.direction[1].direction[0].direction[0].direction[0].direction[0]=new Situation(
                "Трудолюбие-путь к успеху",
                "Теперь отвечаю за раздел купле-продаж Автоваза\n ",
                0,+4,+30,+50);
        start_story.direction[1].direction[0].direction[0].direction[0].direction[1]=new Situation(
                "А вы не очень-то и трудолюбивый",
                "Теперь вы уволены из Автоваза\n",
                0,-1,0,-70);

        start_story.direction[1].direction[1]= new Situation(
                "Ушел домой",
                "(1)Лечь спать"
                        +"(2)Готовиться к сделке",
                2,0,0,0);

        start_story.direction[1].direction[1].direction[0]=new Situation("Вы не подготовились к сделке",
                "Были уволены",0,-1,0,-25);
        start_story.direction[1].direction[1].direction[1]=new Situation(
                "Вы не подготовились к сделке,a легли спать",
                "Вскоре,Вы были уволены\n",0,-1,0,-25);

//start_story.direction[1].direction[0]=start_story.direction[1].direction[0].direction[0].direction[0];

        start_story.direction[2] = new Situation(
                "Все сделано ,как надо ,так сказать просто и эффективно",
                "(1) Нанять диллеров\n"+
                        "(2) Искать покупателей\n"+
                        "(3) Отдохнуть\n",
                3, 0, 0, 0);

        start_story.direction[2].direction[0] = new Situation(
                "Диллер найден/вас ждет повышение",
                "(1)Найти покупателя\n"+
                        "(2) Отдохнуть\n"+
                        "(3) Провести рекламную акцию\n",
                3, +1, -39, +55);

        start_story.direction[2].direction[0].direction[0]=new Situation(
                "Покупатель найден" ,
                "(1) Попросить повышение зарплаты\n"
                        +"(2) Провести рекламу для увелечения спроса \n"
                        +"(3) Купить новую линейку машин AUDI Q2 (2017 Г.)\n",
                3,+1,-15,+15);
        start_story.direction[2].direction[0].direction[1]=new Situation(
                "Отдыхать на работе нельзя" ,
                "Вы были уволены\n",
                0,0,0,0);
        start_story.direction[2].direction[0].direction[2]=new Situation(
                "Рекламная акция не разумна" ,
                "У нас нет товара,который требуется рекламировать\n",
                0,0,0,0);

        start_story.direction[2].direction[0].direction[0].direction[0]= new Situation(
                "Вы обнаглели" ,
                "Были уволены\n",
                0,0,0,0);

        start_story.direction[2].direction[0].direction[0].direction[1]=new Situation(
                "Теперь вы рекламщик" ,
                "В автовазе,мои поздравления\n",
                0,0,0,0);
        start_story.direction[2].direction[0].direction[0].direction[2]=start_story.direction[2].direction[0].direction[0].direction[1];

        start_story.direction[2].direction[1] = new Situation(
                "Покупатель найден/вас ждет повышение",
                "(1)Искать диллера\n"+
                        "(2) Отдохнуть\n"+
                        "(3) Провести рекламную акцию\n",
                3, +1, -39, +55);

        start_story.direction[2].direction[1].direction[0]=new Situation(
                "Диллер найден" ,
                "(1) Попросить повышение зарплаты\n"
                        +"(2) Провести рекламу для увелечения спроса\n "
                        +"(3) Купить новую линейку машин SUZUKI(2017 Г.)\n",
                3,+1,-15,+15);

        start_story.direction[2].direction[1].direction[1]=new Situation(
                "Отдыхать на работе нельзя" ,
                "Вы были уволены\n",
                0,0,0,0);
        start_story.direction[2].direction[1].direction[2]=new Situation(
                "Рекламная акция не разумна" ,
                "У нас нет товара,который требуется рекламировать\n",
                0,0,0,0);
        start_story.direction[2].direction[1].direction[0].direction[0]= new Situation(
                "Вы обнаглели" ,
                "Были уволены\n",
                0,0,0,0);

        start_story.direction[2].direction[1].direction[0].direction[1]=new Situation(
                "Теперь вы Глав. по кадрам" ,
                "В автовазе,мои поздравления\n",
                0,0,0,0);
        start_story.direction[2].direction[1].direction[0].direction[2]=start_story.direction[2].direction[1].direction[0].direction[1];

        start_story.direction[2].direction[2] = new Situation(
                "Вы были уволены",
                "Отдыхать на работе нельзя\n",
                0, 0, 0, 0);

        current_situation=start_story;
    }
    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}