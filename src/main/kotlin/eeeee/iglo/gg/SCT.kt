package eeeee.iglo.gg

import net.minecraftforge.event.level.BlockEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(SCT.MODID)
class SCT {

    companion object {
        const val MODID = "sct"
    }

    init {
        val bus: IEventBus = FMLJavaModLoadingContext.get().modEventBus
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    object EventHandler {

        @SubscribeEvent
        @JvmStatic
        fun onBlockBreak(event: BlockEvent.BreakEvent) {
            val restArray = arrayOf(
                Rest("test 1") {
                },
                Rest("test 2") {
                }
            )

            val dialog = Dialog("test", restArray)
            dialog.open(dialog)
        }
    }
}