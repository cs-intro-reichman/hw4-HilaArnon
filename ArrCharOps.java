import java.util.Arrays;

/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));                           //e  
        System.out.println(indexOf(arr1,'l'));                          // 1
        System.out.println(indexOf(arr1,'l',3));               //5
        System.out.println(lastIndexOf(arr1, 'l'));                     // 5 
        System.out.println(concat(arr1, arr2));                            //clearlyUnderstud
        System.out.println(subArray(arr2, 2, 9));      // derstood
        System.out.println(compareTo("abcd", "abcd"));            // 0
        System.out.println(compareTo("abc", "abcd"));            // -1
        System.out.println(compareTo("abw", "abcd"));             // 1
        System.out.println(compareTo("Abcd", "a"));              // -1
        System.out.println(compareTo("apple", "banana"));        // -1
        System.out.println(compareTo("apple", "applepie"));      // -1
        System.out.println(compareTo("Zoo", "zoo"));             // -1
        System.out.println(hashCode(arr1));                               //  1071050544   (11)
        System.out.println(hashCode(arr2));                              //   618855452078 (12)
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    //The charAt(char[],int) method: In this particular method you have to assume that the array is
    //not empty, meaning that it contains at least one element.
    public static char charAt(char[] arr, int index) {
        if (index >= arr.length || index < 0){        //if the index we got is ok
            return 0;
        }
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        // Replace the following statement with your code
        if (arr1.length != arr2.length){      
            return false;
        }
        for(int i = 0; i < arr1.length; i ++){
            if(arr1[i] != arr2[i]){               //one char isn't the same
                return false;
            }
        }
        return true;     
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for(int i = 0; i < arr.length; i ++){
            if (arr[i] == ch){
                return i;            //first time the char appears
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for(; fromIndex < arr.length; fromIndex ++){
            if (arr[fromIndex] == ch){
                return fromIndex;            //first time the char appears
            }
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     * The lastIndexOf(char[]) method: Note that a for loop can also be written backwards: instead of
     * iterating, say, from 0 up to 10, you can iterate from 10 down to 0.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for(int i = arr.length - 1; i >= 0; i --){
            if (arr[i] == ch){
                return i;            //last time the char appears
            }
        }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    * The concat(char[], char[]) method: One thing that you must do in this method, at some point,
    * is creating a new array that will contain the concatenation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        //A new array that contain first arr1 and after him arr2
        char[] newArray = new char[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i ++){
            newArray[i] = arr1[i];
            //System.out.println("newArray[i]: i = " + i + ", " + newArray[i]);
        }
        int index = arr1.length;
        for(int j = 0; j < arr2.length; j ++){
            //System.out.println("arr2[j]: j = " + + j + ", " + arr2[j]);
            newArray[index] = arr2[j];
            //System.out.println("newArray[index]: index = " + index + ", " + newArray[index]);
            index ++;
        }
        return newArray;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        // new array from beginIndex until up to and including endIndex
        char[] subArray = new char[endIndex - beginIndex];
        int j = 0;
        for(int i = beginIndex; i < endIndex; i++){
            subArray[j] = arr[i];
            j ++;
        }
        return subArray;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        int n = arr.length;
        if(n == 0){                         //arr is empty
            return 0;
        }

        long answer = 0;
        for(int i = 0; i < n; i ++){
            //arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
            answer += arr[i] * (long)Math.pow(7, n - i - 1);
        }
        return answer;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller    ~if its str1: -1.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.  ~greater?: 1.
     * 3. If both strings have the same characters and the same length, they are considered equal   ~: 0.
     * 4. ~error: -2
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */

     //Strings not empty, the int value of chars (==), 
    public static int compareTo(String str1, String str2) {
        if (str1.length() < str2.length()){
            for (int i = 0; i < str1.length(); i ++){
                if (str2.charAt(i) != str1.charAt(i)){
                    return false;
                }
            }
            //return...
        }

        // if (str1.length() > str2.length()){
        //     compareToDifferentLength(str1, str2);
        // } else if (str1.length() < str2.length()){
        //     compareToDifferentLength(str2, str1);
        // }
        return 0;
    }

    public static boolean compareToDifferentLength(String longer, String shorter) {
            //char[] subLongest = subArray(longer, 0, shorter.length() - 1);
            for (int i = 0; i < shorter.length(); i ++){
                if (longer.charAt(i) != shorter.charAt(i)){
                    return false;
                }
            }
        return true;
    }
}
