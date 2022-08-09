package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	//resolucao da tela
	public static int WIDTH = 480, HEIGHR = 480;
	public Player player;	//Instanciar classe Player
	
	public World world;	//instancia classe World
	
	public Game() {
		this.addKeyListener(this);	//colocar eventos de teclado e os metodos ja estao nessa class Game
		//setando as dimensoes
		this.setPreferredSize( new Dimension (WIDTH, HEIGHT));
		new Spritesheet();
		player = new Player(32, 32);	//Dimensoes inicio game
		world = new World();
	}
	
	public void tick () {
		player.tick();		//chama dentro da class Player o metodo tick
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
		
		player.render(g); 	//chama dentro da class Player o metodo render 
		
		world.render(g);
		
		bs.show();
		
	}

	
	public static void main (String [] args) {
		//Instanciou o metodo Game e a biblioteca Jframe
		Game game = new Game();
		JFrame frame = new JFrame();	
		
		//Configuracoes de janelas usando JFrame
		frame.add(game);
		frame.setTitle("Mini Zelda");
		
		frame.setLocationRelativeTo(null);
		
		frame.pack();
		
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

	//TECLADO (KeyListener) Config
	
	@Override
	public void keyTyped(KeyEvent e) {
		//LOGICA para andar
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.right = true;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.left = true;
		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		//LOGICA para parar
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.right = false;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.left = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}