/**
 * Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.
 */
package algorithm;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositiveTwo {
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;

        for(int i=0;i<A.length;i++){
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }

        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)
                return i+1;
        }

        return A.length+1;
    }
    public static void main(String[] args){
        FirstMissingPositiveTwo firstMissingPositive=new FirstMissingPositiveTwo();
        int[] ints={1,2,3,4,6};
        System.out.println(firstMissingPositive.firstMissingPositive(ints));
    }

}