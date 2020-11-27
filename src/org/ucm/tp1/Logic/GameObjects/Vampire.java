package org.ucm.tp1.Logic.GameObjects;

public class Vampire extends GameObject{
	private int health;
	private int fireRate;
	private int damage;
	private boolean move;		//indica si le toca moverse ese turno o no
	
	public Vampire(int row, int column){
		this.health = 3;
        this.fireRate = 1;
        this.damage = 1;
        this.move = false;		//it changes each turn
        deploy(row, column);	
	}

	public boolean move() {
		if(this.move) {
			this.column--;
		}
		this.move = !this.move;
		return !this.move;
    }
	
    public String toString() {
    	return "V[" + this.health + "]";
    }
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getFireRate() {
		return fireRate;
	}
	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public boolean getMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
}
