import java.util.*;



public class Vector {

	private Long sum;
	private Long mode;
	private Long median;
	private Long minimum;
	private Long maximum;

	private final int length;
	private final long[] elements;

	// ===========================================================================
	// INITIALIZATION
	// ===========================================================================

	/**
	 * Constructs new vector with the given
	 * length and all elements set to zero.
	 */
	public Vector(int length) {

		this.sum = null;
		this.mode = null;
		this.median = null;
		this.minimum = null;
		this.maximum = null;

		this.length = length;
		this.elements = new long[length];
	}

	/**
	 * Returns new vector with elements generated at random up to 100.
	 */
	public static Vector random(int length, int seed) {

		Vector vector = new Vector(length);
		Random random = new Random(seed);

		for (int i = 0; i < length; i++) {
			vector.elements[i] = (long) random.nextInt(101);
		}
		return vector;
	}

	/**
	 * Returns new vector with all elements set to given value.
	 */
	public static Vector uniform(int length, long value) {
        
      Vector vecuni = new Vector(length);
		
	  for (int i = 0; i < length; i++){
	      vecuni.elements[i] = (long)value;  
		}
	  //since all elements equal value
	  vecuni.mode = value;
	  vecuni.sum = value * (long)length;
	  vecuni.median = value;
      vecuni.maximum = vecuni.elements[length - 1];
	  vecuni.minimum = vecuni.elements[0];
	  return vecuni;
	}

	/**
	 * Returns new vector with elements in sequence from given start and step.
	 */
	public static Vector sequence(int length, long start, long step) {

		Vector vecs = new Vector(length);
	
		for (int i = 0; i < length; i++){
			
			vecs.elements[i] = (long) start;
			start += step;
		    
		}
        //there is no repeated elements
		vecs.mode = (long) -1;
		return vecs;
	}

	/**
* Returns whether the number is semiprime.
*/
	public static boolean isPQ(long number) {
		
		if(number < 4){
			return false;
		}
		for(long i = 2; i < Math.floor(Math.sqrt(number)) + 1; i++){
			if(number % i == 0){
				if(isPrime(number/i) == true && isPrime(i) == true){
					return true;
				}
			}
		}
		return false;
	}

/**
* Returns new vector with elements generated from the
* pq number sequence starting from the specified value.
*/
	public static Vector pq(int length, long start) {
		Vector vecpq = new Vector (length);
		
		for(int i = 0; i < length; i++){
			if(isPQ(start) == false){
				while(true){
					start++;
					if (isPQ(start) == true){
						break;
					}
				}
			}
			vecpq.elements[i] = start;
			start++;
			
		}
		//It's known that elements are increasing
		//hence, first is minimum and last is maximum
		vecpq.maximum = vecpq.elements[length - 1];
		vecpq.minimum = vecpq.elements[0];
		vecpq.mode = (long) -1;
		return vecpq;
	}

