
package Modelo;

import java.awt.image.BufferedImage;

public class Imagen extends Thread //No lo usará la imagen puramente, pero si todo lo que lo hereda
{
	private BufferedImage sprite;
	private int posX,posY;
	
	public Imagen(BufferedImage sprite, int posX,int posY)
	{
		this.sprite=sprite;
		this.posX=posX;
		this.posY=posY;
	}
	

	public BufferedImage getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	public int getPosX() {
		return posX;
	}

	public synchronized void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public synchronized void setPosY(int posY) {
		this.posY = posY;
	}
	
}
