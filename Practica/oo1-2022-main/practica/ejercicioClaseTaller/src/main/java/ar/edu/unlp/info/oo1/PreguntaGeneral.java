package ar.edu.unlp.info.oo1;

import java.util.Comparator;

public class PreguntaGeneral extends Pregunta{

	public PreguntaGeneral(String texto, Usuario autor) {
		super(texto, autor);
	}

//	@Override
//	public Respuesta mejorRespuesta() {
//		// aqui algo huele mal
//		return this.respuestas.stream().
//				max(Comparator.comparingInt(Respuesta::diferenciaDeVotos)).
//				orElse(null);
//
//	}
	
	public Comparator<Respuesta> comparador(){
		return Comparator.comparingInt(Respuesta::diferenciaDeVotos);
	}

}
