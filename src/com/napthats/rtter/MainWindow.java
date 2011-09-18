package com.napthats.rtter;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;



import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;


public class MainWindow {
	private final JFrame itsFrame = new JFrame();
	private final showTweetsMediator itsSTM; 
	private final JPanel buttonPanel = new JPanel();
	private final JPanel tweetPanel = new JPanel();
	private final JPanel subPanel = new JPanel();
	private final JButton btnNewButton = new JButton("start");
	
	public static MainWindow getInstance(showTweetsMediator STM) {
		return new MainWindow(STM);
	}
	
	private MainWindow() {
		itsSTM = null;
		assert false : "到達不可能なデフォルトコンストラクタ";
	}

	/**
	 * @wbp.parser.constructor
	 */
	private MainWindow(showTweetsMediator STM) {
		itsSTM = STM;
		initialize();
	}
	
	public void displayTweets(List<String> tweets) {
					
		JList statusJList = new JList(tweets.toArray());
		statusJList.setFixedCellHeight(20);
		JScrollPane scrollPane = new JScrollPane(statusJList,
		    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, // 垂直バー
		    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    tweetPanel.removeAll();
		tweetPanel.add(scrollPane);
	    tweetPanel.updateUI();
	}
	
	private void initialize() {
		itsFrame.setBounds(100, 100, 450, 300);
		itsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		itsFrame.getContentPane().setLayout(new BoxLayout(itsFrame.getContentPane(), BoxLayout.X_AXIS));
		
		itsFrame.getContentPane().add(buttonPanel);
		
		btnNewButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				itsSTM.showTweets();
			}
		});
		buttonPanel.add(btnNewButton);
		itsFrame.getContentPane().add(tweetPanel);
		
		itsFrame.getContentPane().add(subPanel);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



