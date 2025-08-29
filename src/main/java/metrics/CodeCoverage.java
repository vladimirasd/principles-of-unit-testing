package metrics;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeCoverage {

    /*
    Тесты для методов
     */
    @Test
    void codeCoverageTest(){
        assertEquals(false, testMethod1(20));
        assertEquals(false, testMethod2(20));
        assertEquals(true, testMethod3("1"));
    }

    /*
     * Базовый метод, сравнивающий число с 10, очевидно, что для этого метода покрытие 66%
     */
    private boolean testMethod1(int a){
        if(a < 10){
            return true;
        }
        return false;
    }
    /* Сокращенная версия первого метода, несмотря на отсутвие хоть какой-то принципиальной разницы здесь покрытие уже 100%
    *  хотя тест все равно плохой, так как даже не обрабывает все возможные варианты аргумента метода
     */
    private boolean testMethod2(int a){
        return a<10;
    }
    /*
    Branch coverage не будет учитывать ветвление в методе valueOf и таким образом будет равено 100%.
     */
    private boolean testMethod3(String a){
        return Integer.valueOf(a).getClass() == Integer.class;
    }

}
