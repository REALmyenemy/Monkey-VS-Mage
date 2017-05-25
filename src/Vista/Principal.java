package Vista;

import Controlador.*;
import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;

public class Principal extends JFrame implements Runnable, MouseListener, KeyListener
{

	/**
	 * @return the jugando
	 */
	public static boolean isJugando() {
		return jugando;
	}

	/**
	 * @param aJugando the jugando to set
	 */
	public static void setJugando(boolean aJugando) {
		jugando = aJugando;
	}

	/**
	 * @return the ganador
	 */
	public static boolean isGanador() {
		return ganador;
	}

	/**
	 * @param aGanador the ganador to set
	 */
	public static void setGanador(boolean aGanador) {
		ganador = aGanador;
	}
	/**
	 *
	 * @return
	 */
	public static boolean getJugando()
	{
		return isJugando();
	}
	
	private Thread principal;
	private static boolean jugando=true;
	private static boolean ganador;
	
	public int getTamX()
	{
		return tamX;
	}

	public int getTamY()
	{
		return tamY;
	}
	
	private final int x=4;
	private final int y=3;
	private final int escala=(int)Math.pow(2,8);
	
	private int tamX;
	private int tamY;
	private Image offscreen;
	private Graphics bufferGraphics;
	private static Principal p;
		
	private ArrayList<Imagen> imagenes=new ArrayList<Imagen>();
	private ArrayList<Sprite> sprites=new ArrayList<Sprite>();
	private ArrayList<Personaje>chars=new ArrayList<Personaje>();
	private ArrayList<Proyectil>proyectiles=new ArrayList<Proyectil>();
	private Mono mono;
	private Nuez nuez;
	private Sprite arco;
	private ArrayList<Bola>bolas=new ArrayList<Bola>();

	public Principal()
	{
		initComponents();
		tamX = x*escala;
		tamY = y*escala;
		this.setSize(tamX,tamY);
		try
		{
			//Primero pongo las imágenes
			mono= new Mono(ImageIO.read(new File("img/mono.png")),199,451);
			mono.setHitboxSize(44, 89);
			
			arco=new Sprite(ImageIO.read(new File("img/range.png")),(mono.getPosX()+(int)mono.getHitbox().getWidth())-3,mono.getPosY()-42);			//arco mono -3 -42
			arco.setHitboxSize(55,98);
			
			
			Mago mago= new Mago(ImageIO.read(new File("img/mage.png")),960,330);
			mago.setHitboxSize(49, 89);
			
			Portal portal =new Portal(null,797,159);
			portal.setHitboxSize(93, 443);
			
			Caja [] caja=new Caja[4];
			for (int i=0;i<caja.length;i++)
			{
				caja[i]=new Caja(ImageIO.read(new File("img/largeboxo.png")),732,460-40*i);
				caja[i].setHitboxSize(62, 55);
			}
			
			
			
			
			nuez=new Nuez(ImageIO.read(new File("img/nut.png")),(mono.getPosX()+5+(int)mono.getHitbox().getWidth()/2),((mono.getPosY()+(int)mono.getHitbox().getHeight()/2)),portal,caja,bolas);
			nuez.setHitboxSize(23, 20);
			
			
			
			imagenes.add(new Imagen(ImageIO.read(new File("img/FONDO.png")),0,0));
			imagenes.add(mono);
			imagenes.add(nuez);
			imagenes.add(arco);
			imagenes.add(mago);
			imagenes.add(portal);
			
			for (int i=0;i<caja.length;i++)
				imagenes.add(caja[i]);
			
			
			
			
		}
		catch (IOException ex)
		{
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		for (int i=0;i<imagenes.size();i++)
		{
			imagenes.get(i).start();
		}
		
		addMouseListener(this);
		addKeyListener(this);
		principal = new Thread(this);
		principal.start();
	}

	@Override
	public void update(Graphics g)
	{
		paint(g);
		

	}

	@Override
	public void paint(Graphics g)
	{
		if (bufferGraphics!=null)
		{
			bufferGraphics.clearRect(0,0,p.tamX,p.tamY);
			bufferGraphics.setColor(Color.white);
			Imagen img;
			for (int i = 0; i < imagenes.size(); i++)
			{
				img=imagenes.get(i); //Para acortar
				bufferGraphics.drawImage(img.getSprite(), img.getPosX(), img.getPosY(), null);
			}
			g.drawImage(offscreen,0,0,null);
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		

		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		p = new Principal();
		p.setSize(p.getTamX(), p.getTamY());
		p.setResizable(false);
		p.setVisible(true);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void run()
	{
		offscreen = createImage(p.tamX,p.tamY);
		bufferGraphics = offscreen.getGraphics();
		
		while (isJugando())
		{
			try {
				Thread.sleep(60);
				repaint();
				if (!nuez.getEnMovimiento())
				{
					nuez.setPosX((mono.getPosX()+7+(int)mono.getHitbox().getWidth()/2));
					nuez.setPosY((mono.getPosY()+(int)mono.getHitbox().getHeight()/2));
				}
			} catch (InterruptedException e) {}

		}
	}

	

	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (!nuez.getEnMovimiento())
		{
			int nx=e.getX(),ny=e.getY();
			System.out.println("Click"+" "+nx+" "+ny);
			if (nx>=arco.getPosX() && nx <=arco.getPosX()+arco.getHitbox().getWidth())
				if (ny>=arco.getPosY() && ny <=arco.getPosY()+arco.getHitbox().getHeight())
					nuez.lanzar(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		mono.moverse(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
	


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
