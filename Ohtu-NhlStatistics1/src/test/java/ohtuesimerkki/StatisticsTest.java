package ohtuesimerkki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhaanran
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }

        @Override
        public int extractInt(String s) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
    
    public StatisticsTest() {
        stats = new Statistics(readerStub);
    }
    @Test
    public void loytyyGretzky() {     
        Player player = stats.search("Gretzky");
        assertEquals("Gretzky",player.getName());
    }
    @Test
    public void eiLoydyMatti() {
        Player player = stats.search("Luukkainen");
        assertEquals(null,player);        
    }
    @Test
    public void loytyyKolmeTeamEDMPelaajaa() {
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());
    }
    @Test
    public void topScorers() {
        List<Player> players = stats.topScorers(1);
//         for (int i = 0; i < players.size(); i++) {
//             System.out.println(players.get(i));
//         }
        assertEquals(2,players.size());
    }
}
