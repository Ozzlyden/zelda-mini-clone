package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	
	public int spd = 4;	//vel de movi 
	public boolean right, up ,down, left; 
	
	public int curAnimation = 0;	//variavel para animacao
	
	public int curFrames = 0, targetFrames = 15; 	//Velocidade dos Frames
	
	
	public Player (int x, int y) {
		super(x,y, 32, 32); //dimensoes de onde comeca o Player
	}
	
	
	public void tick () {
		boolean moved = false;
		
		//Logica de movimentacao
		if (right && World.isFree(x+spd, y) ) {		//world eh a parte de colisao do mundo
			x += spd;
			moved = true;
		}else if (left && World.isFree(x-spd, y)) {
			x -= spd;
			moved = true;
		}
		
		if ( up && World.isFree(x, y-spd)) {
			x -= spd;
			moved = true;
		}else if (down && World.isFree(x, y+spd)) {
			x += spd;
			moved = true;
		}
		
		//LOGICA ANIMACOES
		if(moved) {
			curFrames++;
			if (curFrames == targetFrames) {
				curFrames = 0;
				curAnimation ++;
				if(curAnimation == Spritesheet.player_front.length) {
					curAnimation = 0;
			}
		}
	}
	}
	
	public void render (Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.player_front[curAnimation], x, y, 32, 32, null); 		//render da imagem do Zelda de frente
	}

}
