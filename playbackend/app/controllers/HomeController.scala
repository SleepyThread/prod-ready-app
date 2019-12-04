package controllers

import javax.inject.{Inject, Singleton}
import dao.TaskListDao
import model.TaskList
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(taskListDao : TaskListDao)(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  implicit val taskListFormat = Json.format[TaskList]

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok("Up and Running.")
  }


  def taskList() = Action.async {
    taskListDao.get.map(list => Ok(Json.toJson(list)))
  }
}
