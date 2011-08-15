package net.stackdump.example.gwt.gwtexample.shared.data;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Base class providing delegate methods into {@link LinkedHashMap}, so we don't
 * have to subclass it.  The RPC mechanism doesn't handle subclasses correctly,
 * due to the way it derives the access order.
 */
public class BaseLinkedMap<K, V> implements IsSerializable
{
    /**
     * The backing map.
     */
    private Map<K, V> map = new LinkedHashMap<K, V>();
    
    /**
     * @return the map
     */
    public Map<K, V> getMap()
    {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(final Map<K, V> map)
    {
        this.map = map;
    }

    /**
     * @return
     * @see java.util.Map#size()
     */
    public int size()
    {
        return map.size();
    }

    /**
     * @return
     * @see java.util.Map#isEmpty()
     */
    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    /**
     * @param key
     * @return
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    public boolean containsKey(final Object key)
    {
        return map.containsKey(key);
    }

    /**
     * @param value
     * @return
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    public boolean containsValue(final Object value)
    {
        return map.containsValue(value);
    }

    /**
     * @param key
     * @return
     * @see java.util.Map#get(java.lang.Object)
     */
    public V get(final Object key)
    {
        return map.get(key);
    }

    /**
     * @param key
     * @param value
     * @return
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public V put(final K key, final V value)
    {
        return map.put(key, value);
    }

    /**
     * @param key
     * @return
     * @see java.util.Map#remove(java.lang.Object)
     */
    public V remove(final Object key)
    {
        return map.remove(key);
    }

    /**
     * @param m
     * @see java.util.Map#putAll(java.util.Map)
     */
    public void putAll(final Map<? extends K, ? extends V> m)
    {
        map.putAll(m);
    }

    /**
     * 
     * @see java.util.Map#clear()
     */
    public void clear()
    {
        map.clear();
    }

    /**
     * @return
     * @see java.util.Map#keySet()
     */
    public Set<K> keySet()
    {
        return map.keySet();
    }

    /**
     * @return
     * @see java.util.Map#values()
     */
    public Collection<V> values()
    {
        return map.values();
    }

    /**
     * @return
     * @see java.util.Map#entrySet()
     */
    public Set<Entry<K, V>> entrySet()
    {
        return map.entrySet();
    }

    /**
     * @param o
     * @return
     * @see java.util.Map#equals(java.lang.Object)
     */
    public boolean equals(final Object o)
    {
        return map.equals(o);
    }

    /**
     * @return
     * @see java.util.Map#hashCode()
     */
    public int hashCode()
    {
        return map.hashCode();
    }
}
