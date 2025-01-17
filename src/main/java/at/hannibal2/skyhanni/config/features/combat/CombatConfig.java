package at.hannibal2.skyhanni.config.features.combat;

import at.hannibal2.skyhanni.config.FeatureToggle;
import at.hannibal2.skyhanni.config.features.combat.broodmother.BroodmotherConfig;
import at.hannibal2.skyhanni.config.features.combat.damageindicator.DamageIndicatorConfig;
import at.hannibal2.skyhanni.config.features.combat.end.EndIslandConfig;
import at.hannibal2.skyhanni.config.features.combat.ghostcounter.GhostProfitTrackerConfig;
import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.Accordion;
import io.github.notenoughupdates.moulconfig.annotations.Category;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class CombatConfig {

    @Expose
    @Category(name = "Damage Indicator", desc = "Damage Indicator settings")
    public DamageIndicatorConfig damageIndicator = new DamageIndicatorConfig();

    @Expose
    @Category(name = "Ghost Counter", desc = "Ghost Counter settings")
    public GhostProfitTrackerConfig ghostCounter = new GhostProfitTrackerConfig();

    @Expose
    @Category(name = "End Island", desc = "Features for the End Island")
    public EndIslandConfig endIsland = new EndIslandConfig();

    @Expose
    @ConfigOption(name = "Quiver", desc = "")
    @Accordion
    public QuiverConfig quiverConfig = new QuiverConfig();

    @Expose
    @ConfigOption(name = "Armor Stack Display", desc = "")
    @Accordion
    // TODO rename to armor stack display
    public StackDisplayConfig stackDisplayConfig = new StackDisplayConfig();

    @Expose
    @ConfigOption(name = "Summonings", desc = "")
    @Accordion
    public SummoningsConfig summonings = new SummoningsConfig();

    @Expose
    @ConfigOption(name = "Mobs", desc = "")
    @Accordion
    public MobsConfig mobs = new MobsConfig();

    @Expose
    @ConfigOption(name = "Bestiary", desc = "")
    @Accordion
    public BestiaryConfig bestiary = new BestiaryConfig();

    @Expose
    @ConfigOption(name = "Ender Node Tracker", desc = "")
    @Accordion
    // TODO move into end island config
    public EnderNodeConfig enderNodeTracker = new EnderNodeConfig();

    @Expose
    @ConfigOption(name = "Ferocity Display", desc = "")
    @Accordion
    public FerocityDisplayConfig ferocityDisplay = new FerocityDisplayConfig();

    @Expose
    @ConfigOption(name = "Flare", desc = "")
    @Accordion
    public FlareConfig flare = new FlareConfig();

    @Expose
    @ConfigOption(name = "Broodmother", desc = "")
    @Accordion
    public BroodmotherConfig broodmother = new BroodmotherConfig();

    @Expose
    @ConfigOption(name = "Hide Damage Splash", desc = "Hide all damage splashes anywhere in SkyBlock.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean hideDamageSplash = false;
}
