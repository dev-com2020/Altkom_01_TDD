public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int addNumbers(int a, int b) {
        return calculateSum(a,b);
    }

    private int calculateSum(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }
}
