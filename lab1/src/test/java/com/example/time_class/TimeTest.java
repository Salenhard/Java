package com.example.time_class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void setProps() {
        Time s1 = new Time();
        s1.setProps(5,26,32);
        assertEquals(5, s1.getHours());
        assertEquals(26, s1.getMinutes() );
        assertEquals(32, s1.getSeconds());
    }

    @Test
    void setHours() {
        Time s1 = new Time();
        s1.setHours(2);
        assertEquals(2, s1.getHours());
    }

    @Test
    void setMinutes() {
        Time s1 = new Time();
        s1.setMinutes(20);
        assertEquals( 20, s1.getMinutes());
    }

    @Test
    void setSeconds() {
        Time s1 = new Time();
        s1.setSeconds(30);
        assertEquals( 30, s1.getSeconds());
    }

    @Test
    void addHours() {
        Time s1 = new Time();
        s1.setHours(0);
        s1.addHours(2);
        assertEquals(2, s1.getHours());
    }

    @Test
    void addMinutes() {
        Time s1 = new Time();
        s1.setMinutes(0);
        s1.addMinutes(2);
        assertEquals(2 ,s1.getMinutes());
    }

    @Test
    void addSeconds() {
        Time s1 = new Time();
        s1.setSeconds(1);
        s1.setMinutes(0);
        s1.addSeconds(300);
        assertEquals(5, s1.getMinutes());
        assertEquals(1, s1.getSeconds());
    }

    @Test
    void convert_to_hours() {
        Time s1 = new Time();
        s1.setProps(2,2,2);
        assertEquals(2, s1.convertToHours());
    }

    @Test
    void convert_to_minutes() {
        Time s1 = new Time();
        s1.setProps(2,2,2);
        assertEquals(122,s1.convertToMinutes());
    }

    @Test
    void convert_to_seconds() {
        Time s1 = new Time();
        s1.setProps(2,2,2);
        assertEquals(7322, s1.convertToSeconds());
    }
}