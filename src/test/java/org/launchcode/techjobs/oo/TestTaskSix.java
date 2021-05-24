package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by LaunchCode
 */
public class TestTaskSix extends AbstractTest {

    @Test
    public void testJobFieldClassExists() {
        try {
            Class theClass = getClassByName("JobField");
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.JobField does not exist");
        }
    }

    @Test
    public void testEmployerExtendsJobField() {

        Class employerClass;
        Class jobFieldClass = null;
        Class superclass;

        try {
            jobFieldClass = getClassByName("JobField");
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.Employer does not exist");
        }

        try {
            employerClass = getClassByName("Employer");
            superclass = employerClass.getSuperclass();
            assertEquals(superclass, jobFieldClass);
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.Employer does not exist");
        }

    }

    @Test
    public void testCoreCompetencyExtendsJobField() {

        Class coreCompetencyClass;
        Class jobFieldClass = null;
        Class superclass;

        try {
            jobFieldClass = getClassByName("JobField");
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.Employer does not exist");
        }

        try {
            coreCompetencyClass = getClassByName("CoreCompetency");
            superclass = coreCompetencyClass.getSuperclass();
            assertEquals(superclass, jobFieldClass);
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.CoreCompetency does not exist");
        }

    }

    @Test
    public void testLocationExtendsJobField() {

        Class locationClass;
        Class jobFieldClass = null;
        Class superclass;

        try {
            jobFieldClass = getClassByName("JobField");
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.Employer does not exist");
        }

        try {
            locationClass = getClassByName("Location");
            superclass = locationClass.getSuperclass();
            assertEquals(superclass, jobFieldClass);
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.Location does not exist");
        }

    }

    @Test
    public void testPositionTypeExtendsJobField() {

        Class positionTypeClass;
        Class jobFieldClass = null;
        Class superclass;

        try {
            jobFieldClass = getClassByName("JobField");
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.Employer does not exist");
        }

        try {
            positionTypeClass = getClassByName("PositionType");
            superclass = positionTypeClass.getSuperclass();
            assertEquals(superclass, jobFieldClass);
        } catch (ClassNotFoundException e) {
            fail("Class org.launchcode.techjobs.oo.PositionType does not exist");
        }

    }

}
