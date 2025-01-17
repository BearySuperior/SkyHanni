package at.hannibal2.skyhanni.events

import at.hannibal2.skyhanni.api.event.SkyHanniEvent
import at.hannibal2.skyhanni.data.IslandType

class IslandChangeEvent(val newIsland: IslandType, val oldIsland: IslandType) : SkyHanniEvent()
