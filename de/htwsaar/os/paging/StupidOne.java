package de.htwsaar.os.paging;

import java.util.ListIterator;

/**
 * Exampleimplementation of PagingAlgorithm
 * ... a simple one. It always returns the first tile to be replaced.
 *
 * @author Christoph Karls
 */
public class StupidOne implements PagingAlgorithm {

  public Tile selectTileToReplace(
    Tiles tiles,
    int pageNr,
    ListIterator<Integer> referencesPastCurrent
  ) {
    if (tiles.getNrOfTiles() > 0) {
      return tiles.getTile(0);
    } else {
      return null;
    }
  }
}
