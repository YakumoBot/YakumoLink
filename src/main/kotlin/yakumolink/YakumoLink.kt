@file:Suppress("Annotator")

package ltd.zake.yakumolink

import com.google.auto.service.AutoService
import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.plugin.jvm.JvmPlugin
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.subscribeGroupMessages
import net.mamoe.mirai.console.data.value

@AutoService(JvmPlugin::class)
object YCLinkPluginMain : KotlinPlugin(
    JvmPluginDescription(
        "ltd.zake.yakumolink",
        "1.0.1-20Dec31"
    )
) {
    override fun onEnable() {
        YCLinkSet.reload()
        logger.info("yakumoChatBot 拓展 yakumoLink onEnable")
        subscribeGroupMessages {
            startsWith("#linkTest") {
                reply("YCLink onEnable")
            }
        }

    }
    object YCLinkSet : AutoSavePluginConfig("YCLinkSet") {
        val test:String by value("test")

    }
}