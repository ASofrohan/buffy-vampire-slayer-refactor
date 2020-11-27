package org.ucm.tp1.Logic.GameObjects;

public abstract class GameObject {
	
	protected int column;
	protected int row;
	
	public abstract int getHealth();
	public abstract boolean move();
	public abstract String toString();
	
	public void deploy(int row, int column) {
		this.row = row;
		this.column = column;
	};
	
    public boolean checkPos(int row, int column) {
    	boolean match = false;
    	if(row == this.row && column == this.column) {
    		match = true;
    	}
    	return match;
    }
	
	public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
	public void moveForward() {
		this.column--;
	}
};
