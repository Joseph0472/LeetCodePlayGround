public class IntEasy {

    public int reverse(int x) {//#7
        if(x == 0 || Math.abs(x)<0){
            return 0;
        }
        //Remove unnecessary 0
        while(x%10 == 0){
            x = x/10;
        }
        int target = Math.abs(x);
        //Get the digit
        int digit = 0;
        while(x/10 != 0){
            x = x/10;
            digit++;
        }
        int result = 0;
        while(digit>=0){
            int currentDigit;
            currentDigit = target%10;

            result = (int) (result + currentDigit * Math.pow(10,digit));
            if(result >= 2147483647){
                return 0;
            }
            target = target/10;
            digit--;
        }
        return x<0?-result:result;
    }

    public boolean isPalindrome(int x) {//#9
        if(x<0) return false;
        int reverseNum = 0;
        int leftNum = x;
        while(leftNum != 0){
            reverseNum = leftNum % 10 + reverseNum * 10;
            leftNum /= 10;
        }
        return reverseNum == x;
    }


    public static void main(String[] args) {
        IntEasy obj = new IntEasy();
    }
}
