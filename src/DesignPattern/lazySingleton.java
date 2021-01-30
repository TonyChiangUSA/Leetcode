package DesignPattern;

public class lazySingleton {
    private static lazySingleton INSTANCE;
    public lazySingleton(){

    }
    public static lazySingleton getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new lazySingleton();
        }
        return INSTANCE;
    }
}
