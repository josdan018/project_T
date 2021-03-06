package corotos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class figura implements valor{
	int ID;
	Point centro;
	Point posicionRelativa;
	boolean seleccionada;
	Rectangle region;
	Color color;
	
	
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);
	public abstract void mover(Point p);
	
	public figura() {
		
	}
	
	public figura(int ID, Rectangle region,Point posicionRelativa) {
		this.ID = ID;
		this.region=region;
		this.posicionRelativa=posicionRelativa;
		
	}
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public Point getCentro() {
		return centro;
	}
	
	public void setCentro(Point centro) {
		this.centro = centro;
	}
	
	public boolean getSelecionada(){
		return seleccionada;
	}
	
	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}
	
	public Rectangle getRegion() {
		return region;
	}
	
	public void setRegion(Rectangle region) {
		this.region = region;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public static Point translacionPto(Point posicion,int dx, int dy){
		Point aMover=new Point(posicion);
		aMover.translate(dx, dy);
		return aMover;
	}
	
	public void setPosicion(Point p){
		region.setLocation(p);
		
	}
	
	
	
	
	
}
