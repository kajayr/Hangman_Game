package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.CheckingAllCounts;
import static org.junit.jupiter.api.Assertions.*;

class CheckingAllCountsTest {

    CheckingAllCounts checkingAllCounts;

    @BeforeEach
    void setUp() {
        checkingAllCounts = new CheckingAllCounts();
        System.out.println("Setting up " + checkingAllCounts.getClass());
    }

    @AfterEach
    void tearDown() {
        System.out.println("All tests have been completed");
    }

    @Test
    void getScore() {
        assertEquals(5, checkingAllCounts.getScore(), "Test #1 failed: The score should start from 0");
    }

    @Test
    void getCount() {
        assertEquals(0, checkingAllCounts.getCount(), "Test #1 failed: The value of count should be 5");
    }

    @Test
    void getWinningCount() {
        assertEquals(0, checkingAllCounts.getWinningCount(), "Test #1 failed: The winning count should start from 0");
    }

    @Test
    void getName() {
        assertEquals("store.CheckingAllCounts", checkingAllCounts.getClass().getName(), "Test #1 failed: The class name should be store.CheckingAllCounts");
    }
}