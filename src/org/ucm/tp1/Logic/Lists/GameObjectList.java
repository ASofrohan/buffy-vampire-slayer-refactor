package org.ucm.tp1.Logic.Lists;
import org.ucm.tp1.Logic.GameObjects.GameObject;
import java.util.*;
import org.ucm.tp1.Logic.Level;

public class GameObjectList {
	private ArrayList<GameObject>gameObjects;
	private int vRemaining;	//restar cada vez que aparezca uno
	private int vAlive;		//v on board
	private int vCounter;	//vampiros que han aparecido
	private int sCounter;	//siguiente slayer
	
	public GameObjectList(Level l) {
		this.gameObjects = new ArrayList<GameObject>();
		this.vRemaining = l.getNumberOfVampires();
		this.vCounter = 0;
		this.vAlive = 0;
		this.sCounter = 0;
	}

	public void removeDead() {
		for(int i = 0; i < gameObjects.size(); i++ ) {
			if(gameObjects.get(i).getHealth() <= 0) {
				gameObjects.remove(i);
			}
		}
	}
	
	public void move() {
		for(int i = 0; i < gameObjects.size(); i++ ) {
			if(freePos(gameObjects.get(i).getRow(), gameObjects.get(i).getColumn()-1)) {
				gameObjects.get(i).move();
			}
		}
	}
	
	public boolean freePos(int row, int column) {
		boolean freePos = true;
		for(int i = 0; i < gameObjects.size(); i++ ) {
			if(gameObjects.get(i).checkPos(row, column)) freePos = false;
		}		
		return freePos;
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	public void setGameObjects(ArrayList<GameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}
	public int getvRemaining() {
		return vRemaining;
	}
	public void setvRemaining(int vRemaining) {
		this.vRemaining = vRemaining;
	}
	public int getvAlive() {
		return vAlive;
	}
	public void setvAlive(int vAlive) {
		this.vAlive = vAlive;
	}
	public int getvCounter() {
		return vCounter;
	}
	public void setvCounter(int vCounter) {
		this.vCounter = vCounter;
	}
	public int getsCounter() {
		return sCounter;
	}
	public void setsCounter(int sCounter) {
		this.sCounter = sCounter;
	}
		
}
