/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bookingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public final class Administrator_Page extends javax.swing.JFrame {

    public void readMe1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql1 = "SELECT `customer_id`, `name`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password` FROM `customer` WHERE `user_position` = 1;";
            java.sql.ResultSet rs = st.executeQuery(sql1);
            tabel.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void readMe2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql2 = "SELECT `customer_id`, `name`, `license_no`,`customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password` FROM `customer` WHERE `user_position` = 2;";
            java.sql.ResultSet rs2 = st.executeQuery(sql2);
            table_info.setModel(DbUtils.resultSetToTableModel(rs2));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void readMe3() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql = "SELECT `customer_id`, `name`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password` FROM `customer` WHERE `user_position` = 3;";
            java.sql.ResultSet rs = st.executeQuery(sql);
            table_cust.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readMe4() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql = "SELECT `transaction_id`, `customer_name`,`total_cost`, `transaction_date`, `transaction_time` FROM `customer_payment`";
            java.sql.ResultSet rs = st.executeQuery(sql);
            transaction_page.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Administrator_Page() {
        initComponents();
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        jLabel16.setText(s.format(d));

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                jLabel13.setText(s.format(d));
            }

        }
        ).start();
        readMe1();
        readMe2();
        readMe3();
        readMe4();
    }

    //        -----------------------------------------------------------------------
