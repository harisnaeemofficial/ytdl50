package com.hexotic.v2.gui.support;

import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.hexotic.cons.Constants;
import com.hexotic.lib.exceptions.ResourceException;
import com.hexotic.lib.resource.Resources;
import com.hexotic.v2.gui.theme.Theme;

public class AboutPanel extends JPanel {

	public AboutPanel() {
		this.setBackground(Theme.CONTROL_BAR_BACKGROUND);
		this.setPreferredSize(new Dimension(600, 120));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		GradientPaint paint = new GradientPaint(0, 0, Theme.CONTROL_BAR_BACKGROUND, 0, getHeight(), Theme.CONTROL_BAR_BORDER);
		g2d.setPaint(paint);
		g2d.fillRect(0, 0, getWidth(), getHeight());
 
		try {
			g2d.drawImage(Resources.getInstance().getImage("icon_small.png"), 20, 0, 32, 32, null);
		} catch (ResourceException e) {}

		g2d.setFont(Theme.CONTROL_BAR_FONT.deriveFont(18.0f));
		g2d.setColor(Theme.DARK);
		g2d.drawString(Constants.PROG_NAME, 60, 20);
		
		g2d.setFont(Theme.CONTROL_BAR_FONT.deriveFont(12.0f));
		g2d.setColor(Theme.DARK);
		g2d.drawString("Version: " + Constants.VERSION, 165, 34);
		
		g2d.setFont(Theme.CONTROL_BAR_FONT);
		g2d.drawString("Frontend software for youtube-dl command line utility, find out more at http://hexotic.net", 60, 70);
		g2d.drawString("Copyright Hexotic Software 2014.  All Rights Reserved", 148, 90);
	}

}
