package com.debashis;

import com.debashis.service.IScoreCard;
import com.debashis.service.impl.ScoreCardImpl;

import java.util.LinkedList;
import java.util.Queue;

public class CricketScoreApp {
    public static void main(String[] args) {
        testCase1();
//        testCase2();
//        testCase3();
//        testCase4();
    }

    static void testCase1(){
        Integer noOfOvers = 2;
        Queue<String> battingOrderA = new LinkedList<>();
        battingOrderA.add("P1");
        battingOrderA.add("P2");
        battingOrderA.add("P3");
        battingOrderA.add("P4");
        battingOrderA.add("P5");
        Queue<String> battingOrderB = new LinkedList<>();
        battingOrderB.add("P6");
        battingOrderB.add("P7");
        battingOrderB.add("P8");
        battingOrderB.add("P9");
        battingOrderB.add("P10");

        IScoreCard iScoreCard = new ScoreCardImpl(noOfOvers,battingOrderA,battingOrderB);
        // over 1
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        iScoreCard.playBall("2");
        System.out.println();
        System.out.println();
        //over 2
        iScoreCard.playBall("W");
        iScoreCard.playBall("4");
        iScoreCard.playBall("4");
        iScoreCard.playBall("Wd");
        iScoreCard.playBall("W");
        iScoreCard.playBall("1");
        iScoreCard.playBall("6");
        System.out.println();
        System.out.println();

        // team B
        // over 1
        iScoreCard.playBall("4");
        iScoreCard.playBall("6");
        iScoreCard.playBall("W");
        iScoreCard.playBall("W");
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        System.out.println();
        System.out.println();
        //over 2
        iScoreCard.playBall("6");
        iScoreCard.playBall("1");
        iScoreCard.playBall("W");
        iScoreCard.playBall("W");
        System.out.println();
        System.out.println();
    }

    static void testCase2(){
        Integer noOfOvers = 1;
        Queue<String> battingOrderA = new LinkedList<>();
        battingOrderA.add("P1");
        battingOrderA.add("P2");

        Queue<String> battingOrderB = new LinkedList<>();
        battingOrderB.add("P6");
        battingOrderB.add("P7");


        ScoreCardImpl scoreCardImpl = new ScoreCardImpl(noOfOvers,battingOrderA,battingOrderB);
        // over 1
        scoreCardImpl.playBall("1");
        scoreCardImpl.playBall("1");
        scoreCardImpl.playBall("1");
        scoreCardImpl.playBall("W");

        System.out.println();
        System.out.println();


        // team B
        // over 1
        scoreCardImpl.playBall("0");
        scoreCardImpl.playBall("0");
        scoreCardImpl.playBall("W");

    }


    static void testCase3(){
        Integer noOfOvers = 1;
        Queue<String> battingOrderA = new LinkedList<>();
        battingOrderA.add("P1");
        battingOrderA.add("P2");

        Queue<String> battingOrderB = new LinkedList<>();
        battingOrderB.add("P6");
        battingOrderB.add("P7");


        ScoreCardImpl scoreCardImpl = new ScoreCardImpl(noOfOvers,battingOrderA,battingOrderB);
        // over 1
        scoreCardImpl.playBall("1");
        scoreCardImpl.playBall("No3");
        scoreCardImpl.playBall("1");
        scoreCardImpl.playBall("W");

        System.out.println();
        System.out.println();


        // team B
        // over 1
        scoreCardImpl.playBall("W");

    }

    static void testCase4(){
        Integer noOfOvers = 2;
        Queue<String> battingOrderA = new LinkedList<>();
        battingOrderA.add("P1");
        battingOrderA.add("P2");
        battingOrderA.add("P3");
        battingOrderA.add("P4");
        battingOrderA.add("P5");
        Queue<String> battingOrderB = new LinkedList<>();
        battingOrderB.add("P6");
        battingOrderB.add("P7");
        battingOrderB.add("P8");
        battingOrderB.add("P9");
        battingOrderB.add("P10");

        IScoreCard iScoreCard = new ScoreCardImpl(noOfOvers,battingOrderA,battingOrderB);


        // team A
        // over 1
        iScoreCard.playBall("4");
        iScoreCard.playBall("6");
        iScoreCard.playBall("W");
        iScoreCard.playBall("W");
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        System.out.println();
        System.out.println();
        //over 2
        iScoreCard.playBall("6");
        iScoreCard.playBall("1");
        iScoreCard.playBall("W");
        iScoreCard.playBall("W");
        System.out.println();
        System.out.println();

        //team B
        // over 1
        iScoreCard.playBall("6");
        iScoreCard.playBall("6");
        iScoreCard.playBall("6");
        iScoreCard.playBall("1");
        iScoreCard.playBall("1");
        iScoreCard.playBall("2");
        System.out.println();
        System.out.println();
        //over 2
        iScoreCard.playBall("W");
        iScoreCard.playBall("4");
        iScoreCard.playBall("4");
        iScoreCard.playBall("Wd");
        iScoreCard.playBall("W");
        iScoreCard.playBall("1");
        iScoreCard.playBall("6");
        System.out.println();
        System.out.println();
    }
}
