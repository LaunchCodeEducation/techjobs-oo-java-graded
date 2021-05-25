package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.launchcode.techjobs.oo.test.JobTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by LaunchCode
 */
public class TestTaskFive extends AbstractTest {

    @Test
    public void testTestToStringStartsAndEndsWithNewLineExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testToStringStartsAndEndsWithNewLineMethod = null;

        try {
            testToStringStartsAndEndsWithNewLineMethod = jobTestClass.getMethod("testToStringStartsAndEndsWithNewLine");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringStartsAndEndsWithNewLine method");
        }
    }

    @Test
    public void testTestToStringStartsAndEndsWithNewLineCallsToString (@Mocked Job job) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testToStringStartsAndEndsWithNewLineMethod = jobTestClass.getMethod("testToStringStartsAndEndsWithNewLine");

        new Expectations() {{
            job.toString(); minTimes = 1;
        }};

        try {
            testToStringStartsAndEndsWithNewLineMethod.invoke(jobTest);
        } catch (InvocationTargetException e) {
            // do nothing: we expect this with a mocked Job object
        }
    }

    @Test
    public void testTestToStringStartsAndEndsWithNewLineCallsAssertions (@Mocked Assert mockedAssert) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testToStringStartsAndEndsWithNewLineMethod = jobTestClass.getMethod("testToStringStartsAndEndsWithNewLine");

        new Expectations() {{
            Assert.assertEquals('\n', '\n'); minTimes = 2;
        }};

        testToStringStartsAndEndsWithNewLineMethod.invoke(jobTest);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Job job = createJob("Web Developer", "LaunchCode", "StL", "Back-end developer", "Java");
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testTestToStringContainsCorrectLabelsAndDataExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testToStringContainsCorrectLabelsAndDataMethod = null;

        try {
            testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringContainsCorrectLabelsAndData method");
        }
    }

    @Test
    public void testTestToStringContainsCorrectLabelsAndDataCallsToString (@Mocked Job job) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");

        new Expectations() {{
            job.toString(); minTimes = 1;
        }};

        try {
            testToStringContainsCorrectLabelsAndDataMethod.invoke(jobTest);
        } catch (InvocationTargetException e) {
            // do nothing: we expect this with a mocked Job object
        }
    }

    @Test
    public void testTestToStringContainsCorrectLabelsAndDataCallsAssertions (@Mocked Assert mockedAssert) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");

        new Expectations() {{
            Assert.assertEquals(anyString, anyString); minTimes = 1;
        }};

        testToStringContainsCorrectLabelsAndDataMethod.invoke(jobTest);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob("Web Developer", "LaunchCode", "StL", "Back-end developer", "Java");
        String jobString = getJobString(job);
        assertEquals(jobString, job.toString());
    }

    @Test
    public void testTestToStringHandlesEmptyFieldExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testToStringHandlesEmptyField = null;

        try {
            testToStringHandlesEmptyField = jobTestClass.getMethod("testToStringHandlesEmptyField");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringHandlesEmptyField method");
        }
    }

    @Test
    public void testTestToStringHandlesEmptyFieldCallsToString (@Mocked Job job) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testToStringHandlesEmptyField = jobTestClass.getMethod("testToStringHandlesEmptyField");

        new Expectations() {{
            job.toString(); minTimes = 1;
        }};

        try {
            testToStringHandlesEmptyField.invoke(jobTest);
        } catch (InvocationTargetException e) {
            // do nothing: we expect this with a mocked Job object
        }
    }

    @Test
    public void testTestToStringHandlesEmptyFieldCallsAssertions (@Mocked Assert mockedAssert) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testToStringHandlesEmptyField = jobTestClass.getMethod("testToStringHandlesEmptyField");

        new Expectations() {{
            Assert.assertEquals(anyString, anyString); minTimes = 1;
        }};

        testToStringHandlesEmptyField.invoke(jobTest);
    }

    @Test
    public void testToStringHandlesEmptyField() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob("Web Developer", "", "StL", "", "Java");
        String jobString = getJobString(job);
        assertEquals(jobString, job.toString());
    }

}
