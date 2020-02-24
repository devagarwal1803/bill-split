package config

import controllers.BillSplitApp
import io.dropwizard.Configuration

fun main(args: Array<String>) {
    BillSplitApp().run(*args)
}
