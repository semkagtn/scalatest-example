package com.semkagtn.file

import java.nio.file.{Path, Paths}

import com.semkagtn.TestBase

class FileUtilityTest
  extends TestBase {

  val utility = new FakeUtilityImpl
  
  private var lastPath: Int = 0
  
  def newPath(): Path = {
    lastPath += 1
    Paths.get(lastPath.toString)
  }
  
  describe("touch") {
    
    it("creates file") {
      val path = newPath()
      utility.touch(path)
      val actualResult = utility.getModificationTime(path)
      actualResult should greaterThan(0) 
    }
    
    it("updated mod time") {
      val path = newPath()
      utility.touch(path)
      val mtime = utility.getModificationTime(path)
      Thread.sleep(1)
      utility.touch(path)
      val actualResult = utility.getModificationTime(path)
      actualResult should greaterThan(mtime)
    }
  }
  
  // TODO more cases
}
