import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class person {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[43m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[47m";

    String name;
    String email;
    String source;
    String destination;
    String phone;
    int age;
    String issueDate;

    person() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        issueDate = now.format(formatter);
    }
}

class transport extends person {
    void displayDetails() {
        System.out.println("\n\n--- TICKET INFO ---");
        System.out.println("NAME : " + name);
        System.out.println("EMAIL : " + email);
        System.out.println("AGE : " + age);
        System.out.println("PHONE NUMBER : " + phone);
        System.out.println("SOURCE : " + source);
        System.out.println("DESIINATION : " + destination);
        System.out.println();
    }
}

class payment extends transport {
    int choice; // 1 for Credit Card, 2 for Wallet
    String paymentMethod;
    String accountTitle;
    String accountNumber;

    void makePayment() {
        // Retained for compatibility
    }
}

class airline extends payment {
    String air;
    int price;
    String timing;

    @Override
    void displayDetails() {
        System.out.println(BLACK + WHITE + "\n--- AIRLINE TICKET INFO ---");
        System.out.println(BLUE + "NAME : " + name);
        System.out.println("EMAIL : " + email);
        System.out.println("AGE : " + age);
        System.out.println("PHONE NUMBER : " + phone);
        System.out.println("SOURCE : " + source);
        System.out.println("DESIINATION : " + destination);
        System.out.println("AIRLINE : " + air);
        System.out.println("DATE OF PRINT : " + issueDate + RESET);
        System.out.println("\n\n");
    }

    void makeBooking() {
        // Retained for compatibility
    }
}

class railway extends payment {
    String rail;
    int price;
    String timing;

    @Override
    void displayDetails() {
        System.out.println(BLACK + WHITE + "\n--- RAILWAY TICKET INFO ---");
        System.out.println(BLUE + "NAME : " + name);
        System.out.println("EMAIL : " + email);
        System.out.println("AGE : " + age);
        System.out.println("PHONE NUMBER : " + phone);
        System.out.println("SOURCE : " + source);
        System.out.println("DESIINATION : " + destination);
        System.out.println("TRAIN : " + rail);
        System.out.println("DATE OF PRINT : " + issueDate + RESET);
        System.out.println("\n\n");
    }

    void makeBooking() {
        // Retained for compatibility
    }
}

class bus extends payment {
    String bus_ID;
    int price;
    String timing;

    @Override
    void displayDetails() {
        System.out.println(BLACK + WHITE + "\n--- BUS TICKET INFO ---");
        System.out.println(BLUE + "NAME : " + name);
        System.out.println("EMAIL : " + email);
        System.out.println("AGE : " + age);
        System.out.println("PHONE NUMBER : " + phone);
        System.out.println("SOURCE : " + source);
        System.out.println("DESIINATION : " + destination);
        System.out.println("BUS : " + bus_ID);
        System.out.println("DATE OF PRINT : " + issueDate + RESET);
        System.out.println("\n\n");
    }

    void makeBooking() {
        // Retained for compatibility
    }
}

// Custom UI Components for Professional Look
class RoundedPanel extends JPanel {
    private int radius;
    private Color backgroundColor;

    public RoundedPanel(int radius, Color bg) {
        this.radius = radius;
        this.backgroundColor = bg;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
    }
}

class RoundedBorder implements javax.swing.border.Border {
    private int radius;
    private Color color;

    public RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }
}

class RoundedButton extends JButton {
    private Color backgroundColor;
    private Color hoverColor;
    private int radius;

    public RoundedButton(String text, Color bg, Color hover, Color fg, int radius) {
        super(text);
        this.backgroundColor = bg;
        this.hoverColor = hover;
        this.radius = radius;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(fg);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2.setColor(hoverColor.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(backgroundColor);
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
        g2.dispose();
    }
}

class TicketContainerPanel extends RoundedPanel {
    private Color dividerColor;

    public TicketContainerPanel(int radius, Color bg, Color dividerColor) {
        super(radius, bg);
        this.dividerColor = dividerColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(dividerColor);
        // Draw vertical dashed separator line at 70% width
        float[] dash = { 6.0f, 6.0f };
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        int dividerX = (int) (getWidth() * 0.68);
        g2.drawLine(dividerX, 15, dividerX, getHeight() - 15);
        g2.dispose();
    }
}

class BarcodePanel extends JPanel {
    private Color barcodeColor;

    public BarcodePanel(Color barcodeColor) {
        this.barcodeColor = barcodeColor;
        setOpaque(false);
        setPreferredSize(new Dimension(200, 45));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(barcodeColor);
        int x = 10;
        int width = getWidth() - 20;
        int height = getHeight();
        java.util.Random rand = new java.util.Random(54321); // Fixed seed for aesthetic barcode look
        while (x < width) {
            int w = rand.nextInt(3) + 1; // bar thickness
            int gap = rand.nextInt(3) + 1; // gap size
            g2.fillRect(x, 0, w, height);
            x += w + gap;
        }
        g2.dispose();
    }
}

class VectorIconComponent extends JComponent {
    private String type;
    private Color color;

    public VectorIconComponent(String type, Color color, int size) {
        this.type = type;
        this.color = color;
        setPreferredSize(new Dimension(size, size));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);

        int w = getWidth();
        int h = getHeight();
        int cx = w / 2;
        int cy = h / 2;

