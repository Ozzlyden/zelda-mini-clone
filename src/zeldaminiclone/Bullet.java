package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle{		//Biblioteca de dimencoes
	
	public int dir = 1;			//direcao da bala
	public int speed = 8;		//vel da bala
	
	public int frames = 0;
	
	public Bullet(int x, int y, int dir) {
		super(x+16, y+16, 10, 10);	//tamanho balas
		this.dir = dir;
	}
	
	public void tick() {
		//LOGICA balas
		x+=speed*dir;
		frames++;
		//LOGICA para del a bala depois de 60 frames = 1 min
		if(frames == 60) {
			Player.bullets.remove(this);
			return;
		}
	}
	
	public void render (Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
		
	}
	
	
}
