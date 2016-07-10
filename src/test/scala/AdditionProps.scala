import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalacheck.Prop.forAll

/**
  * Created by gseelinger on 7/8/2016.
  */
object AdditionProps extends Properties("Addition"){
  property("Positive Ints add to a positive Int (test 1)") =
    forAll(Gen.posNum[Int], Gen.posNum[Int]) { (x, y) =>
    x + y >= 0
  }

//  property("Positive Ints add to a positive Int (test 2)") =
//    forAll(Arbitrary.arbitrary[Int].filter(_ >= 0), Arbitrary.arbitrary[Int].filter(_ >= 0)) { (x, y) =>
//      x + y >= 0
//    }
}
