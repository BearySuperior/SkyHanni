package at.hannibal2.skyhanni.features.chat

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.data.IslandType
import at.hannibal2.skyhanni.events.LorenzChatEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.LorenzUtils
import at.hannibal2.skyhanni.utils.LorenzUtils.isInIsland
import at.hannibal2.skyhanni.utils.RegexUtils.matchMatcher
import at.hannibal2.skyhanni.utils.repopatterns.RepoPattern
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@SkyHanniModule
object ArachneChatMessageHider {

    private val config get() = SkyHanniMod.feature.chat
    private var hideArachneDeadMessage = false

    private val patternGroup = RepoPattern.group("chat.arachne")

    /**
     * REGEX-TEST: §4☄ §r§7littlegremlins §r§eplaced an §r§9Arachne's Calling§r§e! Something is awakening! §r§e(§r§a4§r§e/§r§a4§r§e)
     */
    val arachneCallingPattern by patternGroup.pattern(
        "calling",
        "§4☄ §r.* §r§eplaced an §r§9Arachne's Calling§r§e!.*"
    )
    val arachneCrystalPattern by patternGroup.pattern(
        "crystal",
        "§4☄ §r.* §r§eplaced an Arachne Crystal! Something is awakening!"
    )
    private val arachneSpawnPattern by patternGroup.pattern(
        "spawn",
        "§c\\[BOSS] Arachne§r§f: (?:The Era of Spiders begins now\\.|Ahhhh\\.\\.\\.A Calling\\.\\.\\.)"
    )

    /**
     * REGEX-TEST: §dArachne's Keeper used §r§2Venom Shot §r§don you hitting you for §r§c87.7 damage §r§dand infecting you with venom
     */
    private val venomShotPattern by patternGroup.pattern(
        "venom",
        "§dArachne('s Keeper)? used §r§2Venom Shot §r§don you hitting you for §r§c\\d*\\.\\d damage §r§dand infecting you with venom\\."
    )

    @SubscribeEvent
    fun onChat(event: LorenzChatEvent) {
        if (!isEnabled()) return
        if (shouldHide(event.message)) {
            event.blockedReason = "arachne"
        }
    }
    private fun shouldHide(message: String): Boolean {

        venomShotPattern.matchMatcher(message) {
            return true
        }

            if (LorenzUtils.skyBlockArea == "Arachne's Sanctuary") return false


        arachneCallingPattern.matchMatcher(message) {
            return true
        }
        arachneCrystalPattern.matchMatcher(message) {
            return true
        }
        arachneSpawnPattern.matchMatcher(message) {
            return true
        }

        if (message == "§a§l▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬") {
            hideArachneDeadMessage = !hideArachneDeadMessage
            return true
        }
        if (message == "                              §r§6§lARACHNE DOWN!") {
            hideArachneDeadMessage = true
        }
        return hideArachneDeadMessage
    }

    fun isEnabled() = IslandType.SPIDER_DEN.isInIsland() && config.hideArachneMessages
}
