package org.launchcode.techjobs.oo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    Job testJob;
    Job identicalJob;
    Job emptyTestJob;
    Job missingDataJob;
    String missingDataJobDisplay;
    String jobShouldDisplyThis;
    String jobDoesntExistDisplay;
    @Before
    public void createJobObject(){
        Employer testEmployer = new Employer("WholeFoods");
        CoreCompetency testCoreCompetency = new CoreCompetency("Customer Service");
        Location testLocation = new Location("Brentwood");
        PositionType testPositionType = new PositionType("Butcher");
        testJob = new Job("Dalton",testEmployer,testLocation,testPositionType,testCoreCompetency);
        identicalJob = new Job("Dalton",testEmployer,testLocation,testPositionType,testCoreCompetency);
        missingDataJob = new Job("Dalton");
        emptyTestJob = new Job();
        jobShouldDisplyThis = "\nID: 1" +
                "\nName: Dalton" +
                "\nEmployer: WholeFoods" +
                "\nLocation: Brentwood" +
                "\nPositionType: Butcher" +
                "\nCoreCompetency: Customer Service\n";
        missingDataJobDisplay = "\nID: 3"+
                "\nName: Dalton" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPositionType: Data not available" +
                "\nCoreCompetency: Data not available\n";
        jobDoesntExistDisplay ="OOPS! This job does not seem to exist.";
    }
    @After
    public void restIdCounts(){
        testJob.setNextId(1);
    }

    @Test
    public void emptyTest(){
        assertEquals(10,10,.001);
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(emptyTestJob.getId(),testJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        // Tests that each field is assigned to the correct type
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Object);
        assertTrue(testJob.getLocation() instanceof Object);
        assertTrue(testJob.getCoreCompetency() instanceof Object);
        assertTrue(testJob.getPositionType() instanceof Object);

        // Test that the constructor is assigning the field values
        assertEquals("Dalton",testJob.getName());
        assertEquals("WholeFoods",testJob.getEmployer().getValue());
        assertEquals("Brentwood",testJob.getLocation().getValue());
        assertEquals("Customer Service",testJob.getCoreCompetency().getValue());
        assertEquals("Butcher",testJob.getPositionType().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJob.equals(identicalJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        assertEquals('\n',testJob.toString().charAt(0));
        assertEquals('\n',testJob.toString().charAt(testJob.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
    assertEquals(jobShouldDisplyThis,testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        assertEquals(missingDataJobDisplay,missingDataJob.toString());
    }

    //Bonus
    @Test
    public void testToStringHandlesNoDataAtAll(){
        assertEquals(jobDoesntExistDisplay,emptyTestJob.toString());
    }

}
