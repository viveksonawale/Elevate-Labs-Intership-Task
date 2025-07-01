import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    JFrame window;
    JTextField textField;
    JList<TaskItem> list;
    DefaultListModel<TaskItem> listModel;
    JButton addButton, deleteButton;
    JLabel label;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        init();
        addComponents();
    }

    public void init() {
        window = new JFrame("To Do App");
        window.setSize(1200, 700);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel imagePanel = new ImagePanel("./assets/image2.png");
        imagePanel.setLayout(null); // Absolute positioning
        window.setContentPane(imagePanel);

        window.setVisible(true);
    }

    public void addComponents() {
        // Label
        label = new JLabel("Enter Task");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setBounds(30, 290, 100, 30);
        label.setForeground(Color.black);
        window.getContentPane().add(label);

        // TextField
        textField = new JTextField();
        textField.setBounds(120, 290, 300, 30);
        textField.setFont(new Font("Segoe UI", Font.BOLD, 18));
        window.getContentPane().add(textField);

        // Add Button
        addButton = new JButton("Add Task");
        addButton.setBounds(430, 290, 120, 30);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        addButton.setBackground(Color.WHITE);
        addButton.addActionListener(e -> addTask());
        window.getContentPane().add(addButton);

        // Delete Button
        deleteButton = new JButton("Delete Selected");
        deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        deleteButton.setBounds(560, 290, 150, 30); // ✅ correctly placed next to Add button
        deleteButton.setBackground(Color.WHITE);
        deleteButton.addActionListener(e -> deleteTask());
        window.getContentPane().add(deleteButton);

        // List
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        list.setCellRenderer(new TaskRenderer());

        // Toggle task done when clicked
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                if (index != -1) {
                    TaskItem item = listModel.getElementAt(index);
                    item.toggle();
                    list.repaint();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(0, 350, 1500, 600);
        window.getContentPane().add(scrollPane);
    }

    // Add Task Logic
    private void addTask() {
        String task = textField.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(new TaskItem(task));
            textField.setText("");
        } else {
            JOptionPane.showMessageDialog(window, "Please enter a task.");
        }
    }

    // Delete Task Logic
    private void deleteTask() {
        int selected = list.getSelectedIndex();
        if (selected != -1) {
            listModel.remove(selected);
        } else {
            JOptionPane.showMessageDialog(window, "Select a task to delete.");
        }
    }

    // Class to store task and status
    static class TaskItem {
        String text;
        boolean isDone;

        public TaskItem(String text) {
            this.text = text;
            this.isDone = false;
        }

        public void toggle() {
            isDone = !isDone;
        }

        public boolean isDone() {
            return isDone;
        }

        @Override
        public String toString() {
            return (isDone ? " Done " : " Pending ") + text;
        }
    }

    // Renderer to change text color based on status
    static class TaskRenderer extends JLabel implements ListCellRenderer<TaskItem> {
        public TaskRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends TaskItem> list, TaskItem value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
            setFont(new Font("Segoe UI", Font.PLAIN, 18));
            setForeground(value.isDone() ? Color.GRAY : Color.BLACK);
            setBackground(isSelected ? new Color(200, 200, 255) : Color.WHITE);
            return this;
        }
    }

    // Background image with time/date
    class ImagePanel extends JPanel {
        private final Image backgroundImage;

        public ImagePanel(String imagePath) {
            backgroundImage = new ImageIcon(imagePath).getImage();
            Timer timer = new Timer(1000, e -> repaint());
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, -400, getWidth(), getHeight(), this);

            String date = new SimpleDateFormat("dd MM yyyy").format(new Date());
            String time = new SimpleDateFormat("hh:mm a").format(new Date());
            String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date());

            g.setColor(new Color(0, 0, 0, 140));
            g.fillRect(800, getHeight() - 600, 700, 150);

            g.setFont(new Font("Segoe UI", Font.BOLD, 28));
            g.setColor(Color.WHITE);
            g.drawString(date.toUpperCase(), 915, getHeight() - 515);

            g.setFont(new Font("Arial", Font.ITALIC, 24));
            g.drawString(time.toUpperCase(), 950, getHeight() - 490);

            g.setFont(new Font("Segoe UI", Font.BOLD, 40));
            g.setColor(Color.YELLOW);
            g.drawString(dayOfWeek, 910, getHeight() - 550);
        }
    }
}
