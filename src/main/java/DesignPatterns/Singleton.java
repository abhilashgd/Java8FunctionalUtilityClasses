package DesignPatterns;

/**
 * @version 1.0
 * @author: abhilashgd
 * @since: 1/4/22
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
