package com.mycompany.were;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Were extends JFrame {
    private JTextArea chatArea;
    private JTextArea messageArea;
    private JButton sendButton;

    public Were() {
        setTitle("Two-Way Colorful Chat Messenger");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 200, 220));
        
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        chatArea.setBackground(new Color(255, 220, 240));
        
        JScrollPane chatScroll = new JScrollPane(chatArea);
        chatScroll.setBorder(BorderFactory.createLineBorder(new Color(255, 150, 200), 2));
        mainPanel.add(chatScroll, BorderLayout.CENTER);
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color(255, 180, 210));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        messageArea = new JTextArea(2, 40);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        messageArea.setBackground(new Color(255, 240, 250));
        messageArea.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 150), 1));
        
        JScrollPane messageScroll = new JScrollPane(messageArea);
        
        sendButton = new JButton("Send");
        sendButton.setBackground(new Color(255, 100, 150));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createRaisedBevelBorder());
        
        inputPanel.add(messageScroll, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        chatArea.append("User 1: hi\n");
        chatArea.append("User 2: hlo\n");
        chatArea.append("User 2: how are you\n");
        chatArea.append("User 1: i am fine\n");
        
        sendButton.addActionListener(e -> sendMessage());
        
        messageArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !e.isShiftDown()) {
                    e.consume();
                    sendMessage();
                }
            }
        });
    }
    
    private void sendMessage() {
        String message = messageArea.getText().trim();
        if (!message.isEmpty()) {
            chatArea.append("User: " + message + "\n");
            messageArea.setText("");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Were().setVisible(true));
    }
}