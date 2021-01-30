package DesignPattern;

public class DoubleValidateSingleton {
    private static DoubleValidateSingleton INSTANCE;
    public DoubleValidateSingleton(){}

    public static DoubleValidateSingleton getINSTANCE() {
        if(INSTANCE==null){
            synchronized (DoubleValidateSingleton.class){
                if(INSTANCE==null){
                    INSTANCE=new DoubleValidateSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
