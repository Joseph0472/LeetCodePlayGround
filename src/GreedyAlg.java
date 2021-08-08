import java.util.Arrays;

public class GreedyAlg {
    //455
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPointer = 0;
        int sPointer = 0;
        while(gPointer < g.length && sPointer < s.length) {
            if(g[gPointer] <= s[sPointer]) {
                gPointer++;
            }
            sPointer++;
        }

        return gPointer;
    }

    //135
    public int candy(int[] ratings) {
        for(int i=0; i<ratings.length; i++) {
            if(i == 0) {
                continue;
            }
            if(i == ratings.length-1) {

                continue;
            }

        }
        return 0;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;


        return 0;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {2,4}, {1,3}};
        System.out.println(arr.length);
    }
}
