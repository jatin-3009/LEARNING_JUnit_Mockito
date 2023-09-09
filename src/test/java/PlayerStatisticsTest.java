import com.mockito.pojo.Player;
import com.mockito.service.PlayerStatistics;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayerStatisticsTest {

    private Player playerShawnAbove30;
    private PlayerStatistics statisticsOfShawnAbove30;

    @Before
    public void setup() {
        playerShawnAbove30 = new Player("Shawn", 35);
        statisticsOfShawnAbove30 = new PlayerStatistics(playerShawnAbove30, 3, 3);
    }

    @Test
    public void playerNameEqual() {
        Player player2 = new Player("Shawn", 25);
        assertEquals(playerShawnAbove30, player2);
    }

    @Test
    public void playerNameNotEqual() {
        Player player2 = new Player("Axel", 35);
        assertNotEquals(playerShawnAbove30, player2);
    }

    @Test
    public void youngerPlayerSame() {
        Player player2 = new Player("Shawn", 20);
        assertSame(player2, PlayerStatistics.getYoungerPlayer(playerShawnAbove30, player2));
    }

    @Test
    public void underThirtyTrue() {
        Player player = new Player("Axel", 25);
        PlayerStatistics statistics = new PlayerStatistics(player, 10, 10);
        assertTrue(statistics.underThirty());
    }

    @Test
    public void underThirtyFalse() {
        assertFalse(statisticsOfShawnAbove30.underThirty());
    }

    @Test
    public void csvReportNull() {
        Player player = new Player("Axel", 25);
        PlayerStatistics statistics = new PlayerStatistics(player, 0, 0);
        assertNull(statistics.createCsvRecord());
    }

    @Test
    public void csvReportNotNull() {
        Player player = new Player("Axel", 25);
        PlayerStatistics statistics = new PlayerStatistics(player, 3, 3);
        assertNotNull(statistics.createCsvRecord());
    }

    @Test
    public void getCsvStatsRecord() {
        Player player = new Player("Axel", 25);
        PlayerStatistics statistics = new PlayerStatistics(player, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        assertArrayEquals(expectedArray, statistics.createCsvRecord());
    }
}
