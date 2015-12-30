# Sorting Algorithm Visualizer
A tool that allows for users to observe datasets as they are being manipulated by various sorting algorithms.

## Algorithms implemented (as of December 30, 2015)

* Bubble Sort
* Selection Sort

## How to compile

The program requires the Java Development Kit (JDK) for compilation and makes extensive use of the Swing framework.

1. If it is not already installed on your computer, download and install the JDK from [the Oracle website](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

2. Clone this git repository by running the following command in a Git-enabled terminal:
    * `> git clone https://github.com/jzblee/SortingAlgorithms.git`

3. Navigate into the source directory:
    * `> cd SortingAlgorithms/src`

4. Compile and execute the program by running the following commands:
    * `> javac *.java`
    * `> java SortApp`

## How to use

Upon launch, the program automatically generates a dataset based on the criteria
set within the source code during compile time. Click "Sort now" to sort the dataset immediately (without showing any intermediate progress), "Step" to move the algorithm forward by one step of execution and update the representation, or "Rapidstep" to step through the algorithm to completion. Click the "Scramble" button at any point to generate a new random dataset.

## Credits

This project was created by [Jason Lee](http://github.com/jzblee).
