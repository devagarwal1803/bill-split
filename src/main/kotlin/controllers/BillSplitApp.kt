package controllers

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment
import javax.ws.rs.*


class BillSplitConfig(val name: String = "unknown") : Configuration()

class BillSplitApp : Application<BillSplitConfig>() {
    override fun run(configuration: BillSplitConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val billSplitComponent = BillSplitComponent()
        environment.jersey().register(billSplitComponent)
    }
}

@Path("/")
class BillSplitComponent {
    @Path("/test")
    @GET
    fun add():String{
        return "Hello World"
    }
}