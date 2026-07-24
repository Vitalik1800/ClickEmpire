package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;

import com.vs18.clickempire.util.Constants;
import com.vs18.clickempire.util.OfflineIncomeCalculator;

import org.junit.Test;

/**
 * Unit tests for {@link OfflineIncomeCalculator}.
 */
public class OfflineIncomeCalculatorTest {

    /**
     * Verifies that zero offline time
     * produces zero income.
     */
    @Test
    public void calculate_zeroSeconds_shouldReturnZero() {

        long result = OfflineIncomeCalculator.calculate(10, 0);

        assertEquals(0, result);
    }

    /**
     * Verifies that one second of offline time
     * produces correct income.
     */
    @Test
    public void calculate_oneSecond_shouldReturnCorrectIncome() {

        long result = OfflineIncomeCalculator.calculate(10, 1);

        assertEquals(10, result);
    }

    /**
     * Verifies that one minute of offline time
     * produces correct income.
     */
    @Test
    public void calculate_oneMinute_shouldReturnCorrectIncome() {

        long result = OfflineIncomeCalculator.calculate(10, 60);

        assertEquals(600, result);
    }

    /**
     * Verifies that one hour of offline time
     * produces correct income.
     */
    @Test
    public void calculate_oneHour_shouldReturnCorrectIncome() {

        long result = OfflineIncomeCalculator.calculate(10, 3600);

        assertEquals(36000, result);
    }

    /**
     * Verifies that offline income is limited
     * by the maximum allowed offline time.
     */
    @Test
    public void calculate_largeTime_shouldUseOfflineLimit() {

        long result = OfflineIncomeCalculator.calculate(
                10,
                Constants.OFFLINE_LIMIT + 1000
        );

        assertEquals(
                10 * Constants.OFFLINE_LIMIT,
                result
        );
    }

    /**
     * Verifies that multiplication result
     * is calculated exactly.
     */
    @Test
    public void calculate_shouldReturnExactResult() {

        long result = OfflineIncomeCalculator.calculate(7, 15);

        assertEquals(105, result);
    }

    /**
     * Verifies that zero income
     * always returns zero.
     */
    @Test
    public void calculate_zeroIncome_shouldReturnZero() {

        long result = OfflineIncomeCalculator.calculate(0, 3600);

        assertEquals(0, result);
    }
}
