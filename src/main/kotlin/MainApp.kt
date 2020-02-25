//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.BillSplitConfig
import controllers.BillController
import controllers.UserController
import io.dropwizard.Application
import io.dropwizard.setup.Environment

fun main(args: Array<String>) {
    BillSplitApp().run("server")
}
class BillSplitApp : Application<BillSplitConfig>() {
    override fun run(configuration: BillSplitConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val UserComponent = UserController()
        environment.jersey().register(UserComponent)
        val billSplitComponent = BillController()
        environment.jersey().register(billSplitComponent)

//        val mapper = ObjectMapper().registerModule(KotlinModule())
    }
}
