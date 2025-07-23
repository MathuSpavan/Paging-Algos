package de.htwsaar.os.paging;

import java.util.ListIterator;

/**
 * FIFO Page Replacement Algorithm
 */
public class Fifo implements PagingAlgorithm {

    public Fifo() {
        // leerer Default-Konstruktor
    }

    /**
     * Wählt das Tile mit dem kleinsten ticksLoaded-Wert aus,
     * d. h. das am längsten im Speicher verweilende (FIFO).
     */
    @Override
    public Tile selectTileToReplace(
            Tiles tiles,
            int pageNr,
            ListIterator<Integer> referencesPastCurrent
    ) {
        Tile oldest = null;
        int count = tiles.getNrOfTiles();
        for (int i = 0; i < count; i++) {
            Tile t = tiles.getTile(i);
            // nur belegte Tiles betrachten
            if (!t.isInUse()) {
                continue;
            }
            if (oldest == null || t.getTicksLoaded() < oldest.getTicksLoaded()) {
                oldest = t;
            }
        }
        return oldest;
    }
}