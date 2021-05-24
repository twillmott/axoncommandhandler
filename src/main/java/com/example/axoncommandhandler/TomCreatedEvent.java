package com.example.axoncommandhandler;

import lombok.Data;

@Data
public class TomCreatedEvent {
  private final String id;
  private final String name;
}
