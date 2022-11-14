package ar.edu.unlp.info.oo1;

import java.util.Comparator;

public class PreguntaTecnica extends Pregunta{

	public PreguntaTecnica(String texto, Usuario autor) {
		super(texto, autor);
	}

//	@Override
//	public Respuesta mejorRespuesta() {
//		// aqui algo huele mal
//		return this.respuestas.stream().
//				max(Comparator.comparing(Respuesta::adhesion)).
//				orElse(null);
//	}
	
	public Comparator<Respuesta> comparador(){
		return Comparator.comparing(Respuesta::adhesion);
	}
	
}
