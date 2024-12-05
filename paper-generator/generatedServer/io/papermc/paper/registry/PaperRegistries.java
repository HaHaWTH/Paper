package io.papermc.paper.registry;

import com.google.common.base.Preconditions;
import io.papermc.paper.adventure.PaperAdventure;
import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.datacomponent.PaperDataComponentType;
import io.papermc.paper.registry.data.PaperEnchantmentRegistryEntry;
import io.papermc.paper.registry.data.PaperGameEventRegistryEntry;
import io.papermc.paper.registry.data.PaperPaintingVariantRegistryEntry;
import io.papermc.paper.registry.entry.RegistryEntry;
import io.papermc.paper.registry.tag.TagKey;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Art;
import org.bukkit.Fluid;
import org.bukkit.GameEvent;
import org.bukkit.JukeboxSong;
import org.bukkit.Keyed;
import org.bukkit.MusicInstrument;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockType;
import org.bukkit.block.banner.PatternType;
import org.bukkit.craftbukkit.CraftArt;
import org.bukkit.craftbukkit.CraftFluid;
import org.bukkit.craftbukkit.CraftGameEvent;
import org.bukkit.craftbukkit.CraftJukeboxSong;
import org.bukkit.craftbukkit.CraftMusicInstrument;
import org.bukkit.craftbukkit.CraftSound;
import org.bukkit.craftbukkit.attribute.CraftAttribute;
import org.bukkit.craftbukkit.block.CraftBiome;
import org.bukkit.craftbukkit.block.CraftBlockType;
import org.bukkit.craftbukkit.block.banner.CraftPatternType;
import org.bukkit.craftbukkit.damage.CraftDamageType;
import org.bukkit.craftbukkit.enchantments.CraftEnchantment;
import org.bukkit.craftbukkit.entity.CraftCat;
import org.bukkit.craftbukkit.entity.CraftFrog;
import org.bukkit.craftbukkit.entity.CraftVillager;
import org.bukkit.craftbukkit.entity.CraftWolf;
import org.bukkit.craftbukkit.generator.structure.CraftStructure;
import org.bukkit.craftbukkit.generator.structure.CraftStructureType;
import org.bukkit.craftbukkit.inventory.CraftItemType;
import org.bukkit.craftbukkit.inventory.CraftMenuType;
import org.bukkit.craftbukkit.inventory.trim.CraftTrimMaterial;
import org.bukkit.craftbukkit.inventory.trim.CraftTrimPattern;
import org.bukkit.craftbukkit.legacy.FieldRename;
import org.bukkit.craftbukkit.map.CraftMapCursor;
import org.bukkit.craftbukkit.potion.CraftPotionEffectType;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;
import org.bukkit.damage.DamageType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.generator.structure.Structure;
import org.bukkit.generator.structure.StructureType;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.MenuType;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.map.MapCursor;
import org.bukkit.potion.PotionEffectType;
import org.jspecify.annotations.Nullable;

import static io.papermc.paper.registry.entry.RegistryEntry.apiOnly;
import static io.papermc.paper.registry.entry.RegistryEntry.entry;
import static io.papermc.paper.registry.entry.RegistryEntry.writable;

public final class PaperRegistries {

