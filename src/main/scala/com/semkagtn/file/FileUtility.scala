package com.semkagtn.file

import java.nio.file.Path

trait FileUtility {

  /**
   * Returns mtime of the file.
   * Returns negative value if file doesn't exist.
   * 
   * @param path path to file
   */
  def getModificationTime(path: Path): Long
  
  /**
   * Touches the specified file.
   * 
   * @param path path to file
   */
  def touch(path: Path): Unit
}
