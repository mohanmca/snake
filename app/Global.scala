import actors._
import play.api.Play.current
import play.api.libs.concurrent.Akka
import akka.actor.Props
import play.api.GlobalSettings
import play.api.Application
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global
object Global extends GlobalSettings{

  override def onStart(app : Application){
    val gameManagerActor = Akka.system.actorOf(Props[GameManagerActor], name = Actors.gameManagerName)
    val gameActor = Akka.system.actorOf(Props[SnakeGameActor], name = Actors.gameName)
    Akka.system.scheduler.schedule(0.millisecond,100.millisecond,gameActor,TickMsg)
  }

}