        if (type.equals("Airline")) {
            // Draw Airplane
            g2.fillOval(cx - 5, cy - 22, 10, 44);
            int[] wx = { cx, cx + 28, cx + 28, cx, cx - 28, cx - 28 };
            int[] wy = { cy - 8, cy + 6, cy + 10, cy + 1, cy + 10, cy + 6 };
            g2.fillPolygon(wx, wy, 6);
            int[] tx = { cx, cx + 10, cx + 10, cx, cx - 10, cx - 10 };
            int[] ty = { cy + 12, cy + 18, cy + 20, cy + 17, cy + 20, cy + 18 };
            g2.fillPolygon(tx, ty, 6);
        } else if (type.equals("Railway")) {
            // Draw Train
            g2.fillRoundRect(cx - 16, cy - 20, 32, 36, 12, 12);
            g2.setColor(new Color(24, 24, 27)); // dark window (matching COLOR_BG)
            g2.fillRoundRect(cx - 12, cy - 14, 24, 12, 4, 4);
            g2.fillRect(cx - 1, cy - 14, 2, 12);
            g2.setColor(Color.BLACK); // headlights
            g2.fillOval(cx - 10, cy + 6, 6, 6);
            g2.fillOval(cx + 4, cy + 6, 6, 6);
            g2.setColor(color); // wheels/base
            g2.fillRect(cx - 18, cy + 16, 36, 4);
            g2.fillRect(cx - 12, cy + 20, 6, 4);
            g2.fillRect(cx + 6, cy + 20, 6, 4);
        } else if (type.equals("Bus")) {
            // Draw Bus
            g2.fillRoundRect(cx - 18, cy - 18, 36, 32, 8, 8);
            g2.fillRect(cx - 15, cy + 14, 6, 4); // wheels
            g2.fillRect(cx + 9, cy + 14, 6, 4);
            g2.setColor(new Color(24, 24, 27)); // dark windshield (matching COLOR_BG)
            g2.fillRect(cx - 14, cy - 12, 28, 12);
            g2.fillRect(cx - 1, cy - 12, 2, 12);
            g2.setColor(Color.BLACK); // headlights
            g2.fillOval(cx - 12, cy + 4, 5, 5);
            g2.fillOval(cx + 7, cy + 4, 5, 5);
            g2.setColor(color);
            g2.fillRect(cx - 21, cy - 10, 3, 6); // mirrors
            g2.fillRect(cx + 18, cy - 10, 3, 6);
            g2.drawRoundRect(cx - 5, cy + 4, 10, 4, 2, 2); // grill
        }
        g2.dispose();
    }
}

// Main JFrame Class
public class project extends JFrame {
    // Theme Colors
    private static final Color COLOR_BG = new Color(24, 24, 27); // Near Black / Zinc-900
    private static final Color COLOR_CARD = new Color(39, 39, 42); // Dark Ash / Zinc-800
    private static final Color COLOR_TEXT = new Color(244, 244, 245); // Smoke White / Zinc-100
    private static final Color COLOR_MUTED = new Color(161, 161, 170); // Muted Ash / Zinc-400
    private static final Color COLOR_ACCENT = new Color(228, 228, 231); // Smoke White Accent / Zinc-200
    private static final Color COLOR_ACCENT_HOVER = new Color(255, 255, 255); // Pure White Hover
    private static final Color COLOR_ACCENT_TEXT = new Color(24, 24, 27); // Dark text for accent buttons
    private static final Color COLOR_SUCCESS = new Color(16, 185, 129); // Emerald Green
    private static final Color COLOR_SUCCESS_HOVER = new Color(5, 150, 105);
    private static final Color COLOR_INPUT_BG = new Color(24, 24, 27); // Input BG (matching BG for a sleek look)
    private static final Color COLOR_BORDER = new Color(63, 63, 70); // Border / Zinc-700

    private CardLayout cardLayout;
    private JPanel mainContainer;

    // Selection State
    private String selectedType = "Airline";
    private int ticketPrice = 0;
    private String ticketTiming = "";
    private payment currentBooking;

    // Form Text Fields
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtAge;
    private JTextField txtPhone;
    private JTextField txtSource;
    private JTextField txtDestination;
    private JComboBox<String> comboTransport;

    // Payment Form Controls
    private JRadioButton radioCard;
    private JRadioButton radioWallet;
    private CardLayout paymentCardLayout;
    private JPanel paymentSwitchPanel;

    // Credit Card Fields
    private JTextField txtCardName;
    private JTextField txtCardNumber;
    private JTextField txtCardExpiry;
    private JPasswordField txtCardCVV;

    // Mobile Wallet Fields
    private JTextField txtWalletTitle;
    private JTextField txtWalletNumber;
    private JPasswordField txtWalletPIN;

    // Dynamic Labels in Ticket Panel
    private JLabel lblTicketHeader;
    private JLabel lblTicketCategory;
    private JLabel lblTicketPassenger;
    private JLabel lblTicketContact;
    private JLabel lblTicketAge;
    private JLabel lblTicketRoute;
    private JLabel lblTicketService;
    private JLabel lblTicketTime;
    private JLabel lblTicketPrice;
    private JLabel lblTicketDate;
    private JLabel lblTicketPaymentInfo;

    public project() {
        super("Transport Reservation System");
        setupWindow();
        initUI();
    }

    private void setupWindow() {
        setSize(950, 680);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(COLOR_BG);
    }

    private void initUI() {
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);
        mainContainer.setBackground(COLOR_BG);

        // Build main application panels
        JPanel welcomePanel = createWelcomePanel();
        JPanel bookingPanel = createBookingPanel();
        JPanel ticketPanel = createTicketPanel();

