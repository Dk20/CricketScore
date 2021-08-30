package com.debashis.service.impl.tracker;

import com.debashis.util.BallIdentifier;

public class OverTracker {
    private Integer ballCount;
    private Integer overCount;

    public OverTracker() {
        this.ballCount = 0;
        this.overCount = 0;
    }

    public void playBall(String ball){
        switch (BallIdentifier.getType(ball)) {
            case WIDE:
            case NO_BALL:
                break;
            case NORMAL:
            case WICKET:
                ballCount++;
                break;
        }
    }
    public boolean isOverComplete() {
        if(ballCount==6){
            overCount++;
            ballCount=0;
            return true;
        }
        return false;
    }
    public Integer getOverCount(){
        return overCount;
    }
    public String getBallDetails(){
        return "O:B = "+String.valueOf(overCount+1)+":"+String.valueOf(ballCount);
    }
}
