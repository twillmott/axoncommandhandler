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

  @CommandHandler
  @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
  public void handle(CreateTomCommand command) {
    AggregateLifecycle.apply(new TomCreatedEvent(command.getId(), command.getName()));
  }

  @CommandHandlerInterceptor
  public void intercept(CreateTomCommand event,
                        InterceptorChain interceptorChain) throws Exception {

    if (!this.name.equals(event.getName())) {
      throw new IllegalArgumentException("Toms name is wrong");
    }
    interceptorChain.proceed();
  }

  @EventSourcingHandler
  public void on(TomCreatedEvent event) {
    this.id = event.getId();
    this.name = name;
  }


}
