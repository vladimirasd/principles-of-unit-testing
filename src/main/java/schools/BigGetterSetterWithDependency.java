package schools;

public class BigGetterSetterWithDependency {


    private GetSet getSet;

    /*
    Тестировать юниты намного легче когда в качестве зависимостей используеются интрефейсы
     */
    public BigGetterSetterWithDependency(GetSet getSet){
        this.getSet = getSet;
    }
    /*
    Положить новое значение повторенное несолько раз. Важно что даже такой метод возвращает не void. Так тестировать в разы легче. Заметьте, что почти все методы в java.util.collections возвращают что-то.
     */
    public String bigAdd(String a, String b, int c){
        StringBuilder newB = new StringBuilder();
        for(int i = 0; i < c; ++i)
            newB.append(b);
        return getSet.set(a, newB.toString());
    }

    public String bigGet(String a, int c){
        StringBuilder newB = new StringBuilder();
        String b = getSet.get(a);
        for(int i = 0; i < c; ++i)
            newB.append(b);
        return newB.toString();
    }


}
