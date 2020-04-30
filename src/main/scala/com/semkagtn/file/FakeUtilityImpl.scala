package com.semkagtn.file

import java.nio.file.Path

class FakeUtilityImpl
  extends FileUtility {

  private var map = Map.empty[Path, Long]

  override def getModificationTime(path: Path): Long =
    map.getOrElse(path, -1)

  override def touch(path: Path): Unit =
    map = map.updated(path, System.currentTimeMillis)
}
