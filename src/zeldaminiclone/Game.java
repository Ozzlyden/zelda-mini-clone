package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	//resolucao da tela
	public static int WIDTH = 480, HEIGHR = 480;
	
	public Game() {
		//setando as dimensoes
		this.setPreferredSize( new Dimension (WIDTH, HEIGHT));
	}

	public void tick () {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		//Otimizacao de render, para veriguar o Buffer
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		//criar retangulo na tela nas dimensoes (x,y,WIDTH,HEIGHT)
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 50, 50);
		
		bs.show();
		
	}
	
	public static void main (String [] args) {
		//Instanciou o metodo Game e a biblioteca Jframe
		Game game = new Game();
		JFrame frame = new JFrame();	
		
		//Configuracoes de janelas usando JFrame
		frame.add(game);
		frame.setTitle("Mini Zelda");
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		
		//Para finalizar o projeto e nao pegar memoria da maquina
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread (game).start();
		
	}
	
	@Override
	public void run() {

		while (true) {
			tick();
			render();
			try {
				//setando o FPS 60 
				Thread.sleep(1000/60);
			}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
}
