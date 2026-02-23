import java.util.*;
import java.io.*;

class program433
{
    public static void main(String A[]) 
    {
        try
        {
        File fobj = new File("PPA.txt");

        if(fobj.exists())
        {
            System.out.println("File already exists.");
        }
        else
        {
            fobj.createNewFile();
            System.out.println("File successully created.");
        }
        fobj.createNewFile();
        }
        catch(IOException iobj)
        {}
        catch(Exception eobj)
        {}
    }
}