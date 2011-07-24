package corotos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class cuadrada extends figura{
	Vector<enlazante> enlaces;
	
	String nombre;
	
	public cuadrada(int ID, Point posicionAbsoluta) {
		super(
				ID,
				new Rectangle(posicionAbsoluta,	new Dimension(G,G))
				);
		enlaces=new Vector<enlazante>(1, 1);
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		
		for (figura elemento : enlaces) {
			if(elemento.dentroFigura(p))
				return true;
		}
		return region.contains(p);
	}

	@Override
	public void dibujar(Graphics g) {
		for (figura elemento : enlaces) {
			elemento.dibujar(g);
		}
		g.fillRect(region.getLocation().x, region.getLocation().y, region.width, region.height);
		
	}
	
	public void anyadirEnlazante(tipoEnlace tipo, lados lado){
		Point posicion=null;
		switch (lado) {
		case ABAJO:
			posicion=translacionPto(region.getLocation(), 0, +G);
			break;
		case ARRIBA:
			posicion=translacionPto(region.getLocation(), 0, -P);
			break;
		case IZQUIERDA:
			posicion=translacionPto(region.getLocation(), -P, 0);
			break;
		case DERECHA:
			posicion=translacionPto(region.getLocation(), +G, 0);
			break;
		default:
			break;
		}
		enlaces.add(
				new enlazante(
						ID,
						tipo,
						(lado==lados.DERECHA||lado==lados.IZQUIERDA)?orientacionEnlace.VERTICAL:orientacionEnlace.HORIZONTAL,
						lado,
						posicion
						)
				);
		
		
	}

	@Override
	public void mover(Point p) {
		// TODO Auto-generated method stub
		
	}

}