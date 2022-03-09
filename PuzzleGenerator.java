package blocks;

import java.util.Random;

/** A creator of random Blocks puzzles.
 *  @author annetta
 */
class PuzzleGenerator implements PuzzleSource {

    /** A new PuzzleGenerator whose random-number source is seeded
     *  with SEED. */
    PuzzleGenerator(long seed) {
        _random = new Random(seed);
    }

    /* By default, the convention is that overriding methods have the same
     * comment as on the method they override. See PuzzleSource.
     * -- Deal HANDSIZE>0 pieces to MODEL, clearing any previous ones. Returns
     * -- true on success, or false if there are no more hands.
     *  */
    @Override
    public boolean deal(Model model, int handSize) {
        assert handSize > 0;
        model.clearHand();

        for (int i = 0; i < handSize; i++) {
            model._hand.add(PIECES[_random.nextInt(handSize)]);
        }
        return true;
    }

    @Override
    public void setSeed(long seed) {
        _random.setSeed(seed);
    }

    /** My PNRG. */
    private Random _random;

    /** Pieces available to be dealt to hand. */
    static final Piece[] PIECES = {
        new Piece("*** *** ***"),
        new Piece("** **"),
        new Piece("*"),

        new Piece("** ** **"),
        new Piece("*** ***"),

        new Piece("**"),
        new Piece("* *"),
        new Piece("***"),
        new Piece("* * *"),

        new Piece("** *."),
        new Piece("** .*"),
        new Piece("*. **"),
        new Piece(".* **"),

        new Piece("** *. **"),
        new Piece("** .* **"),
        new Piece("*.* ***"),
        new Piece("*** *.*"),

        new Piece("*.. *** *.."),
        new Piece("..* *** ..*"),
        new Piece(".*. .*. ***"),
        new Piece("*** .*. .*."),

        new Piece("*** ..* ..*"),
        new Piece("..* ..* ***"),
        new Piece("*** *.. *.."),
        new Piece("*.. *.. ***"),

        new Piece("** *. *."),
        new Piece("** .* .*"),
        new Piece("*.. ***"),
        new Piece("*** *.."),

        new Piece("*. .*"),
        new Piece(".* *."),

        new Piece("*.. .*. ..*"),
        new Piece("..* .*. *.."),

        new Piece("*.* .*. *.*"),
        new Piece(".*. *.* .*."),

        new Piece(".*. *** .*."),

        new Piece(".** **."),
        new Piece("**. .**"),
        new Piece("*. ** .*"),
        new Piece(".* ** *.")
    };

}
