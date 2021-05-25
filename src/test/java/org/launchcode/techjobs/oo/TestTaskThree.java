package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
public class TestTaskThree extends AbstractTest {

    @Test
    public void testHasNoArgConstructor() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");
        Constructor<Job> noArgConstructor = null;
        try {
            noArgConstructor = jobClass.getConstructor();
        } catch (NoSuchMethodException e) {
            fail("Job does not have a default/no-arg constructor");
        }

    }

    @Test
    public void testNoArgConstructorInitializesIdField () throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class jobClass = getClassByName("Job");
        Constructor<Job> noArgConstructor = jobClass.getConstructor();
        Job job = noArgConstructor.newInstance();
        Field idField = jobClass.getDeclaredField("id");
        idField.setAccessible(true);
        assertTrue(idField.getInt(job) != 0);
    }

    @Test
    public void testNoArgConstructorSetsUniqueIds () throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class jobClass = getClassByName("Job");
        Constructor<Job> noArgConstructor = jobClass.getConstructor();
        Job aJob = noArgConstructor.newInstance();
        Job anotherJob = noArgConstructor.newInstance();
        Field idField = jobClass.getDeclaredField("id");
        idField.setAccessible(true);
        assertNotEquals(idField.getInt(aJob), idField.getInt(anotherJob));
    }

    @Test
    public void testSecondConstructorArguments() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobClass = getClassByName("Job");
        Constructor<Job> noArgConstructor = null;
        try {
            noArgConstructor = jobClass.getConstructor(
                    String.class,
                    Employer.class,
                    Location.class,
                    PositionType.class,
                    CoreCompetency.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not have a second constructor with the appropriate arguments");
        }
    }

    @Test
    public void testSecondConstructorInitializesProperties() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Class jobClass = getClassByName("Job");
        Constructor<Job> secondConstructor = jobClass.getConstructor(
                String.class,
                Employer.class,
                Location.class,
                PositionType.class,
                CoreCompetency.class);

        Job aJob = createJob ("Name", "Employer", "Location", "Position Type", "Core Competency");

        assertNotNull(getJobFieldString(aJob, "name", false));
        assertNotNull(getJobFieldString(aJob, "employer", false));
        assertNotNull(getJobFieldString(aJob, "location", false));
        assertNotNull(getJobFieldString(aJob, "positionType", false));
        assertNotNull(getJobFieldString(aJob, "coreCompetency", false));
    }

    @Test
    public void testSecondConstructorCallsNoArgConstructor (@Mocked Job job) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new Expectations() {{
            new Job(); minTimes = 1; maxTimes = 1;
        }};
        createJob("Name",
                "Employer",
                "Location",
                "Position Type",
                "Core Competency");
    }

    @Test
    public void testNameAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getName");
        } catch (NoSuchMethodException e) {
            fail("Job does not have a getName method");
        }

        try {
            jobClass.getMethod("setName", String.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not have a setName method");
        }
    }

    @Test
    public void testEmployerAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getEmployer");
        } catch (NoSuchMethodException e) {
            fail("Job does not have a getEmployer method");
        }

        try {
            jobClass.getMethod("setEmployer", Employer.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not have a setEmployer method");
        }
    }

    @Test
    public void testLocationAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getLocation");
        } catch (NoSuchMethodException e) {
            fail("Job does not have a getLocation method");
        }

        try {
            jobClass.getMethod("setLocation", Location.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not have a setLocation method");
        }
    }

    @Test
    public void testPositionTypeAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getPositionType");
        } catch (NoSuchMethodException e) {
            fail("Job does not have a getPositionType method");
        }

        try {
            jobClass.getMethod("setPositionType", PositionType.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not have a setPositionType method");
        }
    }

    @Test
    public void testCoreCompetencyAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getCoreCompetency");
        } catch (NoSuchMethodException e) {
            fail("Job does not have a getCoreCompetency method");
        }

        try {
            jobClass.getMethod("setCoreCompetency", CoreCompetency.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not have a setCoreCompetency method");
        }
    }

    @Test
    public void testIdAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getId");
        } catch (NoSuchMethodException e) {
            fail("Job does not have a getId method");
        }

        try {
            jobClass.getMethod("setId", int.class);
        } catch (NoSuchMethodException e) {
            // do nothing, we expect an exception
        }
    }

    @Test
    public void testHasNoNextIdAccessors() throws ClassNotFoundException {
        Class jobClass = getClassByName("Job");

        try {
            jobClass.getMethod("getNextId");
        } catch (NoSuchMethodException e) {
            // do nothing, we expect an exception
        }

        try {
            jobClass.getMethod("setNextId", int.class);
        } catch (NoSuchMethodException e) {
            // do nothing, we expect an exception
        }
    }

    @Test
    public void testEqualsMethod() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Job job = createJob(
                "Name",
                "Employer",
                "Location",
                "Position Type",
                "Core Competency");
        Job anotherJob = createJob(
                "Name",
                "Employer",
                "Location",
                "Position Type",
                "Core Competency");

        try {
            Job.class.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            fail("Job does not declare an equals method");
        }

        assertTrue(job.equals(job));
        assertFalse(job.equals(anotherJob));
        assertNotEquals(getJobId(job), getJobId(anotherJob));

        // Use reflection to make both objects have the same id and test
        Field anotherJobIdField = Job.class.getDeclaredField("id");
        anotherJobIdField.setAccessible(true);
        anotherJobIdField.set(anotherJob, getJobId(job));
        assertTrue(job.equals(anotherJob));
    }

    @Test
    public void testHashCodeMethod() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob(
                "Name",
                "Employer",
                "Location",
                "Position Type",
                "Core Competency");
        Job anotherJob = createJob(
                "Name",
                "Employer",
                "Location",
                "Position Type",
                "Core Competency");
        Method hashCodeMethod = null;

        try {
            hashCodeMethod = Job.class.getDeclaredMethod("hashCode");
        } catch (NoSuchMethodException e) {
            fail("Job does not declare an hashCode method");
        }

        assertEquals(job.hashCode(), job.hashCode());
        assertNotEquals(job.hashCode(), anotherJob.hashCode());

        // Use reflection to make both objects have the same id and test
        Field anotherJobIdField = Job.class.getDeclaredField("id");
        anotherJobIdField.setAccessible(true);
        anotherJobIdField.set(anotherJob, getJobId(job));
        assertEquals(hashCodeMethod.invoke(job), hashCodeMethod.invoke(anotherJob));
    }

}
