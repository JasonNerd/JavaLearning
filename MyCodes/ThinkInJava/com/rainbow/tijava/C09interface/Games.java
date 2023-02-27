package com.rainbow.tijava.C09interface;
interface Game{
    boolean move();
}
interface GameFactory {
    Game getGame();
}
class Checkers implements Game{
    private int moves = 0;
    private static final int MOVES = 3;
    @Override
    public boolean move() {
        System.out.println("Checkers move "+moves);
        return ++moves != MOVES;
    }
}
class CheckersFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Checkers();
    }
}
class Chess implements Game{
    private int move = 0;
    private static final int MOVES = 4;
    @Override
    public boolean move() {
        System.out.println("Chess move "+move);
        return ++move != MOVES;
    }
}
class ChessFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Chess();
    }
}
public class Games {
    public static void playGame(GameFactory gameFactory){
        Game g = gameFactory.getGame();
        while(g.move());
    }
    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}
