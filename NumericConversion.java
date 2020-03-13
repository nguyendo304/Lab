import java.sql.SQLOutput;
import java.lang.*;
import java.util.Scanner;

public class NumericConversion {
    public static void  main(String[] args){
        // variable for user input
        String numeric = null;

        //condition for while loop
        boolean success = true;

        //user choose from menu option
        int option = 0;

        //scanner to read user inputs
        Scanner scn = new Scanner(System.in);

        //final results
        long decodedValueHexadecimal =0;
        short decodeValueBin = 0;
        String result= "";

        while (success == true){
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.print("Please enter an option: ");
            option = scn.nextInt();
            switch (option) {
                //convert a hexadecimal to decimal number
                case 1:
                    System.out.print("\nPlease enter the  numeric string to convert: ");
                    numeric = scn.next();
                    decodedValueHexadecimal = hexStringDecode(numeric);
                    System.out.println("\nResult: " +decodedValueHexadecimal);
                    break;

                //convert a binary number to decimal
                case 2:
                    System.out.print("\nPlease enter the  numeric string to convert: ");
                    numeric = scn.next();

                    decodeValueBin = binaryStringDecode(numeric);
                    System.out.println("\nResult: " +decodeValueBin);
                    break;

                 //convert a binary number to hexadecimal number, display as a String
                case 3:
                    System.out.print("\nPlease enter the  numeric string to convert: ");
                    numeric = scn.next();
                    result = binaryToHex(numeric);
                    System.out.println("\nResult:" +result);
                    break;

                //quit the program
                case 4:
                    success = false;
                    System.out.println("Goodbye!");
                    break;

            }
        }

    }
        //convert a char to int value
    public static short hexCharDecode(char digit){
        //return numeric value of char from '1' to '9'
        if ('0' <= digit && digit <= '9')
            return (short) (digit - '0');

            //return numeric value of char from 'a' to 'f'
        else if ('a' <= digit && digit <= 'f')
            return  (short) (digit -'a' + 10);

            //in case of other char different from above numbers and chars
        else
            System.out.println("invalid input");
        return (short) digit;
    }


    //decode form a hex string to decimal value
    public static long  hexStringDecode (String hex){
        hex = hex.toLowerCase();
        int i = 0;

        //to get values of every char in string
        char c='0';
        short valueinDecimal;
        long  decodedValue =0;

        //truncate string
        String trunString;
        String temp;

        //find the 2 first digit of string, if '0x', cut 2 digit to have a hex number
        temp = hex.substring(0,2);
        if (temp.equals("0x")) {
            trunString = hex.substring(2);

        }
        else
            trunString = hex;

        for (i = 0; i<trunString.length(); i++){
            c = trunString.charAt(i);
            valueinDecimal = hexCharDecode(c);

            decodedValue += Math.pow(16, trunString.length()-1-i)*valueinDecimal;
        }
        return decodedValue;
    }


    //convert a binary String to decimal value
    public static short binaryStringDecode(String binary){
        // lower Case the whole string
        binary = binary.toLowerCase();

        String trunString;
        String temp;

        //find the 2 first digit of string, if '0b', cut 2 digit to have a binary number
        temp = binary.substring(0,2);
        if (temp.equals("0b")) {
            trunString = binary.substring(2);
        }
        else
            trunString = binary;

        double result = 0;
         //to get values of every char in string
        for(int i=0;i<trunString.length();i++){
            if(trunString.charAt(i)== '1'){
                result=result+ Math.pow(2,trunString.length()-1-i);
            }

        }
        return (short) result;

    }

    //to convert a string of binary number to a hex string
  public static String binaryToHex(String binary) {
      binary = binary.toLowerCase();

      String trunString;
      String temp;

      //find the 2 first digit of string, if '0b', cut 2 digit to have a binary number
      temp = binary.substring(0,2);
      if (temp.equals("0b")) {
          trunString = binary.substring(2);
      }
      else
          trunString = binary;

      //call the function to convert a binary number to decimal number
      short binInDecimal= binaryStringDecode(trunString);

      String result ="";
      int remainder =0;

      //display the value of decimal number in hexadecimal
      char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

      //convert from decimal to hex
      while (binInDecimal >0){
            remainder = binInDecimal % 16;

            //display result in string as the reverse direction of remainder value
            result = hex[remainder]+ result;;
            binInDecimal = (short) (binInDecimal/16);

       }
        return result;

    }
}
