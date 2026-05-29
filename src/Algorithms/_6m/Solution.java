package Algorithms._6m;


public class Solution {
    public static String convert(String s, int numRows) {

        int stringLength = s.length();

        //if horizontal or vertical after formating
        if (numRows >= stringLength || numRows == 1) return s;

        int stepBetweenTopOrBottomCharacters = (numRows * 2 - 2);
        StringBuilder result = new StringBuilder();

        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int rowNumber = 0; rowNumber < numRows; rowNumber++) {

            StringBuilder sb = stringBuilders[rowNumber];
            boolean endOfString = false;
            boolean firstCharacterOfTheRow = true;
            int charIndexInString = rowNumber;

            while (!endOfString) {
                //If it is first/last row we collect only top/bottom characters
                //The step between top/bottom characters is equal to 2 x rowNum - 2
                if (rowNumber == 0 || rowNumber == numRows - 1) {
                    //append character
                    sb.append(s.charAt(charIndexInString));
                    //find next index
                    charIndexInString += stepBetweenTopOrBottomCharacters;
                    //check if next index not out of bounds
                    endOfString = charIndexInString >= stringLength;
                } else {
                    //Check if it is the first character of current row
                    if (firstCharacterOfTheRow) {
                        //append character
                        sb.append(s.charAt(rowNumber));
                        //find index of the next top character
                        charIndexInString += stepBetweenTopOrBottomCharacters - rowNumber;
                    } else {
                        //If it is second or more character in current row...

                        //find index of character in current row before top character
                        if ((charIndexInString - rowNumber) < stringLength)
                            sb.append(s.charAt(charIndexInString - rowNumber));
                        else
                            endOfString = true;
                        //find index of character in current row after top character
                        if (charIndexInString + rowNumber < stringLength)
                            sb.append(s.charAt(charIndexInString + rowNumber));
                        else
                            endOfString = true;

                        //go to next top character
                        charIndexInString += stepBetweenTopOrBottomCharacters;
                    }
                    firstCharacterOfTheRow = false;
                }

            }
            result.append(sb);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("abc", 2));
    }
}