package com.mockito.service;

import com.mockito.pojo.Player;

public class PlayerStatistics {
    private Player player;
    private int games;
    private int goals;

    public PlayerStatistics(Player player, int games, int goals) {
        this.player = player;
        this.games = games;
        this.goals = goals;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public boolean underThirty() {
        return this.player.getAge() < 30;
    }

    public static Player getYoungerPlayer(Player player1, Player player2) {
        int ageOfPlayer1 = player1.getAge();
        int ageOfPlayer2 = player2.getAge();

        if (ageOfPlayer1 < ageOfPlayer2) {
            return player1;
        } else if (ageOfPlayer2 < ageOfPlayer1) {
            return player2;
        } else {
            return null;
        }
    }

    public double gamesPerGoal() {
        return (double) this.games / (double) this.goals;
    }

    public double goalsPerGame() {
        return (double) this.goals / (double) this.games;
    }

    public Double[] createCsvRecord() {
        if (this.games == 0 || this.goals == 0) {
            return null;
        } else {
            return new Double[]{goalsPerGame(), gamesPerGoal()};
        }
    }
}
