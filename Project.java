package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 class KeyCaptureExample extends JFrame {

    private JTextArea inputArea;
    private JTextArea logArea;

    public KeyCaptureExample() {
        setTitle("Key Capture Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        JScrollPane inputScroll = new JScrollPane(inputArea);
        JScrollPane logScroll = new JScrollPane(logArea);

        inputScroll.setBorder(BorderFactory.createTitledBorder("Type here"));
        logScroll.setBorder(BorderFactory.createTitledBorder("Key Events Log"));

        add(inputScroll, BorderLayout.CENTER);
        add(logScroll, BorderLayout.SOUTH);
        logScroll.setPreferredSize(new Dimension(500, 150));

        inputArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                logArea.append("Key Typed: " + keyChar + "\n");
                System.out.println("Key Typed: " + keyChar);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                logArea.append("Key Pressed: " + KeyEvent.getKeyText(keyCode) + "\n");
                System.out.println("Key Pressed: " + KeyEvent.getKeyText(keyCode));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                logArea.append("Key Released: " + KeyEvent.getKeyText(keyCode) + "\n");
                System.out.println("Key Released: " + KeyEvent.getKeyText(keyCode));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyCaptureExample example = new KeyCaptureExample();
            example.setVisible(true);
        });
    }
}