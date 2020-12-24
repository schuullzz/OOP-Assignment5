//Complex Class. Implements Comparable and Cloneable.

public class Complex implements Comparable<Complex>,Cloneable{
    //Holds the realNumber of complex number.
    protected double realNumber;
    //Holds the imaginaryNumber of complex number.
    protected double imaginaryNumber;
    //Holds absolute value
    protected double absoluteValue;
    
    //default constructor. It assigns zero to both the real and imaginary
    //number.
    Complex()
    {
        this.realNumber = 0;
        this.imaginaryNumber = 0;
        this.absoluteValue = (Math.sqrt((Math.pow(this.realNumber, 2))+
                (Math.pow(this.imaginaryNumber, 2))));
    }
    
    //Constructor that is only passed a real number and assigns it. 
    //Imaginary number is assigned zero.
    Complex(double real)
    {
        this.realNumber = real;
        this.imaginaryNumber = 0;
        this.absoluteValue = (Math.sqrt((Math.pow(this.realNumber, 2))+
                (Math.pow(this.imaginaryNumber, 2))));
    }
    
    //Constructor that is passed both a real and imaginary number and 
    //assigns them. 
    Complex(double real, double imaginary)
    {
        this.realNumber = real;
        this.imaginaryNumber = imaginary;
        this.absoluteValue = (Math.sqrt((Math.pow(this.realNumber, 2))+
                (Math.pow(this.imaginaryNumber, 2))));
    }
    
    //Returns the real number.
    public double getReal()
    {
        return this.realNumber;
    }
    
    //Return the imaginary number.
    public double getImag()
    {
        return this.imaginaryNumber;
    }
    
    //Sets the real number with the double it is passed.
    public void setReal(double m)
    {
        this.realNumber = m;
    }
    
    //Sets the imaginary number with the double is it passed.
    public void setImag(double m)
    {
        this.imaginaryNumber = m;
    }
    
  
    public Complex addition(Complex o1, Complex o2)
    {
        //Creates an instance of Complex class.
        Complex holder = new Complex();
        //Adds real numbers and assigns it to holders real number.
        holder.realNumber = o1.realNumber + o2.realNumber;
        //Adds imaginary numbers and assigns it to holders imaginary number.
        holder.imaginaryNumber = o1.imaginaryNumber + o2.imaginaryNumber; 
        //Return the class instance.
        return holder;
    }
    
 
    public Complex subtraction(Complex o1, Complex o2)
    {
        //Creates an instance of Complex class.
        Complex holder = new Complex();
        //Subtracts real numbers and assigns it to holders real number.
        holder.realNumber = o1.realNumber - o2.realNumber;
        //Subtracts imaginary numbers and assigns it to holder imaginary number.
        holder.imaginaryNumber = o1.imaginaryNumber - o2.imaginaryNumber; 
        //Returns the class instance.
        return holder;
    }
    

    public Complex multiplication(Complex o1, Complex o2)
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
    
  
    public Complex divide(Complex o1, Complex o2)
    {
        //Creates an instance of Complex class.
        Complex holder = new Complex();
        holder.realNumber = ((o1.realNumber * o2.realNumber)+(o1.imaginaryNumber 
                * o2.imaginaryNumber))/((Math.pow(o2.realNumber, 2)+
                (Math.pow(o2.imaginaryNumber, 2))));
        holder.imaginaryNumber = ((o1.imaginaryNumber * o2.realNumber)
                -(o1.realNumber * o2.imaginaryNumber))/
                ((Math.pow(o2.realNumber, 2)+(Math.pow(o2.imaginaryNumber, 2)))); 
        //Returns the class instance.
        return holder;
    }

    
    public Complex absolute(Complex o1)
    {
        //Creates an instance of Complex class.
        Complex holder = new Complex(o1.realNumber, o1.imaginaryNumber);
        holder.absoluteValue = (Math.sqrt((Math.pow(o1.realNumber, 2))+
                (Math.pow(o1.imaginaryNumber, 2))));
        return holder;
    }
    
    @Override
    public String toString()
    {
        //String that holds formatted real and imaginary number.
        String number = String.format("%.2f" ,this.realNumber) + "+" +
                String.format("%.2f", this.imaginaryNumber) + "i";
        //returns String.
        return number;
    }
    
    //Comparable interphase. Takes an instance of complex.
    @Override
    public int compareTo(Complex n)
    {
        //If both real and imaginary numbers are equal returns 1. If not
        //returns -1.
        if(this.realNumber == n.realNumber && 
                this.imaginaryNumber== n.imaginaryNumber)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    
    //Cloneable interphase. Deep copy.
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        //Creates an instace of Complex and assigns super clone.
        Complex holder = (Complex)super.clone();
        //Holder real number is assigned.
        holder.realNumber = this.realNumber;
        //Holder imaginary number is assigned.
        holder.imaginaryNumber = this.imaginaryNumber;
        //Holder absolute value is assigned.
        holder.absoluteValue = this.absoluteValue;
        //Returns Complex instance.
        return holder;
    }
}
