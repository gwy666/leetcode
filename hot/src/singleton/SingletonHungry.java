package singleton;

public class SingletonHungry {

    private SingletonHungry uniqueInstance=new SingletonHungry();

    private SingletonHungry(){

    }

    public SingletonHungry getUniqueInstance() {
        if(uniqueInstance==null){
            uniqueInstance=new SingletonHungry();
        }
        return uniqueInstance;
    }
}
