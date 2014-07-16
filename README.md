resteasy-api-example
====================

A stripped down example of providing a REST API using resteasy.  The project uses Servlet v3 annotations so that your web.xml can be empty.  Google Guice is rolled in (and responsible for binding the resteasy providers too).

Of note:

HttpServletDispatcherV3 - is an empty subclass of resteasy's HttpServletDispatcher simply to allow me to add the servlet annotations. 

GuiceResteasyBootstrapServletContextListenerV3 - does a similar thing for the Guice listener.  The parent class is configured with a context-parameter (can only be set in a web.xml) so this version simply overrides the relevant method to load the module which sets up the bindings in Guice.

ApplicationModule - binds the resteasy providers into Guice

api.ExampleApi - is an interface that describes the REST api.  This is implemented in this project by controllers.ExampleController.  In general you would probably want two projects - one with the interface in it and then another with the implementation.  You could then share the interface with consumers of your api.  There is an example of using this with a proxy object in the ExampleController.

