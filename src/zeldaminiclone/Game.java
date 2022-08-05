package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	//resolucao da tela
	public static int WIDTH = 480, HEIGHR = 480;
	
	public Game() {
		//setando as dimensoes
		this.setPreferredSize( new Dimension (WIDTH, HEIGHT));
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
			System.out.println("Chamar o game looping");
		}
	
		
	}
	
	

}
