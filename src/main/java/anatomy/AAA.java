package anatomy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAA {
    /**
     * Паттер AAA подразумевает 3 секции теста:
     * arrange ( подготовка),
     * act (действие),
     * assert (проверка)
     */
    @Test
    public void Sum_of_two_numbers(){
        //Arrange
        Calculator sut = new Calculator(); //Обратите внимание на имя объекта типа Calculator. (SUT - System under test)
        double a = 10;
        double b = 20;

        //Act
        double res = sut.sum(a, b); //Обратите внимание, что результат метода сохраняется в отдельную переменную

        //Assert
        assertEquals(30, res);
    }

}
