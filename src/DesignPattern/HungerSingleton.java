package DesignPattern;

public class HungerSingleton {
    private static HungerSingleton INSTANCE = new HungerSingleton();
    public HungerSingleton(){}

    public static HungerSingleton getINSTANCE() {
        return INSTANCE;
    }
}
