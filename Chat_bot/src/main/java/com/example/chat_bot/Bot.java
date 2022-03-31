package com.example.chat_bot;

import java.util.Date;
import java.util.ArrayList;
import java.io.*;
public class Bot {
    public ArrayList<String> message;

    /**
     * Bot Конструктор по умолчанию создаёт пустой список
     */

    Bot() {
        message = new ArrayList<>();
    }

    /**
     * Bot Конструктор с загрузкой данных из файла fileName
     * @param fileName - путь или название файла
     */

    Bot(String fileName) {
        try {
            message = new ArrayList<>();
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                message.add(line);
                line = reader.readLine();
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * writFile writing history of chatting (saving message)
     * @param fileName name of file or path to the file
     * @param message last message
     * @throws IOException if file not opened
     */

    public void writeFile(String fileName, String message) throws IOException {
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file, true);

        // Запись содержимого в файл
        writer.write(message);
        writer.flush();
        writer.close();
    }

    Bot(ArrayList<String> message_) {
        message = new ArrayList<>();
        setMessage(message_);
    }

    /**
     * getMessage
     * @return Возращает список сообщений
     */

    public String getMessages() {
        StringBuilder str = new StringBuilder();
        for (String s : message) str.append(s).append("\n");
        return str.toString();
    }

    /**
     * setMessage устанавливает сообщение
     * @param message_ - новое сообщение его знач записывается в message
     */

    public void setMessage(ArrayList<String> message_) {
            this.message = message_;
    }

    /**
     * addMessage добоваляет сообщение в конец массива
     * @param message_  - сообщение
     */
    public void addMessage(String message_) {
        if(!message_.equals(""))
        {
            this.message.add(message_);
        }
    }

    /**
     * multiply
     * Обрабатывает строку и перемножает 2 числа
     * @return результат умножения
     */

    private double multiply() {
        String[] num = new String[2];
        num[1] = "";
        num[0] = "";
        int k = 0;
        String message_ = this.message.get(this.message.size() - 1).substring(7);
        char[] chArray = message_.toCharArray();
        for(int i = 0; i < message_.length(); i++) {
            if(Character.isDigit(chArray[i]))
            num[k] += chArray[i];
            if(!Character.isDigit(chArray[i]))
                k = 1;
        }
        return Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
    }

    /**
     * getTime возращает текущее время
     * @return текущее дата и время
     */

    private String getTime() {
        Date date = new Date();
        return date.toString();
    }

    /**
     * division
     *
     * Обрабатывает строку и делит 2 числа
     *
     * @return результат деления
     */

    private double division() {
        String[] num = new String[2];
        num[0] = "";
        num[1] = "";
        int k = 0;
        String message_ = this.message.get(this.message.size() - 1).substring(7);
        char[] chArray = message_.toCharArray();
        for(int i = 0; i < message_.length(); i++) {
            if(Character.isDigit(chArray[i]))
                num[k] += chArray[i];
            if(chArray[i] == ' ')
                k = 1;
        }
        return Double.parseDouble(num[0])/Double.parseDouble(num[1]);
    }

    /**
     * parseMessage обробатывает строку message
     * @return ответ на сообщение
     */

    public String parseMessage() {
        String str = "Неизвестая для меня команда! Для того чтобы узнать доступные команды введите: список команд";
        String message_ = this.message.get(this.message.size() - 1).toLowerCase();
        if(message_.contains("привет") || message_.contains("здарова") || message_.contains("ку") || message_.contains("йоу") || message_.contains("здравствуйте")) {
            str = "Привет, человечишка!";
            addMessage(str);
            return str;
        }
        if(message_.contains("умножь")) {
            str = "Ответ: " + multiply();
            addMessage(str);
            return str;
        }
        if(message_.contains("подели")) {
            str = "Ответ: " + division();
            addMessage(str);
            return str;
        }
        if(message_.contains("который час?")) {
            str = "Ответ: " + getTime();
            addMessage(str);
            return str;
        }
        if(message_.contains("список команд")) {
            str = "Список команд: умножь 'число' на 'число', который час?, подели 'число' на 'число'";
            addMessage(str);
            return str;
        }
        if(message_.contains("пока")) {
            str = "Досвидания";
            addMessage(str);
            return str;
        }
        if(message_.contains("курс валюты")) {
            str = getCurrency();
            addMessage(str);
            return str;
        }
        addMessage(str);
        return str;
    }

    /**
     * gets info from internet
     * @return str - current dollar Currency
     */

    private String getCurrency() {
        String str = "";
        return str;                             //todo доделать отображение курса валюты, возможность открывать другие программы, загружать картинки(наверное нет)
    }

}
