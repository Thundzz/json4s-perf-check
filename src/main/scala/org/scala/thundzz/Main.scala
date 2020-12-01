package example

import org.json4s.{DefaultFormats, Formats}
import org.json4s.jackson.Serialization.write

object Timer {

  def time[R](message : String)(block: => R): R = {
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    println(s"$message : Elapsed time: " + (t1 - t0)*1e-6  + "ms")
    result
  }
}

case class Dummy(
  attr1 : String,
  attr2 : Int,
  attr3 : String,
  attr4 : Long,
  attr5 : Option[Int],
)

object Main extends App {
 
  implicit val formats: Formats = DefaultFormats
  var x = 0

  Timer.time("Pre-heating") {
    (1 to 1000000).foreach(i => {
      x += 3
    })
  }
  println(x)

  val cc = Dummy("hello", 3, "", 4L, None)

  Timer.time("First pass") {
    write(cc)
  }

  Timer.time("Second pass") {
    write(cc)
  }
}

