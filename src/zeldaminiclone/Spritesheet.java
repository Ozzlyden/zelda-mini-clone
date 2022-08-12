package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	//Cordenadas da imagem dentro da spritesheet.png
	
	public static BufferedImage[] player_front;		//Array de Imagens do Player de frente
	
	public static BufferedImage[] enemy_front;
	
	
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
		enemy_front = new BufferedImage[2];
	
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);			//Coordenada 0, 11 e resolucao 16x16
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		
		
		enemy_front[0] = Spritesheet.getSprite(109, 224, 16, 16);
		enemy_front[1] = Spritesheet.getSprite(126, 224, 16, 16);
		
		
		
		
		tileWall = Spritesheet.getSprite(280, 221, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
		
	}

}
