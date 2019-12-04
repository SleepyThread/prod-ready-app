package dao

import javax.inject.{ Inject, Singleton }
import model.TaskList
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TaskListDao @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {

  // We want the JdbcProfile for this provider
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  private val TaskLists = TableQuery[TaskListTable]

  /**
    * Here we define the table. It will have a name of people
    */
  private class TaskListTable(tag: Tag) extends Table[TaskList](tag, "TaskList") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def taskInfo = column[String]("taskInfo")


    def * = (id, taskInfo).mapTo[TaskList]
  }


  def get : Future[Seq[TaskList]] = db.run(TaskLists.result)

}
