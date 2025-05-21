package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class App {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character("Luke Skywalker", 172, 77, "blue", "male"));
        characters.add(new Character("Darth Vader", 202, 136, "yellow", "male"));
        characters.add(new Character("Leia Organa", 150, 49, "brown", "female"));
        characters.add(new Character("Anakin Skywalker", 188, 84, "blue", "male"));

        // 1. Print names in UPPERCASE using map and forEach

        characters.stream()
                .map(character -> character.getName().toUpperCase())
                .forEach(name -> System.out.println(name));

        System.out.println("-------------------------------------------------------------");

        // 2. Filter characters with mass > 80 using .filter and .collect(Collectors.toList())
        // store the results in a variable called heavyCharacters and display the new list

        // creates new list to hold heavy characters, uses stream method
        List<Character> heavyCharacters = characters.stream()
                // filters characters mass if greater than 80
                .filter(character -> character.getMass() > 80)
                // if character is over 80 they get added to new list, if not they don't get added
                .toList();
        // loops over each character and displays their name and mass
        heavyCharacters.forEach(character -> System.out.println(character.getName() + " " + character.getMass()));

        System.out.println("-------------------------------------------------------------");

        // 3. Create a new list of just character names using .map and .collect(Collectors.toList())
        // the new list should be called names. Display the new list with a loop

        List<String> names = characters.stream()
                .map(character -> character.getName())
                .toList();

        names.forEach(name -> System.out.println(name));

        System.out.println("-------------------------------------------------------------");

        // 4. Use anyMatch to check for blue eyes and let us know if any character has blue eyes

        boolean hasBlueEyes = characters.stream()
                .anyMatch(character -> character.getEyeColor().equalsIgnoreCase("blue"));

        if (hasBlueEyes) {
            System.out.println("Some characters have blue eyes");
        } else {
            System.out.println("Some characters don't have blue eyes");
        }

        System.out.println("-------------------------------------------------------------");

        // 5. Use allMatch to check if all are male and let us know if all characters are male

        boolean allMale = characters.stream()
                .allMatch(character -> character.getGender().equalsIgnoreCase("male"));

        if (allMale) {
            System.out.println("All characters are male");
        } else {
            System.out.println("All characters are not male");
        }

        System.out.println("-------------------------------------------------------------");

        // 6. Use .mapToInt and .sum to calculate total mass of all characters and then display the total mass

        int totalMass = characters.stream()
                .mapToInt(character -> character.getMass())
                .sum();

        System.out.println("Total mass: " + totalMass);
        System.out.println("Average mass: " + totalMass / characters.size());
    }


}
