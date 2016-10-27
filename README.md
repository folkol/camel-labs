# Apache Camel Laboration


- All routes live in a Camel Context.
 - There is a Camel Spring Context Listener that sets up a Camel Context
 - You can also create one with "new DefaultCamelContext()"
- Camel are Payload Agnostic, you do not have to transform your payload into some transfer format.
- Almost everything is pluggable or configurable
- 



## References

- [http://camel.apache.org/getting-started.html]()
- [Camel In Action - Chapter 1](https://manning-content.s3.amazonaws.com/download/d/9e78430-edc1-4831-a44b-0faf977ebcfa/Ibsen2_Camel2e_MEAP_V08_ch1.pdf)
- []()


## Glossary

**Camel:** Manager of Routes

**Route:** Consumes messages from one Endpoint, optionally transforms them, and Produces them to another Endpoint

**Component**: Factory and Manager of Endpoints (Derive from DefaultComponent)

