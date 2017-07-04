/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mark Christian Sanchez
 */
public class BucketSort {
    private static final int BUCKET_SIZE = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        int[] input = getInput();
//        System.out.println("Printing...");
//        for(int i = 0; i < input.length; i++) {
//            System.out.print(Integer.toString(input[i]) + " ");
//        }
        // Temporarily unavailable
        
        Integer[] list = {119,143,619,301,110};
        Integer[] sorted = bucketSort(list);
        System.out.println("Debug: " + Arrays.toString(sorted));
    }
    
    public static int[] getInput() {
        
        int[] inputArr = null;
        
        
        Scanner sc;
        sc = new Scanner(System.in);
        List<Integer> intArr = new ArrayList<>();
        
        // Ask how many place digits
        System.out.println("How many N places?");
        int place = sc.nextInt();
        
        System.out.println("Places: " + String.valueOf(place) );
        System.out.println("Start inputting the number string: ");
        
        while(sc.hasNext()) {
            System.out.println("Start of Loop");
            if(sc.hasNextInt()) {
                intArr.add(sc.nextInt());
            }
            else {
                sc.next();
            }
        }
        System.out.println("Asan ba ako nagkamali");
        sc.close();
        inputArr = intArr.stream().mapToInt(i->i).toArray();
            
        // Output must be an integer array; int []
        
        return inputArr;
    }
    
    public static Integer[] bucketSort(Integer[] list) {
        
        
        // Get min and max values
        Integer min = list[0];
        Integer max = list[0];
        
        for (int i = 1; i < list.length; i++) {
            if(list[i] < min) {
                min = list[i];
            }
            else if(list[i] > max) {
                max = list[i];
            }
        }
        System.out.println("MaxVal: " + max);
        
        int noOfBuckets = (max - min) / BUCKET_SIZE + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(noOfBuckets);
        for(int i = 0; i < noOfBuckets; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < list.length; i++ ) {
            // Distribute values into buckets
            buckets.get((list[i] - min) / BUCKET_SIZE).add(list[i]);
            System.out.println("DEBUG: i -> " + list[i]);
            System.out.println("DEBUG: (MIN,MAX) = (" + min +","+ max +")");
        }
        
        int pos = 0;
        for(int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArr = new Integer[buckets.get(i).size()];
            // Do insertion sort
            bucketArr = buckets.get(i).toArray(bucketArr);
            System.out.println("BuckArr: " + Arrays.toString(bucketArr));
            insertionSort(bucketArr);
            for(int j = 0; j < bucketArr.length; j++) {
                list[pos++] = bucketArr[j];
            }
        }
        
        return list;
    }
    
    public static Integer[] insertionSort(Integer[] list) {
        
        int length = list.length;
        for(int j = 1; j < length; j++) {
            
            int key = list[j];
            int before = j - 1;
            while ( (before > -1) && (list[before] > key)) {
                list[before+1] = list[before];
                before--;
            }
            list[before+1] = key;
        }
        
        return list;
    }

    
}
