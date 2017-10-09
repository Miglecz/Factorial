package com.epam.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialImplTest {
    private final Factorial factorial = new FactorialImpl();

    @DataProvider(name = "dp1")
    Object[][] expected() {
        return new String[][]{{"0", "1"}, {"1", "1"}, {"2", "2"}, {"3", "6"}, {"4", "24"}, {"300", "306057512216440636035370461297268629388588804173576999416776741259476533176716867465515291422477573349939147888701726368864263907759003154226842927906974559841225476930271954604008012215776252176854255965356903506788725264321896264299365204576448830388909753943489625436053225980776521270822437639449120128678675368305712293681943649956460498166450227716500185176546469340112226034729724066333258583506870150169794168850353752137554910289126407157154830282284937952636580145235233156936482233436799254594095276820608062232812387383880817049600000000000000000000000000000000000000000000000000000000000000000000000000"}};
    }

    @Test(dataProvider = "dp1")
    public void testFactorialShouldCalculateProperValue(String input, String output) {
        // Given
        // When
        final String result = factorial.factorial(input);
        // Then
        assertThat("input=" + input, result, equalTo(output));
    }

    @Test(timeOut = 2000, expectedExceptions = ArrayIndexOutOfBoundsException.class) //why not throwing something meaningful?
    public void testFactorialShouldTimeout() {
        // Given
        final String input = "9223372036854775808";
        // When
        factorial.factorial(input);
        // Then
    }
}
