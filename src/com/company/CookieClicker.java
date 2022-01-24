package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class CookieClicker extends JFrame implements MouseListener{

    JLabel cookieCounterText;
    JLabel cookie;
    JLabel level;

    JButton exit;

    File levelUp = new File("D:\\Personal\\CodingPractice\\JavaCodes\\cookieClicker\\levelUp.wav");

    ImageIcon cookieIcon = new ImageIcon("D:\\Personal\\CodingPractice\\JavaCodes\\cookieClicker\\cookie2.png");
    ImageIcon cookieIconSmall = new ImageIcon("D:\\Personal\\CodingPractice\\JavaCodes\\cookieClicker\\cookie1.png");

    int counter = 0;
    int currentLevel = 0;

    AudioInputStream inputStream;
    Clip gameClip;

    Timer timer;

    CookieClicker() throws UnsupportedAudioFileException, IOException {
        // Cookie png
        cookie = new JLabel();
        cookie.setBounds(90, 100, 200, 200);
        cookie.setIcon(cookieIcon);
        cookie.addMouseListener(this);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBounds(500, 250, 100, 30);
        exit.setFocusable(false);
        exit.setForeground(Color.white);
        exit.setFont(new Font("Comic sans MS", Font.ITALIC, 20));
        exit.setBackground(new Color(117, 72, 38));
        exit.addMouseListener(this);

        // Counter Text
        cookieCounterText = new JLabel();
        cookieCounterText.setText("Cookies Clicked: " + counter);
        cookieCounterText.setForeground(Color.white);
        cookieCounterText.setFont(new Font("Comic sans MS", Font.BOLD, 40));
        cookieCounterText.setBounds(20, 10, 500, 70);

        // Current Level
        level = new JLabel("Level: " + currentLevel);
        level.setBounds(515, 100, 100, 30);
        level.setForeground(Color.white);
        level.setFont(new Font("Comic sans MS", Font.ITALIC, 20));

        // Level up.wav
        inputStream = AudioSystem.getAudioInputStream(levelUp);
        gameClip = null;
        try {
            gameClip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            gameClip.open(inputStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        // Timer for Cursor


        // Game Frame
        this.setTitle("Cookie Clicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setIconImage(cookieIconSmall.getImage());
        this.setSize(700, 350);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);

        // Adding to Game Frame
        this.add(level);
        this.add(exit);
        this.add(cookie);
        this.add(cookieCounterText);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (counter % 50 == 0) {
            currentLevel++;
            level.setText("Level: " + currentLevel);
            gameClip.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            {
                gameClip.stop();
                gameClip.setMicrosecondPosition(0);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == cookie) {
            counter++;
            cookieCounterText.setText("Cookies Clicked: " + counter);
            cookie.setBounds(90, 100, 200, 200);
            cookie.setIcon(cookieIcon);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource() == cookie) {
            cookie.setBounds(95, 100, 200, 200);
            cookie.setIcon(cookieIconSmall);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

