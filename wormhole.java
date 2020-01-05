/*
ID: 02charl1
PROG: wormhole
LANG: JAVA
 */

//PROBLEM ID    :   Wormhole 

import java.util.Scanner;
import java.io.*;

public class wormhole 
{
    //Declares static ints to stop variables from being tied to an instance
    static int numHoles;
    static int[][] a= new int[13][2]; 
    static int[] b = new int[13];
    static int[] c = new int[13];
    
    public static void main(String[] args) throws IOException 
    {

        //Input and output data
        Scanner scan = new Scanner(new File("wormhole.in"));
        PrintWriter pw = new PrintWriter(new File("wormhole.out"));

        //Input data into numHoles
        numHoles = scan.nextInt();

        //Input x and y coordinates and input them into x and y arrays
        for(int i = 1; i <= numHoles; i++) 
        {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }

        //Repeats for number of wormholes to see if cow could get stuck
        for(int i = 1; i <= numHoles; i++) 
        {
            for(int j = 1; j <= numHoles; j++) 
            {
                if(a[j][0] > a[i][0] && a[i][1] == a[j][1]) 
                {
                    if(c[i] == 0 || a[j][0] - a[i][0] < a[c[i]][0] - a[i][0]) 
                    {
                        c[i] = j;
                    }
                }
            }
        }

        scan.close();
        
        //Outputs solver to USACO
        pw.println(solver());
        pw.close();
    }

    public static int solver() 
    {

        //Declares variables
        int total = 0;
        int i = 0;

        //Finds i without j
        for(i = 1; i <= numHoles; i++) 
        {
            if(b[i] == 0)
            {
                break;
            }
        }

        if(i > numHoles) 
        {
            if(check())
            {
                return 1;
            }
            else 
            {
                return 0;
            }
        }

        for(int j = i + 1; j <= numHoles; j++) 
        {

            //Pairs i and j together
            if(b[j] == 0) 
            {
                b[i] = j;
                b[j] = i;
                total += solver();
                b[i] = 0;
                b[j] = 0;
            }
        }

        return total;
    }

    public static boolean check() 
    {
        for(int i = 1; i <= numHoles; i++) 
        {
            int position = i;

            for(int j = 0; j < numHoles; j++) 
            {
                position = c[b[position]];
            }
            
            //Returns true if position is not zero
            if(position != 0) 
            {
                return true;
            }
        }
        //Returns false if position is zero
        return false;
    }

}
