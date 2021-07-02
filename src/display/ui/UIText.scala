package org.apollo
package display.ui
import state.State

import java.awt.Image

case class UIText(text: String = "ERROR: EMPTY TEXT",
                  dimension: UIDimension = UIDimension(),
                  style: UIStyle = UIStyle()
) extends UIComponent {

    val font: UIFontInfo = UIFontInfo()
    val dropShadow: Boolean = false
    val dropShadowOffset: Int = 0
    // TODO: Implement
    def getSprite: Image = ???
    def update(state: State): UIComponent = ???

    override def remake(dimension: UIDimension, style: UIStyle): UIComponent = ???
}
