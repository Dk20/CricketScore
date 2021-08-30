package com.debashis.service.impl.tracker;

import com.debashis.exception.AllOut;
import com.debashis.util.BallIdentifier;

import java.util.Queue;

public class StrikeTracker {
    private Queue<String> battingOrderA;
    private Queue<String> battingOrderB;
    private String striker;
    private String runner;

    public StrikeTracker(Queue<String> battingOrderA,Queue<String> battingOrderB) {
        if(battingOrderA.size()<=1 || battingOrderB.size()<=1)throw new IllegalArgumentException("Incorrect team size");
        this.battingOrderA = battingOrderA;
        this.battingOrderB = battingOrderB;
        this.striker = this.battingOrderA.poll();
        this.runner = this.battingOrderA.poll();
    }

    public void playBall(String ball,boolean isTeamABatting) throws AllOut {
        switch (BallIdentifier.getType(ball)) {
            case WIDE:
                break;
            case NORMAL:
                Integer run = Integer.valueOf(ball);
                swtichForRun(run);
                break;
            case NO_BALL:
                run = Integer.valueOf(ball.substring(2)); // No1..6
                swtichForRun(run);
                break;
            case WICKET:
                if(isTeamABatting){
                    if(battingOrderA.size()==0) throw new AllOut();
                    striker = battingOrderA.poll();
                } else {
                    if(battingOrderB.size()==0) throw new AllOut();
                    striker = battingOrderB.poll();
                }
                break;
        }
    }

    private void swtichForRun(Integer run) {
        switch (run) {
            case 1:
            case 3:
                String temp = striker;
                striker = runner;
                runner = temp;
                break;
            case 2:
            case 4:
            case 6:
                break;
        }
    }

    public void switchBattingTeam(){
        striker = battingOrderB.poll();
        runner = battingOrderB.poll();
    }
    public void endOfOverStrikeChange(){
        String temp = striker;
        striker = runner;
        runner = temp;
    }
    public String getStriker(){
        return striker;
    }
    public String getRunner(){
        return runner;
    }
}
