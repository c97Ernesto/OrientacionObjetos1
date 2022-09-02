package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	/**
	 * Complete con su implementación
	 */
	
	private String text;
	private int likes;
	private boolean featured;
	
	
	/*
	* Permite construir una instancia del WallpostImpl.
	* Luego de la invocación, debe tener como texto: “Undefined post”,
	* no debe estar marcado como destacado y la cantidad de “Me gusta” deben ser 0.
	*/
	public WallPostImpl() {
		this.text = "Undefined post";
		this.featured = false;
		this.likes = 0;
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }
    
    /*
    * Retorna el texto descriptivo de la publicación
    */
	@Override
	public String getText() {
		return this.text;
	}
	
	/*
	* setea el texto descriptivo de la publicación
	*/
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	/*
	* retorna la cantidad de “me gusta”
	*/
	@Override
	public int getLikes() {
		return this.likes;
	}

	/*
	* Incrementa la cantidad de likes en uno y retorna la instancia de Wallpost.
	*/
	@Override
	public WallPost like() {
		this.likes++;
		return this;
	}

	/*
	* Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada. Retorna la
	instancia de Wallpost.
	*/
	@Override
	public WallPost dislike() {
		if (this.likes > 0) {
			this.likes--;
		}
		return this;
	}

	/*
	* Retorna true si el post está marcado como destacado, false en caso contrario
	*/
	@Override
	public boolean isFeatured() {
		return featured;
	}
	
	/*
	* Cambia el post del estado destacado a no destacado y viceversa. Retorna la
	instancia de Wallpost.
	*/
	@Override
	public WallPost toggleFeatured() {
		featured = !featured;
		return this;
	}

}
 