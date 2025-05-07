package space.aliweb.menuframework.menu;

import space.aliweb.menuframework.option.MenuOption;

import java.util.*;

public class MenuOptionMap<OptionType extends MenuOption<?>> implements Map<OptionType, MenuOptionHandler<? extends OptionType>> {
    private Set<Entry<OptionType, MenuOptionHandler<? extends OptionType>>> entries;

    public MenuOptionMap() {
        entries = new LinkedHashSet<>();
    }

    // This whole class just for this
    public MenuOptionHandler<? extends OptionType> getRaw(String raw) {
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            if (entry.getKey().is(raw)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /* Map Methods */

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            if (Objects.equals(entry.getKey(), key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            if (Objects.equals(entry.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MenuOptionHandler<? extends OptionType> get(Object key) {
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public MenuOptionHandler<? extends OptionType> put(OptionType key, MenuOptionHandler<? extends OptionType> value) {
        if (key == null || value == null) {
            throw new NullPointerException("Key or value cannot be null");
        }

        // Check if the key already exists
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            if (Objects.equals(entry.getKey(), key)) {
                // If key exists, update the value
                MenuOptionHandler<? extends OptionType> oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        // If key doesn't exist, add a new entry
        entries.add(new AbstractMap.SimpleEntry<>(key, value));
        return null;
    }

    @Override
    public MenuOptionHandler<? extends OptionType> remove(Object key) {
        Iterator<Entry<OptionType, MenuOptionHandler<? extends OptionType>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry = iterator.next();
            if (Objects.equals(entry.getKey(), key)) {
                iterator.remove();
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends OptionType, ? extends MenuOptionHandler<? extends OptionType>> m) {
        for (Entry<? extends OptionType, ? extends MenuOptionHandler<? extends OptionType>> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public Set<OptionType> keySet() {
        Set<OptionType> keySet = new LinkedHashSet<>();
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    @Override
    public Collection<MenuOptionHandler<? extends OptionType>> values() {
        List<MenuOptionHandler<? extends OptionType>> values = new ArrayList<>();
        for (Entry<OptionType, MenuOptionHandler<? extends OptionType>> entry : entries) {
            values.add(entry.getValue());
        }
        return values;
    }

    @Override
    public Set<Entry<OptionType, MenuOptionHandler<? extends OptionType>>> entrySet() {
        return entries;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.entries);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuOptionMap other = (MenuOptionMap) obj;
        return Objects.equals(this.entries, other.entries);
    }

    @Override
    public String toString() {
        return "MenuOptionMap{" + "entries=" + entries + '}';
    }
}
