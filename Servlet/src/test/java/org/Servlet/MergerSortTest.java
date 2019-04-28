package org.Servlet;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Created by Administrator on 2019/1/27.
 * @DESC
 * @DATE 27
 */
public class MergerSortTest {


@Test
public void mergeSort(){

    int a[]={1,5,3,16,58,15,11};
sort(a);
    System.out.println(Arrays.toString(a));

}





    private  void sort(int []a){
      int []temp=new int[a.length];
        sort(a,0,a.length-1,temp);
    }


    private void sort(int []source,int left,int right,int []temp){

        if(left<right){

            int mid=(left+right)/2;
            sort(source, left, mid, temp);
            sort(source, mid + 1, right, temp);
            sort(source,left,mid,right,temp);

        }

    }


    private void sort(int []source, int left,int mid,int right,int[] temp){

        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid &j<right){

            if(source[i]<=source[j]){
                temp[t++]=source[i++];
            }else{
                temp[t++]=source[j++];
            }

        }


        while (i<=mid){

            temp[t++]=source[i++];
        }

        while (j<=right){
            temp[t++]=source[j++];
        }

        t=0;
        while (left<=right){
            source[left++]=temp[t++];
        }

    }
}
