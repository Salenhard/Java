package com.example.chat_bot;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.ArrayList;
import java.io.*;
import org.json.*;

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
        if(message_.contains("погода")) {
            try {
                str = getWeather("52,02", "113,30");
            } catch (IOException e) {
                e.printStackTrace();
            }
            addMessage(str);
            return str;
        }
        addMessage(str);
        return str;
    }

    /**
     * weather from internet
     * @param lat - latitude
     * @param lon - longitude
     * @return weather in String
     * @throws IOException
     */
    private String getWeather(String lat, String lon) throws IOException {     // TODO кодировка
        String key = "91320940294e5c61e0741ca35f382be0";
        String url_string = "https://api.openweathermap.org/data/2.5/weather?lat="+ lat +"&lon=" + lon + "&appid=" + key + "&units=metric";
        // url_string += "&lang=ru";                                   // информация будет на русском

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        URL url = new URL(url_string);

        connection = (HttpURLConnection) url.openConnection();      // http соединение
        connection.connect();

        InputStream stream = connection.getInputStream();           // считываем весь полученый поток
        reader = new BufferedReader(new InputStreamReader(stream)); // поток в виде строки

        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = reader.readLine()) != null) {
            buffer.append(line).append("\n");
        }

        if(connection != null)
            connection.disconnect();

        if(reader != null)
            reader.close();

        return processJSON(buffer.toString());                      // обрабатываем полученный JSON и возвращаем
    }
    /**
     * convert JSON in String
     * @param json
     * @return some element json on String
     * @throws IOException
     */
    private String processJSON(String json) throws IOException {
        String str = "Пустота";

        JSONObject jsonObject = new JSONObject(json);

        str = "Населённый пункт: " + jsonObject.getString("name") + "\n";
        str += "Температура: " + jsonObject.getJSONObject("main").getDouble("temp") + "\n";
        str += "Давление: " + jsonObject.getJSONObject("main").getDouble("pressure") + " мм рт. ст." +"\n";
        str += "Влажность: " + jsonObject.getJSONObject("main").getDouble("humidity") + "%";

        return str;
    }

}
