package com.example.app;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class InputReader {
  private final Scanner scanner;

  public InputReader() {
    this.scanner = new Scanner(System.in);
  }

  // Method with default value

  /**
   * Reads input from the user with a default message and returns it as a string.
   *
   * @return the input entered by the user
   */
  public String readInput() {
    return readInput("Your option: ");
  }

  /**
   * Reads input from the user and returns it as a string.
   *
   * @param message the message to display to the user before reading input
   * @return the input entered by the user
   */

  public String readInput(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

}