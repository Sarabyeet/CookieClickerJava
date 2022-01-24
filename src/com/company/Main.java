package com.company;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            CookieClicker newCookie = new CookieClicker();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
