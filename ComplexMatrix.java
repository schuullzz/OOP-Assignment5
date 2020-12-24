//Class ComplexMatrix. Sub-class of GenericMatrix from textbook. It
//implements Comparable.

public class ComplexMatrix extends GenericMatrix<Complex> 
        implements Comparable<ComplexMatrix>{
    //Contains a Complex matrix.
    protected Complex[][] matrix;
    //Contains number of rows in matrix.
    protected int row;
    //Contains number of columns in matrix.
    protected int column;
    //Contains sum of real parts.
    protected double realPart = 0;
    //Contains sum of imaginary parts.
    protected double imagPart = 0;
    
    //Contructor that accepts a Complex matrix.
    ComplexMatrix(Complex[][] a)
    {
      //Assigns passed matrix to classes matrix.
      this.matrix = a;
      //Assigns row length of passed matrix.
      this.row = a.length;
      //Assigns column length of passed matrix.
      this.column = a[0].length;
      
      //Calculates total sum of real and imaginary parts.
      for(int x = 0; x < this.row; x++)
      {
          for(int y = 0; y < this.column; y++)
          {
              this.realPart += a[x][y].realNumber;
              this.imagPart += a[x][y].imaginaryNumber;
          }
      }
    }
    
    //Returns sum of all real parts.
    public double getReal()
    {
        return this.realPart;
    }
    
    //Returns sum of all imaginary parts.
    public double getImag()
    {
        return this.imagPart;
    }
   
    //Overrides abstract method add. Takes in two Complex instances. 
    //Returns Complex instance.
    @Override
    protected Complex add(Complex o1, Complex o2)
    {
        //Creates an instace of Complex.
        Complex holder = new Complex();
        //Adds two passed real numbers and assigns to holders realNumber.
        holder.realNumber = o1.realNumber + o2.realNumber;
        //Adds two passed imaginary numbers and assigns them to hodlers
        //imaginaryNumber.
        holder.imaginaryNumber = o1.imaginaryNumber + o2.imaginaryNumber;
        //Returns instance of Complex.
        return holder;
    }
    
    //Overrides abstract method multiply. Takes in two Complex instances.
    //Returns Complex instance.
    @Override
    protected Complex multiply(Complex o1, Complex o2)
    {
        //Creates an instance of Complex class.
        Complex holder = new Complex();
        holder.realNumber = ((o1.realNumber * o2.realNumber)-
                (o1.imaginaryNumber * o2.imaginaryNumber));
        holder.imaginaryNumber = ((o1.imaginaryNumber * o2.realNumber)+
                (o1.realNumber * o2.imaginaryNumber)); 
        //Returns the class instance.
        return holder;
    }
    
    //Overrides abstract method zero. Returns instance of complex.
    @Override
    protected Complex zero()
    {
        //Creates an instance of Complex.
        Complex holder = new Complex();
        //Assigns zero to holders realNumber.
        holder.realNumber = 0;
        //Assigns zero to holders imaginaryNumber.
        holder.imaginaryNumber = 0;
        //Returns instance of Complex.
        return holder;
    }

    //Adds two matrices. Takes in two Complex matrices and returns
    //a Complex matrix.
    @Override
    public Complex[][] addMatrix(Complex[][] matrix1, Complex[][] matrix2) {
    // Check bounds of the two matrices
    if ((matrix1.length != matrix2.length) ||
        (matrix1[0].length != matrix2[0].length)) {
      throw new RuntimeException(
        "The matrices do not have the same size");
    }
    
    //Creates a matrix instance of Complex and assigns row length and
    //column length.
    Complex[][] result =
      new Complex[matrix1.length][matrix1[0].length];

    // Performs addition on the matrices.
    for (int i = 0; i < result.length; i++)
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = add(matrix1[i][j], matrix2[i][j]);
      }

    //Returns instance of Complex.
    return result;
  }
    
    //Multiplies two matrices. Takes in two Complex matrices and returns
    //a Complex matrix.
    @Override
    public Complex[][] multiplyMatrix(Complex[][] matrix1, Complex[][] matrix2) {
    // Check bounds
    if (matrix1[0].length != matrix2.length) {
      throw new RuntimeException(
        "The matrices do not have compatible size");
    }

    //Creates a matrix instance of Complex and assigns row length and
    //column length.
    Complex[][] result =
      new Complex[matrix1.length][matrix2[0].length];

    // Perform multiplication of two matrices
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = zero();

        for (int k = 0; k < matrix1[0].length; k++) {
          result[i][j] = add(result[i][j],
            multiply(matrix1[i][k], matrix2[k][j]));
        }
      }
    }
    
    //Returns instance of Complex.
    return result;
  }
   
   //Displays the matrix. Returns a String of values in matrix.
   @Override
   public String toString()
   {
       String answer = "";
       for(int x = 0; x < this.row; x++)
       {
           answer += "[";
           for(int y = 0; y < this.column; y++)
           {
               if(y == this.column-1)
               {
                   answer = answer + this.matrix[x][y];
               }
               else
               {
                   answer = answer + this.matrix[x][y] + " ";
               }
           }
           answer += "]";
           answer = answer + "\n";
       }
       return answer;
   }
    
    //Overrides method compareTo from interphase comparable. Takes in 
    //ComplexMatrix. Returns an integer.
    @Override
    public int compareTo(ComplexMatrix n) 
    {
        //If this classes realPart is smaller than the ComplexMatrix instance
        //passed in returns -1. If realPart is larger returns 1. If they are
        //equal return 0.
        if(this.realPart < n.realPart)
        {
            return -1;
        }
        else if (this.realPart > n.realPart)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
