package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	
	public int spd = 4;	//vel de movi 
	public boolean right, up ,down, left; 
	
	public Player (int x, int y) {
		super(x,y, 32, 32); //dimensoes de onde comeca o Player
	}
	
	
	public void tick () {
		
		//Logica de movimentacao
		if (right ) {
			x += spd;
		}else if (left) {
			x -= spd;
		}
		
		if ( up ) {
			x += spd;
		}else if (down) {
			x -= spd;
		}
	}
	
	public void render (Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

}
