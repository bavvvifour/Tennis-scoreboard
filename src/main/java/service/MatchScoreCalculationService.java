package service;

import entity.Matches;

public class MatchScoreCalculationService {
    private int firstPointPLayer = 0;
    private int secondPointPLayer = 0;
    private int firstPlayerGames = 0;
    private int secondPlayerGames = 0;

    private final int[] resetPoints = new int[] {0, 0};


    public void addPoint(int winnerId, Matches match) {
        addGame(match);
        checkGames(match);
        if (winnerId == 0) {
            if (firstPointPLayer < 30) {
                match.getMatchScore().setPoints(new int[]{firstPointPLayer += 15, secondPointPLayer});
            } else if (firstPointPLayer == 30) {
                match.getMatchScore().setPoints(new int[]{firstPointPLayer += 10, secondPointPLayer});
            } else if (firstPointPLayer >= 40) {
                firstPointPLayer = 0;
                secondPointPLayer = 0;
                match.getMatchScore().setPoints(resetPoints);
            }
        } else {
            if (secondPointPLayer < 30) {
                match.getMatchScore().setPoints(new int[]{firstPointPLayer, secondPointPLayer += 15});
            } else if (secondPointPLayer == 30) {
                match.getMatchScore().setPoints(new int[]{firstPointPLayer, secondPointPLayer += 10});
            } else if (secondPointPLayer >= 40) {
                firstPointPLayer = 0;
                secondPointPLayer = 0;
                match.getMatchScore().setPoints(resetPoints);
            }
        }
    }

    public void checkGames(Matches matches) {
        int firstPlGame = matches.getMatchScore().getGames()[0];
        int secondPlGame = matches.getMatchScore().getGames()[1];

        if (firstPlGame == 6 && (firstPlGame - secondPlGame >= 2)) {
            matches.getMatchScore().setSets(new int[]{1, 0});
        } else if (secondPlGame == 6 && (secondPlGame - firstPlGame >= 2)) {
            matches.getMatchScore().setSets(new int[]{0, 1});
        } else if (firstPlGame >= 6 || secondPlGame >= 6){
            if ((firstPlGame - secondPlGame) >= 2) {
                matches.getMatchScore().setSets(new int[]{1, 0});
            } else if ((secondPlGame - firstPlGame >= 2)) {
                matches.getMatchScore().setSets(new int[]{0, 1});
            }
        }
    }


    public void addGame(Matches match) {
        if (firstPointPLayer == 40) {
            match.getMatchScore().setGames(new int[]{firstPlayerGames += 1, secondPlayerGames});
            match.getMatchScore().setPoints(resetPoints);
        } else if (secondPointPLayer == 40) {
            match.getMatchScore().setGames(new int[]{firstPlayerGames, secondPlayerGames += 1});
            match.getMatchScore().setPoints(resetPoints);
        }
    }

    public boolean isEndMatch(Matches match) {
        return match.getMatchScore().getSets()[0] == 1 ||
                match.getMatchScore().getSets()[1] == 1;
    }

}
