package com.napthats.rtter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Rtter {

	private final JFrame itsFrame;
	private final ExcuteCommand itsEC;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Rtter window = new Rtter();
					window.itsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rtter() {
		itsFrame = new JFrame();
		itsEC = ExcuteCommand.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		itsFrame.setBounds(100, 100, 450, 300);
		itsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		itsFrame.getContentPane().setLayout(new BoxLayout(itsFrame.getContentPane(), BoxLayout.X_AXIS));
		
		final JPanel buttonPanel = new JPanel();
		itsFrame.getContentPane().add(buttonPanel);
		
		JButton btnNewButton = new JButton("start");
		btnNewButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//itsEC.getTweets();
				update();
			}
		});
		buttonPanel.add(btnNewButton);
		
		final JPanel tweetPanel = new JPanel();
		itsFrame.getContentPane().add(tweetPanel);
		
		JTextArea textArea = new JTextArea();
		tweetPanel.add(textArea);
		
		
		final JPanel subPanel = new JPanel();
		itsFrame.getContentPane().add(subPanel);
	}

	private void update(){
		
	}
}
