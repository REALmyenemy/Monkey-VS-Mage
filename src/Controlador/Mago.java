package Controlador;

import Modelo.Personaje;
import Vista.Principal;
import java.awt.image.BufferedImage;

public class Mago extends Personaje
{
	private boolean right=false;
	public Mago(BufferedImage sprite, int posX, int posY)
	{
		super(sprite, posX, posY);
	}
	
	

	@Override
	public void run() {
		super.run(); //To change body of generated methods, choose Tools | Templates.
		while (Principal.getJugando())
		{
			if (this.getPosX()>=1024-50)
				right=false;
			else
				if (this.getPosX()<=880)
				{
					right=true;
				}
			moverse();
			try {
				Thread.sleep(58);
			} catch (InterruptedException ex) {
			}
		}		
		
	}
	
	public void moverse()
	{
		if (right)
		{
			this.setPosX(this.getPosX()+5);
		}
		else
		{
			this.setPosX(this.getPosX()-5);
		}
	}
			
	
	
	
}
