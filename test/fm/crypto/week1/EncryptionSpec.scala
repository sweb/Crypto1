package fm.crypto.week1

import org.scalatest._

class EncryptionSpec extends FlatSpec{
  val otp = OTPEncryption()
  
  "An OTPEncryption" should "encode empty strings as '00'" in {
    assert(otp.toHex("") == "00")
  }
  
  it should "encode 'a' to '61'" in {
    assert(otp.toHex("a") == "61")
  }
  
  it should "encode 'a b' to '612062'" in {
    assert(otp.toHex("a b") == "612062")
  }
  
  it should "encode 'a' to '01100001'" in {
    assert(otp.toBin("a") == List("01100001"))
  }
  
  it should "encode 0x61 to '01100001'" in {
    assert(otp.hexToBin("61") == "01100001")
  }
  
  it should "xor two binary encoded strings such that '01100001' xor '01100010' result in '00000011'" in {
    assert(otp.xor("01100001", "01100010")== "00000011")
  }
  
  it should "convert hex(61) to char(a)" in {
    assert(otp.hexToChar("61") == 'a')
  }
  
  it should "encrypt a string with another string" in {
    assert(otp.encrypt("Attack at dawn", "Attack at dawn") == "0000000000000000000000000000")
  }
  
  it should "convert a hex string into normal string" in {
    assert(otp.hexToString("41747461636b206174206461776e") == "Attack at dawn")
  }
  
  it should "retrieve the key from encrypting the ciphertext with the plaintext" in {
    assert(otp.encrypt("attack at dawn", otp.hexToString("09e1c5f70a65ac519458e7e53f36")) == "6895b196690e8c30e07883844858")
  }
  
  it should "encrypt the new text with the key" in {
    assert(otp.encrypt("attack at dusk", otp.hexToString("6895b196690e8c30e07883844858")) == "09e1c5f70a65ac519458e7f13b33")
  }
  
  it should "decrypt old text and encrypt again" in {
    assert(otp.encrypt("attack at dusk", otp.hexToString(otp.encrypt("attack at dawn", otp.hexToString("6c73d5240a948c86981bc294814d")))) == "6c73d5240a948c86981bc2808548")
  }

}