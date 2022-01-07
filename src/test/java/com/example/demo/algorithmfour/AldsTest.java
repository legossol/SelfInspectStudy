package com.example.demo.algorithmfour;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("spacesize calc")
class AldsTest {
  private ByteArrayOutputStream getSystemOutputStream(String input) {
    System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    return outputStream;
  }
  @Test
  @DisplayName("simple test")
  void simpleTest() throws IOException {
    String input = "\\\\///";
    String expected = "4\r   \n"+"1 4\r\n";
    ByteArrayOutputStream outputStream = getSystemOutputStream(input);

    MountainPoolCount.main(new String[0]);

    assertThat(outputStream.toString()).hasToString(expected.toString());

  }

}