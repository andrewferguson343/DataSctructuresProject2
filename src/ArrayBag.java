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
			
		if(numberOfEntries < bag.length){
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
			return true;
		}		
				
		return false;
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
		for (int i = 0;i < numberOfEntries; i++) {
			if(anEntry == bag[i])
			{
				bag[i] = bag[numberOfEntries -1];
				bag[numberOfEntries-1] = null;
				numberOfEntries--;
				return true;
			}
			
		}
		return false;
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			for (int i = 0; i < bag.length; i++)
			{
				bag[i] = null;
				numberOfEntries = 0;
			}
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0; i <= numberOfEntries-1; i++) {
			if(bag[i] == anEntry) {
				count++;
			}				
		}		
		return count;
		
	}
	

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		
		return getFrequencyOf(anEntry) > 0;
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
