package singleton;

public enum SingletonEnum {
    UNIQUEINSTANCE;
    private SingletonEnum(){

    }
    public SingletonEnum getUniqueinstance(){
        return SingletonEnum.UNIQUEINSTANCE;
    }
}
