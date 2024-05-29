package named

import scala.collection.mutable.ArrayBuffer
import scala.reflect.Selectable.reflectiveSelectable


object named extends App {
  val rows = ArrayBuffer[Array[String]]()


  using(io.Source.fromFile("src/main/scala/dataset/imdb_dataset.csv")) { source =>
    for (line <- source.getLines().take(6)) {
      rows += line.split(",").map(_.trim)
    }
  }


  for (row <- rows) {
    println(s"${row(0)}|${row(1)}|${row(2)}|${row(3)}")
  }




  //Reading rows as an Array[String] since the input size is unknown at the time.

//Each row gets added to ArrayBuffer as the input is fetched

  def using[A <: {def close(): Unit}, Z](resource: A)(f: A => Z): Z =
    try {
      f(resource)
    } finally {
      resource.close()
    }
}


// output
//
//title|year|imdbid|id
//Miss Jerry|1894|9.0|9779
//"Story of the Kelly Gang|The"|1906|574.0
//Cleopatra|1912|2101.0|2003
//A Florida Enchantment|1914|3973.0|4457
//"Birth of a Nation|The"|1915|4972.0