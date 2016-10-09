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
           
        pacman = new Pacman(60,60);
        
        maze = new Maze();
    }

    Pacman getPacman() {
        return pacman;
    }
    
    Maze getMaze(){
        return maze;
    }
}
