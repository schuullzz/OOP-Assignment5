//Tim Schultz
//Professor Hauschild
//CS 2261
//Project 5

import java.util.*;

public class Project5 {
   public static void main(String args[])throws CloneNotSupportedException
   {
       //holds users choice from menu.
       int choice;
       //holds value to control do-while loop.
       boolean check = true;
       
       //Will continue until user chooses three to quit.
       do{
           //Displays the choices.
           menu();
           //returns users choice.
           choice = menuChoice();
            switch(choice){
                //calls task1 when one is choice.
                case 1: task1(); break;
                //calls task2 when two is choice.
                case 2: task2(); break;
                //Calls trask3 when three is choice.
                case 3: task3(); break;
                //breaks do-while loop when four is choice.
                case 4: check = false; break;
                //Prints out when user types a number outside of 1-4.
                default: System.out.println("You have entered an invalid "
                        + "choice try again.");
            }    
       }while(check == true);
       
   }
   
   //Displays choices for program.
   public static void menu()
   {
       System.out.println("Project 5:\n1. Task 1\n2. Task 2 \n3. Task 3\n"
               + "4. Quit\n");
   }
   
   //Prompts user to pick a number from menu and returns it to main.
   public static int menuChoice()
   {
       Scanner input = new Scanner(System.in);
       int choice;
       
       System.out.println("Which task would you like to perform?");
       choice = input.nextInt();
       return choice;
   }
   
   public static void task1()
   {
       //Below can be used in placement of textbook values provided.
       
       //Complex first = new Complex((double)(Math.random() * 100 + 1),
       //        (double)(Math.random() * 100 + 1));
       //Complex second = new Complex((double)(Math.random() * 100 + 1),
       //        (double)(Math.random() * 100 + 1));
       
       //Creates two complex instances and sets there values.
       //Values taken from the textbook.
       Complex first = new Complex(3.5, 5.5);
       Complex second = new Complex(-3.5, 1);
       
       //Creates a new instance of Complex to add.
       Complex add = new Complex();
       add = add.addition(first, second);
       
       //Displays addition.
       System.out.println("Task 1: \nAddition:");
       System.out.println(first.toString() + " + " + second.toString() +
               " = " + add.toString());
       
       //Creates a new instance of Complex to subtract.
       Complex sub = new Complex();
       sub = sub.subtraction(first, second);
       
       //Displays subtraction.
       System.out.println("Subtraction: ");
       System.out.println(first.toString() + " - " + second.toString() + 
               " = " + sub.toString());
       
       //Creates a new instance of Complex to multiplication.
       Complex mult = new Complex();
       mult = mult.multiplication(first, second);
       
       //Displays product.
       System.out.println("Multiplication: ");
       System.out.println(first.toString() + " * " + second.toString() + 
               " = " + mult.toString());
       
       //Creates a new instance of Complex to divide.
       Complex div = new Complex();
       div = div.divide(first, second);
       
       //Displays divsion.
       System.out.println("Division: ");
       System.out.println(first.toString() + " / " + second.toString() + 
               " = " + div.toString());
       
       //Creates two new complex instances for absolute value.
       Complex abs1 = new Complex();
       Complex abs2 = new Complex();
       
       //Assigns an absolute value.
       abs1 = abs1.absolute(first);
       abs2 = abs2.absolute(second);
       
       //Displays diplays the absolute value.
       System.out.println("Absolute: ");
       System.out.println("|" + first.toString() + "|" + 
               " = " + abs1.absoluteValue);
       System.out.println("|" + second.toString() + "|" + 
               " = " + abs2.absoluteValue + "\n");
       
   }
   
