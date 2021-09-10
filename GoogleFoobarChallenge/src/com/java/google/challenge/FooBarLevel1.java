package com.java.google.challenge;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class FooBarLevel1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> data = new ArrayList<Integer>();
		data.add(1);
		data.add(2);
		data.add(2);
		data.add(3);
		data.add(3);
		data.add(3);
		data.add(4);
		data.add(5);
		data.add(5);
		
		System.out.println(forSortedList(data , 1));

	}
	
	public static List<Integer> forSortedList(List<Integer> data, int n)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		if(data == null || data.size() == 0)
		{
			return result;
		}
		int count = 1;
		int prev = data.get(0);
		for(int i = 1; i < data.size(); i++)
		{
			if(prev == data.get(i))
			{
				count++;
			}else {
				if(count <= n)
				{
					result.add(prev);
				}

				prev = data.get(i);
				count = 1;
			}
		}
		if(count <= n)
		{
			result.add(prev);
		}
		
		return result;
		
	}
	
	public static List<Integer> usingMapUnsorted(List<Integer> data, int n)
	{
		List<Integer> result = new ArrayList<Integer>();
		Map <Integer,Integer> count = new HashMap<Integer,Integer>();
		for(int i = 0; i < data.size(); i++)
		{
			if(count.get(data.get(i)) != null)
			{
				count.put(data.get(i), count.get(data.get(i))+1) ;
			}else {
				count.put(data.get(i), 1) ;
			}
		}
		count.forEach((key,value) -> {
			if(value <= n)
			{
				result.add(key);
			
			}
		});
		
		return result;
		
	}
}
