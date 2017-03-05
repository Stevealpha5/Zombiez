package com.company.Utilities;

public class Util
{
    public static int clamp(int var, int min, int max)
    {
        if(var >= max)
            return max;
        else if(var <= min)
            return min;
        else
            return var;
    }
}
