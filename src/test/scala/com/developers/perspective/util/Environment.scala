package com.developers.perspective.util

import java.util

object Environemnt {
  val baseURL = scala.util.Properties.envOrElse("baseURL", "http://localhost:9091/employees")
  val users = scala.util.Properties.envOrElse("numberOfUsers", "1")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "5000") // in milliseconds

}
