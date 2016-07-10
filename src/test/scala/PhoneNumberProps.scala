import org.scalacheck.{Gen, Properties}

/**
  * Created by gseelinger on 7/8/2016.
  * Borrowed from http://slides.com/marcsaegesser/scalacheck
  */
object PhoneNumberProps extends Properties("PhoneNumber") {
  case class PhoneNumber(npa: String, nxx: String, xxxx: String) {
    require(npa.length  == 3 && !npa.exists(!_.isDigit) && npa(0) != '0', "Invalid npa")
    require(nxx.length  == 3 && !npa.exists(!_.isDigit) && nxx(0) != '0', "Invalid nxx")
    require(xxxx.length == 4 && !npa.exists(!_.isDigit), "Invalid xxxx")

    override def toString = s"($npa)$nxx-$xxxx"
  }

  def genDigitsNoLeadingZero(n: Int): Gen[String] =
    Gen.listOfN(n, Gen.numChar) suchThat (_(0) != '0') map (_.mkString)

  def genDigits(n: Int): Gen[String] =
    Gen.listOfN(n, Gen.numChar) map(_.mkString)

  val genPhoneNumber: Gen[PhoneNumber] =
    for {
      npa <- genDigitsNoLeadingZero(3)
      nxx <- genDigitsNoLeadingZero(3)
      xxxx <- genDigits(4)
    } yield PhoneNumber(npa, nxx, xxxx)
}
