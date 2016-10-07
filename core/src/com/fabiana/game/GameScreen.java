package com.fabiana.game;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
    private PacmanGame pacmanGame;
    private Texture pacmanImg;

    
    public GameScreen(PacmanGame pacmangame){
        this.pacmanGame = pacmangame;
        pacmanImg = new Texture("pacman.png");
    }
    
    @Override
    public void render(float delta){
        SpriteBatch batch = pacmanGame.batch;
        batch.begin();
        batch.draw(pacmanImg, 100, 100);
        batch.end();
        
    }
    
   
}
