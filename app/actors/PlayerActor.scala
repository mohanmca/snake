package actors
import play.api.Play.current
import akka.actor.{Actor, ActorRef}
import game._
import play.api.libs.json._
import game.AliveSnake
import game.Point
import play.api.libs.concurrent.Akka


class PlayerActor(gameId:String,out:ActorRef) extends GameWatcherActor(gameId,out){

  val playMoves : PartialFunction[Any,Unit] = {
    case "l" => Akka.system.actorSelection("/user/"+gameId)  ! Left
    case "r" => Akka.system.actorSelection("/user/"+gameId)  ! Right
  }

  override def receive = playMoves orElse super.receive

  override def preStart = {
    Akka.system.actorSelection("/user/"+gameId) ! RegisterPlayerMsg
  }
}

