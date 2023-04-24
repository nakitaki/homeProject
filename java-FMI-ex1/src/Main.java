import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void exploreStrings(){

        //STRING EQUALS
        String literal1= "FMI"; //goes to the string pool
        String literal2 = "FMI"; //"FMI" is present in the string pool => literalTwo will refer to it
        // == check if the reference of the two objects is the same
        System.out.println(literal1==literal2); //true

        String newString = new String("FMI"); // new String object in the heap
        System.out.println(literal1==newString); //false -> literalOne refers to an object in the String pool
        System.out.println(literal1.equals(newString)); //true; string content is the same

        String intern = newString.intern(); //string "intering" will add the string in the pool
        System.out.println(literal1==newString); //false; newString is not reassigned
        System.out.println(literal1==intern); //true

        //STRING CONCATENATION AND SPLITTING
        String message = "Current year is ";
        message += 2023 + "."; //Strings are immutable so this will create new String object in the pool with the whole sentence
        //Current year is 2023

        String[] words = message.split(" ");//{"Current", "year", "is", "2023."}

        //STRING ITERATION AND CONVERSION (STRING -> CHAR ARRAY)
        String example = "Example";
        char secondChar = example.charAt(1);//'x'; strings are not char arrays -> we cant access them with []
        char[] chars = example.toCharArray(); // convert string to char array

        for(int i = 0; i < chars.length; i++){
            System.out.println(chars[1]);
        }

        for(int i = 0; i < example.length(); i++){
            System.out.println(example.charAt(i));
        }

        for(char current: chars){ //for-each loop
            System.out.println(current);
        }

        //CONVERSION (CHAR ARRAY ->  STRING)
        String backToStr1 = String.valueOf(chars); //note-> chars.toString does not work as the same way
        String backToStr2 = Arrays.toString(chars);

        //STRING MANIPULATION
        String lower = "WHatEveR".toLowerCase(); //"whatever"
        String upper = "WHatEveR".toUpperCase(); //"WHATEVER"
        String reverse = new StringBuilder(lower).reverse().toString(); //"revetahw"

        String replaced = "cut".replace('c','p'); //put
        String substring = "Anaconda".substring(2,6); //[2,6) => "acon"
        boolean containsCo = substring.contains("co"); //true
        boolean startsWithB = substring.startsWith("on"); //false
        boolean endsWithOn = substring.endsWith("on"); //true
        int indexOfN = "Coconut".indexOf("n"); //4
        int length = "Coconut".length(); //7; note-> length is a method, not a field

        String strippedWhiteSpaces = "       some whitespaces we want to strip ".strip(); //"some whitespaces we want to strip"
        String indentedText = "Indent this".indent(4); //"    Indent this" -> indents the text by 4

        //MORE STRING COMPARISONS - IMPORTANT
        boolean isEmpty = "".isEmpty(); //true
        boolean isNotEmpty = " ".isEmpty(); //false
        boolean isBlank = "  ".isBlank(); //true
        boolean equalIgnoringCapitalization = "Java".equalsIgnoreCase("jAVA"); //true
    }

    public static void exploresStringBuilder(){ //good to use StringBuilder when you have to manipulate your string often
        StringBuilder oddNumbers = new StringBuilder(); //with StringBuilder after the for loop you have 1 object, if you use String after the loop you will have 10 objects
        for(int i = 0; i < 20; i++){
            if(i % 2 != 0){
                oddNumbers.append(i).append(" "); //after that you won't have "1", "1 3", "1 3 5", ..., its like in box everything is saved in one object -> it is MUTABLE
            }
        }
        System.out.println(oddNumbers); //"1 3 5 7 9 11 13 15 17 19"

        StringBuilder word = new StringBuilder("racecar");
        boolean isPalindrome = word.equals(word.reverse()); //true

        String feelings = "i" + "<3" + "JAVA"; //if the concatenation is in the same statement, the compiler will optimize this and usr StringBuilder instead
    }

    public static void exploreArrays(){
        int[] array; //just declaration - the array is not created, no memory is allocated
        array = new int[5]; //initialization - now we have {0,0,0,0,0}

        String[] StringArray = {"apple", "banana", "cherry"}; //string array with 3 elements
        char[] charArray = new char[] {'a', 'b'};
        int length = StringArray.length; //3; note-> the length is a field, not a method

        long[][] longMatrix = new long[10][10]; //10x10 array initialized
        double[][] doubleMatrix = new double[100][]; //array with 100 rows initialized, but all rows still uninitialized
        for(int i = 0; i < 100; i++){
            doubleMatrix[i] = new double[10]; //array now initialized;
        }

        int[] intArray = {1,6,7,3};
        Arrays.sort(intArray); //{1,3,6,7}
        int index = Arrays.binarySearch(intArray,7); //3
        int[] copy = Arrays.copyOf(intArray, intArray.length);
        boolean areEqual = Arrays.equals(intArray,copy); //true
        System.out.println(Arrays.toString(copy));

        String[] animals = {"cat", "dog", "bird"};
        Arrays.sort(animals, Collections.reverseOrder()); //{"dog", "cat", "bird"} alphabetical order

        for(String animal: animals){
            System.out.println(animal);
        }

        //as we know, arrays are objects and need to be compared with equals()
        //however, two(ot more) dimensional arrays are arrays of objects
        //and java has a special method for comparing them
        char[][] currentBoard = {{'X','O','X'}, {'X','O','O'}, {'X','X','O'}};
        char[][] winBoard = {{'X','O','X'}, {'X','O','O'}, {'X','X','O'}};
        boolean isWinning = Arrays.deepEquals(currentBoard, winBoard); //true
    }

    public static void main(String[] args){
        exploreStrings();
        exploresStringBuilder();
        exploreArrays();
    }
}