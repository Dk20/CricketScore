package com.debashis.service.impl.tracker;

import com.debashis.util.BallIdentifier;

public class TeamScoreTracker {
    private Integer teamAScore;
    private Integer teamBScore;
    private Integer teamABallCount;
    private Integer teamBBallCount;
    private Integer wicketCountForA;
    private Integer wicketCountForB;

    public TeamScoreTracker() {
        this.teamABallCount=0;
        this.teamBBallCount=0;
        this.teamAScore=0;
        this.teamBScore=0;
        this.wicketCountForA=0;
        this.wicketCountForB=0;
    }

    public void playBall(boolean isTeamABatting, String ball){
        switch (BallIdentifier.getType(ball)) {
            case WIDE:
                if(isTeamABatting)teamAScore++;
                else teamBScore++;
                break;
            case NO_BALL:
                if(isTeamABatting){
                    teamAScore += Integer.valueOf(ball.substring(2));
                    teamAScore++;
                }
                else {
                    teamBScore += Integer.valueOf(ball.substring(2));
                    teamBScore++;
                }
                break;
            case NORMAL:
                Integer run = Integer.valueOf(ball);
                if(isTeamABatting){
                    teamAScore+=run;
                    teamABallCount++;
                }
                else {
                    teamBScore+=run;
                    teamBBallCount++;
                }
                break;
            case WICKET:
                if(isTeamABatting){
                    teamABallCount++;
                    wicketCountForA++;
                }
                else {
                    teamBBallCount++;
                    wicketCountForB++;
                }
                break;
        }
    }
    public void printTotalScore(boolean isTeamABatting){
        if(isTeamABatting){
            System.out.println("Score: "+teamAScore+"/"+wicketCountForA);
            int overs = teamABallCount/6;
            int balls = teamABallCount%6;
            System.out.println(String.format("Overs : %d.%d",overs,balls));
        } else {
            System.out.println("Score: "+teamBScore+"/"+wicketCountForB);
            int overs = teamBBallCount/6;
            int balls = teamBBallCount%6;
            System.out.println(String.format("Overs : %d.%d",overs,balls));

        }
    }

    public Integer getTeamAScore() {
        return teamAScore;
    }

    public Integer getTeamBScore() {
        return teamBScore;
    }
}
