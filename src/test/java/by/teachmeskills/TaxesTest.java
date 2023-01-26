package by.teachmeskills;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxesTest {

    private static final String INCORRECT_TAXES_MSG = "Taxes should be %s when salary is %s";

    @Test(dataProvider = "dataProvider")
    public void checkTaxesBasedOnSalary(double salary, double expectedTaxes) {
        double actualTaxes = getTaxesSum(salary);
        Assert.assertEquals(actualTaxes, expectedTaxes, String.format(INCORRECT_TAXES_MSG, expectedTaxes, salary));
    }

    private double getTaxesSum(double salary) {
        final double twentyPercentageFromSalary = salary * 0.2;
        final double thirteenPercentageFromSalary = salary * 0.13;
        final double thirtyPercentageFromSalary = salary * 0.3;
        double taxes;
        if (salary >= 10000 && salary <= 50000) {
            taxes = twentyPercentageFromSalary;
        } else if (salary < 10000) {
            taxes = thirteenPercentageFromSalary;
        } else {
            taxes = thirtyPercentageFromSalary;
        }
        return taxes;
    }

    @DataProvider
    private Object[][] dataProvider() {
        return new Object[][]{
                {0, 0},
                {10000, 2000},
                {50000, 10000},
                {9999.99, 1299.9987},
                {50000.01, 15000.003}
        };
    }
}
