package com.example.axoncommandhandler;


import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.jupiter.api.Test;

class TomTest {

  @Test
  public void testCreateTom() {
    AggregateTestFixture<Tom> fixture = new AggregateTestFixture<>(Tom.class);

    fixture
        .givenNoPriorActivity()
        .when(new CreateTomCommand("tom1", "NotTom"))
        .expectException(IllegalArgumentException.class);
  }

}