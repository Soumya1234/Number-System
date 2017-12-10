package com.base;

import com.base.Exception.setbitException;

public class Bit
{
    private byte _bit;
    public Bit(int bit) throws setbitException
    {
        if (bit==0)
        {
            _bit=0;
        }
        else if(bit==1)
        {
            _bit=1;
        }
        else
        {
            throw new setbitException("Value of Bit can not be set other than to 1 or 0");
        }
    }
    public void toggle()
    {
        if(_bit==0)
        {
            _bit=1;
        }
        else
        {
            _bit=0;
        }
    }
    public Bit[] addTo(Bit a) throws setbitException {
        Bit[] result=new Bit[2];

        if(this._bit==1 & a._bit==1)
        {
            result[0]=new Bit(0);
            result[1]=new Bit(1);
        }
        else if(this._bit==1 & a._bit==0)
        {
            result[0]=new Bit(1);
            result[1]=new Bit(0);
        }
        else if(this._bit==0 & a._bit==1)
        {
            result[0]=new Bit(1);
            result[1]=new Bit(0);
        }
        else if(this._bit==0 & a._bit==0)
        {
            result[0]=new Bit(0);
            result[1]=new Bit(0);
        }
        return result;

    }
    public char getchar()
    {
        return (char)(_bit+48);
    }
}
