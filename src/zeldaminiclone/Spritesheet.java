package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	//Cordenadas da imagem dentro da spritesheet.png
	
	public static BufferedImage[] player_front;		//Array de Imagens do Player de frente
	
	
	public static BufferedImage[] player_up;
	/*
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	*/
	
	
	public static BufferedImage tileWall;
	
	public Spritesheet() {
		//Esse try e catch serve so para caso n ache a imagem
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png")); 	//Pegando o arquivo /res/spritesheet.png
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		player_front = new BufferedImage[2]; 	//2 spritesheet de Player_front
	
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);			//Coordenada 0, 11 e resolucao 16x16
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		/*
		player_up = new BufferedImage[2];
		player_up[0] = Spritesheet.getSprite(70, 11, 16, 16);
		player_up[1] = Spritesheet.getSprite(87, 11, 16, 16);
		
		
		player_down = new BufferedImage[3]; 
		player_down[0] = Spritesheet.getSprite(0, 11, 16, 16);
		
		player_right = new BufferedImage[3]; 
		player_right[0] = Spritesheet.getSprite(0, 11, 16, 16);
		
		player_left = new BufferedImage[1]; 
		player_left[0] = Spritesheet.getSprite(34, 11, 16, 16);
		player_left[1] = Spritesheet.getSprite(51, 11, 16, 16);
		*/
		
		
		tileWall = Spritesheet.getSprite(280, 221, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
		
	}

}
