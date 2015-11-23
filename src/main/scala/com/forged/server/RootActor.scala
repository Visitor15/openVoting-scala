package com.forged.server

import spray.http.MediaTypes._
import spray.routing.HttpServiceActor
import spray.httpx.PlayTwirlSupport._

/**
 * Created by visitor15 on 11/15/15.
 */
class RootActor extends HttpServiceActor {
  override def receive: Receive = runRoute {
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Hello, world!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
    path("twirl") {
      get {
        complete {
          html.index.render(new java.util.Date)
        }
      }
    } ~
    path("recommend") {
      get {
        complete {
          html.recommend.render()
        }
      }
    } ~
    pathPrefix("theme") {
      get {
        getFromResourceDirectory("theme")
      }
    }
  }
}
