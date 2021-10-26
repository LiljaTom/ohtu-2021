/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lilja
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPalauttaaOikeanPelaajan() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());
    }

    @Test
    public void searchPalauttaaNullJosEiLöydy() {
        Player p = stats.search("name");
        assertNull(p);
    }

    @Test
    public void teamPalauttaaOikeanMaaranPelaajia() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void topScorersPalauttaaOikeanMaaranPelaajia() {
        assertEquals(4, stats.topScorers(3).size());
    }
    
}
