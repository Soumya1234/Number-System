package com.base;

import com.base.Exception.setbitException;

import java.util.Arrays;

public class Binary {
    private Bit[] array;
    private int NoOfBits;
    /* Constructor to initialize the Binary object with an Bit array */
    public Binary(Bit[] a)
    {
        array=a;
        NoOfBits=a.length;
    }
    /* The default constructor
    *  Defaults the NoOfBits field to 8
    *  Defaults the array with 0 bits
    */
    public Binary() throws setbitException
    {
        NoOfBits=8;
        for (int i=0;i<NoOfBits;i++) {
            array[i] = new Bit(0);
        }
    }
    /* Constructor
    * Initializes the NoOfBits field to _noofbits
    * Initializes the array with 0 bits
    */
    public Binary(int _noofbits) throws setbitException
    {
        NoOfBits=_noofbits;
        array=new Bit[NoOfBits];
        for (int i=0;i<NoOfBits;i++)
        {
            array[i]=new Bit(0);
        }
    }

    public   Binary addTo(Binary operand) throws setbitException {
        Binary result=new Binary(NoOfBits);
        Bit cf=new Bit(0);
        for (int i=NoOfBits-1;i>=0;i--)
        {
            Bit[] temp1;
            Bit[] temp2;
            temp1=(cf.addTo(this.array[i]));
            temp2=(temp1[0].addTo(operand.array[i]));
            result.array[i]=temp2[0];
            cf=(temp1[1].addTo(temp2[1]))[0];
        }
        return result;
    }


    public  Binary getOnesComplement()
    {
        for(int i=0;i<NoOfBits;i++)
        {
            this.array[i].toggle();
        }
        return this;
    }


    public  Binary getTwosComplement() throws setbitException
    {
        Binary temp=new Binary(NoOfBits);
        temp.array[NoOfBits-1].toggle();
        return this.getOnesComplement().addTo(temp);
    }

    /* Parses Binary object from a String object
     * Useful for assigning Binary objects from binary strings read from console
     */
    public static Binary parseBinary(String bin_str) throws setbitException
    {
        int str_len=bin_str.length();
        Bit[] bits=new Bit[str_len];
        for(int i=0;i<str_len;i++)
        {
            bits[i]=new Bit(bin_str.charAt(i)-'0');
        }
        return new Binary(bits);
    }
    /*
     Returns the Binary object as String
     */
    @Override
    public String toString()
    {
        char[] output=new char[NoOfBits];
        for (int i=0;i<NoOfBits;i++)
        {
            output[i]=(char)48;
        }
        String binarystr="";
        for (int i=0;i<NoOfBits;i++)
        {
            output[i]=this.array[i].getchar();
            binarystr=binarystr+output[i];
        }
        return binarystr;
    }
    /*
    Returns a decimal object of Integer version
     */
    public Decimal getDecimalInt() throws setbitException {
        Binary temp=new Binary(NoOfBits);
        boolean negativeFlag=false;
        if(array[0].getchar()=='1')
        {
            negativeFlag=true;
            int i=NoOfBits-1;
            do
            {
                temp.array[i]=new Bit(this.array[i]);

            }while(this.array[i--].getchar()!='1');
            Binary temp2=this.getOnesComplement();
            for(int x=i;x>=0;x--)
            {
                temp.array[x]=new Bit(temp2.array[x]);
            }
        }
        else
        {
            temp=this;
        }
        int[] int_bit=new int[NoOfBits];
        for(int i=0;i<NoOfBits;i++)
        {
            int_bit[i]=temp.array[i].getchar()-'0';
        }
        int decimalInt=0;
        int exponent=0;
        for(int i=NoOfBits-1;i>=0;i--)
        {
            decimalInt+=int_bit[i]*Math.pow(2,exponent++);
        }
        Decimal decimal;
        if(negativeFlag)
        {
            decimal=new Decimal(0-decimalInt);
        }
        else
        {
            decimal=new Decimal(decimalInt);
        }
        return decimal;
    }
}
