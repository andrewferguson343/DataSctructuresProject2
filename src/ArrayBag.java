/**
 * 
 */

/**
 * @author gaok
 *
 */
public final class ArrayBag<T> implements BagInterface<T>{

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY=25;
	
	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag()
	{
		this (DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty bag having a given capacity.
    @param desiredCapacity  The integer capacity desired. */
	public ArrayBag(int desiredCapacity)
	{
		bag=(T[]) new Object[desiredCapacity];
		numberOfEntries=0;
	} // end constructor

	
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		boolean errorFlag = true;		
		if(numberOfEntries < bag.length){
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		else {
			errorFlag = false;
		}		
		return errorFlag;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		T buffer  = bag[numberOfEntries - 1];
		bag[numberOfEntries - 1] = null;
		numberOfEntries--;
		return buffer;
		
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return 0;
		}
	}
	

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return false;
		}
		for(int i = 0; i < bag.length; i++) {
			if(bag[i] == anEntry)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		T[] temp = (T[]) new Object[bag.length];
		for(int i = 0; i < bag.length; i++) {
			temp[i]= bag[i];
		}
		return temp;
	}
	
}
