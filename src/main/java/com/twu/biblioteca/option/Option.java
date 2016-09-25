package com.twu.biblioteca.option;

public abstract class Option implements Executable{

    private int id;
    private String name;

    public Option(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}