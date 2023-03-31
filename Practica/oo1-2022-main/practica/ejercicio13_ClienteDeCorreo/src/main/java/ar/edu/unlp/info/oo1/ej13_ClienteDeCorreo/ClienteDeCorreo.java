package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private List<Carpeta> carpetas;
	private Carpeta inbox;
	
	public ClienteDeCorreo() {
		carpetas = new ArrayList<Carpeta>();
		inbox = new Carpeta("inbox");		
	}
	
	/*
	En respuesta al mensaje #recibir, almacena en el inbox (una de las carpetas) el
	email que recibe como parámetro.
	*/
	public void recibir (Email email) {
		inbox.agregarEmail(email);
	}
	
	/*
	En respuesta al mensaje #mover, mueve el email que viene como parámetro de la
	carpeta origen a la carpeta destino (asuma que el email está en la carpeta origen
	cuando se recibe este mensaje).
	*/
	public void mover (Email email, Carpeta origen, Carpeta destino) {
		destino.agregarEmail(email);
		origen.eliminarEmail(email);
	}
	
	/*
	En respuesta al mensaje #buscar retorna el primer email que encuentra cuyo título o
	cuerpo contienen el texto indicado como parámetro. Busca en todas las carpetas.
	*/
	public Email buscar(String texto) {
		return this.carpetas.stream()
				.map(carpeta -> carpeta.busquedaEmail(texto)) //me puede devolver stream de nulls
				.filter(email -> email != null)	
				.findFirst().orElse(null);
	}
	
	/*
	En respuesta al mensaje #espacioOcupado, retorna la suma del espacio ocupado
	por todos los emails de todas las carpetas.
	*/
	public int espacioOcupado() {
		return carpetas.stream()
				.mapToInt(carpeta -> carpeta.tamanioCarpeta())
				.sum();
	}
	
}
