package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Pregunta extends Post{
	
	protected List<Respuesta> respuestas;
	
	public Pregunta(String texto, Usuario autor) {
		super(texto, autor);
		this.respuestas = new ArrayList<Respuesta>();
	}
	
	/*Como no sé a que tipo de Pregunta hago referencia (general o técnica), lo planteo como abstracto
	 * y que cada clase concreta haga su implementación*/
//	public abstract Respuesta mejorRespuesta();
	public abstract Comparator<Respuesta> comparador();
	
	public Respuesta mejorRespuesta() {
		return this.respuestas.stream()
				.max(this.comparador())
				.orElse(null);
	}
	
	
	public boolean fueRespondida() {
		return this.respuestas.stream().anyMatch(r -> r.fueRespondida());
	}
	
	public void agregarRespuesta(Respuesta r) {
		this.respuestas.add(r);
	}

}
