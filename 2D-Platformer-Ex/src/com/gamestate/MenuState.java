package com.gamestate;

import java.awt.*;
import java.awt.event.KeyEvent;

import com.main.GamePanel;
import com.maps.Background;

public class MenuState extends GameState{
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm=gsm;
		
		try {
			bg = new Background("/Backgrounds/menuBG3.jpg",1);
			bg.setVector(1, 0);//sets the speed of scrolling image
			//bg.setPosition(-0.1, 0);
			
			titleColor = new Color(255,0,0);
			titleFont = new Font("Century Gothic", Font.BOLD,38);
			
			font = new Font("Arial", Font.BOLD,28);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	public void update() {
		bg.update();
	}
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Platformer2D EX", 830,320);//220,160 for 640x480
		
		//menu options
		g.setFont(font);
		for(int i=0;i<options.length;i++) {
			if(i == currentChoice) {
				g.setColor(Color.red);
			}
			else {
				g.setColor(Color.black);
			}
			g.drawString(options[i], 940,440+i*24);//315,205 for 640x480 and i*15
		}
		
	}
	private void select() {
		if(currentChoice == 0) {
			
		}
		if(currentChoice == 1) {
			System.exit(0);
		}
	}
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER) {
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length-1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		if(k == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	public void keyReleased(int k) {}
	
}
