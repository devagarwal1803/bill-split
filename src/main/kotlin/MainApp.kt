import config.BillSplitConfig
import controllers.BillController
import controllers.UserController
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import io.ebean.DB

fun main(args: Array<String>) {
    val database = DB.getDefault()
    val userDao = (database)
    BillSplitApp().run("server")
}
class BillSplitApp : Application<BillSplitConfig>() {
    override fun run(configuration: BillSplitConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val userComponent = UserController()
        environment.jersey().register(userComponent)
        val billSplitComponent = BillController()
        environment.jersey().register(billSplitComponent)

//        val mapper = ObjectMapper().registerModule(KotlinModule())
    }
}
