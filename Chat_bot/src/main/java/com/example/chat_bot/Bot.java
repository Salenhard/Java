package com.example.chat_bot;

import java.util.Date;
import java.util.ArrayList;
import java.io.*;

/**
 * bot that answers on commands(messages)
 */

public class Bot {
    /**
     * List of messages
     */
    public ArrayList<String> message;

    /**
     * constructor without params
     */

    Bot() {
        message = new ArrayList<>();
    }

    /**
     * constructor with file
     * @param fileName name or path to file
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
     * writing history of chatting (saving message)
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

    /**
     * constructor that gets list of messages
     * @param message_ list of messages
     */
    Bot(ArrayList<String> message_) {
        message = new ArrayList<>();
        setMessage(message_);
    }

    /**
     * @return list of messages
     */

    public String getMessages() {
        StringBuilder str = new StringBuilder();
        for (String s : message) str.append(s).append("\n");
        return str.toString();
    }

    /**
     * set new message
     * @param message_  new message
     */

    public void setMessage(ArrayList<String> message_) {
            this.message = message_;
    }

    /**
     * append new message in end of list
     * @param message_ new message
     */
    public void addMessage(String message_) {
        if(!message_.equals(""))
        {
            this.message.add(message_);
        }
    }

    /**
     * parse message
     * @return result of multiply
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
     * @return current time and date
     */

    private String getTime() {
        Date date = new Date();
        return date.toString();
    }

    /**
     * parse message
     * @return result of division
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
     * parse last message
     * @return answer on message
     */

    public String parseMessage() {
        String str = "Неизвестая для меня команда! Для того чтобы узнать доступные команды введите: список команд";
        String message_ = this.message.get(this.message.size() - 1).toLowerCase();
        if(message_.contains("привет") || message_.contains("здарова") || message_.contains("ку") || message_.contains("йоу") || message_.contains("здравствуйте")) {
            str = "Привет!";
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
     * @return str current dollar Currency
     */

    private String getCurrency() {
        return "";
    }

}
