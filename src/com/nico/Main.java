/*
Eduardo Dominico Llosa
Midterm Practical Exam
CSCC 20 B - OBJECT-ORIENTED PROGRAMMING
*/

package com.nico;

import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // child class object
	    ChildClass childClass = new ChildClass();
            childClass.testInput();
            childClass.differences(childClass.preTestInput, childClass.postTestInput);
            childClass.summationDifference(childClass.differences);
            childClass.summationSquared(childClass.differences);
            childClass.computeMean(childClass.preTest, childClass.postTest);
            childClass.tValue();
    }
}
// Abstract Parent class with abstract methods
abstract class Parent{
    public abstract void tValue();
    public abstract void differences(double[] preInput, double[] postInput);
    public abstract void computeMean(double x, double y);
    public abstract void summationDifference(double[] difference);
    public abstract void summationSquared(double[] difference);
}
// Child class of the Parent class,that consist of methods inherited from the abstract class, and methods for the process of calculating the T-Value.
class ChildClass extends Parent{
    Scanner read = new Scanner(System.in);

    int testCaseSize = 15;
    double[] differences = new double[testCaseSize];
    double summationDifference;
    double preTest,postTest;
    double summationSquared;
    double preTestMean, postTestMean;
    double[] preTestInput = new double[testCaseSize];
    double[] postTestInput = new double[testCaseSize];
    double compute;
    double tStat;

    void testInput(){
        System.out.println("Enter Pre Test:");
        for (int i = 0; i < testCaseSize ; i++) {
            preTestInput[i] = read.nextInt();
            preTest += preTestInput[i];
        }
        System.out.println("----------------");

        System.out.println("Enter Post Test: ");
        for (int i = 0; i < testCaseSize ; i++) {
            postTestInput[i] = read.nextInt();
            postTest += postTestInput[i];
        }
    }
    void setTValue(){
        compute =  Math.sqrt(((testCaseSize * summationSquared) - (Math.pow(summationDifference, 2))) / (testCaseSize - 1));
        tStat = summationDifference / compute;
    }
    void setTwoMean(double preMean, double postMean){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        preTestMean = preMean / testCaseSize;
        postTestMean = postMean / testCaseSize;

        System.out.println("Pre-Test Mean: " + decimalFormat.format(preTestMean));
        System.out.println("Post-Test Mean: " + decimalFormat.format(postTestMean));
    }
    void setDifference(double[] preInput, double[] postInput){
        for (int i = 0; i < testCaseSize; i++) {
            differences[i]+= preInput[i] - postInput[i];
        }
    }
    void setSummationDifference(double[] difference){
        for (int i = 0; i < testCaseSize; i++) {
            summationDifference += difference[i];
        }
    }
    void setSummationSquared(double[] difference){
        for (int i = 0; i < testCaseSize; i++) {
            summationSquared += Math.pow(difference[i],2);
        }
    }
    // overriding abstract methods from parent class
    @Override
    public void tValue() {
        setTValue();
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        System.out.println("The T value is: " + decimalFormat.format(tStat));
    }
    @Override
    public void differences(double[] preInput, double[] postInput) {
        setDifference(preInput,postInput);
    }
    @Override
    public void computeMean(double x, double y) {
       setTwoMean(x, y);
    }
    @Override
    public void summationDifference(double[] difference) {
        setSummationDifference(difference);
    }
    @Override
    public void summationSquared(double[] difference) {
        setSummationSquared(difference);
    }
}