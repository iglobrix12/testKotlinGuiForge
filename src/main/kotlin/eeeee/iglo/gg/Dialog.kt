package eeeee.iglo.gg

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component

class Dialog(title: String, private val rests: Array<Rest>) : Screen(Component.literal(title)) {

    override fun init() {
        super.init()
        val buttonHeight = 20
        val buttonSpacing = 5
        val totalButtonHeight = buttonHeight * rests.size + buttonSpacing * (rests.size - 1)
        val y = (this.height - totalButtonHeight) / 2
        val maxButtonWidth = this.font.width(title) + 20

        for (i in rests.indices) {
            val rest = rests[i]
            val x = (this.width - maxButtonWidth) / 2

            this.addRenderableWidget(Button(x, y + i * (buttonHeight + buttonSpacing), maxButtonWidth, buttonHeight, Component.literal(rest.label)) {
                this.minecraft?.setScreen(null)
                rest.getAction().execute()
            })
        }
    }

    override fun render(poseStack: PoseStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        super.render(poseStack, mouseX, mouseY, partialTicks)
        val titleWidth = this.font.width(title)
        val buttonHeight = 20
        val buttonSpacing = 5
        val totalButtonHeight = buttonHeight * rests.size + buttonSpacing * (rests.size - 1)
        val y = (this.height - totalButtonHeight) / 2
        val titleX = (this.width - titleWidth) / 2
        val titleY = y - 20
    }

    override fun isPauseScreen(): Boolean {
        return false
    }

    fun open(dialog: Dialog) {
        Minecraft.getInstance().execute {
            Minecraft.getInstance().setScreen(dialog)
        }
    }

}