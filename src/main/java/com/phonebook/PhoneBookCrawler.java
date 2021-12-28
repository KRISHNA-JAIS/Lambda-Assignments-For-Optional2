package com.phonebook;

import java.util.Optional;
import java.util.stream.Stream;

public class PhoneBookCrawler {

    /**
     */
    private PhoneBookEntriesImply phoneBook;
    /**
     * @param PhoneBook
     */
    public PhoneBookCrawler(final PhoneBookEntriesImply PhoneBook) {
        phoneBook = PhoneBook;
    }

    /**
     * @param name
     */
    public void findPhoneNumberByNameAndPunishIfNothingFound(
            final String name) {
        phoneBook.findPhoneNumberByName(name).orElseThrow(() ->
                new IllegalArgumentException(
                        "No phone number found for Punish"));
    }

    /**
     * @param name
     * @return phoneBook.toString()
     */
    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(
            final String name) {
        return phoneBook.findPhoneNumberByName(name).orElseGet(
                () -> phoneBook.toString());
    }

    /**
     * @param name
     * @param phoneNumber
     * @return phoneBook
     */
    public String findPhoneNumberByNameOrNameByPhoneNumber(
            final String name,
            final String phoneNumber) {

        return Stream.of(phoneBook.findPhoneNumberByName(name),
                        phoneBook.findNameByPhoneNumber(phoneNumber),
                        phoneBook.findPhoneNumberByName(name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
    }

    /**
     * @return phoneBook
     */
    public PhoneBookEntriesImply getPhoneBook() {
        return phoneBook;
    }

}