	/**
	 * Returns whether the number is prime.
	 */
	public static boolean isPrime(long number) {
		//sieve of Eratosthenes
		if (number < 2){
		    return false;
		}else if ( number <= 3){
			return true;
		}else if ( number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		for (long i = 5; i <= Math.sqrt(number); i = i + 6){
			if(number % i == 0 || number% (i + 2) == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns new vector with elements generated from the
	 * prime number sequence starting from the specified value.
	 */
	public static Vector prime(int length, long start) {
	
		Vector vecprime = new Vector (length);
		
		for(int i = 0; i < length; i++){
			while(isPrime(start) == false){
			    start++;
				if(isPrime(start) == true){
					break;
				}
			}
			
			vecprime.elements[i] = start;
			start++;
			
		}
		vecprime.maximum = vecprime.elements[length - 1];
		vecprime.minimum = vecprime.elements[0];
		vecprime.mode = (long) -1;
		return vecprime;
	}

	/**
	 * Returns whether the number is abundant.
	 */
	public static boolean isAbundant(long number) {
		if (number < 12){
		    return false;
		}
        long sumofFact = 1;
		for (long i = 2; i <= (number/2) ;i++){
		    if (number % i == 0){ //factorise number
				sumofFact += i;
				if(sumofFact > number){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns new vector with elements generated from the
	 * abundant number sequence starting from the specified value.
	 */
	public static Vector abundant(int length, long start) {
       
		Vector vecabun = new Vector (length);
		
		for(int i = 0; i < length; i++){
			if(isAbundant(start) == false){
				while(true){
					start++;
					if (isAbundant(start) == true){
						break;
					}
				}
			}
			vecabun.elements[i] = start;
			start++;
			
		}

        vecabun.maximum = vecabun.elements[length - 1];
		vecabun.minimum = vecabun.elements[0];
		vecabun.mode = (long) -1;
		return vecabun;
	}

	/**
	 * Returns whether the number is composite.
	 */
	public static boolean isComposite(long number) {
        if (number < 4){
			return false;
		}
		if (isPrime(number) == true){
		return false;
		}
		return true;
	}

	/**
	 * Returns new vector with elements generated from the
	 * composite number sequence starting from the specified value.
	 */
	public static Vector composite(int length, long start) {
        Vector vecCom = new Vector (length);
		
		for(int i = 0; i < length; i++){
			if(isComposite(start) == false){
				while(true){
					start++;
					if (isComposite(start) == true){
						break;
					}
				}
			}
			vecCom.elements[i] = start;
			start++;
		}
		vecCom.maximum = vecCom.elements[length - 1];
		vecCom.minimum = vecCom.elements[0];
		vecCom.mode = (long)-1;
		return vecCom;
	}

	// ===========================================================================
	// VECTOR OPERATIONS
	// ===========================================================================

	/**
	 * Returns new vector that is a copy of the current vector.
	 */
	public Vector cloned() {
		
        Vector VecCloned = new Vector (length);
        for(int i = 0; i < length; i++){
		VecCloned.elements[i] = this.elements[i];
		}
		return VecCloned;
	}

	/**
	 * Returns new vector with elements ordered from smallest to largest.
	 */
	public Vector sorted() {
        
		Vector vecSort = new Vector(length);
		
		for(int i = 0; i < length; i++){
		    vecSort.elements[i] = this.elements[i];
		}
		Arrays.sort(vecSort.elements);

		return vecSort;
	}

	/**
	 * Returns new vector with elements ordered in reverse.
	 */
	public Vector reversed() {
        Vector vecrev = new Vector(length);
		
		for(int i = 0; i < length; i++){
			//replaces elements increasing from 1st element
			//with elements decreasing from last element
		    vecrev.elements[i] = this.elements[length-1 - i];
		}
				

		return vecrev;
	}

	/**
	 * Returns new vector with elements shifted right by a given number of positions.
	 */
	public Vector shifted(long amount) {
        Vector vecshift = new Vector(length);
		for(int i = 0 ; i < length; i++){
			//use modulus, so when the number larger than
			//length, the number can still shift
			vecshift.elements[(int)(i + amount) % length] = this.elements[i];
		}
		return vecshift;
	}

	/**
	 * Returns new vector, adding scalar to each element.
	 */
	public Vector scalarAdd(long scalar) {
        Vector vecsca = new Vector(length);
		for(int i = 0; i < length; i++){
			vecsca.elements[i] = this.elements[i] + scalar;
		}
		return vecsca;
	}

	/**
	 * Returns new vector, multiplying scalar to each element.
	 */
	public Vector scalarMultiply(long scalar) {
        Vector scamul = new Vector(length);
		for(int i = 0; i < length; i++){
			scamul.elements[i] = this.elements[i] * scalar;
		}
		return scamul;
	}

	/**
	 * Returns new vector, adding elements with the same index.
	 */
	public Vector vectorAdd(Vector other) {
        Vector vecadd = new Vector(length);
		for(int i = 0; i < length; i++){
			vecadd.elements[i] = this.elements[i] + other.elements[i];
		}
		return vecadd;
	}

	/**
	 * Returns new vector, multiplying elements with the same index.
	 */
	public Vector vectorMultiply(Vector other) {
        Vector vecmul = new Vector(length);
		for(int i = 0; i < length; i++){
			vecmul.elements[i] = this.elements[i] * other.elements[i];
		}
		return vecmul;
	}

	// ===========================================================================
	// VECTOR COMPUTATIONS
	// ===========================================================================

	/**
	 * Returns the sum of all elements.
	 */
	public Long getSum() {

		// Calculate and store the sum when unknown
		if (this.sum == null) {
			this.sum = (long)0;
			    for (int i = 0; i < length; i++){
			        this.sum += this.elements[i];
				}
		}
			
		return this.sum;
	}

	/**
	 * Returns the most frequently occuring element
	 * or -1 if there is no such unique element.
	 */
	public Long getMode() {
		if(this.mode == null){
			//Key stores the elements, value store frequency
			HashMap <Long,Integer> h = new HashMap <Long,Integer> (this.length);
			for(int i=0; i< length; i++){
                if(h.containsKey(this.elements[i])){
                    h.put(this.elements[i], h.get(this.elements[i]) + 1);
                }else{
                    h.put(this.elements[i], 1);
                }
            }
		    //finds max value
            int maxCount = (Collections.max(h.values()));
            ArrayList <Long> modeKey = new ArrayList <Long> ();
			//adds the keys that equals maximum value
			//to the array list
	     	for(Long mKeys : h.keySet()){
                if(h.get(mKeys).equals(maxCount)){
                modeKey.add(mKeys);
				}
			}
			//if there is more than one key with maximum counts
			//return -1
			if(modeKey.size() > 1){
        	    this.mode = (long) -1;
            }else{
            	this.mode = modeKey.get(0);
            }
		}
		return this.mode;
	}

	/**
	 * Returns the upper median.
	 */
	public Long getMedian() {
		if(this.median == null){
			Arrays.sort(this.elements);
		    int midlen = (length) / 2;
			//divides length by half
			//check if divisible by 2
            if (length % 2 == 0){
		        this.median = this.elements[midlen];
			}else{
				this.median = this.elements[midlen - 1];
			}
		}

		return this.median;
	}

	/**
	 * Returns the smallest value in the vector.
	 */
	public Long getMinimum() {	

		if(this.minimum == null){
			int i = 0;
			// determines the value of i 
			//through the length and initialises minimum
			if(length % 2 == 0){
				if(this.elements[0] < this.elements[1]){
				this.minimum = this.elements[0];
				}else{
				this.minimum = this.elements[1];
				}
				i = 2;
			}else{
				this.minimum = this.elements[0];
				i = 1;
			}
			
			//Goes through elements and
			//does comparison of elements
			while(i < length){
				if(this.elements[i] > this.elements[i+1]){
					if(this.elements[i+1] < this.minimum){
						this.minimum = this.elements[i+1];
					}
				}else{
					if(this.elements[i] < this.minimum){
						this.minimum = this.elements[i];
					}
				}
				i = i + 2;
			}
		}

		return this.minimum;
	}

	/**
	 * Returns the largest value in the vector.
	 */
	public Long getMaximum() {

		if(this.maximum == null){
			int i = 0;
			//sets the value of i
			//initialises maximum
			if(length % 2 == 0){
				if(this.elements[0] < this.elements[1]){
				this.maximum = this.elements[1];
				}else{
				this.maximum = this.elements[0];
				}
				i = 2;
			}else{
				this.maximum = this.elements[0];
				i = 1;
			}
			//goes through elements and compares
			while(i < length){
				if(this.elements[i] > this.elements[i+1]){
					if(this.elements[i] > this.maximum){
						this.maximum = this.elements[i];
					}
				}else{
					if(this.elements[i + 1] > this.maximum){
						this.maximum = this.elements[i + 1];
					}
				}
				i = i + 2;
			}
		}
		return this.maximum;
	}

	/**
	 * Returns the frequency of the value in the vector.
	 */
	public long getFrequency(long value) {
		int frequentCount = 0;
        for(int i = 0; i < length; i++){
			if(this.elements[i] == value){
				frequentCount++;
			}
		}
		if(frequentCount == 1){
				frequentCount =1;
			}

		return frequentCount;
	}

	// ===========================================================================
	// DISPLAY OPERATIONS
	// ===========================================================================

	/**
	 * Displays the vector.
	 */
	public void display() {
		
		System.out.print(this.elements[0]);
		for (int i = 1; i < length; i++){
			
			System.out.print(" " + this.elements[i]);
	
		}
		System.out.println();

	}

	/**
	 * Displays the element at the specified index.
	 */
	public void displayElement(int index) {
		
        System.out.println(this.elements[index]);
	}

	// ===========================================================================
	// ACCESSOR METHODS
	// ===========================================================================

	/**
	 * Returns the vector length.
	 */
	public int getLength() {

		return this.length;
	}

	/**
	 * Returns the vector elements.
	 */
	public long[] getElements() {

		return this.elements;
	}
}


