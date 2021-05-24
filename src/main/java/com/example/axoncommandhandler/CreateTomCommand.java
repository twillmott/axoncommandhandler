package com.example.axoncommandhandler;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CreateTomCommand {
  @TargetAggregateIdentifier
  private final String id;
  private final String name;
}
