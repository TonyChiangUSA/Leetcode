package DesignPattern;

public class StaticInnerClassSingleton {
    public StaticInnerClassSingleton(){}
    public StaticInnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static class SingletonHolder{
        private static final StaticInnerClassSingleton INSTANCE
                =new StaticInnerClassSingleton();
    }
}
