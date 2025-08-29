package schools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
public class SchoolTest {

    /*
    Пример юнит-теста по Лондонской школе. Юнит - это отдельный класс. С заменой зависимости моком. Я использую  Mockito
     */

    @Test
    void londonSchoolTest(){
        GetSet getSet = Mockito.mock(GetSet.class);
        when(getSet.set("a", "b")).thenReturn(null);
        when(getSet.get("a")).thenReturn("bb");
        BigGetterSetterWithDependency school = new BigGetterSetterWithDependency(getSet);
        assertEquals(null,  school.bigAdd("a", "b", 2));
        assertEquals("bbbb", school.bigGet("a", 2));
    }
    /*
    Пример юнит-теста по Лондонской школе. Юнит - это несколько классов. Вместо мока используется реальный объекта класса.
     */

    @Test
    void classicSchoolTest(){
        GetSet getSet = new GetterSetter();
        when(getSet.set("a", "b")).thenReturn(null);
        when(getSet.get("a")).thenReturn("bb");
        BigGetterSetterWithDependency school = new BigGetterSetterWithDependency(getSet);
        assertEquals(null,  school.bigAdd("a", "b", 2));
        assertEquals("bbbb", school.bigGet("a", 2));
    }

}
