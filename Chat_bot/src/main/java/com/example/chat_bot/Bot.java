package com.example.chat_bot;
import java.util.Date;
import java.util.Locale;

public class Bot {
    private String message;

    /**
     * \brief getMessage
     * @return Возращает сообщение
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * \brief setMessage устанавливает сообщение
     * @param message_ - новое сообщение его знач записывается в message
     */
    public void setMessage(String message_) {
        if(message_ != "")
        {
            this.message = message_;
        }
    }

    /**
     * \brief multiply
     * Обрабатывает строку и перемножает 2 числа
     * @return результат умножения
     */
    private int multiply(){
        String[] num = new String[1];
        int k = 0;
        this.message=this.message.substring(7, this.message.length());
        char[] chArray = this.message.toCharArray();
        for(int i = 0; i < this.message.length() - 1; i++) {
            if(Character.isDigit(chArray[i]) == true)
            num[k] += chArray[i];
            if(chArray[i] == ' ')
                k = 1;
        }
        return Integer.parseInt(num[0])*Integer.parseInt(num[1]);
    }
    private String getTime(){
        Date date = new Date();
        return date.toString();
    }

    /**
     * \brief parseMessage обробатывает сторку message
     * @return ответ на сообщение
     */
    public String parseMessage(){
        String str = "";
        String message_ = this.message.toLowerCase();
        if(message_.contains("привет") || message_.contains("здарова") || message_.contains("ку") || message_.contains("йоу") || message_.contains("здравствуйте"))
            return str = "Привет";
        if(message_.contains("умножь"))
            return str = "Ответ: " + multiply();
        if(message_.contains("который час?"))
            return str = "Сейчас: " + getTime();
        if(message_.contains("список команд"))
            return str = "умножь, который час?,";
        if(message_.contains("ы"))
            return str;
        return str = "Неизвестая для меня команда! Для того чтобы узнать доступные команды введите: список команд";
    }
}
