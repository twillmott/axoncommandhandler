package com.example.axoncommandhandler;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class UpdateTomCommand {
  @TargetAggregateIdentifier
  private final String id;
  private final String name;
}
