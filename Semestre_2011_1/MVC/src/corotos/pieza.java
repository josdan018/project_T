package corotos;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class pieza extends figura{
	Vector<cuadrada> cuadrados;
	tipoPieza identificador;
	
	public pieza(int ID, Rectangle region, tipoPieza identificador, Vector<String> nombres) {
		super(ID, region,new Point(0,0));
		System.out.println(ID +" ------------------->nueva");
		this.identificador=identificador;
		cuadrados=new Vector<cuadrada>(1, 1);
		switch (identificador) {
		case COMPILADOR:
			armarCompilador(nombres);
			break;
		case INTERPRETE:
			armarInterprete(nombres);
			break;
		case MAQUINA:
			armarMaquina(nombres);
			break;
		case PROGRAMA:
			armarPrograma(nombres);
		default:
			break;
		}
		
		
	}
	public pieza (){ 
	}
	
@Override
	public boolean dentroFigura(Point p) {
		if(region.contains(p))
			return true;
		for(cuadrada elemento:cuadrados){
			if(elemento.dentroFigura(p))
				return true;
		}
		return false;
	}

	public Vector<cuadrada> getCuadrados() {
		return cuadrados;
	}
	
	
	
	@Override
	public void dibujar(Graphics g) {
		for(cuadrada elemento:cuadrados){
			elemento.dibujar(g);
		}
		
		
	}
	
	public cuadrada retornaCuadrada(Point p){
		for(cuadrada elemento:cuadrados){
			if(elemento.dentroFigura(p))
				return elemento;
		}
		return null;
	}
	
	@Override
	public void mover(Point p) {
		for(cuadrada elemento:cuadrados){
			elemento.mover(p);
		}
	}
	
	public tipoPieza getIdentificador() {
		return identificador;
	}
	
	
	
	private void armarCompilador(Vector<String> nombres){
		//-------centro del compilador----------------
		cuadrada aux=new cuadrada(ID, region.getLocation(),new Point(0, 0),""/*,soy.NINGUNO*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.IZQUIERDA);
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.DERECHA);
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.ABAJO);
		cuadrados.add(aux);
		//-------izquierda del compilador----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), -G-P, 0),new Point(-G-P, 0),nombres.get(0)/*,soy.ENTRADA*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.IZQUIERDA);
		cuadrados.add(aux);
		//-------derecha del compilador----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), +G+P, 0),new Point(+G+P, 0),nombres.get(1)/*,soy.SALIDA*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.BLOQUEADO, lados.DERECHA);
		cuadrados.add(aux);
		//-------abajo del compilador----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), 0, +G+P),new Point(0, +G+P),nombres.get(2)/*,soy.BASE*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.IZQUIERDA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.DERECHA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.ABAJO);
		cuadrados.add(aux);
		
		
	}
	private void armarPrograma(Vector<String> nombres) {
		//-------centro del Programa----------------
		cuadrada aux=new cuadrada(ID, region.getLocation(),new Point(0, 0),nombres.get(0)/*,soy.ENTRADA*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.ARRIBA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.ABAJO);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.IZQUIERDA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.DERECHA);
		cuadrados.add(aux);
		//-------arriba del programa----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), 0, -G-P),new Point(0, -G-P),nombres.get(1)/*,soy.SALIDA*/,cuadrados.size());
		cuadrados.add(aux);
		
	}


	private void armarMaquina(Vector<String> nombres) {
		//-------centro de la maquina----------------
		cuadrada aux=new cuadrada(ID, region.getLocation(),new Point(0, 0),nombres.get(0)/*,soy.ENTRADA*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.ARRIBA);
		aux.anyadirEnlazante(tipoEnlace.TRIANGULAR, lados.ABAJO);
		cuadrados.add(aux);
	}


	private void armarInterprete(Vector<String> nombres) {
		//-------centro del interprete----------------
		cuadrada aux=new cuadrada(ID, region.getLocation(),new Point(0, 0),nombres.get(0)/*,soy.SALIDA*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.ARRIBA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.ABAJO);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.DERECHA);
		cuadrados.add(aux);
		//-------arriba del interprete----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), 0,-G-P),new Point(0, -G-P),nombres.get(0)/*,soy.ENTRADA*/,cuadrados.size());
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.ARRIBA);
		cuadrados.add(aux);
	}

}
