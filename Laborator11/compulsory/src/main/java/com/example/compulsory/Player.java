package com.example.compulsory;

public class Player {
    Integer id;
    String name;
    String game;

    public Player(Integer id, String name, String game) {
        this.id = id;
        this.name = name;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Integer getId() {
        return id;
    }
}
