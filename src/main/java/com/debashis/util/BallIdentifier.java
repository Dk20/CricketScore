package com.debashis.util;

import org.apache.commons.lang3.StringUtils;

public class BallIdentifier {
    public enum BallType{NORMAL,WICKET,WIDE,NO_BALL}

    public static BallType getType(String ball){
        if(StringUtils.isNumeric(ball)){
            return BallType.NORMAL;
        } else if(ball.equals("W")) {
            return BallType.WICKET;
        } else if(ball.equals("Wd")) {
            return BallType.WIDE;
        } else if(ball.startsWith("No")) {
            return BallType.NO_BALL;
        }else {
            throw new IllegalArgumentException("Only supported [0-6] , W, No[1-6] and Wd");
        }
    }

}
