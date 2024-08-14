package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.FinancingFactory;

public class FinancingTests {

    @Test
    public void constructorShouldCreateObjectWhenTheDataAreCorrect(){
        Financing financing = FinancingFactory.createValidFinancing();

        Assertions.assertEquals(100000.0, financing.getTotalAmount());
        Assertions.assertEquals(2000.0, financing.getIncome());
        Assertions.assertEquals(80, financing.getMonths());
    }

    @Test
    public void constructorShouldThrowExceptionWhenTheDataAreInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            Financing financing = FinancingFactory.createInvalidFinancing();
        });
    }

    @Test
    public void totalAmountShouldSetWhenValidData(){
        //Arrange
        Financing financing = FinancingFactory.createValidFinancing();

        //Action
        financing.setTotalAmount(90000.0);

        //Assert
        Assertions.assertEquals(90000.0, financing.getTotalAmount());
    }

    @Test
    public void totalAmountShouldThrowExceptionWhenTheDataAreInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = FinancingFactory.createValidFinancing();

            financing.setTotalAmount(1000000.0);
        });
    }



    @Test
    public void entryShouldCalculateTheValueOfEntry(){
        Financing financing = FinancingFactory.createValidFinancing();
        double expectedValue = 20000.0;

        Assertions.assertEquals(expectedValue, financing.entry());
    }

    @Test
    public void quotaShouldCalculateTheValueOfQuota(){
        Financing financing = FinancingFactory.createValidFinancing();
        double expectedValue = 1000.0;

        Assertions.assertEquals(expectedValue, financing.quota());
    }


}
