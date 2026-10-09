///////////////////////////////////////////
//
// Assignment 2 - Exception Handling
//
// Author: Joshua Spencer
// Course: CPT-237
// Section: W38
// Semester: Fall 2026
///////////////////////////////////////////

import java.util.Scanner;

public class EncryptString extends AnyString {

   public EncryptString(String str) {
      super(str);
   }

   public EncryptString(char[] charArray) {
      super(charArray);
   }

   // Object encryption method with exception throwing
   public String encryptString() throws IllegalArgumentException {
      String resultString = "";
      
      // Loop through string to validate characters
      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);
         
         // Throw exception if character is NOT (a-z) AND NOT space ' '
         if (!((c >= 'a' && c <= 'z') || c == ' ')) {
            throw new IllegalArgumentException("Invalid character encountered: '" + c + "'. Only lowercase letters 'a' through 'z' and spaces are allowed.");
         }
         
         if (c == ' ') {
            resultString += ' ';
         } else {
            resultString += (char)(c + 1);
         }
      }   
      
      return resultString;
   }

   public static String decryptString(String str) {
      String resultString = "";
      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);
         if (c == ' ') {
            resultString += ' ';
         } else {
            resultString += (char)(c - 1);
         }
      }   
      return resultString;
   }
}