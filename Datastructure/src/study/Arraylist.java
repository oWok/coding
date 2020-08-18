package study;

public class Arraylist {
	private int size = 0;
	private Object[] elementDate = new Object[100];
	
	public boolean addLast(Object element) {
		
		elementDate[size] = element;
		size++;
				
		return true;
	}
}
