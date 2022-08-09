package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	//Cordenadas da imagem dentro da spritesheet.png
	public static BufferedImage player_front;		
	
	public Spritesheet() {
		//Esse try e catch serve so para caso n ache a imagem
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png")); 	//Pegando o arquivo /res/spritesheet.png
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		player_front = Spritesheet.getSprite(0, 11, 16, 16);	//Coordenada 0, 11 e resolucao 16x16
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
		
	}

}
