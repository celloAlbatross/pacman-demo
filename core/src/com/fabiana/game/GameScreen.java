package com.fabiana.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
    private PacmanGame pacmanGame;
    private Texture pacmanImg;
    private World world;
    private Pacman pacman;
    private WorldRenderer worldRenderer;


    public GameScreen(PacmanGame pacmangame){
        this.pacmanGame = pacmangame;        
        world = new World(pacmanGame);
        pacman = world.getPacman();
        worldRenderer = new WorldRenderer(pacmanGame,world);
    }

    public void update(float delta){
        
        updatePacmanDirection();
               
        world.update(delta);
    }
    
    private void updatePacmanDirection(){
        if(Gdx.input.isKeyPressed(Keys.ANY_KEY)){
            if(Gdx.input.isKeyPressed(Keys.LEFT)){
              pacman.setNextDirection(pacman.DIRECTION_LEFT);          
            }
            if(Gdx.input.isKeyPressed(Keys.RIGHT)){
              pacman.setNextDirection(pacman.DIRECTION_RIGHT);
            }
            if(Gdx.input.isKeyPressed(Keys.DOWN)){
              pacman.setNextDirection(pacman.DIRECTION_DOWN);
            }
            if(Gdx.input.isKeyPressed(Keys.UP)){
              pacman.setNextDirection(pacman.DIRECTION_UP);
            }
        }else{
            pacman.setNextDirection(pacman.DIRECTION_STILL);
        }
    }

    @Override
    public void render(float delta){
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update(delta);
      
        worldRenderer.render(delta);
    }


}
