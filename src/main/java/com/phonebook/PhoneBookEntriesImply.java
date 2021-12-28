package com.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBookEntriesImply {

    /**
     */
    private static HashMap<String, String> phoneMap = new HashMap<>();
         static {
                phoneMap.put("Krishna", "9621729578");
                phoneMap.put("Shakti", "6387826567");
            }

    /**
     */
    private Map<String, String> phoneMapEntries = phoneMap;

    /**
     * @param name
     * @return Optional.of(phoneMapEntries.get(name))
     */
    public Optional<String> findPhoneNumberByName(final String name) {
        if (phoneMapEntries.containsKey(name)) {
            return Optional.of(phoneMapEntries.get(name));
        }
        return Optional.empty();
    }

    /**
     * @param phoneNumber
     * @return Optional.of(entry.getKey()
     */
    public Optional<String> findNameByPhoneNumber(final String phoneNumber) {

        for (Map.Entry<String, String> entry : phoneMapEntries.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return Optional.of(entry.getKey());
            }
        }
               return Optional.empty();
        }

    /**
     * @return "PhoneBook{" + "phoneBookEntries=" + phoneMapEntries + '}';
     */
    @Override
    public String toString() {
         return "PhoneBook{" + "phoneBookEntries=" + phoneMapEntries + '}';
    }
}


