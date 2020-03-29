
package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PostUser {

  val userString = "{\"empName\":\"Jon\", \"deptName\":\"Admin\",\"age\":40}"

 // val jsonFileFeeder = jsonFile("employees.json").circular
  
  val postUserHttp = http("post user")
    .post("/")
    //    .feed(jsonFileFeeder)
//    .body(StringBody(
//        """{
//            "empName": "${empName}",
//            "deptName": "${deptName}",
//            "age": "${age}"
//        }"""
//     ))
    .body(StringBody(userString))
    .check(status is 200)

  val postUser = scenario("post user")
    .exec(postUserHttp)
}