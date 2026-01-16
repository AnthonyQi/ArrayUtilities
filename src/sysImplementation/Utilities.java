package sysImplementation;

public class Utilities extends java.lang.Object{
	public Utilities() {
		
	}
	public static int [] filter(int [] array, int lowerLimit, int upperLimit) {
		if(array == null) {
			throw new IllegalArgumentException("Null Array");
		}
		if(upperLimit < lowerLimit) {
			throw new IllegalArgumentException("upperLimit < lowerLimit");
		}
		int count = Utilities.getInstances​(array, lowerLimit, upperLimit);
		int [] newArray = new int[count];
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= upperLimit && array[i] >= lowerLimit) {
				newArray[index] = array[i];
				index++;
			}
		}
		return newArray;
	}
	public static String getArrayString​(int[] array, char separator) {
		StringBuffer sb = new StringBuffer("");
		if(array == null) {
			throw new IllegalArgumentException("Null Array");
		}
		if(array.length == 0) {
			return sb.toString();
		}
		for(int i = 0; i < array.length; i++) {
			if(i < (array.length - 1)) {
				sb.append(array[i]).append(separator);
			}
			else {
				sb.append(array[i]);
			}
		} 
		return sb.toString();
	}
	public static StringBuffer[] 
			getArrayStringsLongerThan​(StringBuffer[] array, int length) {
		if(array == null) {
			throw new IllegalArgumentException("Null Array");
		}
		int count = 0;
		//check for strings longer than the length
		//add to count
		for(int i = 0; i < array.length; i++) {
			if(array[i].length() > length) {
				count++;
			}
		}
		StringBuffer [] result = new StringBuffer[count];
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			//checks if length of string < length
			if(array[i].length() > length) {
				result[index] = array[i];
				index++;
			}
		}
		return result;
	}
	public static int getInstances​(int[] array, int lowerLimit, int upperLimit) {
		int counter = 0;
		if(array == null) {
			throw new IllegalArgumentException("Null Array");
		}
		for (int i = 0; i < array.length; i++) {
			//Inclusive check
	        if (array[i] >= lowerLimit && array[i] <= upperLimit) {
	            counter++;
	        }
	    }
		return counter;
	}
	public static void rotate(int[] array, boolean leftRotation, int positions) {
		if (array == null) {
            throw new IllegalArgumentException("Null Array");
        }
        // Only rotate if the array has 2 or more elements
        if (array.length < 2) {
            return;
        }
        //call the rotation methods
        if (leftRotation) {
        	for(int i = 0; i < positions; i++) {
        		rotateLeft(array);
        	}
        } else {
        	for(int i = 0; i < positions; i++) {
        		rotateRight(array);
        	}
        }
	}
	private static void rotateLeft(int [] array) {
		int first = array[0]; //Save the first element
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = first;
	}
	private static void rotateRight(int [] array) {
		int last = array[array.length - 1]; //Save the last element
        for (int i = array.length - 1; i > 0; i--) { //go backwards
            array[i] = array[i - 1];
        }
        array[0] = last;
	}
}