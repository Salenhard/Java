package com.example.chat_bot;
import java.util.Date;
import java.util.ArrayList;
import java.io.*;
public class Bot {
    private ArrayList<String> message;

    /**
     * Конструктор по умолчанию создаёт пустой список
     */
    Bot() {
        message = new ArrayList<>();
    }

    /**
     * \brief Bot(fileName) Конструктор с загрузкой данных из файла fileName
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(String fileName){
        FileOutputStream f = null;
    }
    Bot(ArrayList<String> message_)
    {
        message = new ArrayList<>();
        setMessage(message_);
    }

    /**
     * \brief getMessage
     * @return Возращает список сообщений
     */

    public String getMessages() {
        String str ="";
        for(int i = 0; i < message.size(); i++)
            str += message.get(i) + "\n";
        return str;
    }

    /**
     * \brief setMessage устанавливает сообщение
     * @param message_ - новое сообщение его знач записывается в message
     */

    public void setMessage(ArrayList<String> message_) {
            this.message = message_;
    }

    /**
     * \brief addMessage добоваляет сообщение в конец массива
     * @param message_  - сообщение
     */
    public void addMessage(String message_) {
        if(!message_.equals(""))
        {
            this.message.add(message_);
        }
    }

    /**
     * \brief multiply
     * Обрабатывает строку и перемножает 2 числа
     * @return результат умножения
     */

    private double multiply(){
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
     * \brief getTime возращает текущее время
     * @return текущее дата и время
     */

    private String getTime(){
        Date date = new Date();
        return date.toString();
    }

    /**
     * \brief division
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
     * \brief parseMessage обробатывает строку message
     * @return ответ на сообщение
     */

    public String parseMessage(){
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
        if(message_.contains("")){
            return str;
        }
        return str;
    }

}
