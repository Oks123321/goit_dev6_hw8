package ua.goit.java.dev6.hw8.uuid;

import java.util.UUID;

class MyUuidApp {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        System.out.println("Your UUID is: " + uuidAsString);
    }
}