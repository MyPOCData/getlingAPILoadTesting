
package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random


//object PostUser {
//
//  val userString = "{\"empName\":\"Jon\", \"deptName\":\"Admin\",\"age\":40}"
//  
//  val postUserHttp = http("post user")
//    .post("/")
//    .body(StringBody(userString))
//    .check(status is 200)
//
//  val postUser = scenario("post user")
//    .exec(postUserHttp)
//}


object PostUser{
  
  // declare variables
  val rnd = new Random()
  
  // declare helper methods
  def randomString(length: Int) = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  // The custom feeder itself
  val empFeeder = Iterator.continually(Map(
    "empName" -> ("Emp-" + randomString(5)),
    "deptName" -> ("Dept-" + randomString(6)),
    "age" -> rnd.nextInt(100)
  ))
  
  val postUserHttp = {
    feed(empFeeder).
      exec(http("post user")
        .post("/")
        .body(ELFileBody("employees.json")).asJSON
        .check(status is 200))
      .pause(1)  
  }
  
  val postUser = scenario("post user")
    .exec(postUserHttp)

}