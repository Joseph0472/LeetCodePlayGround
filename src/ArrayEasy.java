import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayEasy {
    public boolean checkIfExist(int[] arr) {
        int i = 0;
        while(i<arr.length) {
            for(int j=0; j< arr.length; j++) {
                if(arr[i] == 2*arr[j] && i!=j) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        int peak = 0;
        int peakLoc = 1;
        int i = 1, k = 0;
        while(i < arr.length) {
            if(arr[i] > arr[i-1]) {
                peakLoc = i;
            } else {
                peakLoc = i-1;
                break;
            }
            i++;
        }
        if(peakLoc == arr.length-1 || peakLoc == 0) return false;
        while(peakLoc+1 < arr.length) {
            if(arr[peakLoc+1] >= arr[peakLoc]) return false;
            peakLoc++;
        }
        return true;
    }

    //In-place operation
    public int[] replaceElements(int[] arr) {
        int i = 0;
        while(i+1 < arr.length) {
            int greatestNum = arr[i+1];
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j]>greatestNum) {
                    greatestNum = arr[j];
                }
            }
            arr[i] = greatestNum;
            i++;
        }
        arr[arr.length-1] = -1;
        return arr;
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int checkingPointer = 0;
        while(i<nums.length) {
            if(nums[i] == 0) {
                for(checkingPointer = i+1; checkingPointer < nums.length; checkingPointer++) {
                    if(nums[checkingPointer] != 0) {
                        nums[i] = nums[checkingPointer];
                        nums[checkingPointer] = 0;
                        break;
                    }
                }
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArrayByParity(int[] A) {
        int startingP = 0;
        int endingP = A.length - 1;
        while(startingP!=endingP) {
            if(A[startingP]%2 != 0) {
                int temp;
                while(A[endingP]%2 !=0 && startingP!=endingP) {
                    endingP--;
                }
                if(startingP == endingP) {
                    return A;
                }
                temp = A[startingP];
                A[startingP] = A[endingP];
                A[endingP] = temp;
            }
            startingP++;
        }
            return A;
    }

    public int thirdMax(int[] nums) {
        int[] bigThree = new int[3];
        int i = 1;
        boolean firstIndexChanged = false;
        boolean lastIndexChanged = false;
        bigThree[1] = nums[0];
        while(i<nums.length) {
            if(nums[i]>bigThree[1]) {
                if(nums[i]>bigThree[0] && firstIndexChanged) {
                    bigThree[2] = bigThree[1];
                    bigThree[1] = bigThree[0];
                    bigThree[0] = nums[i];
                    continue;
                }
                bigThree[0] = nums[i];
                firstIndexChanged = true;
            }
            if(nums[i]<bigThree[1]) {
                if(nums[i]<bigThree[2] && lastIndexChanged) {
                    if(firstIndexChanged){
                        continue;
                    }
                    bigThree[0] = bigThree[1];
                    bigThree[1] = bigThree[2];
                    bigThree[2] = nums[i];
                    continue;
                }
                bigThree[2] = nums[i];
                lastIndexChanged = true;
            }
            i++;
        }
        System.out.println(Arrays.toString(bigThree));
        return 0;
    }

    public static void main(String[] args) {
        ArrayEasy obj = new ArrayEasy();
        int[] array = {3,14,2,3,1};
        String a = "(";
        int asc = (int)a.charAt(0);
    }
}
