package hu.me.iit.webalk.dependency;

public class DependencyImpl implements Dependency {
    @Override
    public void helpNoParameterNoReturnValue() {

    }

    @Override
    public int helpNoParameterReturnValue() {

        return 45;
    }

    @Override
    public int helpWithParameterNoReturnValue(int a) {
        return a;

    }

   /* @Override
    public String Important(String text) {
        final String impSign="<b>";
        String impText=impSign.concat(text).concat(impSign);
        return impText;
    }*/

    @Override
    public String helpImportant(String text) {
        return text;
    }
}
