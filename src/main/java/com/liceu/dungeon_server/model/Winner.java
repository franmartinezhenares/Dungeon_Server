package com.liceu.dungeon_server.model;

import com.liceu.dungeon_server.services.WinnerService;

public class Winner implements Comparable<Winner>{
    WinnerService winnerService = new WinnerService();

    int winnerId;
    private String winnerName;
    private String mazeSolved;
    private long time;


    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getMazeSolved() {
        return mazeSolved;
    }

    public String getMazeSolvedName(int mazeID) {
        return getMazeSolvedName(mazeID);
    }

    public void setMazeSolved(String mazeSolved) {
        this.mazeSolved = mazeSolved;
    }

    public long getTime() {
        return time;
    }

    public String getFormattedTime() {
        return winnerService.formatTime(time);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    @Override
    public int compareTo(Winner o) {
        if(o.getTime() > time) {
            return -1;
        } else if(o.getTime() == time){
            return 0;
        } else {
            return 1;
        }
    }
}
