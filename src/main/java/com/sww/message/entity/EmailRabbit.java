package com.sww.message.entity;

import java.io.Serializable;

public class EmailRabbit implements Serializable{
    private Email email;

    public EmailRabbit(){

    }

    public EmailRabbit(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailRabbit{" +
                 email.toString() +
                '}';
    }
}
