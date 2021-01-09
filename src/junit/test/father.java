package junit.test;

public class father extends grandFather{
    void printClass(){
        System.out.println("father");
    }

    void printFather(){
        super.printClass();
    }
}
