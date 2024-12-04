package mod.yourmediocrepal.init;

import mod.yourmediocrepal.Noel;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class NoelSounds {

    public static void initiialize() {
        Noel.LOGGER.info("Registering Mod Sounds");
    }
    public static final SoundEvent JINGLE_BELLS = registerSound("jingle_bells");
    public static final SoundEvent DISC_DECK_THE_HALLS = registerSound("music_disc.deck_the_halls");
    public static final SoundEvent DISC_JINGLE_BELLS = registerSound("music_disc.jingle_bells");
    public static final SoundEvent DISC_OH_CHRISTMAS_TREE = registerSound("music_disc.oh_christmas_tree");
    public static final SoundEvent DISC_SUGAR_PLUM_FAIRIES = registerSound("music_disc.sugar_plum_fairies");
    public static final SoundEvent DISC_UP_ON_A_HOUSETOP = registerSound("music_disc.up_on_a_housetop");
    public static final SoundEvent DISC_WE_WISH_YOU = registerSound("music_disc.we_wish_you");
    public static final RegistryKey<JukeboxSong> DISC_DECK_THE_HALLS_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Noel.MOD_ID, "music_disc.deck_the_halls"));
    public static final RegistryKey<JukeboxSong> DISC_JINGLE_BELLS_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Noel.MOD_ID, "music_disc.jingle_bells"));
    public static final RegistryKey<JukeboxSong> DISC_OH_CHRISTMAS_TREE_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Noel.MOD_ID, "music_disc.oh_christmas_tree"));
    public static final RegistryKey<JukeboxSong> DISC_SUGAR_PLUM_FAIRIES_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Noel.MOD_ID, "music_disc.sugar_plum_fairies"));
    public static final RegistryKey<JukeboxSong> DISC_UP_ON_A_HOUSETOP_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Noel.MOD_ID, "music_disc.up_on_a_housetop"));
    public static final RegistryKey<JukeboxSong> DISC_WE_WISH_YOU_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Noel.MOD_ID, "music_disc.we_wish_you"));
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(Noel.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

}
