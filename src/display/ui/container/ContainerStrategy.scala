package org.apollo
package display.ui.container

import display.ui.bridge.UISystem
import display.ui.typeclasses.UIDimensionable.UIDimensioner
import physics.{Position, Size}

// A strategy shouldn't really need to know about a specific container but this works for know
trait ContainerStrategy {
  def apply(id: String): UIContainer
  protected def calculateContentSize(container: UIContainer): UIContainer
  protected def repositionChildren(container: UIContainer): UIContainer
  // Applies the padding
  protected def calculatePosition(container: UIContainer): UIContainer = {
    val newPosition = Position(
      container.padding.left + container.position.intX,
      container.padding.top + container.position.intY)
    container.setPosition(newPosition)
  }
  protected def calculateSize(container: UIContainer): UIContainer = {
    val newSize = Size(
      container.padding.horizontal + container.strategy.calculateContentSize(container).size.width,
      container.padding.vertical + container.strategy.calculateContentSize(container).size.height)
    container.setSize(newSize)
  }
}
object ContainerStrategy {
  // This implicit class provides bindings to Container strategy class
  implicit class ContainerStrategyOperations(container: UIContainer) {
     def calculateContentSize(): UIContainer = {
      container.strategy.calculateContentSize(container)
    }
    def repositionChildren(): UIContainer = {
      container.strategy.repositionChildren(container)
    }
    def calculateSize(): UIContainer = {
      container.strategy.calculateSize(container)
    }
    def calculatePosition(): UIContainer = {
      container.strategy.calculatePosition(container)
    }
    def setStrategy(s: ContainerStrategy): UIContainer = {
      UISystem.setChangesMade(true)
      container.copy(strategy = s)
    }
  }
}




