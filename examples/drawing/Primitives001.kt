
package examples.drawing

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle
import org.openrndr.text.Writer

fun main(args: Array<String>) {
    application {
        configure {
            width = 640
            height = 480
        }
        program {
            extend(ScreenRecorder().apply {
                maximumDuration = 5.0
                outputFile = "media/primitives-002.mp4"
            })
            extend {
                drawer.background(ColorRGBa.RED)
                val writer = Writer(drawer)
                drawer.fontMap = FontImageMap.fromUrl("file:fonts/iosevka-custom-medium.ttf", 20.0)
                drawer.stroke = null
                drawer.fill = ColorRGBa.WHITE
                writer.box = Rectangle(Vector2(100.0, 100.0), 400.0, 400.0)
                writer.text("Here is the text")
                writer.newLine()
                writer.text("Here  is another line of text")
            }
        }
    }
}
    