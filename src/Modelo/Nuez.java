package Modelo;

import Controlador.*;
import Vista.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Nuez extends Proyectil
{

	private boolean enMovimiento=false;
	
	private float movX, movY;
	private final int framerate=100;
	private float realPosX,realPosY;
	private Portal portal;
	private Caja[] caja;
	private ArrayList<Bola>bolas;
	
	public Nuez(BufferedImage sprite, int posX, int posY, Portal por,Caja[] caja,ArrayList<Bola> bola)
	{
		super(sprite, posX, posY);
		portal=por;
		this.caja=caja;
		bolas=bola;
	}
	
	public void lanzar(MouseEvent e)
	{
		float cX=e.getX();
		float cY=e.getY();
		float pY=this.getPosY()+(int)this.getHitbox().getHeight();
		float pX=this.getPosX()+(int)this.getHitbox().getWidth()/2;
		if (cX>=pX&&cY<=pY)
		{
			this.setVivo(true);
			float segmento1=cX-pX;
			float segmento2=cY-pY;
			//float hipotenusa=(float)Math.pow((Math.pow(segmento1, 2)+Math.pow(segmento2, 2)), 0.5);
			//voy a simplificarlo en números más sencillos, iba a usar seno, coseno, etc...
			
			//movX=segmento1/segmento2*hipotenusa;
			//movY=segmento2/segmento1*hipotenusa;
			
			//movX=(float) (segmento1*Math.cos(hipotenusa)/framerate);
			//movY=(float) (segmento2*Math.sin(hipotenusa)/framerate);
			
			movX=segmento1/segmento2;
			movY=segmento2/segmento1;
			
			
			
			if (movX<0)
				movX*=-1;
			
			System.out.println("mov "+movX+" "+movY);
			
			realPosX=this.getPosX();
			realPosY=this.getPosY();
			
			enMovimiento=true;
			
		}
	}

	public void run()
	{
		
		while (Principal.getJugando())
		{	
			if (enMovimiento)
			{
				realPosX+=movX;
				realPosY+=movY;
				
				this.setPosX((int)realPosX);
				this.setPosY((int)realPosY);
				
				System.out.println("Me muevo "+this.getPosX()+" "+this.getPosY());
				
				if (this.getPosX()>1024|| this.getPosY()<=-5 || this.getPosY()>768)
				{
					movX=movY=0;
					enMovimiento=false;
				}
				try {
					Thread.sleep(framerate);
				} catch (InterruptedException ex) {
				}
			}else
				System.out.println("");
			
			if (!this.isVivo())
			{
				enMovimiento=false;
			}
			
			comprobar_colision();
			
		}
	}
	
	public boolean getEnMovimiento()
	{
		return enMovimiento;
	}
	public void comprobar_colision() {
		if (this.getHitbox().intersects(portal.getHitbox()))
		{
			if (portal.reducir_vida())
			{
				this.setVivo(false);
				enMovimiento=false;
			}
				
			
		}
	}
	
	
	
	
}
