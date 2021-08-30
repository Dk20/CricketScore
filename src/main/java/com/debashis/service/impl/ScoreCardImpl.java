package com.debashis.service.impl;

import com.debashis.exception.AllOut;
import com.debashis.service.IScoreCard;
import com.debashis.service.impl.tracker.IndividualScoreTracker;
import com.debashis.service.impl.tracker.OverTracker;
import com.debashis.service.impl.tracker.StrikeTracker;
import com.debashis.service.impl.tracker.TeamScoreTracker;

import java.util.Queue;

public class ScoreCardImpl implements IScoreCard {
    private IndividualScoreTracker individualScoreTracker;
    private TeamScoreTracker teamScoreTracker;
    private StrikeTracker strikeTracker;
    private OverTracker overTracker;
    private Integer noOfOvers;
    private boolean isTeamABatting;
    private boolean matchOver;

    public ScoreCardImpl(Integer noOfOvers, Queue<String> teamA, Queue<String> teamB) {
        this.noOfOvers = noOfOvers;
        this.isTeamABatting = true; // team A always bats first
        this.teamScoreTracker = new TeamScoreTracker();
        this.individualScoreTracker = new IndividualScoreTracker(teamA,teamB);
        this.overTracker = new OverTracker();
        this.strikeTracker = new StrikeTracker(teamA,teamB);
        this.matchOver = false;
    }
    @Override
    public void playBall(String ball) {
        if(matchOver)return;

        // --- broadcasts Play Ball event : consumed by all trackers

        //event
        overTracker.playBall(ball);

        String striker = strikeTracker.getStriker();
        printPlayBall(ball,striker);

        //event
        individualScoreTracker.playBall(ball,striker,isTeamABatting);
        //event
        teamScoreTracker.playBall(isTeamABatting,ball);
        //event
        try {
            strikeTracker.playBall(ball,isTeamABatting);
        } catch (AllOut e) {
            if (isTeamABatting) {
                printScoreCard();
                strikeTracker.switchBattingTeam();
                isTeamABatting = false;
                overTracker = new OverTracker();
            } else { // // Match Over condition :: All Out
                printScoreCard();
                printResult();
                matchOver=true;
            }
            return;
        }
        // // Match Over condition:: chase complete
        if(!isTeamABatting && teamScoreTracker.getTeamBScore()>teamScoreTracker.getTeamAScore()){
            printScoreCard();
            printResult();
            matchOver=true;
            return;
        }

        if(overTracker.isOverComplete()){
            printScoreCard();
            strikeTracker.endOfOverStrikeChange();
            if(overTracker.getOverCount()==noOfOvers){
                if(isTeamABatting){
                    strikeTracker.switchBattingTeam();
                    isTeamABatting = false;
                    overTracker = new OverTracker();
                } else { // Match Over condition :: innings over
                    printResult();
                    matchOver=true;
                }
            }
        }
    }
    private void printPlayBall(String ball,String striker){
        System.out.println(overTracker.getBallDetails()+" "+striker+" "+ball);
    }
    private void printScoreCard(){
        System.out.println("\nName| Score|  4s| 6s| Balls");
        individualScoreTracker.printIndividualScores(isTeamABatting,strikeTracker.getStriker(),strikeTracker.getRunner());
        teamScoreTracker.printTotalScore(isTeamABatting);
    }
    private void printResult(){
        String team = teamScoreTracker.getTeamAScore()>teamScoreTracker.getTeamBScore()?"A":"B";
        Integer runs = Math.abs(teamScoreTracker.getTeamAScore()-teamScoreTracker.getTeamBScore());
        System.out.println("Result: team "+team+" won the match by "+runs+" runs.");
    }
}
