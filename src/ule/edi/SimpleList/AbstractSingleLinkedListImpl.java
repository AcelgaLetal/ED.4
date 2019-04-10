package ule.edi.SimpleList;

import java.util.NoSuchElementException;

public abstract class AbstractSingleLinkedListImpl<T> implements SingleLinkedList<T> {

	/**
	 * indica si la lista estÃ¡ vacÃ­a.
	 *  @return true si la lista es vacÃ­a, false en caso contrario
	 */
	public abstract boolean isEmpty();
	
	/**
	 *    Implementar de forma RECURSIVA
	 *  
	 * Devuelve el nÃºmero de elementos de la lista.
	 *  @return numero de elementos de la lista
	 */
	public abstract int size();
	
	/**
	 * Inserta un elemento como primero.
	 * @param element a insertar
	 */
	public abstract void addFirst(T element);
	
	/**
	 *    Implementar de forma RECURSIVA
	 *  
	 * Inserta un elemento como Ãºltimo.
	 *
	 * @param element a insertar
	 */
	public abstract  void addLast(T element);

	
	/**
	 *     Implementar de forma RECURSIVA
	 *  
	 * Inserta el elemento en la posiciÃ³n p, desplazando los elementos a partir de esa posiciÃ³n. 
	 * Si la lista tiene menos de n elementos lo insertarÃ¡ como Ãºltimo elemento.
	 * 
	 * Si la lista era [A, B, C] :
	 *       lista.addAtPos(â€œZâ€�, 1) dejarÃ¡ la lista como [Z, A, B, C].
	 *       lista.addAtPos(â€œZâ€�, 3) dejarÃ¡ la lista como [A, B, Z, C].
	 *       lista.addAtPos(â€œZâ€�, 5) dejarÃ¡ la lista como [A, B, C, Z].
	 *       
	 * @param element a insertar
	 * @param pos posicion en la que se insertarÃ¡ el elemento, desplazando los siguientes
	 * @throw IllegalArgumentException si p<=0
	 */
	public abstract void addAtPos(T element, int p);
	
	/**
	 *   Implementar de forma RECURSIVA
	 *  
	 * inserta n veces el elemento al final de la lista.
	 * Si lista=[A, B, C], lista.addNTimes(â€œZâ€�, 4) dejarÃ¡ la lista como: [A, B, C, Z, Z, Z, Z]
	 *       
	 * @param element a insertar
	 * @param p posicion en la que se insertarÃ¡ el elemento, desplazando los siguientes
	 * @throw IllegalArgumentException si N<0
	 */
	public abstract void addNTimes(T element, int n);

	
	
	/**
	 *    Implementar de forma RECURSIVA
	 *  
	 * Indica la posiciÃ³n donde se encuentra la primera apariciÃ³n de elem desde el principio de la lista (las posiciones empiezan en 1). 
	 * Si n es menor que 1, no hace nada
	 * Dispara la excepciÃ³n NoSuchElementException si no se encuentra el elemento en la lista.
	 *       
	 * @param elem  el elemento a buscar 
	 * @return la posiciÃ³n que ocupa el elemento en la lista
	 * @throws NoSuchElementException si no se encuentra el elemento en la lista.
	 */
	public abstract int indexOf(T elem);
	
	
	/**
	 * 	 Implementar de forma RECURSIVA
	 *  
	 * Elimina el Ãºltimo elemento de la lista.
	 * 
	 * @return el elemento que es eliminado
	 * @throws EmptyCollectionException si la lista estÃ¡ vacÃ­a
	 */
	public abstract T removeLast() throws EmptyCollectionException ;

	/**
	 *   Implementar de forma RECURSIVA
	 *  
	 * Elimina la Ãºltima apariciÃ³n del elemento.
	 * Si la lista es vacÃ­a dispara la excepciÃ³n EmptyCollectionException.
	 * 
	 * Si lista=[A, C, B, C, D, C] 
	 * 		lista.removeLast(â€œCâ€�) dejarÃ¡ a lista=[A, C, B, C, D]
	 * 
	 * @param elem  el elemento a eliminar 
	 * @return el elemento que es eliminado
	 * @throws EmptyCollectionException si la lista estÃ¡ vacÃ­a
	 * @throws NoSuchElementException si no se encuentra el elemento en la lista
	 */
	public abstract T removeLast(T elem) throws EmptyCollectionException;

	
	/**
	 * 
	 * 	  Implementar de forma RECURSIVA
	 *  
	 * Devuelve la lista inversa de la lista actual. 
	 * Deja la lista actual sin modificar.
	 * Por ejemplo, si la lista era [A, B, C], la lista devuelta serÃ¡ [C,B,A]
	 * 
	 */
	public abstract AbstractSingleLinkedListImpl<T> reverse();
	
	
	
	
	/**
	 *   
	 * 	  Implementar de forma RECURSIVA
	 *  
	 * Indica a partir de quÃ© posiciÃ³n se encuentra la sublista pasada como parÃ¡metro en la lista actual o -1 si no se encuentra.
	 * Si part es vacÃ­a devuelve 1
	 * 
	 * Ejemplos:
	 * 
	 *  [A, B, A, B, C], con part=[B, A, X], devolverÃ­a -1 
	 *  [A, B, A, B, C], con part=[B, A], devolverÃ­a 2 
	 *
	 *  [A, B, A, B], con part=[A, B], devolverÃ­a 1 
	 *  
	 *  [A, B, A, B, C, X, A], con part=[B, C, X], devolverÃ­a 4
	 *    
	 * @param part lista a comprobar si es sublista de la actual
	 * @return posiciÃ³n a partir de la que se encuentra la sublista en la lista actual
	 */
	public abstract int isSubList(AbstractSingleLinkedListImpl<T> part) ;
	//	estructura de datos y mÃ©todos ya implementados

	static class Node<G> {
		
		public Node(G element) {
			this.content = element;
			this.next = null;
		}
		
		G content;
		
		Node<G> next;
	}
	
	protected Node<T> header;

	
	@Override
	public String toString() {
		if (header != null) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			Node<T> i = header;
			while (i != null) {
				rx.append(i.content);
				rx.append(", ");
				i = i.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			
			return rx.toString();
		} else {
			return "[]";
		}
	}

	
	

}
