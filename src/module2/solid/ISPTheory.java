package module2.solid;
// ISP - Interface segregation Method

interface Methods{
    void method1();
    void method2();
}

interface MethodsTwo {
    void method3();
    void method4();
    void method5();
}

//we are forced to use all 5 methods which our class WithTwoMethods wont need
//so we segregate interface in two interfaces
class WithTwoMethods implements Methods {
    public void method1(){};
    public void method2(){};
}

class WithThreeMethods implements MethodsTwo {
    @Override
    public void method3() {}

    @Override
    public void method4() {}

    @Override
    public void method5() {}
}

class WithFiveMethods implements Methods, MethodsTwo {
    @Override
    public void method1() {}

    @Override
    public void method2() {}

    @Override
    public void method3() {}

    @Override
    public void method4() {}

    @Override
    public void method5() {}
};

public class ISPTheory {}
