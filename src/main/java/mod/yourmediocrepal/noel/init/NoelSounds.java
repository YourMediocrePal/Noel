package mod.yourmediocrepal.noel.init;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NoelSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Noel.MOD_ID);

    public static final Lazy<SoundEvent> LAZY_DECK_THE_HALLS_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(Noel.MOD_ID, "music_disc.deck_the_halls")));
    public static final Lazy<SoundEvent> LAZY_JINGLE_BELLS_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(Noel.MOD_ID, "music_disc.jingle_bells")));
    public static final Lazy<SoundEvent> LAZY_OH_CHRISTMAS_TREE_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(Noel.MOD_ID, "music_disc.oh_christmas_tree")));
    public static final Lazy<SoundEvent> LAZY_SUGAR_PLUM_FAIRIES_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(Noel.MOD_ID, "music_disc.sugar_plum_fairies")));
    public static final Lazy<SoundEvent> LAZY_UP_ON_A_HOUSETOP_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(Noel.MOD_ID, "music_disc.up_on_a_housetop")));
    public static final Lazy<SoundEvent> LAZY_WE_WISH_YOU_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(Noel.MOD_ID, "music_disc.we_wish_you")));

    public static final RegistryObject<SoundEvent> DECK_THE_HALLS_MUSIC = SOUNDS.register("deck_the_halls_music", LAZY_DECK_THE_HALLS_MUSIC);
    public static final RegistryObject<SoundEvent> JINGLE_BELLS_MUSIC = SOUNDS.register("jingle_bells_music", LAZY_JINGLE_BELLS_MUSIC);
    public static final RegistryObject<SoundEvent> OH_CHRISTMAS_TREE_MUSIC = SOUNDS.register("oh_christmas_tree_music", LAZY_OH_CHRISTMAS_TREE_MUSIC);
    public static final RegistryObject<SoundEvent> SUGAR_PLUM_FAIRIES_MUSIC = SOUNDS.register("sugar_plum_fairies_music", LAZY_SUGAR_PLUM_FAIRIES_MUSIC);
    public static final RegistryObject<SoundEvent> UP_ON_A_HOUSETOP_MUSIC = SOUNDS.register("up_on_a_housetop_music", LAZY_UP_ON_A_HOUSETOP_MUSIC);
    public static final RegistryObject<SoundEvent> WE_WISH_YOU_MUSIC = SOUNDS.register("we_wish_you_music", LAZY_WE_WISH_YOU_MUSIC);
}
