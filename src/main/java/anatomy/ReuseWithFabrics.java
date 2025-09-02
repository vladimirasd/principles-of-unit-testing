package anatomy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReuseWithFabrics {


    /**
     * Так же вместо аннотации BeforeEach можно использовать фабричные методы.
     * Этот метод служит исключительно для демонстрации: в таком методе может содержаться сложная логика
     * и большой набор действии.
     */
    private Calculator createCalc(){
        return new Calculator(10 );
    }

    /**
     * Обратите внимание на имя метода. Он не соответствует стилю Java, однако полностью осмыслено и понятно любому человеку, даже не программисту.
     * При этом имя метода не привязано к имени тестируемого метода, а лишь логически описывает само действие.
     */
    @Test
    public void Add_positive_number_and_get_sum(){
        //Arrange
        Calculator sut = createCalc();

        //Act
        sut.addToSum(5);
        double sum = sut.getSum();

        //Assert
        assertEquals(sum, 15);

    }

    @Test
    public void Add_negative_number_and_get_sum(){
        //Arrange
        Calculator sut = createCalc();

        //Act
        sut.addToSum(-11);
        double sum = sut.getSum();

        //Assert
        assertEquals(sum, -1);

    }
}
