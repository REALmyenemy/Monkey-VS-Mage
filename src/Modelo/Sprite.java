package Modelo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sprite extends Imagen
{
	private Rectangle hitbox;
	
	public Sprite(BufferedImage sprite, int posX, int posY)
	{
		super(sprite,posX,posY);
		hitbox=new Rectangle(posX,posY);
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox)
	{
		this.hitbox = hitbox;
	}
	
	public void setHitboxPos(int x, int y)
	{
		hitbox.x=x;
		hitbox.y=y;
	}
	
	public Dimension getHitboxPos()
	{
		return new Dimension(hitbox.x,hitbox.y);
	}
	
	public void setHitboxSize(int x, int y)
	{
		hitbox.width=x;
		hitbox.height=y;
	}
	
	public Dimension getHitboxSize()
	{
		return new Dimension(hitbox.width,hitbox.height);
	}
	
	
	

}
