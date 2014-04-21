package fm.crypto.week1

import java.math.BigInteger

case class OTPEncryption {
  
  def toHex(message: String): String = {
    String.format("%02x", new BigInteger(1, message.getBytes(/*YOUR_CHARSET?*/)))
  }
  
  def toBin(message: String): List[String] = {
    message.map(x => String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0')).toList
  }
  
  def hexToBin(hexString: String): String = {
    String.format("%8s", new BigInteger(hexString, 16).toString(2)).replace(' ', '0')
  }
  
  def xor(s1: String, s2: String): String = {
    require(s1.size == s2.size)
    val pairedStrings = s1.zip(s2)
    pairedStrings.map(x => (Integer.parseInt(x._1.toString) + Integer.parseInt(x._2.toString)) % 2).mkString
  }
  
  def hexToChar(s: String): Char = 
    Character.toChars(Integer.parseInt(new BigInteger(s, 16).toString(10)))(0)
    
  def hexToInt(s: String): Int = {
    Integer.parseInt(new BigInteger(s, 16).toString(10))
  }
    
  def hexToString(s: String): String = {
    val hexPair = s.sliding(2,2)
    hexPair.map(x => hexToChar(x)).mkString
  }
  
  def hexToListOfInts(s: String): List[Int] = {
    val hexPair = s.sliding(2,2)
    hexPair.map(x => hexToInt(x)).toList
  }
    
  def encrypt(s1: String, s2: String): String = {
    val pairedChars = s1.zip(s2)
    val xoredChars = pairedChars.map(x => x._1^x._2).toList
    xoredChars.map(x => ("00" + Integer.toHexString(x)).substring(Integer.toHexString(x).length)).mkString
  }

}