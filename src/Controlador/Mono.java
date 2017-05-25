package Controlador;

import Modelo.Personaje;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Mono extends Personaje
{
	
	public Mono(BufferedImage sprite, int posX, int posY)
	{
		super(sprite, posX, posY);
	}
	
	public void moverse(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT:
				if (this.getPosX()<=565)
					this.setPosX(this.getPosX()+3);
				break;
			case KeyEvent.VK_LEFT:
				if (this.getPosX()>=1)
					this.setPosX(this.getPosX()-3);
				break;
		}
	}

	@Override
	public void run()
	{
		super.run(); //To change body of generated methods, choose Tools | Templates.
		
	}
	
			
	
}
