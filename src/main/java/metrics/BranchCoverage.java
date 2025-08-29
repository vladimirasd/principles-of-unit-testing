package metrics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BranchCoverage {

    /*
    Тесты для методов
     */
    @Test
    void branchCoverageTest(){
        assertEquals(false, testMethod1(20));
        assertEquals(false, testMethod2(20));
    }

    /*
     * Базовый метод, сравнивающий число с 10. Всего ветвей здесь 2. Тесты проверяют одну => покрытие 50%.
     */
    private boolean testMethod1(int a){
        if(a < 10){
            return true;
        }
        return false;
    }
    /* Сокращенная версия первого метода. В данном случае покрытие будет состоялвть уже 50%, вместо 100%. Что одназначно давет более ясный результат.
     */
    private boolean testMethod2(int a){
        return a<10;
    }

}
