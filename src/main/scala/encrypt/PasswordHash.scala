package encrypt

import java.util.Base64

import com.typesafe.scalalogging.Logger
import io.github.nremond.PBKDF2
import org.slf4j.LoggerFactory

object PasswordHash extends Pbkdf2 {

  private val logger = Logger(LoggerFactory.getLogger(PasswordHash.getClass 34))

  def main(args: Array[String]): Unit = {
    try {
      val text = "12345678"
      val hash = createHash(text)
      logger.info(s"text = ${text}, hash = ${hash}")
    } catch {
      case t:
        Throwable =>
        logger.error(t.getStackTrace.toString)
        System.exit(1)
    }
  }
}


trait Pbkdf2 {

  def createHash(text: String,
                 salt: String = "put_your_salt_here",
                 iterations: Int = 10000,
                 keyLength: Int = 32,
                 algorithm: String = "HmacSHA256"
                 ): String = {
    text match {
      case null | "" => ""
      case _ => Base64.getEncoder.encodeToString(PBKDF2(text.getBytes, salt.getBytes, iterations, keyLength, algorithm))
    }
  }
}