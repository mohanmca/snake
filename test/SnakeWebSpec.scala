import org.junit.runner.RunWith
import org.specs2.runner._
import play.api.libs.json._
import play.api.test._
import game.SnakeGame
import play.Logger
import scala.concurrent._
import scala.concurrent.duration._

@RunWith(classOf[JUnitRunner])
class SnakeWebSpec extends PlaySpecification{

//  implicit val gameReads  = Json.reads[SnakeGame]

  "Snake game web app" should {
    "create game should return the id of the created game" in new WithApplication{
//      Await.result(route(FakeRequest(POST,"/games").withFormUrlEncodedBody(("name"->"test"))).get, 1 second)
      pending("TODO")
    }
  }

}
