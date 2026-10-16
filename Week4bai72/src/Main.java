interface Operation<T> {
    T execute(T a, T b);
}

public class Main {
    public static void main(String[] args) {
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> b != 0 ? a / b : 0.0;

        double num1 = 10.5;
        double num2 = 2.5;

        System.out.println("Cong (" + num1 + " + " + num2 + ") = " + add.execute(num1, num2));
        System.out.println("Tru (" + num1 + " - " + num2 + ") = " + subtract.execute(num1, num2));
        System.out.println("Nhan (" + num1 + " * " + num2 + ") = " + multiply.execute(num1, num2));
        System.out.println("Chia (" + num1 + " / " + num2 + ") = " + divide.execute(num1, num2));
    }
}
