package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // в параметрах жизненный цикл может быть за метод, а может
                                                 // быть за класс, суть в том, что поднимается одно окружение
//@TestMethodOrder(value = MethodOrderer.MethodName.class) -порядок вывода по имени

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)// порядок вывода по аннотации
class CalculatorTest {

    private static Calculator CALCULATOR;
                                              // один калькулятор создаётся только один раз
                                              //@BeforeAll нужны для инициализации AfterAll для закрытия
                                              // а если, дорустим у нас каждый тес как-то меняет объект класса,
                                              // но для каждого последующего он нужен в первоначальном состоянии
                                              // то нам поможет анотация @BeforeEach
    @BeforeAll
    static void  init(){
CALCULATOR =new Calculator();
    }

                                // вот такая анотация позволяет запускать
                                             // метод после каждого теста/метода, если @AfterEach,
    @AfterEach                                             // то метод не статический
    void reset(){
        Calculator.reserAthionAmount();
    }

    @Test
   @Order(3)
        @DisplayName("test A")//@Disabled игнорит помеченный тест
    void addA() {
        int res = CALCULATOR.add(2,3);
        assertEquals(5,res);
        assertEquals(1,Calculator.getAthionAmount());
        System.out.println("A");
    }
    @Test
    @Order(2)
    void addB() {
        int res = CALCULATOR.add(2,3);
        assertEquals(5,res);
        assertEquals(1,Calculator.getAthionAmount());
        System.out.println("B");
    }
    @Test
    @Order(1)
    void addC() {
        int res = CALCULATOR.add(2,3);
        assertEquals(5,res);
        assertEquals(1,Calculator.getAthionAmount());
        System.out.println("C");
    }
                                                //Неправильный тест (он пройдёт, но тестируется букотская ситуация)
    @Test
    void add_faled() {
        int res = CALCULATOR.add(2,3);
        assertNotEquals(6,res);
        assertEquals(1,Calculator.getAthionAmount());

    }
    @Test
    @Timeout(value = 2,unit = TimeUnit.SECONDS)   //Если работа теста длиться больше  чем 2 сек тест упадёт
    void addTimeOut() throws InterruptedException {
        int res = CALCULATOR.add(2,3);
        assertNotEquals(6,res);
        assertEquals(1,Calculator.getAthionAmount());
        Thread.sleep(1000);                   //задержка на 2 сек

    }
    @ParameterizedTest
    @CsvSource({
        "2,3,5",
        "1,1,2",
        "5,5,10"
    })
    void addParametrized(int a, int b,int result) {
        assertEquals(result,CALCULATOR.add(a,b));
    }
    @ParameterizedTest
    @MethodSource("Parametr")
    void addParametrized(int a) {

        assertEquals(a+1,CALCULATOR.add(a,1));
    }

   static List<Integer> Parametr(){
        return List.of(1,2,3,4,5,6);
    }




}