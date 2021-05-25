package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;
import org.launchcode.techjobs.oo.test.JobTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
public class TestTaskFour extends AbstractTest {

    @Tested
    JobTest jobTest;

    @Test
    public void testTestSettingJobIdExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testSettingJobIdMethod = null;

        try {
            testSettingJobIdMethod = jobTestClass.getMethod("testSettingJobId");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testSettingId method");
        }
    }

    @Test
    public void testTestSettingJobIdCallsJobConstructorTwice (@Mocked Job job) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testSettingJobIdMethod = jobTestClass.getMethod("testSettingJobId");


        new Expectations() {{
            new Job(); minTimes = 2; maxTimes = 2;
        }};

        try {
            testSettingJobIdMethod.invoke(jobTest);
        } catch (InvocationTargetException e) {
            // do nothing: this is expected when using a mocked Job instance
        }
    }

    // TODO - this test isn't matching the expectation properly.
//    @Test
//    public void testTestSettingJobIdCallsProperAssertion (@Mocked Assert mockedAssert) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class jobTestClass = getClassByName("test.JobTest");
//        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
//        Method testSettingJobIdMethod = jobTestClass.getMethod("testSettingJobId");
//
//        new Expectations() {{
//            assertNotEquals(anyInt, anyInt);
//        }};
//
//        testSettingJobIdMethod.invoke(jobTest);
//    }

    @Test
    public void testTestJobConstructorSetsAllFieldsExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testSettingJobIdMethod = null;

        try {
            testSettingJobIdMethod = jobTestClass.getMethod("testJobConstructorSetsAllFields");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testJobConstructorSetsAllFields method");
        }
    }

    @Test
    public void testTestJobConstructorSetsAllFieldsCallsAsserts (@Mocked Assert mockedAssert) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testJobConstructorSetsAllFieldsMethod = jobTestClass.getMethod("testJobConstructorSetsAllFields");

        new Expectations() {{
            Assert.assertTrue(anyBoolean); minTimes = 5;
            Assert.assertEquals(anyString, anyString); minTimes = 5;
        }};

        testJobConstructorSetsAllFieldsMethod.invoke(jobTest);
    }

    @Test
    public void testTestJobsForEqualityExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("test.JobTest");

        try {
            jobTestClass.getMethod("testJobsForEquality");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testJobsForEquality method");
        }
    }

    @Test
    public void testTestJobsForEqualityCallsAssertion(@Mocked Assert mockedAssert) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        Method testJobsForEqualityMethod = jobTestClass.getMethod("testJobsForEquality");

        new Expectations() {{
            assertFalse(anyBoolean);
        }};

        testJobsForEqualityMethod.invoke(jobTest);
    }

}