    static final List<RegistryEntry<?, ?>> REGISTRY_ENTRIES;
    private static final Map<RegistryKey<?>, RegistryEntry<?, ?>> BY_REGISTRY_KEY;
    private static final Map<ResourceKey<?>, RegistryEntry<?, ?>> BY_RESOURCE_KEY;
    static {
        REGISTRY_ENTRIES = List.of(
            // Paper start - Generated/RegistryDefinitions
            // @GeneratedFrom 1.21.3
            // built-in
            writable(Registries.GAME_EVENT, RegistryKey.GAME_EVENT, GameEvent.class, CraftGameEvent::new, PaperGameEventRegistryEntry.PaperBuilder::new),
            entry(Registries.STRUCTURE_TYPE, RegistryKey.STRUCTURE_TYPE, StructureType.class, CraftStructureType::new),
            entry(Registries.MOB_EFFECT, RegistryKey.MOB_EFFECT, PotionEffectType.class, CraftPotionEffectType::new),
            entry(Registries.BLOCK, RegistryKey.BLOCK, BlockType.class, CraftBlockType::new),
            entry(Registries.ITEM, RegistryKey.ITEM, ItemType.class, CraftItemType::new),
            entry(Registries.CAT_VARIANT, RegistryKey.CAT_VARIANT, Cat.Type.class, CraftCat.CraftType::new),
            entry(Registries.FROG_VARIANT, RegistryKey.FROG_VARIANT, Frog.Variant.class, CraftFrog.CraftVariant::new),
            entry(Registries.VILLAGER_PROFESSION, RegistryKey.VILLAGER_PROFESSION, Villager.Profession.class, CraftVillager.CraftProfession::new),
            entry(Registries.VILLAGER_TYPE, RegistryKey.VILLAGER_TYPE, Villager.Type.class, CraftVillager.CraftType::new),
            entry(Registries.MAP_DECORATION_TYPE, RegistryKey.MAP_DECORATION_TYPE, MapCursor.Type.class, CraftMapCursor.CraftType::new),
            entry(Registries.MENU, RegistryKey.MENU, MenuType.class, CraftMenuType::new),
            entry(Registries.ATTRIBUTE, RegistryKey.ATTRIBUTE, Attribute.class, CraftAttribute::new),
            entry(Registries.FLUID, RegistryKey.FLUID, Fluid.class, CraftFluid::new),
            entry(Registries.SOUND_EVENT, RegistryKey.SOUND_EVENT, Sound.class, CraftSound::new),
            entry(Registries.DATA_COMPONENT_TYPE, RegistryKey.DATA_COMPONENT_TYPE, DataComponentType.class, PaperDataComponentType::of),

            // data-driven
            entry(Registries.BIOME, RegistryKey.BIOME, Biome.class, CraftBiome::new).delayed(),
            entry(Registries.STRUCTURE, RegistryKey.STRUCTURE, Structure.class, CraftStructure::new).delayed(),
            entry(Registries.TRIM_MATERIAL, RegistryKey.TRIM_MATERIAL, TrimMaterial.class, CraftTrimMaterial::new).delayed(),
            entry(Registries.TRIM_PATTERN, RegistryKey.TRIM_PATTERN, TrimPattern.class, CraftTrimPattern::new).delayed(),
            entry(Registries.DAMAGE_TYPE, RegistryKey.DAMAGE_TYPE, DamageType.class, CraftDamageType::new).delayed(),
            entry(Registries.WOLF_VARIANT, RegistryKey.WOLF_VARIANT, Wolf.Variant.class, CraftWolf.CraftVariant::new).delayed(),
            writable(Registries.ENCHANTMENT, RegistryKey.ENCHANTMENT, Enchantment.class, CraftEnchantment::new, PaperEnchantmentRegistryEntry.PaperBuilder::new).withSerializationUpdater(FieldRename.ENCHANTMENT_RENAME).delayed(),
            entry(Registries.JUKEBOX_SONG, RegistryKey.JUKEBOX_SONG, JukeboxSong.class, CraftJukeboxSong::new).delayed(),
            entry(Registries.BANNER_PATTERN, RegistryKey.BANNER_PATTERN, PatternType.class, CraftPatternType::new).delayed(),
            writable(Registries.PAINTING_VARIANT, RegistryKey.PAINTING_VARIANT, Art.class, CraftArt::new, PaperPaintingVariantRegistryEntry.PaperBuilder::new).delayed(),
            entry(Registries.INSTRUMENT, RegistryKey.INSTRUMENT, MusicInstrument.class, CraftMusicInstrument::new).delayed(),

            // api-only
            apiOnly(Registries.ENTITY_TYPE, RegistryKey.ENTITY_TYPE, PaperSimpleRegistry::entityType),
            apiOnly(Registries.PARTICLE_TYPE, RegistryKey.PARTICLE_TYPE, PaperSimpleRegistry::particleType),
            apiOnly(Registries.POTION, RegistryKey.POTION, PaperSimpleRegistry::potion),
            apiOnly(Registries.MEMORY_MODULE_TYPE, RegistryKey.MEMORY_MODULE_TYPE, () -> org.bukkit.Registry.MEMORY_MODULE_TYPE)
            // Paper end - Generated/RegistryDefinitions
        );
        final Map<RegistryKey<?>, RegistryEntry<?, ?>> byRegistryKey = new IdentityHashMap<>(REGISTRY_ENTRIES.size());
        final Map<ResourceKey<?>, RegistryEntry<?, ?>> byResourceKey = new IdentityHashMap<>(REGISTRY_ENTRIES.size());
        for (final RegistryEntry<?, ?> entry : REGISTRY_ENTRIES) {
            Preconditions.checkState(byRegistryKey.put(entry.apiKey(), entry) == null, "Duplicate api registry key: %s", entry.apiKey());
            Preconditions.checkState(byResourceKey.put(entry.mcKey(), entry) == null, "Duplicate mc registry key: %s", entry.mcKey());
        }
        BY_REGISTRY_KEY = Collections.unmodifiableMap(byRegistryKey);
        BY_RESOURCE_KEY = Collections.unmodifiableMap(byResourceKey);
    }

