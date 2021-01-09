package junit.test;

public class son extends father{
    void printClass(){
        System.out.println("son");
    }

    @Override
    void printFather(){
        super.printClass();
    }

    public static void main(String[] args) {
        son s=new son();
        s.printFather();
        father f=new father();
        f.printFather();
    }
}
