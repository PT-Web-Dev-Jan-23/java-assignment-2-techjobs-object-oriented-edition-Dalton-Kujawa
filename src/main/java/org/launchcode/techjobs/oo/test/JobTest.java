package org.launchcode.techjobs.oo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job testJob;
    Job identicalJob;
    Job emptyTestJob;
    Job missingDataJob;
    String missingDataJobDisplay;
    String jobShouldDisplyThis;
    String jobDoesntExistDisplay;

//    @Before
//    public void setUp() {
//        testJob = new Job("Dalton", new Employer("WholeFoods"),
//                new Location("Brentwood"), new PositionType("Butcher"),
//                new CoreCompetency("Customer Service"));
//        identicalJob = new Job("Dalton", new Employer("WholeFoods"),
//                new Location("Brentwood"), new PositionType("Butcher"),
//                new CoreCompetency("Customer Service"));
//    }
    @Before
    public void createJobObject() {
        testJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));
        identicalJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));
        missingDataJob = new Job("Dalton",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency("Eating"));
        emptyTestJob = new Job();
        jobShouldDisplyThis = "\nID: 5" +
                "\nName: Dalton" +
                "\nEmployer: WholeFoods" +
                "\nLocation: Brentwood" +
                "\nPosition Type: Butcher" +
                "\nCore Competency: Customer Service\n";
        missingDataJobDisplay = "\nID: 5" +
                "\nName: Dalton" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Eating\n";
        jobDoesntExistDisplay = "OOPS! This job does not seem to exist.";
    }

    @After
    public void resetIdCounts() {
        testJob.setNextId(1);
    }

    @Test
    public void emptyTest() {
        assertEquals(10, 10, .001);
    }

    @Test
    public void testSettingJobId() {
        Job emptyTestJob = new Job();
        Job testJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));
        assertNotEquals(emptyTestJob.getId(), testJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));

        // Tests that each field is assigned to the correct type
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob.getPositionType() instanceof PositionType);

        // Test that the constructor is assigning the field values
        assertEquals("Dalton", testJob.getName());
        assertEquals("WholeFoods", testJob.getEmployer().getValue());
        assertEquals("Brentwood", testJob.getLocation().getValue());
        assertEquals("Customer Service", testJob.getCoreCompetency().getValue());
        assertEquals("Butcher", testJob.getPositionType().getValue());
    }

    @Test
    public void testJobsForEquality() {
       Job testJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));
        assertFalse(testJob.equals(identicalJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));
        assertEquals('\n', testJob.toString().charAt(0));
        assertEquals('\n', testJob.toString().charAt(testJob.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Dalton", new Employer("WholeFoods"),
                new Location("Brentwood"), new PositionType("Butcher"),
                new CoreCompetency("Customer Service"));
        assertEquals(jobShouldDisplyThis, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job missingDataJob = new Job("Dalton",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency("Eating"));

        assertEquals(missingDataJobDisplay, missingDataJob.toString());
    }

    //Bonus
    @Test
    public void testToStringHandlesNoDataAtAll() {
        assertEquals(jobDoesntExistDisplay, emptyTestJob.toString());
    }
}
