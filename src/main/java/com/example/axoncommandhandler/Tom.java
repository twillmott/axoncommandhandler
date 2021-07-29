package com.example.axoncommandhandler;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.messaging.InterceptorChain;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.CommandHandlerInterceptor;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Tom {

  @AggregateIdentifier
  private String id;
  private String name = "Tom";

  public Tom(){}

//  @CommandHandler
//  @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
//  public void handle(CreateTomCommand command) throws Exception {
//    AggregateLifecycle.apply(new TomCreatedEvent(command.getId()));
//  }

  @EventSourcingHandler
  public void on(TomCreatedEvent event) {
    this.id = event.getId();
    this.name = name;
  }

  @CommandHandler
  @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
  public void handle(UpdateTomCommand command) throws Exception {
    AggregateLifecycle.apply(new TomCreatedEvent(command.getId()));
    AggregateLifecycle.apply(new TomUpdatedEvent(command.getId(), command.getName()));
  }

  @EventSourcingHandler
  public void on(TomUpdatedEvent event) {
    this.name = name;
  }


  @CommandHandler
  public void handle(DeleteTomCommand command) throws Exception {
    AggregateLifecycle.apply(new TomDeletedEvent(command.getId()));
  }

  @EventSourcingHandler
  public void on(TomDeletedEvent event) {
    AggregateLifecycle.markDeleted();
  }


}
