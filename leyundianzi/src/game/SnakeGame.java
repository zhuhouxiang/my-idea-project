import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeGame extends JFrame implements ActionListener, KeyListener {
    // 游戏常量
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int UNIT_SIZE = 20;
    private static final int GAME_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    private static final int DELAY = 100; // 游戏速度（毫秒）

    // 蛇的身体坐标
    private final int[] x = new int[GAME_UNITS];
    private final int[] y = new int[GAME_UNITS];
    private int bodyParts = 6; // 初始长度

    // 食物位置
    private int foodX;
    private int foodY;

    // 游戏状态
    private char direction = 'R'; // 初始方向：右
    private boolean running = false;
    private Timer timer;
    private Random random;
    private int score = 0;

    public SnakeGame() {
        random = new Random();
        this.setTitle("贪吃蛇游戏");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // 居中显示
        this.addKeyListener(this);
        this.setVisible(true);

        // 初始化游戏面板
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);

        startGame();
    }

    // 开始游戏
    public void startGame() {
        newFood();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    // 绘制游戏元素
    public void paint(Graphics g) {
        // 绘制游戏背景
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 绘制网格线（可选）
        g.setColor(new Color(40, 40, 40));
        for (int i = 0; i < HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, HEIGHT);
        }

        // 绘制食物
        g.setColor(Color.RED);
        g.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);

        // 绘制蛇
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) { // 蛇头
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else { // 蛇身
                g.setColor(new Color(45, 180, 0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }

        // 绘制分数
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("分数: " + score, (WIDTH - metrics.stringWidth("分数: " + score)) / 2, g.getFont().getSize());
    }

    // 生成新食物
    public void newFood() {
        foodX = random.nextInt((int)(WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        foodY = random.nextInt((int)(HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        // 确保食物不会出现在蛇身上
        for (int i = 0; i < bodyParts; i++) {
            if (x[i] == foodX && y[i] == foodY) {
                newFood();
            }
        }
    }

    // 移动蛇
    public void move() {
        // 移动身体部分（从尾部开始）
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        // 移动头部
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    // 检查碰撞
    public void checkCollisions() {
        // 撞到自己
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        // 撞墙
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "游戏结束！最终分数: " + score,
                    "游戏结束", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 检查是否吃到食物
    public void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            bodyParts++;
            score += 10;
            newFood();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFood();
            checkCollisions();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_SPACE:
                // 空格键重新开始游戏
                if (!running) {
                    resetGame();
                }
                break;
        }
    }

    // 重置游戏
    private void resetGame() {
        bodyParts = 6;
        score = 0;
        direction = 'R';
        // 重置蛇的位置
        for (int i = 0; i < GAME_UNITS; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        startGame();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    // 游戏面板类
    public class GamePanel extends JPanel {
        public GamePanel() {
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setBackground(Color.BLACK);
            this.setFocusable(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paint(g);
        }
    }

    public static void main(String[] args) {
        // 在事件调度线程中启动游戏
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}