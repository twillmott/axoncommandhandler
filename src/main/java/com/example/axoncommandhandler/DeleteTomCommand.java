package com.example.axoncommandhandler;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class DeleteTomCommand {
  @TargetAggregateIdentifier
  private final String id;
}
