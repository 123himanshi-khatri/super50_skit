
import java.util.*;

public class MyString {

private final String originalString;  // store the original string
private StringBuilder currentString;  // temporary for operations

    // Constructor that sets current string
    public MyString(String str) {
    this.originalString = str;                // save original string
    this.currentString = new StringBuilder(str);
}
private void reset() {
    currentString = new StringBuilder(originalString);
}


    //  Append new string to current string
    public void append(String newString) {
        reset();

        // Append a space if current string is not empty
        if (currentString.length() > 0) {
        currentString.append(" ");
    }
        // this is to append newString to currentString

        currentString.append(newString);
        System.out.println("Updated String:  "  + currentString);
    }

    //  Count words in the current string
    public int countWords() {
        reset();

        // Trim leading/trailing spaces and split by whitespace
        String temp = currentString.toString().trim();
          if (temp.isEmpty()) return 0;
          //this is to count words in the string
          // Split by whitespace
          // \s+ means one or more whitespace characters
          
        String[] words = temp.split("\\s+");
        
        return words.length;
    }

    //  Replace characters or substrings
    public void replace(String a, String b) {
        reset();

        // Replace all occurrences of a with b
        String replaced = currentString.toString().replace(a, b);
        // Update current string
        currentString = new StringBuilder(replaced);
        System.out.println("Updated String: " + currentString);
    }

    //  Check palindrome
    public boolean isPalindrome() {
        reset();

        // Clean string: remove spaces and convert to lowercase
        String basicString = currentString.toString().replaceAll("s+", "").toLowerCase();
        // this checks if the string is equal to its reverse
        String reversed = new StringBuilder(basicString).reverse().toString();
        return basicString.equals(reversed);
    }

    //  Splice (remove substring from start index with given length)
    public void splice(int start, int length) {
        reset();

        // Validate start and length
        if (start < 0 || start >= currentString.length()) {
            System.out.println("Invalid start index!");
            return;
        }
        //this checks if length is negative
        int end = Math.min(start + length, currentString.length());

        currentString.delete(start, end);
        System.out.println("Updated String: " + currentString);
    }

    //  Split string by a pattern
    public void split(String pattern) {
        reset();

        //exmaple pattern could be space, comma, etc.
        
        String[] parts = currentString.toString().split(pattern);
        System.out.println("Split result: " + Arrays.toString(parts));
    }

  public void maxRepeat() {
    reset();

    String s = currentString.toString();
    // Frequency map to count occurrences of each character
    Map<Character, Integer> freq = new HashMap<>();

    // Count frequency of each character
    //loop through each character in the string
    for (char c : s.toCharArray()) {
        //getOrDefault returns the value to which the specified key is mapped, or defaultValue 0 if this map contains no mapping for the key.
        // if  character c is already in the map, increment its count by 1
        freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    // Find max repeating character
    char maxChar = 0;
    int maxCount = 0;
    // Iterate through the frequency map to find the character with the highest count
    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
        if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
            maxChar = entry.getKey();
        }
    }

    System.out.println("Max repeating character: '" + maxChar + "' -> " + maxCount + " times");
}


    //  Sort characters alphabetically
    public void sort() {
        reset();

        char[] arr = currentString.toString().toCharArray();
        Arrays.sort(arr);
        // Update current string with sorted characters
        currentString = new StringBuilder(new String(arr));
        System.out.println("Sorted String: " + currentString);
    }

    //  Shift first n characters to end of the string
    public void shift(int n) {
        reset();

        // Validate n 
        if (n < 0 || n > currentString.length()) {
            System.out.println("Invalid shift value!");
            return;
        }
        // Perform shift operation
        // Substring from n to end + substring from 0 to n
        String shifted = currentString.substring(n) + currentString.substring(0, n);
        currentString = new StringBuilder(shifted);
        System.out.println("Shifted String: " + currentString);
    }

    //  Reverse string content 
    public void reverse() {
        reset();

        // Reverse the current string
        currentString.reverse();
        System.out.println("Reversed String: " +currentString);
    }

    // Getter for current string
    public String getString() {

        // need for getter method is to access the current string outside the class for example in main method
        return currentString.toString();
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Scanner for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial string: ");
        // Read entire line including spaces
        String str = sc.nextLine();
// Create MyString object
        MyString obj = new MyString(str);

        while (true) {
            System.out.println("\nChoose Operation:");
            System.out.println("1. Append\n2. CountWords\n3. Replace\n4. isPalindrome\n5. Splice");
            System.out.println("6. Split\n7. MaxRepeatingCharacter\n8. Sort\n9. Shift\n10. Reverse\n11. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            //why because nextInt does not consume the newline character
            sc.nextLine();

            switch (ch) {
    case 1 ->   {
        System.out.print("Enter string to append: ");
        String add = sc.nextLine(); // no extra nextLine needed
        obj.append(add);
                }

    case 2 -> System.out.println("Word count: " + obj.countWords());

   case 3 -> {
    System.out.print("Enter the string to replace in the current string: ");
    String a = sc.nextLine();

    System.out.print("Enter the new text that should replace  " + a +  ": ");
    String b = sc.nextLine();

    obj.replace(a, b);
}


    case 4 -> System.out.println("Is Palindrome? " + obj.isPalindrome());

    case 5 ->   {
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter length: ");
        int len = sc.nextInt();
        obj.splice(start, len);
                }

    case 6 -> {
    System.out.println("Examples of patterns: space -> ' ', comma -> ',' , dash -> -");

    System.out.print("Enter your split pattern: ");
    String pattern = sc.nextLine();

    System.out.println("Splitting the string using pattern: \"" + pattern + "\"");
    obj.split(pattern);
}


    case 7 -> obj.maxRepeat();

    case 8 -> obj.sort();

    case 9 ->   {
        System.out.print("Enter n to shift: ");
        int n = sc.nextInt();
        obj.shift(n);
                }

    case 10 -> obj.reverse();

    case 11 ->  {
        System.out.println("Exiting program...");
        sc.close();
        

             
                }

    default -> System.out.println("Invalid choice!");


            }
        }
    }
}
