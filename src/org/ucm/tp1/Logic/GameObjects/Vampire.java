package org.ucm.tp1.Logic.GameObjects;
import org.ucm.tp1.Logic.Game;


public class Vampire extends GameObject{
	private int health;
	private int fireRate;
	private int damage;
	private boolean move;		//indica si le toca moverse ese turno o no
	private boolean isAlive;
	
	public Vampire(int row, int column, Game game){
		this.game = game;
		this.health = 3;
        this.fireRate = 1;
        this.damage = 1;
        this.move = false;		//it changes each turn
        this.isAlive = true;
        deploy(row, column);
        setvAlive(getvAlive()+1);
	}
	
	@Override
	public void attack() {
		IAttack other = game.getAttackableInPosition(this.row, this.column-1);
		if(other != null) other.receiveVampireAttack(this.damage);
	}
	
	public boolean receiveSlayerAttack(int damage) {
		if(isAlive) this.health = this.health-damage;
		if(this.health <= 0) {
			setvAlive(getvAlive()-1);
			this.isAlive = false;
		}
		return true;
	}
	
	public boolean move() {
		if(this.move && this.isAlive) {
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
