package com.example.database;

import java.io.IOException;

/**
 * class of person
 * @author Gurbatov Vladislav
 */
public class Person {
    private String name;
    private int age;
    private int number;
    private int money;

    /**
     * default constructor
     */
    Person(){
        this.name = "Федор";
        this.age = 24;
        this.number = 232232;
        this.money = 29000;
    }

    /**
     * constructor with params
     * @param name name of person
     * @param age age of person
     * @param number number of person
     * @param money money of person
     * @throws IOException if 1 of params is not correct
     */
    Person(String name, int age, int number, int money) throws IOException {
        setParams(name,age,number,money);
    }

    /**
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * sets new name of person
     * @param name new name for person
     */
    public void setName(String name) throws IOException {
        if(!name.equals(""))
        this.name = name;
        else
            throw new IOException("Name cant be null!");
    }

    /**
     * @return age of person
     */
    public int getAge() {
        return age;
    }

    /**
     * sets age of person
     * @param age new age for person
     * @throws IOException if new age is less than 0
     */
    public void setAge(int age) throws IOException {
        if(age > 0)
        this.age = age;
        else
            throw new IOException("Age cant be less then 0!");
    }

    /**
     * @return number of person
     */
    public int getNumber(){
        return number;
    }

    /**
     * sets number of person
     * @param number new number
     * @throws IOException if number less than 0
     */
    public void setNumber(int number) throws IOException {
        if(number > 0)
        this.number = number;
        else
            throw new IOException("Number cant be less then 0!");
    }

    /**
     * @return money of person
     */
    public int getMoney() {
        return money;
    }

    /**
     * sets money of person
     * @param money new money
     * @throws IOException if money less than 0
     */
    public void setMoney(int money) throws IOException {
        if(money >= 0)
        this.money = money;
        else
            throw new IOException("Number cant be less then 0!");
    }

    /**
     * sets all params of person
     * @param name new name for person
     * @param age new age for person
     * @param number new number for person
     * @param money new money for person
     * @throws IOException if something is less than 0
     */
    public void setParams(String name, int age, int number, int money) throws IOException {
        setName(name);
        setMoney(money);
        setNumber(number);
        setAge(age);
    }

    /**
     * @return all params in string
     */
    public String toString(){
        return getName() + ", " + getAge() + ", " + getMoney() + ", " + getNumber();
    }

}
