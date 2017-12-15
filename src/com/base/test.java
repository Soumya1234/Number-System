package com.base;

import com.base.Exception.setbitException;

import java.util.BitSet;
import java.util.Scanner;

public class test
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Enter one decimal input: ");
            Scanner scanner = new Scanner(System.in);
            String decimalStr=scanner.nextLine();
            Decimal d1=new Decimal(Integer.parseInt(decimalStr));
            Binary bin=d1.getBinary(8);
            System.out.println("The binary equivalent of "+ decimalStr +" is: "+bin);
            System.out.println("Converting this binary back to decimal..");
            Decimal d2=bin.getDecimalInt();
            System.out.println("The result is: "+d2);
        }
        catch (setbitException e)
        {
            System.out.println(e.toString());
        }
    }
}