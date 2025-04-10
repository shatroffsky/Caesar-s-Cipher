package RunProgram;

import CaesarCipher.BrudeForce;
import FileReaderOrWriter.FileToDecrypt;
import FileReaderOrWriter.FileToEncrypt;
import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class FrontEnd {

    private JFrame window;
    private JPanel jPanel;
    private JButton chooser;
    private JLabel path, keyLabel;
    private JTextArea keyIn;
    private JScrollPane scrollPane;
    private Path file;
    private JRadioButton encrypt, decrypt, brute;
    private JRadioButton uk, eng;
    private final JButton submit = new JButton("Submit");

    public FrontEnd(){
        initializeUI();
    }

    private void initializeUI() {
        createWindow();
        createPanel();
        createOptionButtons();
        createLanguageButtons();
        createFileButton();
        createKeyField();
        setComponentSizes();
        addListeners();
        if (jPanel != null) {
            jPanel.add(submit);
        }
        Result();
        if (jPanel != null) {
            jPanel.revalidate();
        }
        if (jPanel != null) {
            jPanel.repaint();
        }
    }

    public void Result(){
        submit.addActionListener(_ -> GetOption());
    }

    public void GetOption(){
        if (!brute.isSelected() && !encrypt.isSelected() && !decrypt.isSelected()) {
            JOptionPane.showMessageDialog(window, "Виберіть дію.");
            return;
        }
        if (encrypt.isSelected() && CheckFile() && CheckKey()) {
            FileToEncrypt fileToEncrypt = new FileToEncrypt(file, GetKey());
            if (ChekLanguage().equals("UK")){
                fileToEncrypt.EncrytpFileUA();
                End();
            } else if (ChekLanguage().equals("ENG")) {
                fileToEncrypt.EncrytpFileENG();
                End();
            }
        } else if (decrypt.isSelected() && CheckFile() && CheckKey()) {
            FileToDecrypt fileToDecrypt = new FileToDecrypt(file, GetKey());
            if (ChekLanguage().equals("UK")){
                fileToDecrypt.DecrytpFileUA();
                End();
            } else if (ChekLanguage().equals("ENG")) {
                fileToDecrypt.DecrytpFileENG();
                End();
            }
        } else if (brute.isSelected() && CheckFile()) {
            new BrudeForce(file);
            End();
        }
    }

    public void End(){
        JOptionPane.showMessageDialog(window, "Успішно!");
    }

    public String ChekLanguage(){
        if (uk.isSelected()){
            return "UK";
        } else if (eng.isSelected()) {
            return "ENG";
        } else {
            return new FileToEncrypt(file, 0).GetAlphabet();
        }
    }

    public boolean CheckFile(){
        if (file == null) {
            JOptionPane.showMessageDialog(window, "Оберіть файл перед виконанням операції.");
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckKey(){
        if (GetKey() == null) {
            JOptionPane.showMessageDialog(window, "Введіть ключ.");
            return false;
        } else {
            return true;
        }
    }

    private void createWindow() {
        window = new JFrame("Caesar's Cipher");
        window.setResizable(true);
        window.setBounds(600, 250, 300, 280);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public Integer GetKey() {
        String text = keyIn.getText().trim();
        if (text.isEmpty()) return null;
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void createPanel() {
        jPanel = new JPanel();
        window.add(jPanel);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    }

    private void createOptionButtons() {
        JLabel label = new JLabel("Виберіть дію з текстом:");
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        encrypt = new JRadioButton("Encrypt");
        decrypt = new JRadioButton("Decrypt");
        brute = new JRadioButton("Brute Force");

        ButtonGroup group = new ButtonGroup();
        group.add(encrypt);
        group.add(decrypt);
        group.add(brute);

        addToPanel(label);
        addToPanel(horizontalGroup(encrypt, decrypt, brute));
    }

    private JPanel horizontalGroup(Component... components) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        for (Component c : components) {
            panel.add(c);
            panel.add(Box.createRigidArea(new Dimension(5, 0))); // відступ між елементами
        }
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        return panel;
    }

    private void createLanguageButtons() {
        JLabel label = new JLabel("Виберіть мову тексту:");
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        uk = new JRadioButton("Ukraine");
        eng = new JRadioButton("English");

        ButtonGroup languageGroup = new ButtonGroup();
        languageGroup.add(uk);
        languageGroup.add(eng);

        addToPanel(label);
        addToPanel(horizontalGroup(uk, eng));
    }

    private void createFileButton() {
        chooser = new JButton("Select file");
        path = new JLabel();
        chooser.setVisible(false);
        path.setVisible(false);

        addToPanel(horizontalGroup(chooser, path));
    }

    private void createKeyField() {
        keyLabel = new JLabel("Enter key:");

        keyIn = new JTextArea(1, 5);
        keyIn.setLineWrap(false);
        keyIn.setWrapStyleWord(false);
        keyIn.setMinimumSize(new Dimension(40, 25));

        scrollPane = new JScrollPane(keyIn);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setMaximumSize(new Dimension(100, 37)); // розтяг по ширині

        keyLabel.setVisible(false);
        scrollPane.setVisible(false);

        addToPanel(horizontalGroup(keyLabel, scrollPane));
    }

    private void addToPanel(JComponent component) {
        component.setAlignmentX(Component.LEFT_ALIGNMENT);
        jPanel.add(component);
    }

    private void addListeners() {
        encrypt.addActionListener(_ -> Visibility(true));
        decrypt.addActionListener(_ -> Visibility(true));
        brute.addActionListener(_ -> Visibility(false));

        chooser.addActionListener(_ -> openFileChooser());
    }

    private void Visibility(boolean isVisible) {
        chooser.setVisible(true);
        scrollPane.setVisible(isVisible);
        keyLabel.setVisible(isVisible);
        jPanel.revalidate();
        jPanel.repaint();
    }

    private void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser("D:\\Texts");
        if (fileChooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile().toPath().toAbsolutePath();
            path.setText(file.toString());
            path.setVisible(true);
        }
    }

    private void setComponentSizes() {
        Font font = new Font("Arial", Font.PLAIN, 15);  // Визначаємо базовий шрифт
        chooser.setFont(font);
        path.setFont(font);
        keyLabel.setFont(font);
        keyIn.setFont(font);
        encrypt.setFont(font);
        decrypt.setFont(font);
        brute.setFont(font);
        uk.setFont(font);
        eng.setFont(font);
    }

}
