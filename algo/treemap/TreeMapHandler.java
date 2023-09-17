package algo.treemap;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * Handles add and retrieve operations on TreeMaps.
 */
public class TreeMapHandler {
    /**
     * Creates a TreeMap containing the provides entries. If there are more than one entry with the same key,
     * the first entry value is added. Following entries with identical keys will not replace the previously added value.
     *
     * @param entries entries with key and value
     * @return TreeMap with the provided entries
     */
    public TreeMap<Integer, Integer> createTreeMap(Entry[] entries) {
    //skapar en treemap för att hålla våra entries
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    //itererar genom entries våran tillfälliga variabel är entry
        for(Entry entry : entries)
        {
            //vi använder oss av entry som itererar genom entries för att lägga till nycklar och värden i våran skapade
            // treemap, vi använder oss av putIfAbsent för att motverka dubbletter
            map.putIfAbsent(entry.key, entry.value);
        }
        //TODO: Add implementation
        //jag returnerar "map" som nu är fylld en entries av nyckel och värden par som inte har dubbletter
        return map;
    }
    /**
     * Retrieves a Map with the entries associated with the provided keys.
     *
     * @param tree the tree map
     * @param keys keys for the entries we want to retrieve
     * @return Map containing the retrieved entries
     */
    public Map<Integer, Integer> retrieve(TreeMap<Integer, Integer> tree, int[] keys) {
        //Skapar en Treemap som kommer bara innehålla de sökta värden
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        //Itererar genom de sökta keys som vi har givits.
        for(int key : keys) {

        //key itererar genom keys och tar varje värde en i taget och lägger till det i vår skapta Treemap "map"
        //vår "map" kommer bara innehålla de sökta entries som nycklarna vi givits leder till.
        map.put(key, tree.get(key));
        }
        //TODO: Add implementation
        //returnerar en treemap med entries som nycklarna vi har givits leder till
        return map;
    }
    /**
     * Retrieves a Map containing the entries between the provided keys (including the from and to key).
     * @param tree the TreeMap
     * @param fromKey low endpoint of keys (inclusive)
     * @param toKey high endpoint of keys (inclusive)
     * @return Map containing the entries between the provided keys (including the from and to key)
     */
    public Map<Integer, Integer> retrieve(TreeMap<Integer, Integer> tree, int fromKey, int toKey) {
        //Skapar en sortedmap som är extended med navigations metoder.
       NavigableMap<Integer, Integer> fromTo = new TreeMap<Integer, Integer>();

       //Ger fromTo de specificerade värden från tree via att använda en submap. Startvärdet är fromKey och slutvärdet
        //toKey. Vi behöver också lägga till en boolean true efter fromKey och en efter toKey så att de inkluderas,
        //annars kommer de inte läggas in i fromTo, utan bara värdena mellan fromKey och toKey läggs till då.
        //I detta fall behöver vi också värdet för fromKey och toKey
       fromTo = tree.subMap(fromKey, true, toKey, true );

       //Returnerar fromTo som anhåller värdena from. fromKey tom. toKey
       return fromTo;
        //TODO: Add implementation
    }
    /**
     * Retrieves all keys from the tree.
     * @param tree the TreeMap
     * @return Collection with all keys
     */
    public Collection<Integer> retrieveAllKeys(TreeMap<Integer, Integer> tree) {

        //Skapar en collection som innehåller key värden från tree, keySet tillåter mig att bara få key värdet.
        //Jag behöver inte iterera igenom tree, för vi ska ha alla key värden.
        Collection<Integer> keys = tree.keySet();

        //TODO: Add implementation
        //returnerar keys, som är en collection av keys från tree.
        return keys;
    }
    /**
     * Retrieves all values from the tree.
     * @param tree the TreeMap
     * @return Collection with all values
     */
    public Collection<Integer> retrieveAllValues(TreeMap<Integer, Integer> tree) {

        //Skapar en collection av integers som representerar integer i platsen values inom tree, values tillåter mig få
        //de sökta värden. Jag behöver inte iterera genom tree, för vi ska ha alla values värden
        Collection<Integer> allValues = tree.values();

        //TODO: Add implementation
        //returnerar allValues som är en collection av alla values från tree
        return allValues;
    }
}