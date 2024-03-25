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
   public String readInput() {
    return readInput("Your option: ");
}

  public String readInput(String message) {
      System.out.print(message);
      return scanner.nextLine();
  }

}
