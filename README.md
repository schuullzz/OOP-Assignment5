# OOP-Assignment5: Complex Matrices
## Project5.java Comparator.java Complex.java ComplexMatrix.java GenericMatrix.java 

* An extension from textbook problem.
* This project is designed to get practice using comparators, generics, and containers. 

## Installation

OOP-Assignment5 has been tested on CentOS v6.10 with gcc v6.1.0.

```
make
```

## Usage

```
java Project5

```
* Program

```
User is prompted to select Task 1, Task 2, Task 3, or Quit.

Task 1: Complex class stores complex numbers of the form a + bi. Demonstrates add, subtract, 
multiply, divide, and abs for complex numbers. toString method returns a string representation 
of the number in the form a + bi. It is Comparable and Cloneable (deep copy). 

Task 2: ComplexMatrix class extends GenericMatrix class in section 19.9 in textbook and implements 
add, multiply, and zero, and toString. Creates two matrices and user is prompted for size of both
matrices. Matrices are filled with random numbers. Comparable interface is used when comparing total 
magnitude of real parts.

Task 3: User is prompted for a number of matrices and their size in rows and columns. Using an ArrayList 
and a LinkedList. They are filled with random numbers. Displays to screen using toString. ArrayList is sorted
using comparator. The comparator compares ComplexMatrix objects by the total magnitude of their imaginary 
parts. Displays the ArrayList and then the LinkedList.
```
