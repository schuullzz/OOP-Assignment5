#Author: Timothy Schultz

JFLAGS = -g 
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	  Comparator.java \
	  Complex.java \
	  ComplexMatrix.java \
	  GenericMatrix.java \
	  Project5.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
