package com.example.time_class;
//Автор: Гурбатов Владислав ИВТ-20
// import static com.sun.tools.doclint.Entity.and;

import java.io.IOException;

public class Time {     // Класс время
    private int hours;                                                      // часы
    private int minutes;                                                    // минуты
    private int seconds;                                                    // секунды

    public Time(int new_hours, int new_minutes, int new_seconds) {               // Конструтор с параметрами
        setProps(new_hours,new_minutes,new_seconds);
    }
    public Time() {                                                              // Конструктор по умолчанию
        setProps(2,4,5);
    }

    public void setProps(int new_hours, int new_minutes, int new_seconds) {       // устанавливает все параметры класса
        setHours(new_hours);
        setMinutes(new_minutes);
        setSeconds(new_seconds);
    }

    public void setHours(int new_hours) {                               // устанавливает часы
        if(new_hours <= 23 && new_hours >= 0)
        this.hours = new_hours;
        else
            throw new NullPointerException("Hours must be between 0 and 23!");
    }

    public void setMinutes(int new_minutes) {                           // устанавливает минуты
        if(new_minutes <= 59 && new_minutes >= 0)
            this.minutes = new_minutes;
        else
            throw new NullPointerException("Minutes must be between 0 and 59!");
    }

    public void setSeconds(int new_seconds) {                             // устанавливает секунды
        if(new_seconds <= 59 && new_seconds >= 0)
            this.seconds = new_seconds;
        else
            throw new NullPointerException("Seconds must be between 0 and 59!");
    }

    public int getHours() {                                              // возращает часы
        return this.hours;
    }

    public int getMinutes() {                                               // возращает минуты
        return this.minutes;
    }

    public int getSeconds() {                                                // возращает секунды
        return this.seconds;
    }

    public void addHours(int hours_) {                                        // добавляет часы
        if(hours_ > 0)
        this.hours = (this.hours + hours_) % 24;
        else
            throw new NullPointerException("Hours cant be less then 0!");
    }

    public void addMinutes(int minutes_) {                                  // добавляет минуты
        if(minutes_ > 0) {
            this.hours += (this.minutes + minutes_) / 60;
            this.minutes = (this.minutes + minutes_) % 60;
            this.hours %= 24;
        }
        else
            throw new NullPointerException("Minutes cant be less then 0!");
    }

    public void addSeconds(int seconds_) {                                // добавляет секунды
        if(seconds_ > 0) {
            this.minutes += (this.seconds + seconds_) / 60;
            this.seconds = (this.seconds + seconds_) % 60;
            this.hours += this.minutes / 60;
            this.minutes %= 60;
            this.hours %=  24;
        }
        else
            throw new NullPointerException("Seconds cant be less then 0!");
    }

    public int convert_to_hours() {                                   // переводит в часы
        return this.hours;
    }

    public int convert_to_minutes() {                                 // переводит в минуты
        return this.minutes + this.hours*60;
    }

    public int convert_to_seconds() {                                 // переводит в секунды
        return this.minutes * 60 + this.hours * 60 * 60 + this.seconds;
    }
    public String toString() {                                     // Возращает все значение в виде строки
        return (String)(this.hours + ":" + this.minutes + ":" + this.seconds);
    }
}
