package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle {		//Biblioteca de dimensoes
	
	public int spd = 2;	//vel de movimento
	public int right = 1, up = 0 ,down = 0, left = 0; 
	
	public int curAnimation = 0;	//variavel para animacao
	
	public int curFrames = 0, targetFrames = 15; 	//Velocidade dos Frames
	
	public static List <Bullet> bullets = new ArrayList <Bullet>();
	
	public boolean shoot = false;		//var para atirar 
	
	public int dir = 1;
	
	
	public Enemy (int x, int y) {
		super(x,y, 64, 64); //dimensoes de onde comeca o Player
	}
	
	
	public void perseguirPlayer() {
		//LOGICA I.A
		Player p = Game.player;
		if(x < p.x && World.isFree(x+spd, y)) {
			//Randomizando o movimento
			if(new Random().nextInt(100) < 50)		//Pega um numero entre 0 e 100, se for acima de 50 = mover
				x+=spd;
		}else if(x > p.x && World.isFree(x-spd, y)) {
			if(new Random().nextInt(100) < 50)
				x-=spd;
		}
		
		if (y < p.y && World.isFree(x, y+spd)) {
			if(new Random().nextInt(100) < 50)
				y+=spd;
		}else if (y > p.y && World.isFree(x, y-spd)) {
			if(new Random().nextInt(100) < 50)
				y-=spd;
		}
	}
	
	public void tick () {
		boolean moved = true;
			
			perseguirPlayer(); 
		
		
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
		g.drawImage(Spritesheet.enemy_front[curAnimation], x, y, 32, 32, null); 		//render da imagem do enemy
		for(int i = 0; i < bullets.size(); i ++) {
			bullets.get(i).render(g);
		}
	}

}
