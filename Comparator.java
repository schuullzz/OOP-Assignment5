//Comparator class. Implements Comparator and Serializable.

public class Comparator implements java.util.Comparator<ComplexMatrix>,
        java.io.Serializable{
    //Compare method takes in two instances of ComplexMatrix. It compares
    //them and either return a -1 or 1. If they are equal the it returns
    // a 0.
    @Override
    public int compare(ComplexMatrix a, ComplexMatrix b)
    {
       if(a.getImag() < b.getImag())
       {
           return -1;
       }
       else if (a.getImag() > b.getImag())
       {
           return 1;
       }
       else
       {
           return 0;
       }
    }
   
}
