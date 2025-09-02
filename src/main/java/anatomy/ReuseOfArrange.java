package anatomy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReuseOfArrange {

    Calculator sut;

    /**
     * Для избегания множественных повторений одного и того же кода,
     * часть подготовки можно вынести в отдельный метод с аннотацией BeforeEach.
     * Данный метод будет выполняться перед каждым вызовом метода с аннотацией Test в этом классе.
     */
    @BeforeEach
    public void arrange(){
        sut = new Calculator(10 );
    }

    /**
     * Обратите внимание на имя метода. Он не соответствует стилю Java, однако полностью осмысленнен и понятен любому человеку,
     * даже не программисту. При этом имя метода не привязано к имени тестируемого метода.
     */
    @Test
    public void Add_positive_number_and_get_sum(){
        //Act
        sut.addToSum(5);
        double sum = sut.getSum();

        //Assert
        assertEquals(sum, 15);

    }

    @Test
    public void Add_negative_number_and_get_sum(){
        //Act
        sut.addToSum(-11);
        double sum = sut.getSum();

        //Assert
        assertEquals(sum, -1);

    }
}
