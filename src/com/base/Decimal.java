package com.base;

import com.base.Exception.setbitException;

public class Decimal {
    private int DecimalInt;

    public Decimal(int a)
    {
        DecimalInt =a;
    }
    public Binary getBinary(int NoOfBits) throws setbitException {
        int a;
        if(DecimalInt<0)
        {
           a=0-DecimalInt;
        }
        else {
            a = DecimalInt;
        }
        Bit[] bit=new Bit[NoOfBits];
        int binary[]=new int[NoOfBits];
        for (int i=0;i<NoOfBits;i++)
        {
            binary[i]=0;
        }
        int i=NoOfBits-1;
        while(a!=0)
        {
            binary[i]=a%2;
            a/=2;
            i--;
        }
        for(int x=0;x<NoOfBits;x++)
        {
            bit[x]=new Bit(binary[x]);
        }
        Binary result=new Binary(bit);
        if(DecimalInt<0)
        {
            return result.getTwosComplement();
        }
        else {
            return result;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(DecimalInt);
    }
}
