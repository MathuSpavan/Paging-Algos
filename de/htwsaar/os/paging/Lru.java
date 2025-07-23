package de.htwsaar.os.paging;

import java.util.ListIterator;

/**
 * LRU (Least Recently Used) Page Replacement Algorithm
 */
public class Lru implements PagingAlgorithm {

    public Lru() {
        // leerer Default-Konstruktor
    }

    /**
     * Wählt das Tile mit dem kleinsten ticksLastAccessed-Wert aus,
     * d. h. das am längsten nicht mehr genutzte (LRU).
     */
    @Override
    public Tile selectTileToReplace(
            Tiles tiles,
            int pageNr,
            ListIterator<Integer> referencesPastCurrent
    ) {
        Tile lru = null;
        int count = tiles.getNrOfTiles();
        for (int i = 0; i < count; i++) {
            Tile t = tiles.getTile(i);
            // nur belegte Tiles betrachten
            if (!t.isInUse()) {
                continue;
            }
            if (lru == null || t.getTicksLastAccessed() < lru.getTicksLastAccessed()) {
                lru = t;
            }
        }
        return lru;
    }
}
