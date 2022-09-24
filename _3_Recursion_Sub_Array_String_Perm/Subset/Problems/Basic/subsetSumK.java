package _3_Recursion_Sub_Array_String_Perm.Subset.Problems.Basic;

import java.util.ArrayList;

public class subsetSumK {
    public static void main(String[] args) {
        System.out.println("All subset with sum k:");
        subSet(0,new int[]{3,5,8,2,-2},new ArrayList<Integer>(),8,0);

        System.out.println("First subset with sum k:");
        oneSubSet(0,new int[]{3,5,8,2,-2},new ArrayList<Integer>(),8,0);

        System.out.println("Subset of sum k count: "+ subSetCount(0,new int[]{3,5,8,2,-2},new ArrayList<Integer>(),8,0));
    }

    static void subSet(int index, int[] arr, ArrayList<Integer> ds, int k,int sum){
        if(index == arr.length){
            if(sum == k)
                System.out.println(ds);
            return;
        }

        ds.add(arr[index]);     //add ele
        sum = sum+ arr[index];
        subSet(index+1, arr, ds,k,sum);  //take ele to be included in the subsequence

        ds.remove(ds.size()-1);    //rem added ele so that we can have subset without this ele
        sum = sum- arr[index];

        subSet(index+1, arr, ds,k,sum);  //don't take ele to be included in the subsequence
    }

    static boolean oneSubSet(int index, int[] arr, ArrayList<Integer> ds, int k,int sum){
        if(index == arr.length){
            if(sum == k){
                System.out.println(ds);
                return true;
            }else
                return false;
        }

        ds.add(arr[index]);     //add ele
        sum = sum+ arr[index];
        if(oneSubSet(index+1, arr, ds,k,sum) == true) {//take ele to be included in the subsequence
            return true;
        }

        ds.remove(ds.size()-1);    //rem added ele so that we can have subset without this ele
        sum = sum- arr[index];

        if(oneSubSet(index+1, arr, ds,k,sum) ==true){//don't take ele to be included in the subsequence
            return true;
        }

        return false;
    }



    static int subSetCount(int index, int[] arr, ArrayList<Integer> ds, int k,int sum){
        if(index == arr.length){
            if(sum == k)
                return 1;
            else
                return 0;
        }

        ds.add(arr[index]);     //add ele
        sum = sum+ arr[index];
        int left = subSetCount(index+1, arr, ds,k,sum);  //take ele to be included in the subsequence

        ds.remove(ds.size()-1);    //rem added ele so that we can have subset without this ele
        sum = sum- arr[index];

        int right = subSetCount(index+1, arr, ds,k,sum);  //don't take ele to be included in the subsequence

        return left+right;
    }
}
