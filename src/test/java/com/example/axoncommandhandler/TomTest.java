package com.example.axoncommandhandler;


import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.jupiter.api.Test;

class TomTest {

  @Test
  public void testCreateTom() {
    AggregateTestFixture<Tom> fixture = new AggregateTestFixture<>(Tom.class);

    fixture
        .givenCommands(new UpdateTomCommand("tom1", "Tom"), new DeleteTomCommand("tom1"))
        .when(new UpdateTomCommand("tom1", "Back from the dead"))
        .expectEvents(new TomCreatedEvent("tom1"), new TomUpdatedEvent("tom1", "Back from the dead"));
  }

}