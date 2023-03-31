package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//SISTEMA DE PREGUNTAS Y RESPUESTAS.
//Se precisa modelar en objetos e implementar un sistema de preguntas y respuestas on-line
//con las siguientes funcionalidades:
//	1. Registrar un usuario: se indica un nombre de usuario y un email.
//	2. Crear una pregunta: se indica el usuario (que es creador de la pregunta) y el texto.
//	Hay dos tipos de preguntas: preguntas técnicas y preguntas de interés general.
//	3. Crear una respuesta: se indica el texto de la respuesta y la pregunta a la que
//	responde. Se debe contar además con el autor de la respuesta (un usuario del
//	sistema).
//	4. Votar positiva o negativamente una respuesta: un usuario (el autor del voto)
//	puede votar a favor o en contra a una respuesta dada. Se registra el voto, con su
//	autor y la fecha en que se produjo. Asuma que un usuario no intentará votar más de
//	una vez en una respuesta.
//	5. Obtener todas las preguntas ya respondidas (con al menos un voto positivo).
//	Devolver todas las preguntas del sistema que tienen al menos una respuesta con un
//	voto positivo.
//	6. Obtener la mejor respuesta de una pregunta. Dada una pregunta, retornar la
//	mejor respuesta (si existe alguna respuesta). La mejor respuesta depende del tipo
//	de pregunta a la que pertenece:
//		a. Pregunta técnica: la mejor respuesta es la que posee mayor adhesión. Para
//		calcular la adhesión de una respuesta se divide el número de votos positivos
//		que tuvo por el número total de votos que tuvo (positivos / (positivos +
//		negativos)). Si dos o más respuestas tienen igual adhesión se devuelve
//		cualquiera de ellas. Si una respuesta no tiene votos el consenso es 0.
//		b. Pregunta de interés general: la mejor respuesta es la que tiene la mayor
//		diferencia de votos (votos positivos - votos negativos). Si dos o más
//		respuestas tienen igual diferencia de votos se devuelve cualquiera de ellas
public class Sistema {
	private List<Usuario> usuarios;
	private List<Pregunta> preguntas;
	
	public Sistema () {
		this.usuarios = new ArrayList<Usuario>();
		this.preguntas = new ArrayList<Pregunta>();
	}
	
	public void registrarUsuario(Usuario u) {
		this.usuarios.add(u);
	}
	public void agregarPregunta(Pregunta p) {
		this.preguntas.add(p);
	}
	public void agregarRespuesta(Respuesta r, Pregunta p) {
		p.agregarRespuesta(r);
	}
	public List<Pregunta> respondidas(){
		return this.preguntas.stream().filter(p -> p.fueRespondida()).collect(Collectors.toList());
	}
	
}
