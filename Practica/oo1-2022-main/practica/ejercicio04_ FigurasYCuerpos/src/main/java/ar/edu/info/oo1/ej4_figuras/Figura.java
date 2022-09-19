package ar.edu.info.oo1.ej4_figuras;
/*
 * INTERFACE: es como Java Class, pero solo tiene constantes estaticas y metodos abstractos.
 * Usamos la interfaz para implementar herencia multiple. Una clase Java puede implementar
 * multiples inerfaces java. Todos los metodos en una interfaz son implicitamente publicos
 * y abstractos
 */
public interface Figura {
	public double getArea();
	public double getPerimetro();
}