    @SuppressWarnings("unchecked")
    public static <M, T extends Keyed> @Nullable RegistryEntry<M, T> getEntry(final ResourceKey<? extends Registry<M>> resourceKey) {
        return (RegistryEntry<M, T>) BY_RESOURCE_KEY.get(resourceKey);
    }

    @SuppressWarnings("unchecked")
    public static <M, T extends Keyed> @Nullable RegistryEntry<M, T> getEntry(final RegistryKey<? super T> registryKey) {
        return (RegistryEntry<M, T>) BY_REGISTRY_KEY.get(registryKey);
    }

    @SuppressWarnings("unchecked")
    public static <M, T> RegistryKey<T> registryFromNms(final ResourceKey<? extends Registry<M>> registryResourceKey) {
        return (RegistryKey<T>) Objects.requireNonNull(BY_RESOURCE_KEY.get(registryResourceKey), registryResourceKey + " doesn't have an api RegistryKey").apiKey();
    }

    @SuppressWarnings("unchecked")
    public static <M, T> ResourceKey<? extends Registry<M>> registryToNms(final RegistryKey<T> registryKey) {
        return (ResourceKey<? extends Registry<M>>) Objects.requireNonNull(BY_REGISTRY_KEY.get(registryKey), registryKey + " doesn't have an mc registry ResourceKey").mcKey();
    }

    public static <M, T> TypedKey<T> fromNms(final ResourceKey<M> resourceKey) {
        return TypedKey.create(registryFromNms(resourceKey.registryKey()), CraftNamespacedKey.fromMinecraft(resourceKey.location()));
    }

    @SuppressWarnings({"unchecked", "RedundantCast"})
    public static <M, T> ResourceKey<M> toNms(final TypedKey<T> typedKey) {
        return ResourceKey.create((ResourceKey<? extends Registry<M>>) PaperRegistries.registryToNms(typedKey.registryKey()), PaperAdventure.asVanilla(typedKey.key()));
    }

    public static <M, T> TagKey<T> fromNms(final net.minecraft.tags.TagKey<M> tagKey) {
        return TagKey.create(registryFromNms(tagKey.registry()), CraftNamespacedKey.fromMinecraft(tagKey.location()));
    }

    @SuppressWarnings({"unchecked", "RedundantCast"})
    public static <M, T> net.minecraft.tags.TagKey<M> toNms(final TagKey<T> tagKey) {
        return net.minecraft.tags.TagKey.create((ResourceKey<? extends Registry<M>>) registryToNms(tagKey.registryKey()), PaperAdventure.asVanilla(tagKey.key()));
    }

    private PaperRegistries() {
    }
}