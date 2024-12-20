/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp_perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FAWKES
 */
public class ANGGOTA extends javax.swing.JInternalFrame {

    Connection conn;
    Statement stm;
    ResultSet rs;
    
    /**
     * Creates new form rockwell_what
     */
    public ANGGOTA() {
        initComponents();
        //this.setLocation(130,120);
        siapIsi(false);
        tombolNormal();
        tampildaftaranggota();
        
    }
    
    public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan","root","");
            stm=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
    
    private void kodeanggota(){
        try {
            setKoneksi();
            String sql="select right (kodeanggota,2)+1 from tb_anggota ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    txkodeanggota.setText("KA"+no);}
                }
            else
            {
                txkodeanggota.setText("KA001"); 
        }
        } catch (Exception e) 
        {
        } 
    }
    
    private void siapIsi(boolean a){
        txkodeanggota.setEnabled(a);
        txnama.setEnabled(a);
        txnpm.setEnabled(a);
        txprogramstudi.setEnabled(a);
        txnomerhp.setEnabled(a);
        txalamat.setEnabled(a);
    }
    
    private void tombolNormal(){
        bttambah.setEnabled(true);
        btsimpan.setEnabled(false);
        bthapus.setEnabled(false);
        btedit.setEnabled(false);
        btcari.setEnabled(true);
        
    }
    
    private void bersih(){
        txkodeanggota.setText("");
        txnama.setText("");
        txnpm.setText("");
        txprogramstudi.setText("");     
        txnomerhp.setText("");
        txalamat.setText("");
    }
    
    private void simpan(){
        try{
            setKoneksi();
            String sql="insert into tb_anggota values('"+txkodeanggota.getText()
                    +"','"+txnama.getText()
                    +"','"+txnpm.getText()
                    +"','"+txprogramstudi.getText()
                    +"','"+txnomerhp.getText()
                    +"','"+txalamat.getText() +"')";
            stm.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"SIMPAN DATA ANGGOTA BERHASIL :)");
            }
            catch (Exception e) {
        }
        tampildaftaranggota();
       
    }
    
    
    
    private void perbarui(){
        try{
            setKoneksi();
            String sql="update tb_anggota set nama='"+txnama.getText()
                    +"',npm='"+txnpm.getText()
                    +"',programstudi='"+txprogramstudi.getText()
                    +"',nomerhp='"+txnomerhp.getText()
                    +"',alamat='"+txalamat.getText()
                    +"' where kodeanggota='"+txkodeanggota.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"EDIT DATA ANGGOTA BERHASIL","",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(Exception e){
        }
        tampildaftaranggota();
        
    }
    
    private void hapus(){
        try{
            String sql="delete from tb_anggota where kodeanggota='"+ txkodeanggota.getText() +"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "DATA ANGGOTA TELAH DIHAPUS");
            }
            catch (Exception e) {
            }
        tampildaftaranggota();
    }
    
    public void tampildaftaranggota(){
        Object header[]={"KodeAnggota","Nama","Npm","ProgramStudi","NoHp","Alamat"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelanggota.setModel(data);
        setKoneksi();
        String sql="select*from tb_anggota";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txkodeanggota = new javax.swing.JTextField();
        txnama = new javax.swing.JTextField();
        txnpm = new javax.swing.JTextField();
        txprogramstudi = new javax.swing.JTextField();
        txnomerhp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txalamat = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        bttambah = new javax.swing.JButton();
        btsimpan = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        txpencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelanggota = new javax.swing.JTable();
        btcari = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ENTRY DATA ANGGOTA");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KODE ANGGOTA");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NPM");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PROGRAM STUDI");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NOMER TLP/HP");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ALAMAT");

        txkodeanggota.setEditable(false);
        txkodeanggota.setBackground(new java.awt.Color(204, 204, 204));
        txkodeanggota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txkodeanggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txkodeanggotaActionPerformed(evt);
            }
        });

        txnama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamaActionPerformed(evt);
            }
        });

        txnpm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txnpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnpmActionPerformed(evt);
            }
        });

        txprogramstudi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txprogramstudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txprogramstudiActionPerformed(evt);
            }
        });

        txnomerhp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txnomerhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnomerhpActionPerformed(evt);
            }
        });

        txalamat.setColumns(20);
        txalamat.setRows(5);
        jScrollPane1.setViewportView(txalamat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txkodeanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txnpm, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txprogramstudi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txnomerhp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txnomerhp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txkodeanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txnpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txprogramstudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        bttambah.setBackground(new java.awt.Color(0, 0, 0));
        bttambah.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        bttambah.setForeground(new java.awt.Color(255, 255, 255));
        bttambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon (24).png"))); // NOI18N
        bttambah.setText("TAMBAH");
        bttambah.setPreferredSize(new java.awt.Dimension(87, 40));
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        btsimpan.setBackground(new java.awt.Color(0, 0, 0));
        btsimpan.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon (21).png"))); // NOI18N
        btsimpan.setText("SIMPAN");
        btsimpan.setPreferredSize(new java.awt.Dimension(87, 40));
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        btedit.setBackground(new java.awt.Color(0, 0, 0));
        btedit.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btedit.setForeground(new java.awt.Color(255, 255, 255));
        btedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon (57).png"))); // NOI18N
        btedit.setText("EDIT");
        btedit.setPreferredSize(new java.awt.Dimension(87, 40));
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditActionPerformed(evt);
            }
        });

        bthapus.setBackground(new java.awt.Color(0, 0, 0));
        bthapus.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        bthapus.setForeground(new java.awt.Color(255, 255, 255));
        bthapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon (26).png"))); // NOI18N
        bthapus.setText("HAPUS");
        bthapus.setPreferredSize(new java.awt.Dimension(87, 40));
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btedit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthapus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btedit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bthapus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txpencarian.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txpencarian.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txpencarian.setText("KETIK KODE ANGGOTA UNTUK MENCARI ANGGOTA");
        txpencarian.setPreferredSize(new java.awt.Dimension(87, 30));
        txpencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txpencarianActionPerformed(evt);
            }
        });
        txpencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txpencarianKeyPressed(evt);
            }
        });

        tabelanggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelanggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelanggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelanggota);

        btcari.setBackground(new java.awt.Color(0, 0, 0));
        btcari.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btcari.setForeground(new java.awt.Color(255, 255, 255));
        btcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon (45).png"))); // NOI18N
        btcari.setText("CARI");
        btcari.setPreferredSize(new java.awt.Dimension(87, 40));
        btcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btcari, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txpencarian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btcari, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 865, 360);
    }// </editor-fold>//GEN-END:initComponents

    private void txnomerhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnomerhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnomerhpActionPerformed

    private void txprogramstudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txprogramstudiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txprogramstudiActionPerformed

    private void txnpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnpmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnpmActionPerformed

    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamaActionPerformed

    private void txkodeanggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txkodeanggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txkodeanggotaActionPerformed

    private void btcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcariActionPerformed
        // TODO add your handling code here:

        Object header[]={"KodeAnggota","Nama","Npm","ProgramStudi","NoHp","Alamat"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelanggota.setModel(data);
        setKoneksi();
        String sql="Select * from tb_anggota where kodeanggota like '%" + txpencarian.getText() + "%'" + "or nama like '%" +txpencarian.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btcariActionPerformed

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
        // TODO add your handling code here:
        if(bttambah.getText().equalsIgnoreCase("TAMBAH")){
            bttambah.setText("BATAL");
            bersih();
            siapIsi(true);
            kodeanggota();

            txkodeanggota.setEnabled(true);
            txnama.setEnabled(true);
            bttambah.setEnabled(true);
            btsimpan.setEnabled(true);
            bthapus.setEnabled(false);
            btedit.setEnabled(false);
            btcari.setEnabled(false);

        } else{
            bttambah.setText("TAMBAH");
            bersih();
            siapIsi(false);
            tombolNormal();
            tampildaftaranggota();
        }
    }//GEN-LAST:event_bttambahActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        // TODO add your handling code here:
        if(txkodeanggota.getText().isEmpty()
                ||txnama.getText().isEmpty()
                || txnpm.getText().isEmpty()
                ||txprogramstudi.getText().isEmpty()
                ||txnomerhp.getText().isEmpty()
                ||txalamat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "LENGKAPI INPUTAN DATA!!!","",JOptionPane.INFORMATION_MESSAGE);
        } else{

            if(bttambah.getText().equalsIgnoreCase("BATAL")){
                if(bttambah.getText().equalsIgnoreCase("BATAL")){
                    simpan();
                } else{
                    JOptionPane.showMessageDialog(null, "SIMPAN DATA GAGAL, PERIKSA KEMBALI :( ","",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(btedit.getText().equalsIgnoreCase("BATAL")){
                if(btedit.getText().equalsIgnoreCase("BATAL")){
                    perbarui();
                } else{
                    JOptionPane.showMessageDialog(null, "EDIT DATA GAGAL, PERIKSA KEMBALI :( ","",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            bersih();
            siapIsi(false);
            bttambah.setText("TAMBAH");
            btedit.setText("EDIT");
            tombolNormal();
        }
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        // TODO add your handling code here:
        if(btedit.getText().equalsIgnoreCase("EDIT")){
            btedit.setText("BATAL");
            siapIsi(true);
            txkodeanggota.setEnabled(false);
            bttambah.setEnabled(false);
            btsimpan.setEnabled(true);
            bthapus.setEnabled(false);
            btedit.setEnabled(true);
            btcari.setEnabled(false);
        } else{
            btedit.setText("EDIT");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_bteditActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        // TODO add your handling code here:
        int pesan=JOptionPane.showConfirmDialog(null, "YAKIN DATA AKAN DIHAPUS ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION){
            if(pesan==JOptionPane.YES_OPTION){
                hapus();
                bersih();
                siapIsi(false);
                tombolNormal();
            } else{
                JOptionPane.showMessageDialog(null, "HAPUS DATA GAGAL :(");
            }
        }
    }//GEN-LAST:event_bthapusActionPerformed

    private void txpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txpencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txpencarianActionPerformed

    private void txpencarianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpencarianKeyPressed
        // TODO add your handling code here:
        Object header[]={"KodeAnggota","Nama","Npm","ProgramStudi","NoHp","Alamat"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelanggota.setModel(data);
        setKoneksi();
        String sql="Select * from tb_anggota where kodeanggota like '%" + txpencarian.getText() + "%'" + "or nama like '%" +txpencarian.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txpencarianKeyPressed

    private void tabelanggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelanggotaMouseClicked
        // TODO add your handling code here:
        int baris = tabelanggota.getSelectedRow();
        txkodeanggota.setText(tabelanggota.getModel().getValueAt(baris, 0).toString());
        txnama.setText(tabelanggota.getModel().getValueAt(baris, 1).toString());
        txnpm.setText(tabelanggota.getModel().getValueAt(baris, 2).toString());
        txprogramstudi.setText(tabelanggota.getModel().getValueAt(baris, 3).toString());
        txnomerhp.setText(tabelanggota.getModel().getValueAt(baris, 4).toString());
        txalamat.setText(tabelanggota.getModel().getValueAt(baris, 5).toString());
        bthapus.setEnabled(true);
        btedit.setEnabled(true);
    }//GEN-LAST:event_tabelanggotaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcari;
    private javax.swing.JButton btedit;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelanggota;
    private javax.swing.JTextArea txalamat;
    private javax.swing.JTextField txkodeanggota;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txnomerhp;
    private javax.swing.JTextField txnpm;
    private javax.swing.JTextField txpencarian;
    private javax.swing.JTextField txprogramstudi;
    // End of variables declaration//GEN-END:variables
}
