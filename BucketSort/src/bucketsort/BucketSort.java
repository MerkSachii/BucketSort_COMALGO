/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mark Christian Sanchez
 */
public class BucketSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] input = getInput();
        System.out.println("Printing...");
        for(int i = 0; i < input.length; i++) {
            System.out.print(Integer.toString(input[i]) + " ");
        }
        
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
            
        
        
        return inputArr;
    }
    
    
    
}
