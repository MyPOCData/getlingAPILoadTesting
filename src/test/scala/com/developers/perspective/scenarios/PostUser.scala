package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PostUser {

  val userString = "{\"empName\":\"Jon\", \"deptName\":\"Admin\",\"age\":40}"

  val postUserHttp = http("post user")
    .post("/")
    .body(StringBody(userString))
    .check(status is 200)

  val postUser = scenario("post user")
    .exec(postUserHttp)
}