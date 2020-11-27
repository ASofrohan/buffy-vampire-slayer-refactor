package org.ucm.tp1.Logic;
import org.ucm.tp1.Logic.Lists.GameObjectList;
import org.ucm.tp1.Logic.GameObjects.Player;

public class GameObjectBoard {
	
	private Player player;
	private GameObjectList objectList;
	
	public GameObjectBoard(Level l) {
		//inicializar objetos
		this.player = new Player();
		this.objectList = new GameObjectList(l);
	}
	
	public boolean checkWin() {
		boolean win = false;	
		if(objectList.getvRemaining() == 0 && objectList.getvAlive() == 0) win = true;	//no v left on the board and remaining
		return win;
	}
	
	public boolean checkLose() {		//vampire about to move and on the first column
		boolean lose = false;	
		for(int i = 0; i < objectList.getGameObjects().size(); i++) {
			if(objectList.getGameObjects().get(i).getColumn() == (-1)) lose = true;
		}	
		return lose;
	}
	
	public void update(boolean addCoins){
		if(addCoins) this.player.setCoins(this.player.getCoins()+10);		//add coins
		objectList.move();		//move all
	}
	
	public void attack() {
		//attack slayers
		int counter;		//number of shots a vampire will recieve
		for(int j = 0; j < this.vampireList.getCounter(); j++) {
			counter = 0;
			for(int x = 0; x < this.vampireList.getVampireList()[j].getColumn(); x++) {		//check number of slayers in a row
				if(!this.slayerList.checkPos(this.vampireList.getVampireList()[j].getRow(), x)) {
					counter++;
				}
			}
			this.vampireList.getVampireList()[j].setHealth(this.vampireList.getVampireList()[j].getHealth()-counter);		//recieve shots
		}
		//attack vampires
		for(int i = 0; i < this.slayerList.getCounter(); i++) {
			if(this.slayerList.getSlayerList()[i].getDeployed() && !this.vampireList.checkPos(this.slayerList.getSlayerList()[i].getRow(), this.slayerList.getSlayerList()[i].getColumn()+1)) {
				this.slayerList.getSlayerList()[i].setHealth(this.slayerList.getSlayerList()[i].getHealth()-1);		//recieve vampire attack
			}
		}
	}
	
	public boolean addSlayer(int row, int column){
		row--;
		column--;
		boolean added = false;
		if(this.player.getCoins() >= 50) {
			added = objectList.addSlayer(row, column);
			if(added) this.getPlayer().setCoins(this.getPlayer().getCoins()-50);		//update coins
		}
		return added;
	}
	
	public void addVampire(double rand, int nRows, int nColumns, double frequency){
		objectList.addVampire(rand, nRows, nColumns, frequency);
	}
	
	public void removeDead(){
		objectList.removeDead();
	}
	
	String searchPos(int row, int column) {		//search object 4 the board
		String object = " ";
		boolean found = false;
		
		//search vampire		
		for (int j = 0; j < this.vampireList.getCounter(); j++) {
			if (this.vampireList.getVampireList()[j].getRow()== row && this.vampireList.getVampireList()[j].getColumn() == column && this.vampireList.getVampireList()[j].getDeployed()) {
				found = true;
				object = "V[" + this.vampireList.getVampireList()[j].getHealth() + "]";
			}
		}
		
		//search slayer
		if(!found)
			for (int k = 0; k < this.slayerList.getCounter(); k++) {
				if (this.slayerList.getSlayerList()[k].getRow() == row && this.slayerList.getSlayerList()[k].getColumn() == column && this.slayerList.getSlayerList()[k].getDeployed()) {
					found = true;
					object = "S[" + this.slayerList.getSlayerList()[k].getHealth() + "]";
				}
			}
		
		return object;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public GameObjectList getObjectList() {
		return objectList;
	}
	public void setObjectList(GameObjectList objectList) {
		this.objectList = objectList;
	}

	
	
}
