
package examples.`07_Interaction`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.panel.ControlManager
import org.openrndr.panel.controlManager
import org.openrndr.panel.elements.*
import org.openrndr.panel.layout
import org.openrndr.panel.style.*
import org.openrndr.panel.styleSheet

fun main() {
    application {
        program {
            extend(ControlManager()) {
                layout {
                    slider {
                        label = "Slide me"
                        value = 0.50
                        range = Range(0.0, 1.0)
                        precision = 2
                        events.valueChanged.listen {
                            println("the new value is ${it.newValue}")
                        }
                    }
                }
            }
        }
    }
}
    