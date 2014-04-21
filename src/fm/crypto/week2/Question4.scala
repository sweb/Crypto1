package fm.crypto.week2

object Question4 extends App {
  val otp = fm.crypto.week1.OTPEncryption()
  
  val pair1 = ("5f67abaf5210722b","bbe033c00bc9330e")
  val pair2 = ("9d1a4f78cb28d863","75e5e3ea773ec3e6")
  val pair3 = ("9f970f4e932330e4", "6068f0b1b645c008")
  val pair4 = ("4af532671351e2e1", "87a40cfa8dd39154")
  
  println(otp.encrypt(otp.hexToString(pair1._1), otp.hexToString(pair1._2)))
  println(otp.encrypt(otp.hexToString(pair2._1), otp.hexToString(pair2._2)))
  println(otp.encrypt(otp.hexToString(pair3._1), otp.hexToString(pair3._2)))
  println(otp.encrypt(otp.hexToString(pair4._1), otp.hexToString(pair4._2)))

}