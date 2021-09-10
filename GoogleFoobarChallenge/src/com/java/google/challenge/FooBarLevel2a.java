package com.java.google.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FooBarLevel2a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1};
		System.out.println(solution(nums));
	}
	public static int solution(int[] l) {
        // Your code here
		if(l.length == 0)
			return 0;
        Arrays.sort(l);
        Queue<Integer> q0 = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int sum = 0;
        for(int i = 0;i < l.length; i++)
        {
            sum = sum + l[i];
            if(l[i] % 3 == 0)
                q0.add(l[i]);
            else if(l[i] % 3 == 1)
                q1.add(l[i]);
            else
                q2.add(l[i]);
        }
        if(sum % 3 == 1)
        {
            if(!q1.isEmpty())
                q1.remove();
            else{
                if(!q2.isEmpty())
                    q2.remove();
                if(!q2.isEmpty())
                    q2.remove();
            }
        }
        else if(sum % 3 == 2)
        {
            if(!q2.isEmpty())
                q2.remove();
            else{
                if(!q1.isEmpty())
                    q1.remove();
                if(!q1.isEmpty())
                    q1.remove();
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(q0.size() != 0)
            ls.add(q0.remove());
        while(q1.size() != 0)
            ls.add(q1.remove());
        while(q2.size() != 0)
            ls.add(q2.remove());
        Collections.sort(ls);
        String result = "";
        for(int i = ls.size() - 1; i >= 0; i--)
            result += ls.get(i);
        if((result.length() > 1 && result.charAt(0) == '0') || result.length() == 0)
            return 0;
        return Integer.parseInt(result);
    }
	
	public static String largestMultipleOfThree(int[] arr) {
        Arrays.sort(arr);
       Queue<Integer> q0 = new LinkedList<>();
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (arr[i] % 3 == 0)
				q0.add(arr[i]);
			else if ((arr[i] % 3) == 1)
				q1.add(arr[i]);
			else
				q2.add(arr[i]);
		}
		if (sum % 3 == 1) {
			if (!q1.isEmpty())
				q1.remove();
           else {
				if (!q2.isEmpty()) 
					q2.remove();
				
               if (!q2.isEmpty())
					q2.remove();
           }
		} else if (sum % 3 == 2) {
			if (!q2.isEmpty()) 
				q2.remove();
           else {
				if (!q1.isEmpty()) 
					q1.remove();
               if (!q1.isEmpty()) 
					q1.remove();
           }
		}
		List<Integer> ls=new ArrayList<>();
       while (q0.size()!=0)
			ls.add(q0.remove());
		while (q1.size()!=0)
			ls.add(q1.remove());
		while (q2.size()!=0)
			ls.add(q2.remove());
       Collections.sort(ls);
       String out="";
		for (int i = ls.size()-1; i >= 0; i--) 
			out+=ls.get(i);
       if(out.length()>1&&out.charAt(0) == '0')
           return "0";
       return out;    
   }

}
