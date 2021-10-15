package singleton;

public class SingletonLazy {

    private volatile SingletonLazy uniqueInstance;
    private SingletonLazy(){

    }

    public SingletonLazy getUniqueInstance() {

        if(uniqueInstance==null){
            synchronized (SingletonLazy.class){
                if(uniqueInstance==null){
                    uniqueInstance=new SingletonLazy();
                }
            }
        }
        return uniqueInstance;
    }
}
