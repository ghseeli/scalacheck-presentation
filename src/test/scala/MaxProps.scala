import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
/**
  * Created by gseelinger on 7/8/2016.
  * Adapted from http://slides.com/marcsaegesser/scalacheck#/3
  */
object MaxProps extends Properties("max") {
  def max(a: Int, b: Int): Int = {
    if (a > b) a
    else b
  }

  property("Max is greater than or equal to inputs") = forAll {
    (x: Int, y: Int) =>
      val z = max(x, y)
      z >= x && z >= y
  }

  property("Max is equal to one of two inputs") = forAll {
    (x: Int, y: Int) =>
      val z = max(x, y)
      z == x || z == y
  }


}
