package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJobOne;
    Job testJobTwo;
    Job testJobWithConstructor;
    Job testJobWithEmptyValue;

    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
        testJobWithConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobWithEmptyValue = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(testJobOne.getId() != testJobTwo.getId() && (testJobTwo.getId() - testJobOne.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJobWithConstructor.getId() > 0);
        assertTrue(testJobWithConstructor.getName() instanceof String);
        assertTrue(testJobWithConstructor.getEmployer() instanceof Employer);
        assertTrue(testJobWithConstructor.getLocation() instanceof Location);
        assertTrue(testJobWithConstructor.getPositionType() instanceof PositionType);
        assertTrue(testJobWithConstructor.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobOne == testJobTwo);
    }

    @Test
    public void testToStringForBlankLineInBeginningAndEnd() {
        assertTrue(testJobWithConstructor.toString().startsWith("\n"));
        assertTrue(testJobWithConstructor.toString().endsWith("\n"));
    }


    @Test
    public void testToStringContainsLabelForEachFieldAndAppropriateData() {
        assertEquals(testJobWithConstructor.toString(), ("\nID: " + testJobWithConstructor.getId() + "\nName: " + testJobWithConstructor.getName() + "\nEmployer: " + testJobWithConstructor.getEmployer() + "\nLocation: " + testJobWithConstructor.getLocation() + "\nPosition Type: " + testJobWithConstructor.getPositionType() + "\nCore Competency: " + testJobWithConstructor.getCoreCompetency() + "\n"));
    }

    @Test
    public void testEmptyFieldReturnsDataNotAvailable() {
        assertTrue(testJobWithEmptyValue.toString().contains("Data not available"));

    }

    @Test
    public void testOnlyContainsIdReturnsJobDoesNotExist() {
        assertEquals(testJobOne.toString(), "OOPS! This job does not seem to exist.");
    }



}
