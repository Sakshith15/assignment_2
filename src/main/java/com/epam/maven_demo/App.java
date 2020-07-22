package com.epam.maven_demo;

import java.util.Scanner;

interface sortGift
{
	public void sortgift(int numGift,int candies[]);
}
class sort implements sortGift
{
	public void sortgift(int numGift,int candies[])
	{
		int temp=0;
		int d[]=new int[numGift];
		for(int i=0;i<numGift;i++)
		{
			d[i]=i+1;
		}
		for(int i=0;i<numGift;i++)
		{
			for(int j=i+1;j<numGift;j++)
			{
				if(candies[i]>candies[j])
				{
					temp=candies[i];
					candies[i]=candies[j];
					candies[j]=temp;
					temp=d[i];
					d[i]=d[j];
					d[j]=temp;
				}
			}
		}
		for(int i=0;i<numGift;i++)
		{
			System.out.println("gift"+d[i]);
		}
	}
}
abstract class Gift
{
	public abstract int chocweight(int numchoc);
	public abstract int sweetweight(int numsweet);
}
abstract class Choclates extends Gift
{
	int cweight=5;
	public int chocweight(int numchoc)
	{
		return(numchoc*cweight);
	}
}
class Sweets extends Choclates
{
	int sweight=4;
	public int sweetweight(int numsweet)
	{
		return(numsweet*sweight);
	}
}

public class App 
{
    public static void main( String[] args )
    {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the no of children: ");
    	
    	int numGift = input.nextInt();
    	
    	int Gift[] = new int[numGift];
    	
    	Choclates eclairs=new Sweets();
		Choclates waffy=new Sweets();
		int tweight[]=new int[numGift];
		Sweets laddu=new Sweets();
		Sweets kalakand=new Sweets();
		int candies[]=new int[numGift];
		
		for(int i=0;i<numGift;i++)
		{
			int chocweight=0;
			int sweetweight=0;
			int numcandies=0;
			System.out.println("Enter number of eclairs choclates in gift"+(i+1));
			int eclairchoc=input.nextInt();
			chocweight+=eclairs.chocweight(eclairchoc);
			System.out.println("Enter number of waffies choclates in gift"+(i+1));
			int waffychoc=input.nextInt();
			chocweight+=waffy.chocweight(waffychoc);
			System.out.println("Enter number of laddus in gift"+(i+1));
			int numladdu=input.nextInt();
			sweetweight+=laddu.sweetweight(numladdu);
			System.out.println("Enter number of burfee in gift"+(i+1));
			int numkalakand=input.nextInt();
			sweetweight+=kalakand.sweetweight(numkalakand);		
			tweight[i]=chocweight+sweetweight;
			numcandies=eclairchoc+waffychoc+numladdu+numkalakand;
			candies[i]=numcandies;
		}
		System.out.println("Weights of gifts:");
		for(int i=0;i<numGift;i++)
		{
			System.out.print(tweight[i]+"	");
		}
		System.out.println();
		System.out.println("Number of candies:");
		for(int i=0;i<numGift;i++)
		{
			System.out.print(candies[i]+"	");
		}
		System.out.println();
		sortGift s=new sort();
		s.sortgift(numGift,candies);

    }
}
