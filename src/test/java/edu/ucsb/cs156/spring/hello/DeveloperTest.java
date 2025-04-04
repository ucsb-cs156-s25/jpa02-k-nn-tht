package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Kenneth T.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("k-nn-tht", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-13", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Kenneth"),"Team should contain Kenneth");
        assertTrue(t.getMembers().contains("Timothy"),"Team should contain Timothy");
        assertTrue(t.getMembers().contains("Conner"),"Team should contain Conner");
        assertTrue(t.getMembers().contains("Nikunj"),"Team should contain Nikunj");
        assertTrue(t.getMembers().contains("Tuan"),"Team should contain Tuan");
        assertTrue(t.getMembers().contains("Cheng"),"Team should contain Cheng");
        // ... etc
    }


    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
