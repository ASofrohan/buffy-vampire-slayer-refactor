package org.ucm.tp1.Logic;
import org.ucm.tp1.Logic.GameObjects.IAttack;
import org.ucm.tp1.view.IPrintable;
import java.util.*;

public class Game implements IPrintable {
    private Long seed;
    private Level level;
    private int cycles;
    private GameObjectBoard gameObjectBoard;
    private boolean exitGame;
    private boolean win;
    
    
    public Game(long seed, Level level) {
        this.seed = seed;
        this.level = level;
        this.cycles = 0;
        this.gameObjectBoard = new GameObjectBoard(level);
        this.exitGame = false;
        this.win = false;
    }
    
    public void update() {
    	gameObjectBoard.update(randomGenerator(seed) >= 0.5);		//give coins && move
    	gameObjectBoard.getObjectList().attack();
    	gameObjectBoard.addVampire(randomGenerator(seed), level.getDim_y()-1, level.getDim_x()-1, level.getVampireFrequency(), this);
    	gameObjectBoard.removeDead();
    	cycles++;
    }
    
    public boolean isFinished() {
    	this.exitGame = (gameObjectBoard.checkWin() || gameObjectBoard.checkLose());
    	this.win = gameObjectBoard.checkWin();
    	return this.exitGame;
    }
    
    public String toStringObjectAt(int row, int column) {
    	return this.gameObjectBoard.searchPos(row, column);
    }
    
    public double randomGenerator(Long seed) {		//generator
    	Random generator = new Random(seed);
    	this.seed = (long)generator.nextInt();
    	generator.setSeed(seed);
    	return generator.nextDouble();
    }
    
    public IAttack getAttackableInPosition(int row, int column) {
    	return gameObjectBoard.getObjectPosition(row, column);
    }
    
    public String getPositionToString(int x, int y) {
    	return gameObjectBoard.getObjectList().toStringSearch(x,y);
    }
    
    public int getCycles()  {
        return cycles;
    }
    
    public void setCycles(int nCycles) {
        this.cycles = nCycles;
    }

	public Level getLevel() {
        return level;
    }
    
    public void setLevel(Level newLevel) {
        this.level = newLevel;
    }   
    
    public Long getSeed() {
		return seed;
	}

	public void setSeed(Long seed) {
		this.seed = seed;
	}

	public GameObjectBoard getGameObjectBoard() {
        return gameObjectBoard;
    }
    
    public void setGameObjectBoard (GameObjectBoard newGameObjectBoard) {
        this.gameObjectBoard = newGameObjectBoard;
    }
    
    public boolean getExitGame() {
    	return exitGame;
    }
    
    public void setExitGame(boolean exit) {
    	this.exitGame = exit;
    }
    
    public boolean getWin() {
    	return win;
    }
    
    public void setWin(boolean w) {
    	this.win = w;
    }

}