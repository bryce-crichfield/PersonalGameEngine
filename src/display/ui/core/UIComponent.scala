package org.apollo
package display.ui.core

import state.State

import java.awt.Image

/** super class of all UI elements */
trait UIComponent {
  val id: String
  val dimension: UIDimension
  val style: UIStyle

  /** !!! [ EVERY OVERRIDE MUST CALL THE UIBridge setChangesMade() METHOD !!! */
  def remake(dimension: UIDimension = dimension,
             style: UIStyle = style): UIComponent

  def getSprite: Image

  def update(state: State): UIComponent
}
