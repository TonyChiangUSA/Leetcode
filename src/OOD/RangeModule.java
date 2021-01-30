package OOD;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class RangeModule {
    TreeMap<Integer, Integer> intervals = new TreeMap<>();
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(start != null && intervals.get(start) >= left){
            left = start;
        }
        if(end != null && intervals.get(end) > right){
            right = intervals.get(end);
        }
        intervals.put(left, right);

        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if(start == null) return false;
        return intervals.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
      
        if(end != null && intervals.get(end) > right){
            intervals.put(right, intervals.get(end));
        }
        if(start != null && intervals.get(start) > left){
            intervals.put(start, left);
        }
        intervals.subMap(left, true, right, false).clear();
    }

    public static void main(String[] args) {
        RangeModule rangeModule=new RangeModule();
        rangeModule.addRange(10,20);
        rangeModule.removeRange(14,16);
    }
}


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
