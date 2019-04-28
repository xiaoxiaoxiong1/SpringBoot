package org.Servlet;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

import org.Servlet.eventBus.Event;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
/*@Slf4j*/
public class GuavaTest {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Test
	public void testOptional() {
		Integer a=null;
		Optional<Integer> b=Optional.fromNullable(a);
		
		Integer a1=null;
//	Optional<Integer> b1=Optional.of(a1);
		log.info("{}",b.or(1));;
		
	//	System.out.println(b.get()+b1.get());
	}
	
	@Test
	public void testCollection() {
		HashMap hashMap=new HashMap();
		Hashtable hashtable=new Hashtable();
	  System.out.println(BigDecimal.valueOf(100000001).divide(BigDecimal.valueOf(100000000),2, BigDecimal.ROUND_CEILING).toString() );
	}



	@Test
	public void bingguipaixu(){
		int []a = {9,8,7,6,5,4,3,2,1};
		sort(a);
		System.out.print(Arrays.toString(a));
	}



	private void sort(int[] source){
		int []temp = new int[source.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		sort(source,0,source.length-1,temp);
	}



	private void  sort(int[] source,int left,int right,int [] temp){
		if(left<right){
			int mid = (left+right)/2;
			sort(source,left,mid,temp);//左边归并排序，使得左子序列有序
			sort(source,mid+1,right,temp);//右边归并排序，使得右子序列有序
			merge(source,left,mid,right,temp);//将两个有序子数组合并操作
		}

	}

	private void merge(int[] source,int left,int mid,int right,int[]temp){
	/*	int i = left;//左序列指针
		int j = mid+1;//右序列指针
		int t = 0;//临时数组指针
		while (i<=mid && j<=right){
			if(source[i]<=source[j]){
				temp[t++] = source[i++];
			}else {
				temp[t++] = source[j++];
			}
		}
		while(i<=mid){//将左边剩余元素填充进temp中
			temp[t++] = source[i++];
		}
		while(j<=right){//将右序列剩余元素填充进temp中
			temp[t++] = source[j++];
		}
		t = 0;
		//将temp中的元素全部拷贝到原数组中
		while(left <= right){
			source[left++] = temp[t++];
		}*/
      int i=left;
		int j=mid+1;
		int t=0;
		while (i<=mid&& j<=right){

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
