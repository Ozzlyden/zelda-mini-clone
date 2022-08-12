package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends Rectangle {		//Biblioteca de dimensoes
	
	public int spd = 4;	//vel de movi 
	public int right = 1, up = 0 ,down = 0, left = 0; 
	
	public int curAnimation = 0;	//variavel para animacao
	
	public int curFrames = 0, targetFrames = 15; 	//Velocidade dos Frames
	
	public static List <Bullet> bullets = new ArrayList <Bullet>();
	
	public boolean shoot = false;		//var para atirar 
	
	public int dir = 1;
	
	
	public Enemy (int x, int y) {
		super(x,y, 64, 64); //dimensoes de onde comeca o Player
	}
	
	
	public void tick () {
		boolean moved = true;
		
		//Logica I.A
		if(right == 1 && World.isFree(x+1, y) ) {
			x++;
		}
		
		
		//LOGICA ANIMACOES
		if(moved) {
			curFrames++;
			if (curFrames == targetFrames) {
				curFrames = 0;
				curAnimation ++;
				if(curAnimation == Spritesheet.enemy_front.length) {
					curAnimation = 0;
			}
		}
			//LOGICA TIRO 
			if(shoot) {
				shoot = false;
				bullets.add(new Bullet(x, y, dir));	
			}
			for(int i = 0; i < bullets.size(); i ++) {
				bullets.get(i).tick();
			}
	}
	}
	
	public void render (Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.enemy_front[curAnimation], x, y, 32, 32, null); 		//render da imagem do enemy
		for(int i = 0; i < bullets.size(); i ++) {
			bullets.get(i).render(g);
		}
	}

}
