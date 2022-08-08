package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle{
	
	public Blocks (int x, int y) {
		super(x,y,32,32); 	//tamanho dos blocos de colisao
	}

	public void render (Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);	//renderiza borda dos blocos
	}
	
}
