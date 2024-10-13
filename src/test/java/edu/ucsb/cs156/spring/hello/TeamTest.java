package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assertTrue(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
    @Test
    public void equals_returns_correct_value() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("Different name");
        
        assertTrue(team.equals(team));
        assertTrue(team.equals(team1));
        assertTrue(!team.equals("Not a team"));
        assertTrue(!team.equals(team2));

        team1.addMember("Bob");
        assertTrue(!team.equals(team1));

    }

    @Test
    public void hashCode_returns_correct_hashCode() {
        Team t = new Team("t");
        int result = t.hashCode();
        int expectedResult = 117;
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
