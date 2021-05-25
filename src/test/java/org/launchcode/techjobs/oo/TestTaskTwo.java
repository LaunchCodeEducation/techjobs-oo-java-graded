package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
public class TestTaskTwo extends AbstractTest {

    @Test
    public void testSecondLocationConstructorExists() throws ClassNotFoundException {

        Class theClass = getClassByName("Location");
        Constructor theConstructor = null;
        try {
            theConstructor = theClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            fail("Location does not have a constructor that takes a String parameter");
        }
    }

    @Test
    public void testSecondLocationConstructorInitializesValue() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class theClass = getClassByName("Location");
        Constructor theConstructor = null;
        try {
            theConstructor = theClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            fail("Location does not have a constructor that takes a String parameter");
        }

        String locValue = "A location";
        Location newLocation = (Location) theConstructor.newInstance(locValue);
        assertEquals(locValue, newLocation.getValue());
    }

    @Test
    public void testSecondLocationConstructorInitializesId() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class locationClass = getClassByName("Location");
        Constructor secondConstructor = locationClass.getConstructor(String.class);
        Location loc = (Location) secondConstructor.newInstance("a location");
        assertTrue(loc.getId() > 0);
    }

    @Test
    public void testCoreCompetencyHasValueAccessors() throws ClassNotFoundException {
        Class coreCompetencyClass = getClassByName("CoreCompetency");

        try {
            coreCompetencyClass.getMethod("getValue");
        } catch (NoSuchMethodException e) {
            fail("CoreCompetency does not have a getValue method");
        }

        try {
            coreCompetencyClass.getMethod("setValue", String.class);
        } catch (NoSuchMethodException e) {
            fail("CoreCompetency does not have a setValue method");
        }
    }

    @Test
    public void testCoreCompetencyHasIdGetter() throws ClassNotFoundException {
        Class coreCompetencyClass = getClassByName("CoreCompetency");

        try {
            coreCompetencyClass.getMethod("getId");
        } catch (NoSuchMethodException e) {
            fail("CoreCompetency does not have a getId method");
        }
    }

    @Test
    public void testCoreCompetencyHasNoIdSetter() throws ClassNotFoundException {
        Class coreCompetencyClass = getClassByName("CoreCompetency");

        try {
            coreCompetencyClass.getMethod("setId", int.class);
            fail("CoreCompetency should not have a setId method");
        } catch (NoSuchMethodException e) {
            String asdf = "";
        }
    }

    @Test
    public void testPositionTypeToStringMethod()  {
        String aValue = "a position type";
        PositionType positionType = new PositionType(aValue);
        assertEquals(aValue, positionType.toString());
    }

    @Test
    public void testPositionTypeEqualsMethod() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        PositionType positionType = new PositionType("asdf");
        PositionType anotherPositionType = new PositionType("asdf");

        /*
         * Look for .equals either on PositionType or its superclass.
         * If looking on the superclass, ensure that the student has
         * created the JobField base class and pulled the method up.
         * */
        try {
            PositionType.class.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            try {
                Class jobFieldClass = getClassByName("JobField");
                Class superclass = PositionType.class.getSuperclass();
                assertEquals(jobFieldClass, superclass);
                superclass.getDeclaredMethod("equals", Object.class);
            } catch (NoSuchMethodException | ClassNotFoundException ex) {
                fail("PositionType does not declare an equals method");
            }
        }

        assertTrue(positionType.equals(positionType));
        assertFalse(positionType.equals(anotherPositionType));
        assertNotEquals(positionType.getId(), anotherPositionType.getId());

        // Use reflection to make both objects have the same id and test
        Field anotherPositionTypeIdField;
        try {
            anotherPositionTypeIdField = PositionType.class.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            anotherPositionTypeIdField = PositionType.class.getSuperclass().getDeclaredField("id");
        }
        anotherPositionTypeIdField.setAccessible(true);
        anotherPositionTypeIdField.set(anotherPositionType, positionType.getId());
        assertTrue(positionType.equals(anotherPositionType));
    }

    @Test
    public void testPositionTypeHashCodeMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class positionTypeClass = getClassByName("PositionType");
        PositionType positionType = new PositionType("asdf");
        PositionType anotherPositionType = new PositionType("asdf");
        Method hashCodeMethod = positionTypeClass.getMethod("hashCode");

        try {
            PositionType.class.getDeclaredMethod("hashCode");
        } catch (NoSuchMethodException e) {
            try {
                Class jobFieldClass = getClassByName("JobField");
                Class superclass = PositionType.class.getSuperclass();
                assertEquals(jobFieldClass, superclass);
                superclass.getDeclaredMethod("hashCode");
            } catch (NoSuchMethodException | ClassNotFoundException ex) {
                fail("PositionType does not declare an hashCode method");
            }
        }

        assertEquals(hashCodeMethod.invoke(positionType), hashCodeMethod.invoke(positionType));
        assertNotEquals(hashCodeMethod.invoke(positionType), hashCodeMethod.invoke(anotherPositionType));

        // Use reflection to make both objects have the same id and test
        Field anotherPositionTypeIdField;
        try {
            anotherPositionTypeIdField = PositionType.class.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            anotherPositionTypeIdField = PositionType.class.getSuperclass().getDeclaredField("id");
        }

        anotherPositionTypeIdField.setAccessible(true);
        anotherPositionTypeIdField.set(anotherPositionType, positionType.getId());
        assertEquals(hashCodeMethod.invoke(positionType), hashCodeMethod.invoke(anotherPositionType));
    }

}
