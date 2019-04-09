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
			header.content = element;
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
		if(header.content == null)
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
			header.content = element;
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
		
	}

	@Override
	public int indexOf(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T removeLast() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast(T elem) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSingleLinkedListImpl<T> reverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int isSubList(AbstractSingleLinkedListImpl<T> part) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
