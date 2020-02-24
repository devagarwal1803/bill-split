import config.BillSplitConfig
import controllers.BillSplitController
import io.dropwizard.Application
import io.dropwizard.setup.Environment

fun main(args: Array<String>) {
    BillSplitApp().run("server")
}
class BillSplitApp : Application<BillSplitConfig>() {
    override fun run(configuration: BillSplitConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val billSplitComponent = BillSplitController()
        environment.jersey().register(billSplitComponent)
    }
}
