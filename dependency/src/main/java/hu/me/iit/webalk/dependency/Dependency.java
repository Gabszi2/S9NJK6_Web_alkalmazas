package hu.me.iit.webalk.dependency;

public interface Dependency {
    void helpNoParameterNoReturnValue();
    int helpNoParameterReturnValue();

    int helpWithParameterNoReturnValue(int a);
    //String Important(String text);
    String helpImportant(String text);
}
