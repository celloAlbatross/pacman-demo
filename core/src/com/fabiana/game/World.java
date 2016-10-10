package com.fabiana.game;


public class World {
    private Pacman pacman;
    private PacmanGame pacmanGame;
    private Maze maze;
    
    public void update(float deta){
        pacman.update();
    }

    World(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        
        maze = new Maze();
           
        pacman = new Pacman(60,60,maze);
        
    }

    Pacman getPacman() {
        return pacman;
    }
    
    Maze getMaze(){
        return maze;
    }
}
