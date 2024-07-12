package com.blackman.enums;


public enum Sex {

    WOMAN(0, "女性"),
    MAN(1, "男性"),
    SECRET(2, "秘密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

}
