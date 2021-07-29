package com.example.axoncommandhandler;

import lombok.Data;

@Data
public class TomUpdatedEvent {
  private final String id;
  private final String name;
}
