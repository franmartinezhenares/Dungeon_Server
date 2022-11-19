package com.liceu.dungeon_server.model;

import com.liceu.dungeon_server.services.WinnerService;

public class Winner {
    WinnerService winnerService = new WinnerService();
    private String winnerName;
    private int mazeSolved;
    private long time;


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
        return winnerService.formatTime(time);
    }

    public void setTime(long time) {
        this.time = time;
    }
}
