import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Lock extends JPanel{
	boolean set = false;
	Lock(int pos){
		int correct, q1, q2, answer;
		
		setSize(200,500);
		setBackground(Color.white);
		setLayout(null);
		
		
		
		switch(pos){
		case 1: setLocation(0,0); break;
		case 2: setLocation(200,0); break;
		case 3: setLocation(400,0); break;
		}
		
		Random rand = new Random();
		
		correct = rand.nextInt(3)+1;
		q1 = rand.nextInt(9)+1;
		q2 = rand.nextInt(9)+1;
		answer = q1+q2;
		
		JPanel questionPanel = new JPanel();
		questionPanel.setSize(100,75);
		questionPanel.setLocation(50,10);
		questionPanel.setLayout(new GridLayout(1,1));
		questionPanel.setBackground(Color.red);
		
		questionPanel.setVisible(true);
		add(questionPanel);
		
		JTextArea questionArea = new JTextArea();
		questionArea.setEditable(false);
		questionArea.setVisible(true);
		questionArea.setText(q1 + " + " + q2 + " = ?");
		questionPanel.add(questionArea);
		
		
		JPanel answerPanel = new JPanel();
		answerPanel.setSize(100, 300);
		answerPanel.setLocation(50,150);
		answerPanel.setBackground(Color.green);
		answerPanel.setVisible(true);
		answerPanel.setLayout(new GridLayout(3,1));
		add(answerPanel);
		
		JButton b1 = new JButton(Integer.toString(rand.nextInt(9)+1));
		b1.setBackground(Color.green);
		answerPanel.add(b1);
		
		JButton b2 = new JButton(Integer.toString( rand.nextInt(9)+1));
		b2.setBackground(Color.green);
		answerPanel.add(b2);
		
		JButton b3 = new JButton(Integer.toString(rand.nextInt(9)+1));
		b3.setBackground(Color.green);
		answerPanel.add(b3);
		
		switch(correct){
			case 1: b1.setText(Integer.toString(answer)); break;
			case 2: b2.setText(Integer.toString(answer)); break;
			case 3: b3.setText(Integer.toString(answer)); break;
		}
		
		
		if(correct==1) {
			b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) right();
					
				}
				
			});
			b2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) wrong();
				}
				
			});
			b3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) wrong();
				}
				
			});
		}
		if(correct==2) {
			b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) wrong();
				}
				
			});
			b2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) right();
				}
				
			});
			b3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) wrong();
				}
				
			});
		}
		if(correct==3) {
			b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) wrong();
				}
				
			});
			b2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(set == false) wrong();
				}
				
			});
			b3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				if(set == false) right();
				}
				
			});
		}
		
		
		
	}
	private void wrong() {
		setBackground(Color.red);
		AdventureManager.currentTreasure.locksFailed++;
		set = true;
		
		if((AdventureManager.currentTreasure.locksFailed + AdventureManager.currentTreasure.locksPassed == 3) ) {
			failure();
		}
	}
	private void right() {
		setBackground(Color.green);
		AdventureManager.currentTreasure.locksPassed++;
		set = true;
		
		if((AdventureManager.currentTreasure.locksFailed + AdventureManager.currentTreasure.locksPassed == 3) && (AdventureManager.currentTreasure.locksPassed == 3) ) {
			success();
		}
		if((AdventureManager.currentTreasure.locksFailed + AdventureManager.currentTreasure.locksPassed == 3) && (AdventureManager.currentTreasure.locksPassed < 3) ) {
			failure();
		}
	}
	private void failure() {
		AdventureManager.currentTreasure.locksFailed = 0;
		AdventureManager.currentTreasure.locksPassed = 0;
		AdventureManager.currentRoom.t.start();
		AdventureManager.currentTreasure.unlockPanel.setVisible(false);
		AdventureManager.mainPanel.setVisible(true);
		Main.window.requestFocus();
	}
	private void success() {
		AdventureManager.currentTreasure.locksFailed = 0;
		AdventureManager.currentTreasure.locksPassed = 0;
		AdventureManager.currentRoom.t.start();
		AdventureManager.currentTreasure.unlockPanel.setVisible(false);
		AdventureManager.currentTreasure.openChest();
		AdventureManager.mainPanel.setVisible(true);
		Main.window.requestFocus();
	}
	
}
