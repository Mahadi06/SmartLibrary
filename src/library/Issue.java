/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahadi
 */
public class Issue extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Issue() {
        initComponents();
        connect();
       loadBook();
        loadMember();
        loadIssue();
        
    }
    
    Connection con;
    PreparedStatement preStat;
    
    
   
    
    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lms","root","");
            Class.forName("com.mysql.jdbc.Dreiver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    
    public void loadMember(){
        int column;
            try {
               
                 preStat = con.prepareStatement("SELECT * from members");
                 ResultSet rs = preStat.executeQuery();
                 
                 ResultSetMetaData rsmd = rs.getMetaData();
                 column = rsmd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)memberTable.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector vec = new Vector();
                     
                     for(int i=1; i<=column; i++)
                     {
                         vec.add(rs.getString("member_id"));
                         vec.add(rs.getString("member_name"));
                         vec.add(rs.getString("member_phone"));
                         vec.add(rs.getString("member_email"));
                         vec.add(rs.getString("member_address"));
                                                  
                     }             
                     d.addRow(vec);
                     
                 }    
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void loadIssue(){
        int column;
            try {
               
                 preStat = con.prepareStatement("SELECT * from issues");
                 ResultSet rs = preStat.executeQuery();
                 
                 ResultSetMetaData rsmd = rs.getMetaData();
                 column = rsmd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)issueTable.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector vec = new Vector();
                     
                     for(int i=1; i<=column; i++)
                     {
                         vec.add(rs.getString("issue_id"));
                         vec.add(rs.getString("member_id"));
                         vec.add(rs.getString("member_name"));
                         vec.add(rs.getString("book_id"));
                         vec.add(rs.getString("book_name"));
                         vec.add(rs.getString("issue_date"));
                         vec.add(rs.getString("return_date"));
                         vec.add(rs.getString("status"));
                                                  
                     }             
                     d.addRow(vec);
                     
                 }    
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void loadBook(){
        int column;
            try {
               
                  preStat = con.prepareStatement("SELECT books.book_id, books.book_name, books.author, books.publish_year, "
                         + "categories.category_name from books, categories where books.book_category = "
                         + "categories.category_id");
                 ResultSet rs = preStat.executeQuery();
                 
                 ResultSetMetaData rsmd = rs.getMetaData();
                 column = rsmd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)bookTable.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector vec = new Vector();
                     
                     for(int i=1; i<=column; i++)
                     {
                          vec.add(rs.getString("books.book_id"));
                         vec.add(rs.getString("books.book_name"));
                         vec.add(rs.getString("books.author"));
                         vec.add(rs.getString("books.publish_year"));
                         vec.add(rs.getString("categories.category_name"));
                                                  
                     }             
                     d.addRow(vec);
                     
                 }
  
                
         
                 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        issueBtn = new javax.swing.JButton();
        removeMemberBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bookId = new javax.swing.JTextField();
        memberName = new javax.swing.JTextField();
        memberId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        bookName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        returnDate = new com.toedter.calendar.JDateChooser();
        issueDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        issueId = new javax.swing.JTextField();
        returnBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(64, 115, 158));
        jPanel1.setForeground(java.awt.Color.white);

        jPanel2.setBackground(new java.awt.Color(47, 54, 64));

        jLabel1.setBackground(new java.awt.Color(47, 54, 64));
        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("MANAGE MEMBERS");

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\mahad\\Downloads\\icons8-go-back-100.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Membmer Id");

        issueBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        issueBtn.setText("ISSUE");
        issueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnActionPerformed(evt);
            }
        });

        removeMemberBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeMemberBtn.setText("REMOVE");
        removeMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMemberBtnActionPerformed(evt);
            }
        });

        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEMBER ID", "MEMBER NAME", "PHONE", "EMAIL", "ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        memberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberTable);

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Member Name");

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Book Id");

        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Book Name");

        bookId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIdActionPerformed(evt);
            }
        });

        memberName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        memberName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        memberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNameActionPerformed(evt);
            }
        });

        memberId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        memberId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        memberId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Select Member");

        jLabel7.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Book Issue Data");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BOOK ID", "BOOK NAME", "AUTHOR", "PUBLISHED YEAR", "ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookTable);

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue_Id", "Member Id", "Member Name", "Book Id", "Book Name", "Issue Date", "Return Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(issueTable);

        jLabel8.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Select Book");

        bookName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Issue Date");

        jLabel10.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Return Date");

        jPanel3.setBackground(new java.awt.Color(39, 60, 117));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Issue Id");

        issueId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        returnBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(issueId, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 158, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(issueId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(memberId, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(issueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(bookId, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(memberName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bookName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(issueDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(removeMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(177, 177, 177))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(memberId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(27, 27, 27)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3)))
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(17, 17, 17)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel9))))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel10))
                    .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void issueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnActionPerformed
        // TODO add your handling code here:
        String mId = memberId.getText();
        String mName = memberName.getText();
        String bkId = bookId.getText();
        String bkName = bookName.getText();
        String returnDt = returnDate.getDate().toString();
        String issueDt = issueDate.getDate().toString();
       
        
        try {
            preStat = con.prepareStatement("insert into issues (member_id, member_name, book_id, book_name, issue_date, return_date, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            preStat.setString(1,mId);
            preStat.setString(2,mName);
            preStat.setString(3,bkId);
            preStat.setString(4,bkName);
            preStat.setString(5,issueDt);
            preStat.setString(6,returnDt);
            preStat.setString(7,"Issued");
            
            int n = preStat.executeUpdate();
            
            if(n == 1){
                JOptionPane.showMessageDialog(null,"Book Issued");
                bookName.setText("");
                 bookId.setText("");
                memberName.setText("");
               memberId.setText("");
               
                loadIssue();
            }else{
                JOptionPane.showMessageDialog(this,"Something is wrong");
                bookName.setText("");
                 bookId.setText("");
                memberName.setText("");
               memberId.setText("");
               loadIssue();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_issueBtnActionPerformed

    private void memberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)memberTable.getModel();
        int selectIndex = memberTable.getSelectedRow();

        memberName.setText(d1.getValueAt(selectIndex, 1).toString());
       // bookId.setText(d1.getValueAt(selectIndex, 2).toString());
       //memberName.setText(d1.getValueAt(selectIndex, 3).toString());
       memberId.setText(d1.getValueAt(selectIndex, 0).toString());
       
        
       
    }//GEN-LAST:event_memberTableMouseClicked

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)issueTable.getModel();
        int selectIndex = issueTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        //int bkCategory = (int) bookCategory.getSelectedItem();
        try {
            preStat = con.prepareStatement("update issues set status = ? where issue_id = ? ");
            preStat.setString(1, "Returned");
           
           
            preStat.setInt(2, id);
            
            int n = preStat.executeUpdate();
            
            if(n == 1){
                JOptionPane.showMessageDialog(null,"Book Returned");
                memberName.setText("");
                bookId.setText("");
                memberName.setText("");
                memberId.setText("");
                issueBtn.setEnabled(true);
                loadIssue();
            }else{
                JOptionPane.showMessageDialog(null,"Something is wrong");
               memberName.setText("");
                bookId.setText("");
                memberName.setText("");
               memberId.setText("");
                issueBtn.setEnabled(true);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_returnBtnActionPerformed

    private void removeMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMemberBtnActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)memberTable.getModel();
        int selectIndex = memberTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        
        try {
            preStat = con.prepareStatement("delete from members where member_id = ? ");
            preStat.setInt(1, id);
            
            int n = preStat.executeUpdate();
            
            if(n == 1){
                JOptionPane.showMessageDialog(null,"Member is Deleted");
                memberName.setText("");
                bookId.setText("");
                memberName.setText("");
                memberId.setText("");
              
                issueBtn.setEnabled(true);
                loadMember();
            }else{
                JOptionPane.showMessageDialog(null,"Something is wrong ");
               memberName.setText("");
                bookId.setText("");
                memberName.setText("");
               memberId.setText("");
                issueBtn.setEnabled(true);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeMemberBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.hide();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookIdActionPerformed

    private void memberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberNameActionPerformed

    private void memberIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIdActionPerformed

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();

        
        bookId.setText(d1.getValueAt(selectIndex, 0).toString());
       bookName.setText(d1.getValueAt(selectIndex, 1).toString());
       
       
        
        
        
    }//GEN-LAST:event_bookTableMouseClicked

    private void bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNameActionPerformed

    private void issueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)issueTable.getModel();
        int selectIndex = issueTable.getSelectedRow();
        issueId.setText(d1.getValueAt(selectIndex, 0).toString());
        issueBtn.setEnabled(false);
      
        
    }//GEN-LAST:event_issueTableMouseClicked

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
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Issue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookId;
    private javax.swing.JTextField bookName;
    private javax.swing.JTable bookTable;
    private javax.swing.JButton issueBtn;
    private com.toedter.calendar.JDateChooser issueDate;
    private javax.swing.JTextField issueId;
    private javax.swing.JTable issueTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField memberId;
    private javax.swing.JTextField memberName;
    private javax.swing.JTable memberTable;
    private javax.swing.JButton removeMemberBtn;
    private javax.swing.JButton returnBtn;
    private com.toedter.calendar.JDateChooser returnDate;
    // End of variables declaration//GEN-END:variables
}
