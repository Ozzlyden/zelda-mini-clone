package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	//resolucao da tela
	public static int WIDTH = 640, HEIGHT = 480;	//Tamanho Janela
	public static int SCALE = 3;					//escala
	
	public static Player player;	//Instanciar classe Player
	
	public World world;	//instancia classe World
	public List <Enemy> enemies = new ArrayList <Enemy>(); 
	
	
	public Game() {
		this.addKeyListener(this);	//colocar eventos de teclado e os metodos ja estao nessa class Game
		//setando as dimensoes
		this.setPreferredSize( new Dimension (WIDTH, HEIGHT));
		new Spritesheet();
		player = new Player(32, 32);	//Dimensoes inicio game
		world = new World();
		
		enemies.add(new Enemy(32, 32));	//colocando Enemy na mesm posicao do player
		enemies.add(new Enemy(64, 64));
		
	}
	
	public void tick () {
		player.tick();		//chama dentro da class Player o metodo tick
		
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}
	} 
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		//Otimizacao de render, para veriguar o Buffer
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color (0, 135, 13));
		//criar retangulo na tela nas dimensoes (x,y,WIDTH,HEIGHT)
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		player.render(g); 	//chama dentro da class Player o metodo render 
		//render enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}
		
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
		
		frame.setLocationRelativeTo(null);		//centralizar janela
		
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
	public void keyPressed(KeyEvent e) {
		//LOGICA para precionar
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		//Botao para atirar
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			player.shoot = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//LOGICA para soltar botao
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}
}
	
	
