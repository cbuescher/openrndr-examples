
package examples.`11_Advanced_Topics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import java.io.File

fun main() {
    application {
        program {
            val cs = ComputeShader.fromCode(File("data/compute-shaders/fill.cs").readText(), "cs1")
        
            val tempBuffer = loadImage("data/images/cheeta.jpg")
            val inputBuffer = colorBuffer(width, height)
            tempBuffer.copyTo(inputBuffer)
            val outputBuffer = colorBuffer(width, height)
        
            extend {
                cs.uniform("fillColor", ColorRGBa.PINK.shade(0.1))
                cs.uniform("seconds", seconds)
                cs.image("inputImg", 0, inputBuffer.imageBinding(0, ImageAccess.READ))
                cs.image("outputImg", 1, outputBuffer.imageBinding(0, ImageAccess.WRITE))
                cs.execute(outputBuffer.width, outputBuffer.height, 1)
                drawer.image(outputBuffer)
            }
        }
    }
}
    