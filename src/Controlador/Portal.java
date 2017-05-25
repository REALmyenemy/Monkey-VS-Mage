package Controlador;

import Modelo.Sprite;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Portal extends Sprite
{
	private static BufferedImage[] sprites=new BufferedImage[4];
	private int vida=3;
	
	public Portal(BufferedImage sprite, int posX, int posY)
	{
		super(sprite,posX,posY);
		for (int i=0;i<=vida;i++)
		{
			try {
				sprites[i]=ImageIO.read(new File("img/wall"+i+".png"));
			} catch (IOException ex) {
				Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		ajustarSprite();
	}
	
	private void ajustarSprite()
	{
		this.setSprite(sprites[sprites.length-(vida+1)]);
	}
	
	public boolean reducir_vida()
	{
		if (vida>0)
		{
			vida--;
			ajustarSprite();
			return true;
		}
		
		return false;
	}
			
	
	
}
