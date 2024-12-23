package project.com.Model.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BrickTest {

    private Brick brickY;
    private Brick brickB;
    private Brick brickG;
    private Brick brickP;
    private Brick brickHash;

    @BeforeEach
    void setUp() {
        brickY = new Brick(new Position(10, 10), 'Y');
        brickB = new Brick(new Position(20, 20), 'B');
        brickG = new Brick(new Position(30, 30), 'G');
        brickP = new Brick(new Position(40, 40), 'P');
        brickHash = new Brick(new Position(50, 50), '#');
    }

    @Test
    void testInitialState() {
        assertEquals('Y', brickY.getCharacter());
        assertEquals('B', brickB.getCharacter());
        assertEquals('G', brickG.getCharacter());
        assertEquals('P', brickP.getCharacter());
        assertEquals('#', brickHash.getCharacter());

        assertEquals(2, brickY.getDurability());
        assertEquals(1, brickB.getDurability());
        assertEquals(1, brickG.getDurability());
        assertEquals(1, brickP.getDurability());
        assertEquals(5, brickHash.getDurability());

        assertEquals(50, brickY.getScore());
        assertEquals(30, brickB.getScore());
        assertEquals(20, brickG.getScore());
        assertEquals(10, brickP.getScore());
    }

    @Test
    void testHit() {
        brickY.hit();
        assertEquals(1, brickY.getDurability());

        brickHash.hit();
        assertEquals(4, brickHash.getDurability());

        brickHash.hit();
        assertEquals(3, brickHash.getDurability());
    }

    @Test
    void testHitBox() {
        Rectangle hitBox = brickY.getHitBox();
        assertEquals(new Rectangle(10, 10, 15, 8), hitBox);

        hitBox = brickHash.getHitBox();
        assertEquals(new Rectangle(50, 50, 15, 8), hitBox);
    }
}
