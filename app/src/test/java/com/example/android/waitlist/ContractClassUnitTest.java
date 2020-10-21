package com.example.android.waitlist;

import android.provider.BaseColumns;

import com.example.android.waitlist.data.WaitlistContract;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ContractClassUnitTest {

    @Test
    public void inner_class_exists() throws Exception {
        Class[] innerClasses = WaitlistContract.class.getDeclaredClasses();
        assertEquals("There should be 1 Inner class inside the contract class", 1, innerClasses.length);
    }

    @Test
    public void inner_class_type_correct() throws Exception {
        Class[] innerClasses = WaitlistContract.class.getDeclaredClasses();
        assertEquals("Cannot find inner class to complete unit test", 1, innerClasses.length);
        Class entryClass = innerClasses[0];
        assertTrue("Inner class should implement the BaseColumns interface", BaseColumns.class.isAssignableFrom(entryClass));
        assertTrue("Inner class should be final", Modifier.isFinal(entryClass.getModifiers()));
        assertTrue("Inner class should be static", Modifier.isStatic(entryClass.getModifiers()));
    }

    @Test
    public void inner_class_members_correct() throws Exception {
        Class[] innerClasses = WaitlistContract.class.getDeclaredClasses();
        assertEquals("Cannot find inner class to complete unit test", 1, innerClasses.length);
        Class entryClass = innerClasses[0];
        Field[] allFields = entryClass.getDeclaredFields();

        final List<Field> allFields2 = new ArrayList<>();
        for (final Field field : allFields) {
            if (!field.getType().equals(WaitlistContract.class)) {
                allFields2.add(field);
            }
        }
        assertEquals("There should be exactly 4 String members in the inner class", 4, allFields2.size());
        for (Field field : allFields2) {
            assertSame("All members in the contract class should be Strings", field.getType(), String.class);
            assertTrue("All members in the contract class should be final", Modifier.isFinal(field.getModifiers()));
            assertTrue("All members in the contract class should be static", Modifier.isStatic(field.getModifiers()));
        }
    }
}