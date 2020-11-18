package MergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class merge {


    public static int[][] merge(int[][] intervals) {
        if(intervals==null || intervals[0].length==0) return intervals;
        List<int[]> res=new LinkedList<>();
        Arrays.sort(intervals,(a, b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int left=intervals[0][0];
        int right=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(right>=intervals[i][0] && right<=intervals[i][1]){
                right=intervals[i][1];
                int[] interval={left,right};
                res.add(interval);
            }

            if(right<intervals[i][0]){
                res.add(intervals[i]);
            }
        }

        int[][] resMatrix=new int[res.size()][];
        for(int i=0;i<res.size();i++){
            resMatrix[i]=res.get(i);
        }
        return resMatrix;
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
