import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private boolean cancelled = true;

    public LoginDialog(JFrame parent) {
        super(parent, "Вхід", true);

        
        JLabel usernameLabel = new JLabel("Логін:");
        JLabel passwordLabel = new JLabel("Пароль:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        
        JButton okButton = new JButton("ОК");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelled = false;
                dispose(); 
            }
        });
        JButton cancelButton = new JButton("Відміна");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(okButton);
        panel.add(cancelButton);

        
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        pack(); 
        setLocationRelativeTo(null); 
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Головне вікно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);

        LoginDialog dialog = new LoginDialog(frame);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        if (!dialog.isCancelled()) {
            System.out.println("Введений логін: " + dialog.getUsername());
            System.out.println("Введений пароль: " + dialog.getPassword());
        } else {
            System.out.println("Вхід скасовано.");
        }
    }
}
