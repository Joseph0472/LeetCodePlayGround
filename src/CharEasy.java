public class CharEasy {
    public int romanToInt(String s) {//#13
        int result = 0;
        int loc = 0;
        //Substring and compare
        while(loc + 2 <= s.length()) {
            int currentNum = singleRomanToInt(s.substring(loc, loc+1));
            int nextNum = singleRomanToInt(s.substring(loc+1, loc+2));
            if(currentNum >= nextNum) {
                result += currentNum;
                loc += 1;
            } else {
                result += nextNum - currentNum;
                loc += 2;
            }
        }
        if(loc+1 == s.length()) {
            result += singleRomanToInt(s.substring(loc,loc+1));
        }
        return result;
    }
    private int singleRomanToInt(String str) {
        int num = 0;
        switch (str) {
            case "I":
                num = 1;
                break;
            case "V":
                num = 5;
                break;
            case "X":
                num = 10;
                break;
            case "L":
                num = 50;
                break;
            case "C":
                num = 100;
                break;
            case "D":
                num = 500;
                break;
            case "M":
                num = 1000;
                break;
        }
        return num;
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int length = strs[0].length();
        //Loop in arr's eles
        for (int i = 1; i < strs.length; i++) {
            length = Math.min(length, strs[i].length());
            //Loop in each ele
            for (int j = 0; j < length; j++) {
                char firstPre = strs[0].charAt(j), currentPre = strs[i].charAt(j);

                if (firstPre != currentPre) {
                    length = j;
                    break;
                }
            }
        }

        return strs[0].substring(0, length);
    }

    public boolean isValid(String s) {
        //check the first braket, say (
        //the next char should be ), or, the last char should be ).
        //if not, then it is not valid.
        // use two pointers.

        //TODO: Reconsider this question.


        int length = s.length();
        int locBeginning = 0;
        int locEnding = s.length() - 1;
        boolean result = true;
        if(length==1) return false;
        while(locBeginning <= locEnding) {
            switch ((int)s.charAt(locBeginning)) {
                case 40://(
                    if((int)s.charAt(locBeginning+1) == 41 || (int)s.charAt(locEnding) == 41) {
                        locBeginning++;
                        locEnding--;
                    } else {
                        result = false;
                    }
                    break;
                case 91://[
                    if((int)s.charAt(locBeginning+1) != 93 && (int)s.charAt(locEnding) != 493) {
                        result = false;
                    } else {
                        locBeginning++;
                        locEnding--;
                    }
                    break;
                case 123://{
                    if((int)s.charAt(locBeginning+1) != 125 && (int)s.charAt(locEnding) != 125) {
                        result = false;
                    } else {
                        locBeginning++;
                        locEnding--;
                    }
                    break;
                default:
                    return false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CharEasy obj = new CharEasy();
        String cars[] = new String[] {"Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda"};
        System.out.println(obj.isValid("(())()"));
    }
}
