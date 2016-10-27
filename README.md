# Apache Camel Laboration


- All routes live in a Camel Context.
	- There is a Camel Spring Context Listener that sets up a Camel Context.
	- You can also create one with "new DefaultCamelContext()".
- Camel are Payload Agnostic, you do not have to transform your payload into some transfer format.
- Almost everything is pluggable or configurable.
- Automatic, pluggable, type converters.
- Comes with a Test Kit.
- Camel's Message Model
	- Message: Fundamental Entity containing the data
	- Message = body (payload), headers (Map<String, Object>, attachments, id
	- Exchange: A Camel abstraction for an exchange of messages. inMessage + outMessage. A message's container during routing.

## Camel's Architecture

**Camel Context**: Container (Routing Engine, Components, Processors)

**Routing Engine**: What is actually moving messages around the routes. Not exposed in API.

**Routes**: The core abstraction. Simples case: A chain of processors. ONE source endpoint.

- Consumer(input, populates the initial Exchange) -> Processor(s)(optionally sets outputmessage. If not, the input is reused as output down the route) -> MEP/Producer (inOnly vs inOut)

**DSL**: Domain-specific language for defining routes. XML / Java / etc.

	from("file:data/inbox")
		.filter().xpath("/order[not(@test)]")
		.to("jms:queue:order")

**Processors**: A Core Camel Concept that can use, create or modify Exchanges. During routing, exchanges flow from one processor to another. A route is a graph of Processors, where edges connect output from one Processor to the input of another.

**Component**: Components are the main extensionpoints of Camel. From a programming perspective, a Component are associated with a name (which is used in the URIs for the DSL), and they act as factories for Endpoints.

**Endpoint**: An Endpoint is an input or an output of a Route. Enpoint URIs are divided into three parts. scheme, context path and options.
- Scheme: Identifies the Component that will be used to create the Endpoint.
- Context Path: The Context Path is sent to the Factory Method.
- Options: This will configure the created Endpoint.

**Producer**: An Entity that will send a message to an Endpoint.

**Consumer**: Consumes messages, wraps then into Exchanges, and sends them to be processed. Event driven or polling.




## References

- [http://camel.apache.org/getting-started.html]()
- [Camel In Action - Chapter 1](https://manning-content.s3.amazonaws.com/download/d/9e78430-edc1-4831-a44b-0faf977ebcfa/Ibsen2_Camel2e_MEAP_V08_ch1.pdf)
- [http://camel.apache.org/examples.html]()


## Glossary

**Camel:** Manager of Routes

**Route:** Consumes messages from one Endpoint, optionally transforms them, and Produces them to another Endpoint

**Component:** Factory and Manager of Endpoints (Derive from DefaultComponent)

**Camel Context:** A collection of routes and routing rules. See [http://camel.apache.org/lifecycle.html]()

**Camel Context**: Container(Registry, Type Converters, Components, Endpoints, Routes, Data formats, Languages)

**Components**: Contains all components that are in use. Auto discovered, OSGi bundles etc.

**Endpoints**: Contains all endpoints that have been created.

**Routes**: Contains all routes that have been added.

**Type converters**: Contains all loaded type converters. Manual or automatic conversion.

**Data formats**: Contains all loaded data formats.

**Registry**: Registry for looking up beans, by default a JNDI registry.

**Languages**: Contains all loaded languages. XPath, Camel's Simple Expression Languages etc.


