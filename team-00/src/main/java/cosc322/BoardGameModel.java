/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc322;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author drews
 */
public class BoardGameModel {
    
    public static final String POS_MARKED_BLACK = "black";
    public static final String POS_MARKED_WHITE = "white";
    public static final String POS_MARKED_ARROW = "arrow";
    public static final String POS_AVAILABLE = "available";
    
    int[] pos;
    
    //wQueens contains the objects for each of the white queens, bQueens does the same for black queens.
    Queen[] wQueens = new Queen[4];
    Queen[] bQueens = new Queen[4];
    
    private boolean whiteTurn;
    
    private String[][] board = new String[10][10];
    
    //Creates Initial Board State
    public BoardGameModel(){
        whiteTurn = true;
        
        wQueens[0] = new Queen(new int[]{0,3});
        wQueens[1] = new Queen(new int[]{0,6});
        wQueens[2] = new Queen(new int[]{2,0});
        wQueens[3] = new Queen(new int[]{2,9});
        
        bQueens[0] = new Queen(new int[]{7,0});
        bQueens[1] = new Queen(new int[]{7,9});
        bQueens[2] = new Queen(new int[]{9,3});
        bQueens[3] = new Queen(new int[]{9,6});
        
        for(int i = 0; i < 4; i++){
            pos = wQueens[i].getPosition();
            board[pos[0]][pos[1]] = POS_MARKED_WHITE;
            
            pos = bQueens[i].getPosition();
            board[pos[0]][pos[1]] = POS_MARKED_BLACK;
        }
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(board[i][j] == null){
                    board[i][j] = POS_AVAILABLE;
                }
            }
        }
    }
    
    //Creates board state given the previous board state, the coordiantes of the queen just moved, the new coordinates of the queen just move
    public BoardGameModel(BoardGameModel prev, int[] qPrev, int[] qNow, int[] arrow){
        board = prev.getBoard();
        whiteTurn = !prev.getWhiteTurn();
        wQueens = prev.getWhiteQueens();
        bQueens = prev.getBlackQueens();
        
        int activeQueen;
        
        if(whiteTurn == true){
            for(int i = 0; i < 4; i++){
                if(Arrays.equals(wQueens[i].getPosition(), qPrev)){
                    activeQueen = i;
                    wQueens[i] = new Queen(new int[]{qNow[0], qNow[1]});
                    break;
                }
            }
        }else{
             for(int i = 0; i < 4; i++){
                if(Arrays.equals(bQueens[i].getPosition(), qPrev)){
                    activeQueen = i;
                    bQueens[i] = new Queen(new int[]{qNow[0], qNow[1]});
                    break;
                }
            }
        }
        
        board[qPrev[0]][qPrev[1]] = POS_AVAILABLE;
        board[arrow[0]][arrow[1]] = POS_MARKED_ARROW;
        
    }
    
    public String[][] getBoard(){
        return this.board;
    }
    
    public boolean getWhiteTurn(){
        return whiteTurn;
    }
    
    public Queen[] getWhiteQueens(){
        return wQueens;
    }
    
    public Queen[] getBlackQueens(){
        return bQueens;
    }
    
}