// table to text field
    public void viewMe() {
        int i = tabel.getSelectedRow();
        TableModel model = tabel.getModel();
        fullname.setText(model.getValueAt(i, 1).toString());
        String date = model.getValueAt(i, 2).toString();
        try {
            Date date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
            birthdate.setDate(date2);
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        address.setText((String) model.getValueAt(i, 3));
        contact.setText(model.getValueAt(i, 4).toString());
        email_add.setText(model.getValueAt(i, 5).toString());
        password.setText(model.getValueAt(i, 6).toString());
    }

    public void viewMe2() {
        int i = table_info.getSelectedRow();
        TableModel model = table_info.getModel();
        company_name_info.setText(model.getValueAt(i, 1).toString());
        address_info.setText(model.getValueAt(i, 4).toString());
        license_no.setText(model.getValueAt(i, 2).toString());
        contact_info.setText(model.getValueAt(i, 3).toString());
        email_add_info.setText(model.getValueAt(i, 5).toString());
        password_info.setText(model.getValueAt(i, 6).toString());
    }

    public void viewMe3() {
        int i = table_cust.getSelectedRow();
        TableModel model = table_cust.getModel();
        cust_name.setText(model.getValueAt(i, 1).toString());
        String date = model.getValueAt(i, 2).toString();
        try {
            Date date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
            cust_birth.setDate(date2);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        cust_contact.setText(model.getValueAt(i, 3).toString());
        cust_add.setText((String) model.getValueAt(i, 4));
        cust_email.setText(model.getValueAt(i, 5).toString());
        cust_pass.setText(model.getValueAt(i, 6).toString());
    }

    public void viewMe4() {
        int i = transaction_page.getSelectedRow();
        TableModel model = transaction_page.getModel();
        trans_id.setText(model.getValueAt(i, 0).toString());
        trans_id_cust.setText(model.getValueAt(i, 1).toString());
        trans_cost.setText((String) model.getValueAt(i, 2));

        String date = model.getValueAt(i, 3).toString();
        try {
            Date date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
            trans_date.setText(date);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        trans_time.setText(model.getValueAt(i, 4).toString());
    }

    public void deleteText() {
        fullname.setText("");
        birthdate.setCalendar(null);
        address.setText("");
        contact.setText("");
        email_add.setText("");
        password.setText("");
    }

    public void deleteText2() {
        company_name_info.setText("");
        license_no.setText("");
        contact_info.setText("");
        address_info.setText("");
        email_add_info.setText("");
        password_info.setText("");

    }

    public void deleteText3() {
        cust_name.setText("");
        cust_birth.setCalendar(null);
        cust_add.setText("");
        cust_contact.setText("");
        cust_email.setText("");
        cust_pass.setText("");
    }

    public void deleteText4() {
        trans_id.setText("");
        trans_date.setText("");
        trans_id_cust.setText("");
        trans_cost.setText("");
        trans_time.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        address = new javax.swing.JTextField();
        fullname = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        email_add = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        create_label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        read_label = new javax.swing.JLabel();
        update_label = new javax.swing.JLabel();
        delete_label = new javax.swing.JLabel();
        birthdate = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        license_no = new javax.swing.JTextField();
        address_info = new javax.swing.JTextField();
        company_name_info = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        password_info = new javax.swing.JTextField();
        email_add_info = new javax.swing.JTextField();
        contact_info = new javax.swing.JTextField();
        create_label_info = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_info = new javax.swing.JTable();
        read_label_info = new javax.swing.JLabel();
        update_label_info = new javax.swing.JLabel();
        delete_label_info = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_cust = new javax.swing.JTable();
        cust_read = new javax.swing.JLabel();
        cust_create = new javax.swing.JLabel();
        cust_update = new javax.swing.JLabel();
        cust_delete = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        cust_contact = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        cust_name = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        cust_email = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        cust_add = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        cust_pass = new javax.swing.JTextField();
        cust_birth = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        trans_id_cust = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        trans_time = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        transaction_page = new javax.swing.JTable();
        trans_read = new javax.swing.JLabel();
        trans_delete = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        trans_cost = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        trans_id = new javax.swing.JTextField();
        trans_date = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("G2G PH");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dashboard");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Logout");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/G2GPH (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );

        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/cal-removebg-preview (1).png"))); // NOI18N

        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("      ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 102));
        jLabel14.setText("x");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 204));
        jLabel15.setText("-");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(0, 102, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/time-removebg-preview (1).png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 255));
        jLabel18.setText("Administrators Information");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setForeground(new java.awt.Color(0, 102, 255));
        jLabel39.setText("Full Name:");

        jLabel40.setForeground(new java.awt.Color(0, 102, 255));
        jLabel40.setText("Birthdate:");

        jLabel41.setForeground(new java.awt.Color(0, 102, 255));
        jLabel41.setText("Address:");

        jLabel42.setForeground(new java.awt.Color(0, 102, 255));
        jLabel42.setText("Contact No:");

        jLabel43.setForeground(new java.awt.Color(0, 102, 255));
        jLabel43.setText("Email Address:");

        jLabel44.setForeground(new java.awt.Color(0, 102, 255));
        jLabel44.setText("Password:");

        create_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        create_label.setForeground(new java.awt.Color(0, 102, 255));
        create_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q3.png"))); // NOI18N
        create_label.setText("Create");
        create_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_labelMouseClicked(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Full Name", "Birthdate", "Contact No.", "Address", "Email Address", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.setSelectionBackground(new java.awt.Color(0, 102, 204));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        read_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        read_label.setForeground(new java.awt.Color(0, 102, 255));
        read_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q1.png"))); // NOI18N
        read_label.setText("Read");
        read_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                read_labelMouseClicked(evt);
            }
        });

        update_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update_label.setForeground(new java.awt.Color(0, 102, 255));
        update_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q2.png"))); // NOI18N
        update_label.setText("Update");
        update_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_labelMouseClicked(evt);
            }
        });

        delete_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_label.setForeground(new java.awt.Color(0, 102, 255));
        delete_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q.png"))); // NOI18N
        delete_label.setText("Delete");
        delete_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_labelMouseClicked(evt);
            }
        });

        birthdate.setDateFormatString("dd MMM yyyy");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email_add, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(fullname)
                    .addComponent(address)
                    .addComponent(contact)
                    .addComponent(password)
                    .addComponent(birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(create_label)
                .addGap(18, 18, 18)
                .addComponent(read_label)
                .addGap(18, 18, 18)
                .addComponent(update_label)
                .addGap(18, 18, 18)
                .addComponent(delete_label)
                .addGap(162, 162, 162))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(email_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(read_label)
                    .addComponent(update_label)
                    .addComponent(delete_label)
                    .addComponent(create_label))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Administrator", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 255));
        jLabel19.setText("Airline Company Information");

        jLabel27.setForeground(new java.awt.Color(0, 102, 255));
        jLabel27.setText("Company Name:");

        jLabel28.setForeground(new java.awt.Color(0, 102, 255));
        jLabel28.setText("Address:");

        jLabel29.setForeground(new java.awt.Color(0, 102, 255));
        jLabel29.setText("License No:");

        jLabel30.setForeground(new java.awt.Color(0, 102, 255));
        jLabel30.setText("Contact No.");

        jLabel31.setForeground(new java.awt.Color(0, 102, 255));
        jLabel31.setText("Email Add:");

        jLabel32.setForeground(new java.awt.Color(0, 102, 255));
        jLabel32.setText("Password:");

        create_label_info.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        create_label_info.setForeground(new java.awt.Color(0, 102, 255));
        create_label_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q3.png"))); // NOI18N
        create_label_info.setText("Create");
        create_label_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_label_infoMouseClicked(evt);
            }
        });

        table_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Company Id", "Company Name", "Address", "License No.", "Contact No.", "Email Add", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_info.setSelectionBackground(new java.awt.Color(0, 102, 204));
        table_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_infoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_info);

        read_label_info.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        read_label_info.setForeground(new java.awt.Color(0, 102, 255));
        read_label_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q1.png"))); // NOI18N
        read_label_info.setText("Read");
        read_label_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                read_label_infoMouseClicked(evt);
            }
        });

        update_label_info.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update_label_info.setForeground(new java.awt.Color(0, 102, 255));
        update_label_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q2.png"))); // NOI18N
        update_label_info.setText("Update");
        update_label_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_label_infoMouseClicked(evt);
            }
        });

        delete_label_info.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_label_info.setForeground(new java.awt.Color(0, 102, 255));
        delete_label_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q.png"))); // NOI18N
        delete_label_info.setText("Delete");
        delete_label_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_label_infoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 909, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(company_name_info)
                            .addComponent(address_info)
                            .addComponent(password_info)
                            .addComponent(email_add_info)
                            .addComponent(contact_info)
                            .addComponent(license_no, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(create_label_info)
                        .addGap(18, 18, 18)
                        .addComponent(read_label_info)
                        .addGap(18, 18, 18)
                        .addComponent(update_label_info)
                        .addGap(18, 18, 18)
                        .addComponent(delete_label_info)
                        .addGap(156, 156, 156)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(company_name_info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(address_info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(license_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(contact_info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(email_add_info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(password_info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(read_label_info)
                    .addComponent(update_label_info)
                    .addComponent(delete_label_info)
                    .addComponent(create_label_info))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Airline Company", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 255));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 255));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 255));
        jLabel26.setText("Customer Information");

        table_cust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer Id", "Name", "Birthdate", "Contact No.", "Address", "Email Add", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cust.setSelectionBackground(new java.awt.Color(0, 102, 204));
        table_cust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_custMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_cust);

        cust_read.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cust_read.setForeground(new java.awt.Color(0, 102, 255));
        cust_read.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q1.png"))); // NOI18N
        cust_read.setText("Read");
        cust_read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cust_readMouseClicked(evt);
            }
        });

        cust_create.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cust_create.setForeground(new java.awt.Color(0, 102, 255));
        cust_create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q3.png"))); // NOI18N
        cust_create.setText("Create");
        cust_create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cust_createMouseClicked(evt);
            }
        });

        cust_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cust_update.setForeground(new java.awt.Color(0, 102, 255));
        cust_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q2.png"))); // NOI18N
        cust_update.setText("Update");
        cust_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cust_updateMouseClicked(evt);
            }
        });

        cust_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cust_delete.setForeground(new java.awt.Color(0, 102, 255));
        cust_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q.png"))); // NOI18N
        cust_delete.setText("Delete");
        cust_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cust_deleteMouseClicked(evt);
            }
        });

        jLabel59.setForeground(new java.awt.Color(0, 102, 255));
        jLabel59.setText("Contact No:");

        jLabel60.setForeground(new java.awt.Color(0, 102, 255));
        jLabel60.setText("Birthdate:");

        jLabel62.setForeground(new java.awt.Color(0, 102, 255));
        jLabel62.setText("Full Name:");

        jLabel63.setForeground(new java.awt.Color(0, 102, 255));
        jLabel63.setText("Email Address:");

        jLabel64.setForeground(new java.awt.Color(0, 102, 255));
        jLabel64.setText("Address:");

        jLabel65.setForeground(new java.awt.Color(0, 102, 255));
        jLabel65.setText("Password");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel59)
                                            .addComponent(jLabel60)
                                            .addComponent(jLabel63)
                                            .addComponent(jLabel64)
                                            .addComponent(jLabel65))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cust_add)
                                            .addComponent(cust_contact)
                                            .addComponent(cust_pass)
                                            .addComponent(cust_email, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                            .addComponent(cust_birth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel62)
                                        .addGap(5, 5, 5)
                                        .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(cust_create)
                                .addGap(18, 18, 18)
                                .addComponent(cust_read)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cust_update)
                                .addGap(18, 18, 18)
                                .addComponent(cust_delete)
                                .addGap(216, 216, 216))))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel23))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel62)
                                    .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel60)
                                    .addComponent(cust_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cust_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel59))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel64)
                                    .addComponent(cust_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cust_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel63))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cust_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cust_create)
                                    .addComponent(cust_read)
                                    .addComponent(cust_update)
                                    .addComponent(cust_delete))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer Information", jPanel6);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel66.setForeground(new java.awt.Color(0, 102, 255));
        jLabel66.setText("Customer Name:");

        jLabel67.setForeground(new java.awt.Color(0, 102, 255));
        jLabel67.setText("Total Cost:");

        jLabel68.setForeground(new java.awt.Color(0, 102, 255));
        jLabel68.setText("Transaction Date:");

        transaction_page.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Customer ID", "Total Cost", "Transaction Date", "Transaction Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transaction_page.setSelectionBackground(new java.awt.Color(0, 102, 204));
        transaction_page.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaction_pageMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(transaction_page);

        trans_read.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        trans_read.setForeground(new java.awt.Color(0, 102, 255));
        trans_read.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q1.png"))); // NOI18N
        trans_read.setText("Read");
        trans_read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trans_readMouseClicked(evt);
            }
        });

        trans_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        trans_delete.setForeground(new java.awt.Color(0, 102, 255));
        trans_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookingsystem/q.png"))); // NOI18N
        trans_delete.setText("Delete");
        trans_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trans_deleteMouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 255));
        jLabel33.setText("Transactions");

        jLabel69.setForeground(new java.awt.Color(0, 102, 255));
        jLabel69.setText("Transaction Time:");

        jLabel70.setForeground(new java.awt.Color(0, 102, 255));
        jLabel70.setText("Transaction ID:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addGap(5, 5, 5)
                                        .addComponent(trans_id_cust, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel68)
                                            .addComponent(jLabel67)
                                            .addComponent(jLabel69))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(trans_time, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                            .addComponent(trans_cost, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                            .addComponent(trans_date, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trans_id, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(trans_read)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trans_delete)
                                .addGap(132, 132, 132)))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(trans_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(trans_id_cust, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(trans_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(trans_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(trans_time, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trans_delete)
                    .addComponent(trans_read))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1119, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transactions", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        System.exit(0);

    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        {
            setState(ICONIFIED);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
        SignUpPage sp = new SignUpPage();
        sp.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Do you want to continue action?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            LandingPage lc = new LandingPage();
            lc.setVisible(true);
        } else if (response == JOptionPane.NO_OPTION) {
            this.setVisible(true);

        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void create_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_labelMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (email_add.getText().equals("") && password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                Date date = birthdate.getDate();
                String strDate = DateFormat.getDateInstance().format(date);
                java.sql.PreparedStatement pst = con.prepareStatement("INSERT INTO `customer`(`user_position`, `customer_id`, `name`, `license_no`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password`) VALUES ('1',null,?,0,?,?,?,?,?)");
                pst.setString(1, fullname.getText());
                pst.setString(2, strDate);
                pst.setString(3, contact.getText());
                pst.setString(4, address.getText());
                pst.setString(5, email_add.getText());
                pst.setString(6, password.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Added new person info.");
                readMe1();
                deleteText();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_create_labelMouseClicked

    private void read_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_read_labelMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql = "SELECT `customer_id`, `name`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password` FROM `customer` WHERE `user_position` = 1;";
            java.sql.ResultSet rs = st.executeQuery(sql);
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
            JOptionPane.showMessageDialog(this, "Database is viewed.");
            readMe1();
            deleteText();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_read_labelMouseClicked

    private void update_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_labelMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (email_add.getText().equals("") && password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                Date date = birthdate.getDate();
                String strDate = DateFormat.getDateInstance().format(date);
                java.sql.PreparedStatement pst = con.prepareStatement("UPDATE `customer` SET `name`=?,`customer_birthdate`=?,`customer_contactno`=?,`customer_address`=?,`customer_emailadd`=?,`customer_password`=? WHERE `customer_emailadd` = ? AND `customer_password` = ?");
                pst.setString(1, fullname.getText());
                pst.setString(2, strDate);
                pst.setString(3, contact.getText());
                pst.setString(4, address.getText());
                pst.setString(5, email_add.getText());
                pst.setString(6, password.getText());
                pst.setString(7, email_add.getText());
                pst.setString(8, password.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Updated the item.");
                readMe1();
                deleteText();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_update_labelMouseClicked

    private void delete_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_labelMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (email_add.getText().equals("") && password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM customer WHERE customer_emailadd = ? ");
                pst.setString(1, email_add.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deleted the item.");
                readMe1();
                deleteText();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_delete_labelMouseClicked

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        viewMe();
    }//GEN-LAST:event_tabelMouseClicked

    private void create_label_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_label_infoMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (email_add_info.getText().equals("") && password_info.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                java.sql.PreparedStatement pst = con.prepareStatement("INSERT INTO `customer`(`user_position`, `customer_id`, `name`, `license_no`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password`) VALUES ('2',null,?,?,0,?,?,?,?)");
                pst.setString(1, company_name_info.getText());
                pst.setString(2, license_no.getText());
                pst.setString(3, contact_info.getText());
                pst.setString(4, address_info.getText());
                pst.setString(5, email_add_info.getText());
                pst.setString(6, password_info.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Added new airline info.");
                readMe2();
                deleteText2();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_create_label_infoMouseClicked

    private void read_label_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_read_label_infoMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            String sql = "SELECT `customer_id`, `name`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password` FROM `customer` WHERE `user_position` = 2;";
            java.sql.ResultSet rs = st.executeQuery(sql);
            table_info.setModel(DbUtils.resultSetToTableModel(rs));
            JOptionPane.showMessageDialog(this, "Database is viewed.");
            readMe2();
            deleteText2();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_read_label_infoMouseClicked

    private void update_label_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_label_infoMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (email_add_info.getText().equals("") && password_info.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                java.sql.PreparedStatement pst = con.prepareStatement("UPDATE `customer` SET `name`=?,`license_no`=?,`customer_contactno`=?,`customer_address`=?,`customer_emailadd`=?,`customer_password`=? WHERE `customer_emailadd` = ? AND `customer_password` = ?");
                pst.setString(1, company_name_info.getText());
                pst.setString(2, license_no.getText());
                pst.setString(3, contact_info.getText());
                pst.setString(4, address_info.getText());
                pst.setString(5, email_add_info.getText());
                pst.setString(6, password_info.getText());
                pst.setString(7, email_add_info.getText());
                pst.setString(8, password_info.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Updated the info of the airline company.");
                readMe2();
                deleteText2();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_update_label_infoMouseClicked

    private void delete_label_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_label_infoMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (email_add_info.getText().equals("") && password_info.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM `customer` WHERE `customer_emailadd` = ?");
                pst.setString(1, email_add_info.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deleted an airline company.");
                readMe2();
                deleteText2();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_delete_label_infoMouseClicked

    private void table_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_infoMouseClicked
        viewMe2();
    }//GEN-LAST:event_table_infoMouseClicked

    private void cust_createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cust_createMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (cust_email.getText().equals("") && cust_email.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                Date date = cust_birth.getDate();
                String strDate = DateFormat.getDateInstance().format(date);
                java.sql.PreparedStatement pst = con.prepareStatement("INSERT INTO `customer`(`user_position`, `customer_id`, `name`, `license_no`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password`) VALUES ('3',null,?,0,?,?,?,?,?)");
                pst.setString(1, cust_name.getText());
                pst.setString(2, strDate);
                pst.setString(3, cust_contact.getText());
                pst.setString(4, cust_add.getText());
                pst.setString(5, cust_email.getText());
                pst.setString(6, cust_pass.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Added new customer info.");
                readMe3();
                deleteText3();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cust_createMouseClicked

    private void cust_readMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cust_readMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql = "SELECT `customer_id`, `name`, `customer_birthdate`, `customer_contactno`, `customer_address`, `customer_emailadd`, `customer_password` FROM `customer` WHERE `user_position` = 3;";
            java.sql.ResultSet rs = st.executeQuery(sql);
            tabel.setModel(DbUtils.resultSetToTableModel(rs));

            JOptionPane.showMessageDialog(this, "Database is viewed.");
            readMe3();
            deleteText3();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cust_readMouseClicked

    private void cust_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cust_updateMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (cust_email.getText().equals("") && cust_email.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                Date date = cust_birth.getDate();
                String strDate = DateFormat.getDateInstance().format(date);
                java.sql.PreparedStatement pst = con.prepareStatement("UPDATE `customer` SET `name`=?,`customer_birthdate`=?,`customer_contactno`=?,`customer_address`=?,`customer_emailadd`=?,`customer_password`=? WHERE `customer_emailadd` = ? AND `customer_password` = ?");
                pst.setString(1, cust_name.getText());
                pst.setString(2, strDate);
                pst.setString(3, cust_contact.getText());
                pst.setString(4, cust_add.getText());
                pst.setString(5, cust_email.getText());
                pst.setString(6, cust_pass.getText());
                pst.setString(7, cust_email.getText());
                pst.setString(8, cust_pass.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Updated the info of the customer.");
                readMe3();
                deleteText3();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cust_updateMouseClicked

    private void cust_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cust_deleteMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (cust_email.getText().equals("") && cust_email.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM customer WHERE customer_emailadd = ? ");
                pst.setString(1, cust_email.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deleted the customer info.");
                readMe3();
                deleteText3();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cust_deleteMouseClicked

    private void table_custMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_custMouseClicked
        viewMe3();
    }//GEN-LAST:event_table_custMouseClicked

    private void transaction_pageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaction_pageMouseClicked
        viewMe4();
    }//GEN-LAST:event_transaction_pageMouseClicked

    private void trans_readMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trans_readMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            java.sql.Statement st = con.createStatement();
            System.out.println("Connected.");
            String sql = "SELECT `transaction_id`, `customer_name`, `total_cost`, `transaction_date`, `transaction_time` FROM `customer_payment`";
            java.sql.ResultSet rs = st.executeQuery(sql);
            transaction_page.setModel(DbUtils.resultSetToTableModel(rs));

            JOptionPane.showMessageDialog(this, "Database is viewed.");
            readMe4();
            deleteText4();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_trans_readMouseClicked

    private void trans_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trans_deleteMouseClicked
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingsystem", "root", "");
            if (trans_id.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please input something");
            } else {
                java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM `customer_payment` WHERE `transaction_id` = ? ");
                pst.setString(1, trans_id.getText());
                int rs = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deleted the customer info.");
                readMe4();
                deleteText4();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_trans_deleteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrator_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrator_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrator_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrator_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrator_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField address_info;
    private com.toedter.calendar.JDateChooser birthdate;
    private javax.swing.JTextField company_name_info;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField contact_info;
    private javax.swing.JLabel create_label;
    private javax.swing.JLabel create_label_info;
    private javax.swing.JTextField cust_add;
    private com.toedter.calendar.JDateChooser cust_birth;
    private javax.swing.JTextField cust_contact;
    private javax.swing.JLabel cust_create;
    private javax.swing.JLabel cust_delete;
    private javax.swing.JTextField cust_email;
    private javax.swing.JTextField cust_name;
    private javax.swing.JTextField cust_pass;
    private javax.swing.JLabel cust_read;
    private javax.swing.JLabel cust_update;
    private javax.swing.JLabel delete_label;
    private javax.swing.JLabel delete_label_info;
    private javax.swing.JTextField email_add;
    private javax.swing.JTextField email_add_info;
    private javax.swing.JTextField fullname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField license_no;
    private javax.swing.JTextField password;
    private javax.swing.JTextField password_info;
    private javax.swing.JLabel read_label;
    private javax.swing.JLabel read_label_info;
    private javax.swing.JTable tabel;
    private javax.swing.JTable table_cust;
    private javax.swing.JTable table_info;
    private javax.swing.JTextField trans_cost;
    private javax.swing.JTextField trans_date;
    private javax.swing.JLabel trans_delete;
    private javax.swing.JTextField trans_id;
    private javax.swing.JTextField trans_id_cust;
    private javax.swing.JLabel trans_read;
    private javax.swing.JTextField trans_time;
    private javax.swing.JTable transaction_page;
    private javax.swing.JLabel update_label;
    private javax.swing.JLabel update_label_info;
    // End of variables declaration//GEN-END:variables
}
