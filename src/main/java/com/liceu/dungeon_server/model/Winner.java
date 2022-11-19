package com.liceu.dungeon_server.model;

public class Winner {
    private String winnerName;
    private int mazeSolved;
    private String time;


    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public int getMazeSolved() {
        return mazeSolved;
    }

    public void setMazeSolved(int mazeSolved) {
        this.mazeSolved = mazeSolved;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
