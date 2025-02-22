package earth.terrarium.adastra.common.config;

import com.teamresourceful.resourcefulconfig.common.annotations.*;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;
import com.teamresourceful.resourcefulconfig.web.annotations.Gradient;
import com.teamresourceful.resourcefulconfig.web.annotations.Link;
import com.teamresourceful.resourcefulconfig.web.annotations.WebInfo;
import earth.terrarium.adastra.client.config.AdAstraConfigClient;

@Config("ad_astra")
@WebInfo(
    title = "Ad Astra",
    description = "Live long and prosper, and may the force be with you.",

    icon = "planet",
    gradient = @Gradient(value = "45deg", first = "#7F4DEE", second = "#E7797A"),

    links = {
        @Link(value = "https://discord.gg/terrarium", icon = "gamepad-2", title = "Discord"),
        @Link(value = "https://github.com/terrarium-earth/Ad-Astra", icon = "github", title = "GitHub"),

        @Link(value = "https://www.curseforge.com/minecraft/mc-mods/ad-astra", icon = "curseforge", title = "CurseForge"),
        @Link(value = "https://modrinth.com/mod/ad-astra", icon = "modrinth", title = "Modrinth"),
    }
)
public final class AdAstraConfig {
    @ConfigButton(text = "Client Config", translation = "config.ad_astra.clientConfig")
    public static void clientConfig() {
        AdAstraConfigClient.open();
    }

    @ConfigEntry(
        id = "allowFlagImages",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.allowFlagImages"
    )
    @Comment("Allow players to set custom flag images for their rockets.")
    public static boolean allowFlagImages = true;

    @ConfigEntry(
        id = "launchAnywhere",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.launchFromAnywhere"
    )
    @Comment("Allow rockets to be launched from any dimension, even if it's not considered a planet.")
    public static boolean launchFromAnywhere;

    @ConfigEntry(
        id = "planetRandomTickSpeed",
        type = EntryType.INTEGER,
        translation = "config.ad_astra.planetRandomTickSpeed"
    )
    @Comment("The random tick speed for breaking plants, torches, freezing water, etc. on planets.")
    public static int planetRandomTickSpeed = 20;

    @ConfigEntry(
        id = "forcePlanetTick",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.forcePlanetTick"
    )
    @Comment("Always tick every planet chunk for things like freezing water, breaking plants, etc., regardless of whether the chunk can tick randomly or not. This has a small performance impact.")
    public static boolean forcePlanetTick;

    @ConfigEntry(
        id = "atmosphereLeave",
        type = EntryType.INTEGER,
        translation = "config.ad_astra.atmosphereLeave"
    )
    @Comment("The y level where rockets should leave the dimension and enter space.")
    public static int atmosphereLeave = 600;

    @ConfigEntry(
        id = "disabledPlanets",
        type = EntryType.STRING,
        translation = "config.ad_astra.disabledPlanets"
    )
    @Comment("A comma-separated list of planet IDs that should be hidden from the planets screen. e.g. minecraft:overworld,ad_astra:moon,ad_astra:mars,ad_astra:venus,ad_astra:mercury,ad_astra:glacio")
    public static String disabledPlanets = "";

    @ConfigEntry(
        id = "disableOxygen",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.disableOxygen"
    )
    @Comment("Disables oxygen damage.")
    public static boolean disableOxygen;

    @ConfigEntry(
        id = "disableTemperature",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.disableTemperature"
    )
    @Comment("Disables temperature damage.")
    public static boolean disableTemperature;

    @ConfigEntry(
        id = "disableGravity",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.disableGravity"
    )
    @Comment("Uses normal gravity for all planets.")
    public static boolean disableGravity;

    @ConfigEntry(
        id = "disableAirVortexes",
        type = EntryType.BOOLEAN,
        translation = "config.ad_astra.disableAirVortexes"
    )
    @Comment("An Air Vortex is created when an oxygenated structure breaks its seal, causing every entity inside to rapidly get sucked out. This setting disables that.")
    public static boolean disableAirVortexes;

    @InlineCategory
    public static MachineConfig machineConfig;
}
