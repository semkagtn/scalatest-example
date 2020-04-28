package com.semkagtn

import java.io.PrintWriter
import java.io.StringWriter

package object extensions {

  implicit class RichThrowable(val throwable: Throwable)
    extends AnyVal {
    
    def stackTrackAsString: String = {
      val stringWriter = new StringWriter
      throwable.printStackTrace(new PrintWriter(stringWriter))
      stringWriter.toString
    }
  }
}