   //Creates two matrices based on user input. Displays those matrices. 
   //Then shows the result of adding and multiplying the two matrices.
   //CompareTo compares based on total magnitude of real parts.
   public static void task2()
   {
       //Holds number of rows of first matrix.
       int row1;
       //Holds number of columns of first matrix.
       int column1;
       //Holds number of rows of second matrix.
       int row2;
       //Holds number of columns of second matrix.
       int column2;
       Scanner input = new Scanner(System.in);
       
       System.out.println("Task 2:");
       
       //Prompts user for rows for matrix 1.
       System.out.println("How many rows do these matrix 1 have?");
       row1 = input.nextInt();
       
       //Prompts user for columns for matrix 1.
       System.out.println("How many columns do these matrix 1 have?");
       column1 = input.nextInt();
       
       //Prompts user for rows of matrix 2.
       System.out.println("How many rows do these matrix 2 have?");
       row2 = input.nextInt();
       
       //Prompts user for columns for matrix 2.
       System.out.println("How many columns do these matrix 2 have?");
       column2 = input.nextInt();
       
       //Creates a matrix based on user specification and fills it with random
       //complex numbers. Random function fills the matrix.
       Complex[][] matrix1 = new Complex[row1][column1];
       matrix1 = random(row1, column1);
       
       //Creates a matrix based on user specification and fills it with random
       //complex numbers. Random function fills the matrix.
       Complex[][] matrix2 = new Complex[row2][column2];
       matrix2 = random(row2, column2);
       
       //Creates a new ComplexMatrix instances and is passed matrix1.
       ComplexMatrix firstMatrix = new ComplexMatrix(matrix1);
       
       //Creates a new ComplexMatrix instances and is passed matrix2.
       ComplexMatrix secondMatrix = new ComplexMatrix(matrix2);
       
       //Displays the first matrix.
       System.out.println("First Matrix:\n" + firstMatrix.toString());
       
       //Displays the second matrix.
       System.out.println("Second Matrix:\n" + secondMatrix.toString());
       
       //Try-catch block that catches a RuntimeException. RuntimeException 
       //occurs when the matrices are not the same size.
       try{
       //Creates a matrix of Complex to hold the two matrices added together.
       Complex[][] addMatrices = new Complex[row1][column1];
       addMatrices = firstMatrix.addMatrix(matrix1, matrix2);
       //Passed the added matrix to a new instance of ComplexMatrix.
       ComplexMatrix m1M2Add = new ComplexMatrix(addMatrices);
       
       //Displays the two matrices added together.
       System.out.println("Addition of matrix 1 and matrix 2:\n"
               + m1M2Add.toString());
       
       //Creates a matrix of Complex to hold the two matrices multiplied
       //together.
       Complex[][] multMatrices = new Complex[row1][column1];
       multMatrices = firstMatrix.multiplyMatrix(matrix1, matrix2);
       //Passed the product of the two matrices to a new instance of 
       //ComplexMatrix.
       ComplexMatrix m1M2Mult = new ComplexMatrix(multMatrices);
       
       //Displays the product of the two matrices.
       System.out.println("Product of matrix 1 and matrix 2:\n"
               + m1M2Mult.toString());
       }
       //Catches the runtime error and displays the passed string.
       catch(RuntimeException e)
       {
           System.out.println(e + "\n");
       }
   }
   
   //Creates both an ArrayList and LinkedList of matrices that have randomly
   //generated complex number. The original ArrayList and LinkedLists are 
   //displayed. Then ArrayList uses compareTo method to compare size based
   //on the sum of real parts. The LinkedList uses a comparator to compare size
   //based on the sum of imaginary parts.
   public static void task3()
   {
       //Holds the number of matrices.
       int matrices;
       //Holds the number of rows of the matrices.
       int row1;
       //Holds the number of columns of the matrices.
       int column1;
       Scanner input = new Scanner(System.in);
       
       //Prompts user for the number of matrices to create.
       System.out.println("How many matrices would you like to create?");
       matrices = input.nextInt();
       
       //Prompts user for the number of rows in each matrix.
       System.out.println("How many rows do these matrices have?");
       row1 = input.nextInt();
       
       //Prompts user for the number of columns in each matrix.
       System.out.println("How many columns do these matrices have?");
       column1 = input.nextInt();
       
       //Creates an ArrayList and a LinkedList.
       ArrayList<ComplexMatrix> set = new ArrayList<>();
       LinkedList<ComplexMatrix> set2 = new LinkedList<>();
       
       //Creates an instance of ComplexMatrix. It is passed a matrix which is
       //randomly assigned complex numbers. This instance is then added to 
       //set which is an ArrayList.
       for(int x = 0; x < matrices; x++)
       {
           set.add(new ComplexMatrix(random(row1, column1)));
       }
       
       //Creates an instance of ComplexMatrix. It is passed a matrix which is
       //randomly assigned complex numbers. This instance is then added to 
       //set2 which is a LinkedList.
       for(int x = 0; x < matrices; x++)
       {
           set2.add(new ComplexMatrix(random(row1, column1)));
       }
       
       System.out.println("\nOriginal ArrayLists:");
       
       //Displays the original ArrayList.
       for(int x = 0; x < matrices; x++)
       {
           System.out.println(set.get(x).toString());
       }
       
       //Sorts ArrayList based on compareTo method.
       Collections.sort(set);
       
       //Displays the newly sorted ArrayList.
       System.out.println("\nSorted ArrayLists:");
       for(int x = 0; x < matrices; x++)
       {
           System.out.println("Sum of Real Part: " + set.get(x).realPart);
           System.out.println(set.get(x).toString());
       }
 
       System.out.println("Original LinkedLists:");
       
       //Displays the LinkedList
       for(int x = 0; x < matrices; x++)
       {
           System.out.println(set2.get(x).toString());
       }
       
       //Sorts LinkedList based on Comparator.
       Collections.sort(set2, new Comparator());
       
       //Displays newly sorted LinkedList.
        System.out.println("\nSorted LinkedLists:");
       for(int x = 0; x < matrices; x++)
       {
           System.out.println("Sum of Imaginary Parts: " + 
                   set2.get(x).imagPart);
           System.out.println(set2.get(x).toString());
       }
   
   }
   
   //Generates random complex numbers.
   public static Complex[][] random(int row1, int column1)
   {
       //Creates a matrix instace of Complex.
       Complex[][] matrix1 = new Complex [row1][column1];
       
       //Fills the matrix with random Complex numbers.
       for(int x = 0; x < matrix1.length; x++)
       {
           for(int z = 0; z < matrix1[0].length; z++)
           {
               matrix1[x][z] = new Complex((double)(Math.random() * 100 + 1), 
               (double)(Math.random() * 100 + 1));
           }
       }
       
       //Returns random matrix.
       return matrix1;
   }       
}
