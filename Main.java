interface Calculator {
    void add(int a, int b);
}

class Test implements Calculator {
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator c = new Test();
        c.add(5, 10);
    }
}