package com.debashis.service.impl.tracker;

import com.debashis.util.BallIdentifier;

import java.util.*;

public class IndividualScoreTracker {
    private Map<String, List<Integer>> individualScoreA;
    private Map<String, List<Integer>> individualScoreB;

    public IndividualScoreTracker(Queue<String> teamA, Queue<String> teamB) {
        individualScoreA = new HashMap<>();
        individualScoreB = new HashMap<>();
        teamA.stream().forEach(player-> individualScoreA.put(player,new ArrayList<>()));
        teamB.stream().forEach(player-> individualScoreB.put(player,new ArrayList<>()));
    }

    public void playBall(String ball,String player,boolean isTeamABatting){
        switch (BallIdentifier.getType(ball)) {
            case WIDE:
            case WICKET:
                break;
            case NO_BALL:
                Integer run = Integer.valueOf(ball.substring(2));
                if(isTeamABatting){
                    individualScoreA.get(player).add(run);
                } else {
                    individualScoreB.get(player).add(run);
                }
                break;
            case NORMAL:
                run = Integer.valueOf(ball);
                if(isTeamABatting){
                    individualScoreA.get(player).add(run);
                } else {
                    individualScoreB.get(player).add(run);
                }
                break;
        }
    }

    public void printIndividualScores(boolean isTeamABatting,String striker,String runner){
        if(isTeamABatting){
            individualScoreA.forEach((player,scores)->{
                printIndividualScore(player,scores,striker,runner);
            });
        } else {
            individualScoreB.forEach((player,scores)->{
                printIndividualScore(player,scores,striker,runner);
            });
        }
    }
    private void printIndividualScore(String player,List<Integer> scores,String striker,String runner){
        Integer score = scores.stream().reduce(0,Integer::sum);
        Integer noOfBallsPlayed = scores.size();
        Long fours = scores.stream().filter(s->s==4).count();
        Long sixes = scores.stream().filter(s->s==6).count();
        boolean onPitch = striker.equals(player) || runner.equals(player);
        System.out.println(player+(onPitch?"*":"")+" "+score+" "+fours+" "+sixes+" "+noOfBallsPlayed);
    }
}
