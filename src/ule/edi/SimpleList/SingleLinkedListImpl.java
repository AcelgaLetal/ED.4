package ule.edi.SimpleList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SingleLinkedListImpl<T> extends AbstractSingleLinkedListImpl<T> {
	
	public SingleLinkedListImpl(T ... elements)
	{		
		// IMPLEMENTAR DE FORMA RECURSIVA 
		initRecurs(0, elements);
		
    }
	public void initRecurs(int counter, T ... elements)
	{
		if(counter == elements.length)
		{
			return;
		}
		else
		{
			addLast(elements[counter]);
			initRecurs(counter + 1, elements);
		}
	}
		
	@Override
	public void addLast(T element)
	{
		if(isEmpty())
		{
			Node<T> nuevo = new Node<T>(element);
			header = nuevo;
		}
		else
		{
			Node<T> aux = new Node<T>(null);
			Node<T> nuevo = new Node<T>(element);
			aux.next = header.next;
			
			if(aux.next == null)
			{
				header.next = nuevo;
			}
			else
			{
				aux.next = addNewNode(aux.next);
				aux.next.next = nuevo;
			}
		}
	}
	
	public Node<T> addNewNode(Node<T> actual)
	{
		Node<T> aux = new Node<T>(null);
		
		aux.next = actual;
		
		if(aux.next.next == null)
		{
			return aux.next;
		}
		else
		{
			aux.next = aux.next.next;
			return addNewNode(aux.next);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(header == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			Node<T> aux = new Node<T>(null);
			aux.next = header.next;
			
			if(aux.next == null)
			{
				return 1;
			}
			else
			{
				return recurSize(2, aux.next);
			}
		}
	}
	
	public int recurSize(int counter, Node<T> actual)
	{
		Node<T> aux = new Node<T>(null);
		
		aux.next = actual;
		
		if(aux.next.next == null)
		{
			return counter;
		}
		else
		{
			aux.next = aux.next.next;
			return recurSize(counter + 1, aux.next);
		}
	}

	@Override
	public void addFirst(T element)
	{
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			Node<T> nuevo = new Node<T>(element);
			header = nuevo;
		}
		else
		{
			Node<T> nuevo = new Node<T>(element);
			
			nuevo.next = header;
			header = nuevo;
		}
	}

	

	@Override
	public void addAtPos(T element, int p)
	{
		// TODO Auto-generated method stub
		Node<T> aux = new Node<T>(null);
		Node<T> nuevo = new Node<T>(element);
		
		if(p > size())
		{
			addLast(element);
		}
		else
		{
			if(p == 1)
			{
				addFirst(element);
			}
			else if(p == 2)
			{
				nuevo.next = header.next;
				header.next = nuevo;
			}
			else
			{
				aux.next = header.next;
				aux.next = recurAddAtPos(2, p, aux.next);
				nuevo.next = aux.next.next;
				aux.next.next = nuevo;
			}	
		}
	}
	
	public Node<T> recurAddAtPos(int counter, int p, Node<T> actual)
	{
		Node<T> aux = new Node<T>(null);
		aux.next = actual;
		
		if(counter == p - 1)
		{
			return aux.next;
		}
		else
		{
			aux.next = aux.next.next;
			return recurAddAtPos(counter + 1, p, aux.next);
		}
	}

	@Override
	public void addNTimes(T element, int n)
	{
		// TODO Auto-generated method stub
		if(n == 1)
		{
			addLast(element);
			return;
		}
		else
		{
			addLast(element);
			addNTimes(element, n - 1);
			return;
		}
		
	}

	@Override
	public int indexOf(T elem)
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			int index = 0;
			
			if(header.content == elem)
			{
				return 1;
			}
			else
			{
				Node<T> aux = new Node<T>(null);
				
				aux.next = header.next;
				index = recurIndexOf(aux.next, elem, 2);
				
				if(index == -1)
				{
					throw new NoSuchElementException();
				}
				else
				{
					return index;
				}
			}
		}
	}
	
	public int recurIndexOf(Node<T> actual, T elem, int p)
	{
		Node<T> aux = new Node<T>(null);
		aux.next = actual;
		
		if(aux.next.content == elem)
		{
			return p;
		}
		else if(aux.next == null)
		{
			return -1;
		}
		else
		{
			aux.next = aux.next.next;
			return recurIndexOf(aux.next, elem, p + 1);
		}
		
	}

	@Override
	public T removeLast() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		
		if(isEmpty())
		{
			throw new EmptyCollectionException("La lista esta vacia");
		}
		else
		{
			T elem = null;
			
			if(header.next == null)
			{
				elem = header.content;
				header = null;
				return elem;
			}
			else if(header.next.next == null)
			{
				elem = header.next.content;
				header.next = null;
				return elem;
			}
			else
			{
				Node<T> aux = new Node<T>(null);
				aux.next = header.next;
				
				aux.next = recurRemoveLast(aux.next, null);
				elem = aux.next.next.content;
				aux.next.next = null;
				return elem;
			}
		}
	}
	
	public Node<T> recurRemoveLast(Node<T> actual, T elem)
	{
		Node<T> aux = new Node<T>(null);
		aux.next = actual;
		
		if(aux.next.next.next == elem)
		{
			return aux.next;
		}
		else
		{
			aux.next = aux.next.next;
			return recurRemoveLast(aux.next, elem);
		}
		
	}

	@Override
	public T removeLast(T elem) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new EmptyCollectionException("La lista esta vacia");
		}
		else
		{
			T returnElem = null;
			
			if(header.content == elem)
			{
				returnElem = header.content;
				header = header.next;
				return returnElem;
			}
			else if(header.next.content == elem)
			{
				returnElem = header.next.content;
				header.next = header.next.next;
				return returnElem;
			}
			else
			{
				Node<T> aux = new Node<T>(null);
				aux.next = header.next;
				
				aux.next = recur2RemoveLast(aux.next, elem);
				returnElem = aux.next.next.content;
				aux.next.next = aux.next.next.next;
				return returnElem;
			}
		}
		
		
	}
	public Node<T> recur2RemoveLast(Node<T> actual, T elem)
	{
		Node<T> aux = new Node<T>(null);
		aux.next = actual;
		
		if(aux.next.next.content == elem)
		{
			return aux.next;
		}
		else
		{
			aux.next = aux.next.next;
			return recur2RemoveLast(aux.next, elem);
		}
	}

	@Override
	public AbstractSingleLinkedListImpl<T> reverse()
	{
		// TODO Auto-generated method stub
		
		return recurReverse(size());
		
	}
	public AbstractSingleLinkedListImpl recurReverse(int count)
	{
		if (count == 0)
		{
			return this;
		}
		else
		{
			Node<T> aux = new Node<T>(null);
			aux.next = header;
			header = header.next;
			addAtPos(aux.next.content, count);
			return recurReverse(count - 1);
		}
	}
	

	@Override
	public int isSubList(AbstractSingleLinkedListImpl<T> part) 
	{
		if(part.isEmpty())
		{
			return 1;
		}
		else
		{
			return recurIsSubList(part, header, 1);
		}
	}
	
	public int recurIsSubList(AbstractSingleLinkedListImpl<T> part, Node<T> actual, int count)
	{
		if(count > size())
		{
			return -1;
		}
		if(actual.content == part.header.content)
		{
			if(recurAuxSubList(part.header, actual, 1, part.size(), count))
			{
				return count;
			}
			else
			{
				Node<T> aux = new Node<T>(null);
				aux.next = actual;
				aux.next = aux.next.next;
				return recurIsSubList(part, aux.next, count + 1);
			}
		}
		else
		{
			Node<T> aux = new Node<T>(null);
			aux.next = actual;
			aux.next = aux.next.next;
			return recurIsSubList(part, aux.next, count + 1);
		}
	}
	public boolean recurAuxSubList(Node<T> partNode, Node<T> actual, int count, int tam, int posAct)
	{
		if((size() - posAct) < tam)
		{
			return false;
		}
		if(count == tam)
		{
			return true;
		}
		else
		{
			Node<T> aux = new Node<T>(null);
			Node<T> auxPart = new Node<T>(null);
			
			aux.next = actual;
			auxPart.next = partNode;
			
			if(aux.next.next.content != auxPart.next.next.content)
			{
				return false;
			}
			else
			{
				aux.next = aux.next.next;
				auxPart.next = auxPart.next.next;
				return recurAuxSubList(auxPart.next, aux.next, count + 1, tam, posAct);
			}
		}
	}

	
}
