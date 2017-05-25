
package Controlador;

import Modelo.Personaje;
import Modelo.Sprite;
import java.awt.image.BufferedImage;

public class Proyectil extends Sprite
{
	private boolean vivo=true;
	
	
	public Proyectil(BufferedImage sprite, int posX, int posY)
	{
		super(sprite,posX,posY);
	}
	
//	public void comprobar_colision(Proyectil s)
//	{
//		if (this.getHitbox().intersects(s.getHitbox()))
//		{
//			vivo=false;
//			s.setVivo(false);
//		}
//	}
	
	public void comprobar_colision(Portal s) //////
	{
	}
	
	public void comprobar_colision(Caja s) //////
	{
		if (this.getHitbox().intersects(s.getHitbox()))
		{
			
		}
	}
	
	
	public void comprobar_colision(Personaje s) //////
	{
		if (this.getHitbox().intersects(s.getHitbox()))
		{
			
		}
	}


	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

}
