import config.BillSplitConfig
import controllers.BillController
import controllers.UserController
import dao.BillDao
import dao.UsersDao
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import io.ebean.DB
import services.BillService
import services.UsersService


class MainApp : Application<BillSplitConfig>() {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            MainApp().run("server")
        }
    }

    override fun run(configuration: BillSplitConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val database = DB.getDefault()
        val userDao = UsersDao(database)
        val userService = UsersService(userDao)

        val billDao = BillDao(database)
        val billService = BillService(billDao)

        val userComponent = UserController(userService)
        environment.jersey().register(userComponent)

        val billComponent = BillController(billService)
        environment.jersey().register(billComponent)

//        val mapper = ObjectMapper().registerModule(KotlinModule())
    }
}
