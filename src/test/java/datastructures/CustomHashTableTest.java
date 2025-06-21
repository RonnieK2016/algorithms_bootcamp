package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class CustomHashTableTest {

    @Test
    void clear() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertTrue(hm.isEmpty());
        Assertions.assertEquals(0, hm.size());
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertFalse(hm.isEmpty());
        Assertions.assertEquals(2, hm.size());
        hm.clear();
        Assertions.assertTrue(hm.isEmpty());
        Assertions.assertEquals(0, hm.size());
    }

    @Test
    void contains() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertTrue(hm.contains("TestValue1"));
        Assertions.assertTrue(hm.contains("TestValue2"));
    }

    @Test
    void containsKey() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertTrue(hm.containsKey("TestKey1"));
        Assertions.assertTrue(hm.containsKey("TestKey2"));
        Assertions.assertFalse(hm.containsKey("TestKey3"));
    }

    @Test
    void containsValue() {
        contains();
    }

    @Test
    void entrySet() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Set<String> expectedKeys = new HashSet<>(Arrays.asList("TestKey1", "TestKey2"));
        Set<String> expectedValues = new HashSet<>(Arrays.asList("TestValue1", "TestValue2"));
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        Assertions.assertEquals(2, entrySet.size());
        for(Map.Entry<String, String> entry : entrySet) {
            Assertions.assertTrue(expectedKeys.contains(entry.getKey()));
            Assertions.assertTrue(expectedValues.contains(entry.getValue()));
            expectedKeys.remove(entry.getKey());
            expectedValues.remove(entry.getValue());
        }
    }

    @Test
    void get() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String[] keys = new String[20000];
        String[] values = new String[20000];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.putIfAbsent(keys[i], values[i]));
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.get(keys[i]));
        }
        Assertions.assertNull(hm.get("NonExistingKey"));
    }

    @Test
    void getOrDefault() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String defaultValue = "DefaultValue";
        String[] keys = new String[20000];
        String[] values = new String[20000];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.putIfAbsent(keys[i], values[i]));
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.getOrDefault(keys[i], defaultValue));
        }
        Assertions.assertEquals(defaultValue, hm.getOrDefault("NonExistingKey", defaultValue));
    }

    @Test
    void isEmpty() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertTrue(hm.isEmpty());
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertFalse(hm.isEmpty());
    }

    @Test
    void keySet() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Set<String> expectedKeys = new HashSet<>(Arrays.asList("TestKey1", "TestKey2"));
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Set<String> keySet = hm.keySet();
        Assertions.assertEquals(2, keySet.size());
        for(String key : keySet) {
            Assertions.assertTrue(expectedKeys.contains(key));
            expectedKeys.remove(key);
        }
    }

    @Test
    void put() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertEquals("TestValue3", hm.put("TestKey3", "TestValue3"));
        Assertions.assertEquals("TestValue4", hm.put("TestKey4", "TestValue4"));
        Assertions.assertEquals("TestValue5", hm.put("TestKey5", "TestValue5"));
        Assertions.assertEquals("TestValue6", hm.put("TestKey6", "TestValue6"));
        Assertions.assertEquals("TestValue7", hm.put("TestKey7", "TestValue7"));
        Assertions.assertEquals("TestValue8", hm.put("TestKey8", "TestValue8"));
        Assertions.assertEquals("TestValue9", hm.put("TestKey9", "TestValue9"));
        Assertions.assertEquals("TestValue10", hm.put("TestKey1", "TestValue10"));
    }

    @Test
    void putIfAbsent() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String[] keys = new String[20000];
        String[] values = new String[20000];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.putIfAbsent(keys[i], values[i]));
        }

        Assertions.assertEquals(keys.length, hm.size());

        Assertions.assertEquals("TestValue_2", hm.putIfAbsent("TestKey_2", "TestValue_3"));
        Assertions.assertEquals("TestValue_1", hm.putIfAbsent("TestKey_1", "TestValue_4"));
    }

    @Test
    void remove() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String[] keys = new String[20000];
        String[] values = new String[20000];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.put(keys[i], values[i]));
        }
        Assertions.assertEquals(keys.length, hm.size());

        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.remove(keys[i]));
        }

        Assertions.assertNull(hm.remove("NonExistingKey"));

        Assertions.assertEquals(0, hm.size());
        Assertions.assertTrue(hm.isEmpty());
    }

    @Test
    void removeWithValue() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String[] keys = new String[20000];
        String[] values = new String[20000];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.put(keys[i], values[i]));
        }
        Assertions.assertEquals(keys.length, hm.size());

        Assertions.assertFalse(hm.remove("TestKey_0", "NonExistingValue"));

        for(int i = 0; i < keys.length; i++) {
            Assertions.assertTrue(hm.remove(keys[i], values[i]));
        }

        Assertions.assertFalse(hm.remove("NonExistingKey", "NonExistingValue"));

        Assertions.assertEquals(0, hm.size());
        Assertions.assertTrue(hm.isEmpty());
    }

    @Test
    void replace() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertEquals("TestValue2", hm.replace("TestKey2", "TestValue3"));
        Assertions.assertEquals("TestValue3", hm.get("TestKey2"));
        Assertions.assertNull(hm.replace("TestKey3", "TestValue4"));
    }

    @Test
    void testReplaceWithOldValue() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        Assertions.assertEquals("TestValue1", hm.put("TestKey1", "TestValue1"));
        Assertions.assertEquals("TestValue2", hm.put("TestKey2", "TestValue2"));
        Assertions.assertTrue(hm.replace("TestKey2", "TestValue2", "TestValue3"));
        Assertions.assertEquals("TestValue3", hm.get("TestKey2"));
        Assertions.assertFalse(hm.replace("TestKe1", "TestValue4", "TestValue5"));
    }

    @Test
    void size() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String[] keys = new String[2000];
        String[] values = new String[2000];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.put(keys[i], values[i]));
            Assertions.assertEquals(i + 1, hm.size());
        }
    }

    @Test
    void values() {
        CustomHashTable<String, String> hm = new CustomHashTable<>();
        String[] keys = new String[200];
        String[] values = new String[200];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = "TestKey_" + i;
            values[i] = "TestValue_" + i;
        }
        Set<String> expectedValues = new HashSet<>(Arrays.asList(values));
        for(int i = 0; i < keys.length; i++) {
            Assertions.assertEquals(values[i], hm.put(keys[i], values[i]));
        }
        Collection<String> actualValues = hm.values();
        Assertions.assertEquals(200, actualValues.size());
        for(String value : actualValues) {
            Assertions.assertTrue(expectedValues.remove(value));
        }
    }
}