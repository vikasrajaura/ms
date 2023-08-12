package p5.ls.cloud.gateway;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



class A {
    void show() {
        System.out.println("in A");
    }
}

class Z extends A {
    void show() throws IOException {
        System.out.println("in Z");
    }

    public static void main(String args[]) {
        A s = new Z();
        s.show();
    }

}