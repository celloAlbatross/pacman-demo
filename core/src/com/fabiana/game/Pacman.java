package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
    private Vector2 position;

    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    
    private int currentDirection;
    private int nextDirection;
    private Maze maze;
    
    private int getRow(){
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE;
    }
    
    private int getColum(){
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE;
    }

    private static final int [][] DIR_DIFF = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    
    public void update(){
        if(isAtCenter()){
            if(canMoveInDirection(nextDirection)){
                currentDirection = nextDirection;
                if(maze.hasDotAt(getRow(), getColum())){
                    maze.removeDotAt(getRow(), getColum());
                }
            }else{
                currentDirection = DIRECTION_STILL;
            }
        }
        position.x += SPEED * DIR_DIFF[currentDirection][0];
        position.y += SPEED * DIR_DIFF[currentDirection][1];
    }
    
    public boolean isAtCenter(){
        int blockSize = WorldRenderer.BLOCK_SIZE;
        
        return (((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y) - blockSize/2) % blockSize) == 0);
    }
    
    public Pacman(int x,int y,Maze maze){
        position = new Vector2(x,y);
        
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        
        this.maze = maze;
    }

    public Vector2 getPosition(){
        return position;
    }
    
    public void setNextDirection(int dir){
        nextDirection = dir;
    }
    
    private boolean canMoveInDirection(int dir){
        int newRow = getRow() + DIR_DIFF[dir][1];
        int newCol = getColum()+ DIR_DIFF[dir][0];
        return !(maze.hasWallAt(newRow, newCol));
//        return true;
    }
    
    
}
