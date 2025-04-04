package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_boolean() {
        Team team2 = new Team("test-team");
        //Same obj
        assertEquals(team.equals(team), true);
        //Same name and members
        assertEquals(team.equals(team2), true);
        //Diff name same members
        team2.setName("no");
        assertEquals(team.equals(team2), false);
        //Same name diff members
        team2.setName("test-team");
        team2.addMember("Kenneth");
        assertEquals(team.equals(team2), false);
        //Diff name diff members
        team2.setName("no");
        assertEquals(team.equals(team2), false);
        //Not same obj
        assertEquals(team.equals("j"), false);
    }

    // @Test
    // public void hashCode_returns_correct_hashes() {
    //     Team t1 = new Team();
    //     t1.setName("foo");
    //     t1.addMember("bar");
    //     Team t2 = new Team();
    //     t2.setName("foo");
    //     t2.addMember("bar");
    //     assertEquals(t1.hashCode(), t2.hashCode());
    // }

    @Test
    public void hashCode_workaround(){
        // instantiate t as a Team object
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);

    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