        mainContainer.add(welcomePanel, "Welcome");
        mainContainer.add(bookingPanel, "Booking");
        mainContainer.add(ticketPanel, "Ticket");

        add(mainContainer);
        cardLayout.show(mainContainer, "Welcome");
    }

    // --- PANEL CREATION METHODS ---

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COLOR_BG);
        panel.setBorder(new EmptyBorder(40, 50, 20, 50));

        // Header Section
        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        headerPanel.setBackground(COLOR_BG);

        JLabel titleLabel = new JLabel("TRANSPORT RESERVATION SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(COLOR_TEXT);
        headerPanel.add(titleLabel);

        JLabel subLabel = new JLabel("Book flights, trains, and bus tickets in a few clicks", JLabel.CENTER);
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subLabel.setForeground(COLOR_MUTED);
        headerPanel.add(subLabel);

        panel.add(headerPanel, BorderLayout.NORTH);

        // Cards Section for selecting booking options
        JPanel cardsContainer = new JPanel(new GridLayout(1, 3, 30, 0));
        cardsContainer.setBackground(COLOR_BG);
        cardsContainer.setBorder(new EmptyBorder(50, 0, 50, 0));

        cardsContainer.add(createSelectionCard("Airline Booking", "Premium domestic & international airline bookings.",
                "Starting from 25,000 PKR", "Airline"));
        cardsContainer.add(createSelectionCard("Railway Booking", "High-speed scenic and comfortable train rides.",
                "Starting from 9,000 PKR", "Railway"));
        cardsContainer.add(createSelectionCard("Bus Booking", "Convenient city-to-city commuter coaches.",
                "Starting from 5,000 PKR", "Bus"));

        panel.add(cardsContainer, BorderLayout.CENTER);

        // Footer / Credits section
        RoundedPanel footerPanel = new RoundedPanel(12, COLOR_CARD);
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        footerPanel.setPreferredSize(new Dimension(800, 60));

        JLabel creditsTitle = new JLabel("OOP LAB PROJECT DEVELOPED BY:", JLabel.CENTER);
        creditsTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        creditsTitle.setForeground(COLOR_MUTED);

        JLabel creditsNames = new JLabel(
                "ANUM SAJID (SE-241043)   \u2022   MUHAMMAD REZA (SE-241014)   \u2022   MARIAM FATIMA (SE-241015)",
                JLabel.CENTER);
        creditsNames.setFont(new Font("Segoe UI", Font.BOLD, 13));
        creditsNames.setForeground(COLOR_ACCENT);

        JPanel footerTextGrid = new JPanel(new GridLayout(2, 1, 2, 2));
        footerTextGrid.setBackground(COLOR_CARD);
        footerTextGrid.add(creditsTitle);
        footerTextGrid.add(creditsNames);

        footerPanel.add(footerTextGrid, BorderLayout.CENTER);

        panel.add(footerPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSelectionCard(String title, String desc, String pricing, String type) {
        RoundedPanel card = new RoundedPanel(20, COLOR_CARD);
        card.setLayout(new GridBagLayout());
        card.setBorder(new EmptyBorder(25, 20, 25, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1.0;

        // Custom Vector Icon
        VectorIconComponent iconComp = new VectorIconComponent(type, COLOR_ACCENT, 64);
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 15, 0);
        card.add(iconComp, gbc);

        // Card Title
        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(COLOR_TEXT);
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        card.add(titleLabel, gbc);

        // Description
        JLabel descLabel = new JLabel("<html><center>" + desc + "</center></html>", JLabel.CENTER);
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descLabel.setForeground(COLOR_MUTED);
        descLabel.setPreferredSize(new Dimension(180, 50));
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 15, 0);
        card.add(descLabel, gbc);

        // Pricing Label
        JLabel pricingLabel = new JLabel(pricing, JLabel.CENTER);
        pricingLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        pricingLabel.setForeground(COLOR_SUCCESS);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 20, 0);
        card.add(pricingLabel, gbc);

        // Action Button
        RoundedButton btnSelect = new RoundedButton("Book Now", COLOR_ACCENT, COLOR_ACCENT_HOVER, COLOR_ACCENT_TEXT,
                12);
        btnSelect.addActionListener(e -> {
            selectedType = type;
            lblTicketCategory.setText(selectedType.toUpperCase() + " TICKET");
            updateTransportChoices();
            cardLayout.show(mainContainer, "Booking");
        });
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 10, 0, 10);
        card.add(btnSelect, gbc);

        return card;
    }

    private JPanel createBookingPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(new EmptyBorder(25, 40, 25, 40));

        // Header Panel with Back Button & Dynamic Title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(COLOR_BG);
        topPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        RoundedButton btnBack = new RoundedButton("\u2190 Back to Services", COLOR_CARD, COLOR_BORDER, COLOR_TEXT, 8);
        btnBack.setPreferredSize(new Dimension(160, 36));
        btnBack.addActionListener(e -> cardLayout.show(mainContainer, "Welcome"));
        topPanel.add(btnBack, BorderLayout.WEST);

        JLabel bookingHeaderLabel = new JLabel("PASSENGER DETAILS & PAYMENT", JLabel.RIGHT);
        bookingHeaderLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        bookingHeaderLabel.setForeground(COLOR_TEXT);
        topPanel.add(bookingHeaderLabel, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Split Layout: Left Form (Passenger Info), Right Form (Payment & Booking
        // summary)
        JPanel centerGrid = new JPanel(new GridLayout(1, 2, 30, 0));
        centerGrid.setBackground(COLOR_BG);

        // --- LEFT COLUMN: PASSENGER & ROUTE INFO ---
        RoundedPanel leftPanel = new RoundedPanel(20, COLOR_CARD);
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Section Title
        JLabel lblSectionPass = new JLabel("1. PASSENGER & SERVICE INFO");
        lblSectionPass.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblSectionPass.setForeground(COLOR_ACCENT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 10, 20, 10);
        leftPanel.add(lblSectionPass, gbc);

        // Form Fields Instantiation
        txtName = new JTextField();
        styleTextField(txtName, "Enter passenger's full name");
        txtEmail = new JTextField();
        styleTextField(txtEmail, "Enter email address");
        txtAge = new JTextField();
        styleTextField(txtAge, "Enter age");
        txtPhone = new JTextField();
        styleTextField(txtPhone, "Enter phone number");
        txtSource = new JTextField();
        styleTextField(txtSource, "Departure city");
        txtDestination = new JTextField();
        styleTextField(txtDestination, "Destination city");

        comboTransport = new JComboBox<>();
        styleComboBox(comboTransport);

        // Dynamic price update listener
        comboTransport.addActionListener(e -> updatePriceTag());

        // Add form rows
        addFormRow(leftPanel, gbc, 1, "Passenger Name:", txtName);
        addFormRow(leftPanel, gbc, 2, "Email Address:", txtEmail);
        addFormRow(leftPanel, gbc, 3, "Age:", txtAge);
        addFormRow(leftPanel, gbc, 4, "Phone Number:", txtPhone);
        addFormRow(leftPanel, gbc, 5, "Departure From:", txtSource);
        addFormRow(leftPanel, gbc, 6, "Destination To:", txtDestination);
        addFormRow(leftPanel, gbc, 7, "Select Transport:", comboTransport);

        centerGrid.add(leftPanel);

        // --- RIGHT COLUMN: PAYMENT ---
        RoundedPanel rightPanel = new RoundedPanel(20, COLOR_CARD);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.fill = GridBagConstraints.HORIZONTAL;
        gbcR.gridx = 0;
        gbcR.weightx = 1.0;

        // Section Title
        JLabel lblSectionPay = new JLabel("2. PAYMENT DETAILS");
        lblSectionPay.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblSectionPay.setForeground(COLOR_ACCENT);
        gbcR.gridy = 0;
        gbcR.insets = new Insets(0, 10, 15, 10);
        rightPanel.add(lblSectionPay, gbcR);

        // Payment Method Radio Selection
        radioCard = new JRadioButton("Credit / Debit Card");
        radioCard.setFont(new Font("Segoe UI", Font.BOLD, 13));
        radioCard.setForeground(COLOR_TEXT);
        radioCard.setBackground(COLOR_CARD);
        radioCard.setSelected(true);

        radioWallet = new JRadioButton("Easypaisa / Jazzcash");
        radioWallet.setFont(new Font("Segoe UI", Font.BOLD, 13));
        radioWallet.setForeground(COLOR_TEXT);
        radioWallet.setBackground(COLOR_CARD);

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(radioCard);
        paymentGroup.add(radioWallet);

        JPanel radioContainer = new JPanel(new GridLayout(1, 2, 10, 0));
        radioContainer.setBackground(COLOR_CARD);
        radioContainer.add(radioCard);
        radioContainer.add(radioWallet);

        gbcR.gridy = 1;
        gbcR.insets = new Insets(0, 10, 15, 10);
        rightPanel.add(radioContainer, gbcR);

        // Interactive Fields Switching Container (CardLayout)
        paymentCardLayout = new CardLayout();
        paymentSwitchPanel = new JPanel(paymentCardLayout);
        paymentSwitchPanel.setBackground(COLOR_CARD);

        // Card Payment Form Panel
        JPanel cardForm = new JPanel(new GridBagLayout());
        cardForm.setBackground(COLOR_CARD);
        GridBagConstraints gbcC = new GridBagConstraints();
        gbcC.fill = GridBagConstraints.HORIZONTAL;

        txtCardName = new JTextField();
        styleTextField(txtCardName, "Name on Card");
        txtCardNumber = new JTextField();
        styleTextField(txtCardNumber, "Card Number");
        txtCardExpiry = new JTextField();
        styleTextField(txtCardExpiry, "MM/YY");
        txtCardCVV = new JPasswordField();
        styleTextField(txtCardCVV, "CVV");

        addFormRow(cardForm, gbcC, 0, "Cardholder Name:", txtCardName);
        addFormRow(cardForm, gbcC, 1, "Card Number:", txtCardNumber);
        addFormRow(cardForm, gbcC, 2, "Expiry (MM/YY):", txtCardExpiry);
        addFormRow(cardForm, gbcC, 3, "Security CVV:", txtCardCVV);

        // Wallet Payment Form Panel
        JPanel walletForm = new JPanel(new GridBagLayout());
        walletForm.setBackground(COLOR_CARD);
        GridBagConstraints gbcW = new GridBagConstraints();
        gbcW.fill = GridBagConstraints.HORIZONTAL;

        txtWalletTitle = new JTextField();
        styleTextField(txtWalletTitle, "Account Name");
        txtWalletNumber = new JTextField();
        styleTextField(txtWalletNumber, "03*********");
        txtWalletPIN = new JPasswordField();
        styleTextField(txtWalletPIN, "PIN");

        addFormRow(walletForm, gbcW, 0, "Account Title:", txtWalletTitle);
        addFormRow(walletForm, gbcW, 1, "Mobile Number:", txtWalletNumber);
        addFormRow(walletForm, gbcW, 2, "6-Digit Security PIN:", txtWalletPIN);

        paymentSwitchPanel.add(cardForm, "Card");
        paymentSwitchPanel.add(walletForm, "Wallet");

        gbcR.gridy = 2;
        gbcR.insets = new Insets(0, 0, 15, 0);
        rightPanel.add(paymentSwitchPanel, gbcR);

        // Dynamic Payment method layout toggles
        radioCard.addActionListener(e -> paymentCardLayout.show(paymentSwitchPanel, "Card"));
        radioWallet.addActionListener(e -> paymentCardLayout.show(paymentSwitchPanel, "Wallet"));

        // Bottom Summary Frame with dynamically calculated fare and Checkout button
        RoundedPanel checkoutBox = new RoundedPanel(12, COLOR_INPUT_BG);
        checkoutBox.setLayout(new GridBagLayout());
        checkoutBox.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbcCh = new GridBagConstraints();
        gbcCh.fill = GridBagConstraints.BOTH;

        JLabel lblFareText = new JLabel("TOTAL PAYABLE FARE");
        lblFareText.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblFareText.setForeground(COLOR_MUTED);
        gbcCh.gridx = 0;
        gbcCh.gridy = 0;
        gbcCh.weightx = 1.0;
        checkoutBox.add(lblFareText, gbcCh);

        lblTicketPrice = new JLabel("0 PKR");
        lblTicketPrice.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTicketPrice.setForeground(COLOR_SUCCESS);
        gbcCh.gridy = 1;
        checkoutBox.add(lblTicketPrice, gbcCh);

        RoundedButton btnPay = new RoundedButton("Confirm & Purchase Ticket", COLOR_SUCCESS, COLOR_SUCCESS_HOVER,
                Color.WHITE, 10);
        btnPay.setPreferredSize(new Dimension(200, 42));
        btnPay.addActionListener(e -> processBookingSubmit());
        gbcCh.gridy = 2;
        gbcCh.insets = new Insets(10, 0, 0, 0);
        checkoutBox.add(btnPay, gbcCh);

        gbcR.gridy = 3;
        gbcR.insets = new Insets(5, 10, 0, 10);
        rightPanel.add(checkoutBox, gbcR);

        centerGrid.add(rightPanel);

        mainPanel.add(centerGrid, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createTicketPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(new EmptyBorder(30, 50, 30, 50));

        // Header Alert
        JPanel alertPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        alertPanel.setBackground(COLOR_BG);
        alertPanel.setBorder(new EmptyBorder(0, 0, 25, 0));

        JLabel alertTitle = new JLabel("Booking Completed Successfully!", JLabel.CENTER);
        alertTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        alertTitle.setForeground(COLOR_SUCCESS);

        JLabel alertSubText = new JLabel("Your payment has been cleared and your boarding ticket has been issued.",
                JLabel.CENTER);
        alertSubText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        alertSubText.setForeground(COLOR_TEXT);

        alertPanel.add(alertTitle);
        alertPanel.add(alertSubText);
        mainPanel.add(alertPanel, BorderLayout.NORTH);

        // A beautiful realistic physical Boarding Ticket Card Graphic
        TicketContainerPanel ticketCard = new TicketContainerPanel(20, COLOR_CARD, COLOR_BORDER);
        ticketCard.setLayout(new GridBagLayout());
        ticketCard.setBorder(new EmptyBorder(25, 30, 25, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // LEFT PART OF TICKET (Main Travel Voucher - 65% width)
        JPanel leftTicketPanel = new JPanel(new GridBagLayout());
        leftTicketPanel.setOpaque(false);
        GridBagConstraints gbcL = new GridBagConstraints();
        gbcL.fill = GridBagConstraints.HORIZONTAL;
        gbcL.anchor = GridBagConstraints.WEST;

        // Brand Banner
        JLabel lblVoucherTitle = new JLabel("TRS BOARDING PASS & VOUCHER");
        lblVoucherTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblVoucherTitle.setForeground(COLOR_ACCENT);
        gbcL.gridx = 0;
        gbcL.gridy = 0;
        gbcL.gridwidth = 2;
        gbcL.weightx = 1.0;
        gbcL.insets = new Insets(0, 0, 15, 0);
        leftTicketPanel.add(lblVoucherTitle, gbcL);

        // Passenger Details Column
        lblTicketHeader = new JLabel("AIRLINE RESERVATION");
        lblTicketHeader.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTicketHeader.setForeground(COLOR_TEXT);
        gbcL.gridy = 1;
        gbcL.insets = new Insets(0, 0, 15, 0);
        leftTicketPanel.add(lblTicketHeader, gbcL);

        // Detail Fields
        lblTicketPassenger = new JLabel("Passenger Name: JOHN DOE");
        lblTicketPassenger.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTicketPassenger.setForeground(COLOR_TEXT);
        gbcL.gridy = 2;
        gbcL.gridwidth = 2;
        gbcL.insets = new Insets(0, 0, 8, 0);
        leftTicketPanel.add(lblTicketPassenger, gbcL);

        lblTicketContact = new JLabel("Email / Phone: dummy@test.com / 12345678");
        lblTicketContact.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTicketContact.setForeground(COLOR_MUTED);
        gbcL.gridy = 3;
        gbcL.insets = new Insets(0, 0, 8, 0);
        leftTicketPanel.add(lblTicketContact, gbcL);

        lblTicketAge = new JLabel("Passenger Age: 25 years");
        lblTicketAge.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTicketAge.setForeground(COLOR_MUTED);
        gbcL.gridy = 4;
        gbcL.insets = new Insets(0, 0, 15, 0);
        leftTicketPanel.add(lblTicketAge, gbcL);

        // Travel Vector (Source -> Destination)
        lblTicketRoute = new JLabel("KARACHI (KHI)  \u2794  LAHORE (LHE)");
        lblTicketRoute.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTicketRoute.setForeground(COLOR_SUCCESS);
        gbcL.gridy = 5;
        gbcL.insets = new Insets(5, 0, 15, 0);
        leftTicketPanel.add(lblTicketRoute, gbcL);

        // Service & Timing
        lblTicketService = new JLabel("Service Carrier: PIA - Flight A101");
        lblTicketService.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblTicketService.setForeground(COLOR_TEXT);
        gbcL.gridy = 6;
        gbcL.insets = new Insets(0, 0, 6, 0);
        leftTicketPanel.add(lblTicketService, gbcL);

        lblTicketTime = new JLabel("Scheduled Time: 13:40");
        lblTicketTime.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTicketTime.setForeground(COLOR_MUTED);
        gbcL.gridy = 7;
        gbcL.insets = new Insets(0, 0, 0, 0);
        leftTicketPanel.add(lblTicketTime, gbcL);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.65;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 0, 0, 20);
        ticketCard.add(leftTicketPanel, gbc);

        // RIGHT PART OF TICKET (Control Receipt Stub - 35% width)
        JPanel rightTicketPanel = new JPanel(new GridBagLayout());
        rightTicketPanel.setOpaque(false);
        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.fill = GridBagConstraints.HORIZONTAL;
        gbcR.anchor = GridBagConstraints.EAST;

        lblTicketCategory = new JLabel("AIRLINE BOARDING PASS");
        lblTicketCategory.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblTicketCategory.setForeground(COLOR_MUTED);
        gbcR.gridx = 0;
        gbcR.gridy = 0;
        gbcR.insets = new Insets(0, 10, 10, 0);
        rightTicketPanel.add(lblTicketCategory, gbcR);

        JLabel lblStubReceipt = new JLabel("PAYMENT RECEIPT STUB");
        lblStubReceipt.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblStubReceipt.setForeground(COLOR_TEXT);
        gbcR.gridy = 1;
        gbcR.insets = new Insets(0, 10, 12, 0);
        rightTicketPanel.add(lblStubReceipt, gbcR);

        lblTicketPaymentInfo = new JLabel("Method: Credit Card");
        lblTicketPaymentInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTicketPaymentInfo.setForeground(COLOR_MUTED);
        gbcR.gridy = 2;
        gbcR.insets = new Insets(0, 10, 6, 0);
        rightTicketPanel.add(lblTicketPaymentInfo, gbcR);

        lblTicketDate = new JLabel("Date: 26-05-2026 09:40:15");
        lblTicketDate.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblTicketDate.setForeground(COLOR_MUTED);
        gbcR.gridy = 3;
        gbcR.insets = new Insets(0, 10, 20, 0);
        rightTicketPanel.add(lblTicketDate, gbcR);

        // Barcode
        BarcodePanel bCode = new BarcodePanel(COLOR_TEXT);
        gbcR.gridy = 4;
        gbcR.fill = GridBagConstraints.BOTH;
        gbcR.insets = new Insets(0, 10, 15, 0);
        rightTicketPanel.add(bCode, gbcR);

        JLabel lblSecCode = new JLabel("\u2605 SECURE RESERVATION CONFIRMED \u2605", JLabel.CENTER);
        lblSecCode.setFont(new Font("Segoe UI", Font.BOLD, 9));
        lblSecCode.setForeground(COLOR_SUCCESS);
        gbcR.gridy = 5;
        gbcR.fill = GridBagConstraints.HORIZONTAL;
        gbcR.insets = new Insets(5, 10, 0, 0);
        rightTicketPanel.add(lblSecCode, gbcR);

        gbc.gridx = 1;
        gbc.weightx = 0.35;
        gbc.insets = new Insets(0, 20, 0, 0);
        ticketCard.add(rightTicketPanel, gbc);

        mainPanel.add(ticketCard, BorderLayout.CENTER);

        // Action Options below Ticket display
        JPanel buttonFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonFooter.setBackground(COLOR_BG);

        RoundedButton btnPrint = new RoundedButton("\uD83D\uDDA8 Console Print Info & Reset", COLOR_ACCENT,
                COLOR_ACCENT_HOVER, COLOR_ACCENT_TEXT, 10);
        btnPrint.setPreferredSize(new Dimension(240, 42));
        btnPrint.addActionListener(e -> {
            // Logs ticket data in the terminal as well, matching CLI project outputs!
            currentBooking.displayDetails();
            resetBookingForm();
            cardLayout.show(mainContainer, "Welcome");
        });
        buttonFooter.add(btnPrint);

        RoundedButton btnDone = new RoundedButton("Done & Return Home", COLOR_SUCCESS, COLOR_SUCCESS_HOVER, Color.WHITE,
                10);
        btnDone.setPreferredSize(new Dimension(220, 42));
        btnDone.addActionListener(e -> {
            resetBookingForm();
            cardLayout.show(mainContainer, "Welcome");
        });
        buttonFooter.add(btnDone);

        mainPanel.add(buttonFooter, BorderLayout.SOUTH);

        return mainPanel;
    }

    // --- FORM UTILITY AND EVENT HELPER METHODS ---

    private void styleTextField(JTextField field, String placeholder) {
        field.setBackground(COLOR_INPUT_BG);
        field.setForeground(COLOR_TEXT);
        field.setCaretColor(COLOR_TEXT);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(8, COLOR_BORDER),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)));
    }

    private void styleComboBox(JComboBox<String> combo) {

        // Base styling (closed combo box)
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        combo.setBackground(Color.BLACK);
        combo.setForeground(Color.DARK_GRAY);
        combo.setFocusable(false);

        // Custom renderer (dropdown list styling)
        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (isSelected) {
                    setBackground(COLOR_BORDER); // highlight color
                    setForeground(COLOR_TEXT);
                } else {
                    setBackground(Color.BLACK);
                    setForeground(COLOR_TEXT);
                }

                setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
                return this;
            }
        });
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, Component field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 10, 6, 10);

        JLabel label = new JLabel(labelText);
        label.setForeground(COLOR_MUTED);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(field, gbc);
    }

    private void updateTransportChoices() {
        comboTransport.removeAllItems();
        if (selectedType.equals("Airline")) {
            comboTransport.addItem("A101 (25,000 PKR - 13:40)");
            comboTransport.addItem("A126 (75,000 PKR - 15:20)");
            comboTransport.addItem("A156 (60,000 PKR - 00:30)");
            comboTransport.addItem("A234 (90,000 PKR - 04:15)");
            comboTransport.addItem("A278 (92,500 PKR - 09:35)");
        } else if (selectedType.equals("Railway")) {
            comboTransport.addItem("Green Line (25,000 PKR - 13:40)");
            comboTransport.addItem("Pakistan Express (15,000 PKR - 15:20)");
            comboTransport.addItem("Awami Express (10,000 PKR - 00:30)");
            comboTransport.addItem("Rehman Baba (9,000 PKR - 04:15)");
        } else if (selectedType.equals("Bus")) {
            comboTransport.addItem("Faisal Movers (5,000 PKR - 09:40)");
            comboTransport.addItem("Daewoo Express (7,500 PKR - 12:20)");
            comboTransport.addItem("Niazi Express (6,000 PKR - 16:30)");
            comboTransport.addItem("Skyways (9,000 PKR - 20:15)");
        }
        updatePriceTag();
    }

    private void updatePriceTag() {
        String selection = (String) comboTransport.getSelectedItem();
        if (selection == null) {
            lblTicketPrice.setText("0 PKR");
            ticketPrice = 0;
            ticketTiming = "";
            return;
        }

        // Parse price and timing from the combo item string
        try {
            int pkrIdx = selection.indexOf(" PKR");
            if (pkrIdx != -1) {
                int start = pkrIdx - 1;
                while (start >= 0 && (Character.isDigit(selection.charAt(start)) || selection.charAt(start) == ',')) {
                    start--;
                }
                String priceStr = selection.substring(start + 1, pkrIdx).replace(",", "").trim();
                ticketPrice = Integer.parseInt(priceStr);
                lblTicketPrice.setText(String.format("%,d PKR", ticketPrice));
            }

            // Extract timing (e.g. at the end like "13:40")
            int hyphenIdx = selection.lastIndexOf("- ");
            if (hyphenIdx != -1 && hyphenIdx + 2 < selection.length()) {
                ticketTiming = selection.substring(hyphenIdx + 2).replace(")", "").trim();
            }
        } catch (Exception ex) {
            ticketPrice = 0;
            ticketTiming = "";
            lblTicketPrice.setText("0 PKR");
        }
    }

    private void processBookingSubmit() {
        if (!validateFormFields()) {
            return;
        }

        // Instantiate corresponding object and populate fields
        if (selectedType.equals("Airline")) {
            airline airObj = new airline();
            populatePaymentDetails(airObj);
            String selectedCarrier = (String) comboTransport.getSelectedItem();
            airObj.air = selectedCarrier != null ? selectedCarrier.split(" \\(")[0] : "A101";
            airObj.price = ticketPrice;
            airObj.timing = ticketTiming;
            currentBooking = airObj;
        } else if (selectedType.equals("Railway")) {
            railway railObj = new railway();
            populatePaymentDetails(railObj);
            String selectedTrain = (String) comboTransport.getSelectedItem();
            railObj.rail = selectedTrain != null ? selectedTrain.split(" \\(")[0] : "Green Line";
            railObj.price = ticketPrice;
            railObj.timing = ticketTiming;
            currentBooking = railObj;
        } else if (selectedType.equals("Bus")) {
            bus busObj = new bus();
            populatePaymentDetails(busObj);
            String selectedBus = (String) comboTransport.getSelectedItem();
            busObj.bus_ID = selectedBus != null ? selectedBus.split(" \\(")[0] : "Faisal Movers";
            busObj.price = ticketPrice;
            busObj.timing = ticketTiming;
            currentBooking = busObj;
        }

        // Update the visual ticket screen components
        lblTicketHeader.setText(selectedType.toUpperCase() + " RESERVATION");
        lblTicketPassenger.setText("Passenger Name:  " + currentBooking.name.toUpperCase());
        lblTicketContact.setText("Email / Phone:   " + currentBooking.email + "  |  " + currentBooking.phone);
        lblTicketAge.setText("Passenger Age:   " + currentBooking.age + " Years");
        lblTicketRoute.setText(
                currentBooking.source.toUpperCase() + "   \u2794   " + currentBooking.destination.toUpperCase());

        String serviceDetails = "";
        if (currentBooking instanceof airline) {
            serviceDetails = "Flight: " + ((airline) currentBooking).air;
        } else if (currentBooking instanceof railway) {
            serviceDetails = "Train: " + ((railway) currentBooking).rail;
        } else if (currentBooking instanceof bus) {
            serviceDetails = "Bus Carrier: " + ((bus) currentBooking).bus_ID;
        }
        lblTicketService.setText("Service Operator: " + serviceDetails);
        lblTicketTime.setText("Scheduled Time: " + ticketTiming);
        lblTicketDate.setText("Issue Date: " + currentBooking.issueDate);
        lblTicketPaymentInfo.setText("Method: " + currentBooking.paymentMethod);

        // Show successful purchase popup alert
        JOptionPane.showMessageDialog(this,
                "Payment of " + String.format("%,d", ticketPrice)
                        + " PKR received successfully.\nThank you for choosing Transport Reservation System!",
                "Payment Confirmed", JOptionPane.INFORMATION_MESSAGE);

        // Go to Ticket view
        cardLayout.show(mainContainer, "Ticket");
    }

    private void populatePaymentDetails(payment obj) {
        obj.name = txtName.getText().trim();
        obj.email = txtEmail.getText().trim();
        obj.age = Integer.parseInt(txtAge.getText().trim());
        obj.phone = txtPhone.getText().trim();
        obj.source = txtSource.getText().trim();
        obj.destination = txtDestination.getText().trim();

        if (radioCard.isSelected()) {
            obj.choice = 1;
            obj.paymentMethod = "Credit / Debit Card";
            obj.accountTitle = txtCardName.getText().trim();
            // Anonymize for print/display
            String cardNum = txtCardNumber.getText().trim();
            obj.accountNumber = cardNum.length() > 4 ? "****-****-****-" + cardNum.substring(cardNum.length() - 4)
                    : cardNum;
        } else {
            obj.choice = 2;
            obj.paymentMethod = "Easypaisa/Jazzcash";
            obj.accountTitle = txtWalletTitle.getText().trim();
            String walletNum = txtWalletNumber.getText().trim();
            obj.accountNumber = walletNum.length() > 4 ? "****-***-" + walletNum.substring(walletNum.length() - 4)
                    : walletNum;
        }
    }

    private boolean validateFormFields() {
        if (txtName.getText().trim().isEmpty()) {
            return validationAlert("Please enter the passenger's name.");
        }
        String email = txtEmail.getText().trim();
        if (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            return validationAlert("Please enter a valid email address.");
        }
        String ageStr = txtAge.getText().trim();
        if (ageStr.isEmpty()) {
            return validationAlert("Please enter the passenger's age.");
        }
        try {
            int age = Integer.parseInt(ageStr);
            if (age <= 0 || age > 120) {
                return validationAlert("Please enter a valid age range (1 - 120).");
            }
        } catch (NumberFormatException e) {
            return validationAlert("Age must be a valid number.");
        }
        if (txtPhone.getText().trim().isEmpty()) {
            return validationAlert("Please enter a contact phone number.");
        }
        if (txtSource.getText().trim().isEmpty()) {
            return validationAlert("Please specify the travel origin (Departure).");
        }
        if (txtDestination.getText().trim().isEmpty()) {
            return validationAlert("Please specify the travel destination.");
        }

        // Validate payment fields
        if (radioCard.isSelected()) {
            if (txtCardName.getText().trim().isEmpty()) {
                return validationAlert("Please enter the cardholder's name.");
            }
            String cardNum = txtCardNumber.getText().trim();
            if (cardNum.length() < 12) {
                return validationAlert("Please enter a valid Credit Card number (minimum 12 digits).");
            }
            String expiry = txtCardExpiry.getText().trim();
            if (expiry.length() < 5 || !expiry.contains("/")) {
                return validationAlert("Please enter expiry in MM/YY format.");
            }
            if (new String(txtCardCVV.getPassword()).trim().length() < 3) {
                return validationAlert("Please enter a valid 3-4 digit Security CVV.");
            }
        } else {
            if (txtWalletTitle.getText().trim().isEmpty()) {
                return validationAlert("Please enter the mobile wallet account title.");
            }
            String phoneNum = txtWalletNumber.getText().trim();
            if (phoneNum.length() < 10) {
                return validationAlert("Please enter a valid mobile account number.");
            }
            if (new String(txtWalletPIN.getPassword()).trim().isEmpty()) {
                return validationAlert("Please enter your account transaction security PIN.");
            }
        }
        return true;
    }

    private boolean validationAlert(String message) {
        JOptionPane.showMessageDialog(this, message, "Missing Information", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    private void resetBookingForm() {
        txtName.setText("");
        txtEmail.setText("");
        txtAge.setText("");
        txtPhone.setText("");
        txtSource.setText("");
        txtDestination.setText("");

        txtCardName.setText("");
        txtCardNumber.setText("");
        txtCardExpiry.setText("");
        txtCardCVV.setText("");

        txtWalletTitle.setText("");
        txtWalletNumber.setText("");
        txtWalletPIN.setText("");

        radioCard.setSelected(true);
        paymentCardLayout.show(paymentSwitchPanel, "Card");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                // Fallback to standard LookAndFeel
            }
            project mainFrame = new project();
            mainFrame.setVisible(true);
        });
    }
}