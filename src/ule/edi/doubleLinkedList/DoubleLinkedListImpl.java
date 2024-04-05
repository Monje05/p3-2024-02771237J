package ule.edi.doubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Node;

public class DoubleLinkedListImpl<T> implements DoubleList<T> {


	//	referencia al primer aux de la lista
	private DoubleNode<T> front;

	//	referencia al Último aux de la lista
	private DoubleNode<T> last;


	private class DoubleNode<T> {

		DoubleNode(T element) {
			this.elem = element;
			this.next = null;
			this.prev = null;
		}

		T elem;

		DoubleNode<T> next;
		DoubleNode<T> prev;
	}

	///// ITERADOR normal //////////

	@SuppressWarnings("hiding")
	private class DoubleLinkedListIterator<T> implements Iterator<T> {
		DoubleNode<T> node;
		public DoubleLinkedListIterator(DoubleNode<T> aux) {
		}

		@Override
		public boolean hasNext() {
			// TODO
			return false;
		}
	

		@Override
		public T next() {
		// TODO
			return null;
		}
	}

	////// FIN ITERATOR



	@SuppressWarnings("hiding")
	private class DoubleLinkedListIteratorReverse<T> implements Iterator<T> {
		DoubleNode<T> node;
		public DoubleLinkedListIteratorReverse(DoubleNode<T> aux) {
			// TODO	
			}

		@Override
		public boolean hasNext() {
			// TODO	
			return false;
			}

		@Override
		public T next() {
			// TODO
			return null;
		}
	}
	
	// TODO: añadir clases para el resto de iteradores

	/////

	@SafeVarargs
	public DoubleLinkedListImpl(T...v ) {
		// permite añadir varios elementos a la lista en el constructor
		for (T elem:v) {
			this.addLast(elem);
		}
	}


	@Override
	public boolean isEmpty() {
		return size() == 0;
	}


	@Override
	public void clear() {
		DoubleNode<T> current = front;
		while(current != last) {
			current = current.next;
			current = null;
		}
		
	}

	@Override
	public void addFirst(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}
		DoubleNode<T> nuevo = new DoubleNode<T>(elem);
		if(isEmpty()) {
			front = nuevo;
			last = nuevo;
		} else {
			nuevo.next = front;
			front.prev = nuevo;
			front = nuevo;
		}
		
	}


	@Override
	public void addLast(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}
		DoubleNode<T> nuevo = new DoubleNode<T>(elem);
		if(isEmpty()) {
			front = nuevo;
			last = nuevo;
		} else {
			nuevo.prev = last;
			last.next = nuevo;
			last = nuevo;
		}
		
	}


	@Override
	public void addPos(T elem, int position) {
		if(elem == null) {
			throw new NullPointerException();
		}
		if(position <= 0) {
			throw new IllegalArgumentException();
		}
		if(position == 1) {
			addFirst(elem);
			return;
		}
		DoubleNode<T> current = front;
		for(int i = 0; i < position - 2 && current != null; i++) {
			current = current.next;
		}
		if(current == null) {
			addLast(elem);
			return;
		}
		DoubleNode<T> nuevo = new DoubleNode<T>(elem);
		nuevo.next = current.next;
		nuevo.prev = current;
		if(current.next != null) {
			current.next.prev = nuevo;
		}
		current.next = nuevo;
		if(nuevo.next == null) {
			last = nuevo;
		}
		
	}

	
	@Override
	public T getElemPos(int position) {
		if(position < 1 || position > size()) {
			throw new IllegalArgumentException();
		}
		DoubleNode<T> current = front;
		for(int i = 0; i < position -1; i++) {
			current = current.next;
		}
		return current.elem;
	}


	@Override
	public int getPosFirst(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}
		DoubleNode<T> current = front;
		int pos = 1;
		for(int i = 0; current != null; i++) {
			if(current.elem.equals(elem)) {
				pos = i + 1;
				return pos;
			}
			current = current.next;
		}
		if(pos == 1) {
			throw new NoSuchElementException();
		}
		return pos;
	}


	@Override
	public int getPosLast(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}
		DoubleNode<T> current = front;
		int pos = 1;
		for(int i = 0; current != null; i++) {
			if(current.elem.equals(elem)) {
				pos = i + 1;
			}
			current = current.next;
		}
		if(pos == 1) {
			throw new NoSuchElementException();
		}	
		return pos;
	}

	
	@Override
	public T removeLast()  throws EmptyCollectionException{
		if(isEmpty()) {
			throw new EmptyCollectionException("La lista está vacía.");
		}
		T removeElement = null;
		if(size() == 1) {
			removeElement = front.elem;
			front = front.next;
		} else {
			DoubleNode<T> current = front;
			while(current.next.next != null) {
				current = current.next;
			}
			removeElement = current.next.elem;
			current.next = null; 
		}
		return removeElement;
	}
	

	@Override
	public T removePos(int pos)  throws EmptyCollectionException{
		if(isEmpty()) {
			throw new EmptyCollectionException("La lista está vacía.");
		}
		if(pos < 1 || pos > size()) {
			throw new IllegalArgumentException();
		}
		DoubleNode<T> current = front;
		for(int i = 0; i < pos - 2; i++) {
			current = current.next;
		}
		T removeElement = null;
		if(pos ==  1) {
			removeElement = front.elem;
			front = front.next;
		} else {
			removeElement = current.next.elem;
			current.next = current.next.next;
		}
		return removeElement;
	}


	@Override
	public int removeN(T elem, int times) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public DoubleList<T> copy() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int size() {
		int count = 0;
		DoubleNode<T> current = front;
		while(current != null){
			current = current.next;
			count++;
		}
		return count;
	}


	
	@Override
	public int maxRepeated() {
	// TODO
		return 0;
	}


	@Override
	public void addAfter(T elem, T target) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addAfterAll(T elem, T target) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T removePenul() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int countElem(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean sameElems(DoubleList<T> other) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String toString() {
		String result = "(";
		DoubleNode<T> current = front;
		while (current != null) {
			result += current.elem + " ";
			current = current.next;
		}
		result += ")";
		return result;
	}
	
	@Override
	public String toStringReverse() {
		// TODO
		return "";
	}


	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO
				
		return null;
	}
	
	@Override
	public String toStringFromUntilReverse(int from, int until) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Iterator<T> iterator() {
		return new DoubleLinkedListIterator<>(front);
	}

	@Override
	public Iterator<T> reverseIterator() {
		return new DoubleLinkedListIteratorReverse<>(last);
	}
	

	@Override
	public Iterator<T> progressIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> progressReverseIterator() {
		// TODO Auto-generated method stub
		return null;
	}


}