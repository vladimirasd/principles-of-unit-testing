package anatomy;

public class Calculator {

    private double sum = 0;

    public double sum(double a, double b){
        return a + b;
    }

    public void addToSum(double a){
        sum += a;
    }

    public Calculator(){};

    public Calculator(double sum){
        this.sum = sum;
    }

    public double getSum(){
        return sum;
    }

}
