
package com.myapp.bai2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.awt.*;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import com.myapp.bai2.Student;
import com.myapp.bai2.FrameFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameQLSV extends javax.swing.JFrame {
    List <Student> list = new ArrayList<Student>();
    Student x;
    private static int pos = 0;
    private static int check = 0;
    
    public FrameQLSV() {
        initComponents();
//        list.add(new Student("1111", "Kim Ngân", "2002-12-29"));
        View();
        ViewTable();
    }
    public void View(){        
        if (pos >= 0 && pos < list.size()){
            x = list.get(pos);
            this.jTFMssv.setText("" + x.getMssv());
            this.jTFName.setText(x.getName());
            this.jTFDate.setText(x.getDate());
        }else{
            this.jTFMssv.setText("");
            this.jTFName.setText("");
            this.jTFDate.setText("");
        }

        
//        OnOff(true, true, true, true, false, false, false, false, false, false, false );
    }
    public void OnOff(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h, boolean i, boolean j, boolean k){
        this.btnSave.show(e);
        this.btnCancel.show(f);
        this.btnEdit.show(g);
        this.btnDelete.show(h);
        this.btnOpenFile.show(i);
        this.btnSaveFile.show(j);
        this.btnCancelFile.show(k);
//        --------------------------
        this.btnAdd.show(a);
        this.btnFile.show(b);
        this.btnCsdl.show(c);
        this.btnExit.show(d);
        
    }
    public void ViewTable(){
        DefaultTableModel model = (DefaultTableModel) this.jTbListStudent.getModel();
        model.setNumRows(0);
        for(Student x:list){
            model.addRow(new Object[]{x.getMssv(), x.getName(), x.getDate()});
        } 
    }
    // hàm check mã sv có tồn tại trong bảng ko
    public boolean isStudentIdExist(String MSSV) {
    for (Student student : list) {
        if (student.getMssv().equals(MSSV)) {
            return true;
        }
    }
    return false;
    }
    // hàm lấy mssv
    public Student findStudentById(String id) {
    for (Student student : list) {
        if (student.getMssv().equals(id)) {
            return student;
        }
    }
    return null;
    }
    //
    public void deleteStudentById(String id) {
        for (Iterator<Student> iterator = list.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.getMssv().equals(id)) {
                iterator.remove();
            }
        }
    }
    
    public void editStudent(String id) {
        id = jTFMssv.getText();
        String name = jTFName.getText();
        String date = jTFDate.getText();
        for (Iterator<Student> iterator = list.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.getMssv().equals(id)) {
                student.setMssv(id);
                student.setName(name);
                student.setDate(date);
            }
        }
    }
    
    private static void saveFile(File fileToSave) {
        try {
            FileWriter writer = new FileWriter(fileToSave);
            // write something to file
            writer.write("Hello, World!");
            writer.close();
            System.out.println("Saved to " + fileToSave.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred when trying to write to file: " + fileToSave.getAbsolutePath());
            e.printStackTrace();
        }
    }
    
    public static void openFile(File fileToOpen) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToOpen));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFMssv = new javax.swing.JTextField();
        jTFName = new javax.swing.JTextField();
        jTFDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new java.awt.Button();
        btnSave = new java.awt.Button();
        btnEdit = new java.awt.Button();
        btnDelete = new java.awt.Button();
        btnCancel = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbListStudent = new javax.swing.JTable();
        btnFile = new java.awt.Button();
        btnCsdl = new java.awt.Button();
        btnExit = new java.awt.Button();
        btnOpenFile = new java.awt.Button();
        btnSaveFile = new java.awt.Button();
        btnCancelFile = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sinh viên");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 1, true));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin sinh viên");

        jLabel2.setText("Mã số sinh viên");

        jLabel3.setText("Tên sinh viên");

        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("(dd/mm/yy)");

        btnAdd.setLabel("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setLabel("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setLabel("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setLabel("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setLabel("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTFMssv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTFDate, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(463, 463, 463)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFMssv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 1, true));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Danh sách sinh viên");

        jTbListStudent.setAutoCreateRowSorter(true);
        jTbListStudent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTbListStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số sinh viên", "Tên", "Ngày sinh"
            }
        ));
        jTbListStudent.setEditingColumn(1);
        jTbListStudent.setFillsViewportHeight(true);
        jTbListStudent.setFocusCycleRoot(true);
        jTbListStudent.setShowGrid(true);
        jTbListStudent.setShowVerticalLines(true);
        jTbListStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTbListStudentMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTbListStudent);

        btnFile.setLabel("File");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        btnCsdl.setLabel("CSDL");
        btnCsdl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCsdlActionPerformed(evt);
            }
        });

        btnExit.setLabel("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnOpenFile.setLabel("Mở File");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        btnSaveFile.setLabel("Lưu File");
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });

        btnCancelFile.setLabel("Hủy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnCsdl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnCancelFile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCsdl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCsdlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCsdlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCsdlActionPerformed

    private void jTbListStudentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbListStudentMousePressed
        pos = this.jTbListStudent.getSelectedRow();
        View();
//        ViewTable();       
    }//GEN-LAST:event_jTbListStudentMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.jTFMssv.setText("");
        this.jTFName.setText("");
        this.jTFDate.setText("");
        
        check = 1;
        
//        OnOff(false, false, false, true, true, true,false, false, true, true, true);
             
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String mssv = this.jTFMssv.getText().trim();
        String name = this.jTFName.getText().trim();
        String date = this.jTFDate.getText().trim();
        // check các textField is not null
        if(name.isEmpty() || mssv.isEmpty() || date.isEmpty()){
            JOptionPane.showMessageDialog(this, 
                    "Mã số sinh viên, tên, ngày sinh không được để trống",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        //check các thông tin ngày sinh có dúng định dạng chưa        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(date, formatter);
        }catch(DateTimeParseException e){
            JOptionPane.showMessageDialog(this, 
                    "Ngày sinh không hợp lệ!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        if(isStudentIdExist(mssv)) {
            JOptionPane.showMessageDialog(this, "Mã số sinh viên đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            list.add(new Student(mssv, name, date));
        }
        
//        if(check==1){
//            list.add(new Student(mssv, name, date));
//        }
//        if(check==-1){
//            list.set(pos, new Student(mssv, name, date));
//        }
        View();        
        ViewTable();    
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        View();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        
//        OnOff(true, false, false, true, false, false, false, false,true, false, true);

    }//GEN-LAST:event_btnFileActionPerformed

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open a file");

            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                openFile(fileToOpen);
                JOptionPane.showMessageDialog(FrameQLSV.this, "File" + fileToOpen.getName() + " đã được mở thành công");
            }
        });
    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = this.jTbListStudent.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) this.jTbListStudent.getModel();
//        check = -1;
        
        if(selectedRow >= 0) {
            String id = jTFMssv.getText();
//            String name = jTFName.getText();
//            String date = jTFDate.getText();

            Student student = findStudentById(id);
            if(student != null) {
//                student.setName(name);
//                student.setDate(date);
                editStudent(id);
                model.fireTableDataChanged(); // refresh the student table
            } 
        }
        
        View();        
        ViewTable();  
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Xử lý sự kiện khi bạn nhấn nút "Delete" (Xóa)
        int selectedRow = jTbListStudent.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) this.jTbListStudent.getModel();

        if(selectedRow >= 0) {
            String id = jTFMssv.getText();
            Student student = findStudentById(id);
            if(student != null) {
                // Hiển thị hộp thoại xác nhận trước khi xóa
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the student " + student.getName() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION) {
                    deleteStudentById(id); // delete the student
                    model.fireTableDataChanged(); // refresh the student table                                
                }
            }  
        }
        View();        
        ViewTable(); 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                if (fileToSave.exists()) {
                    int overwrite = JOptionPane.showConfirmDialog(null,
                            "File " + fileToSave.getName() + " đã tồn tại. Bạn có muốn ghi đè lên không?", "Overwrite?", JOptionPane.YES_NO_OPTION);
                    if (overwrite == JOptionPane.YES_OPTION) {
                        saveFile(fileToSave);
                    }
                } else {                   
                    saveFile(fileToSave);
                    JOptionPane.showMessageDialog(FrameQLSV.this, "File" + fileToSave.getName() + " đã được lưu");
                }
            }
        });
    }//GEN-LAST:event_btnSaveFileActionPerformed


    public static void main(String args[]) {           
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameQLSV().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAdd;
    private java.awt.Button btnCancel;
    private java.awt.Button btnCancelFile;
    private java.awt.Button btnCsdl;
    private java.awt.Button btnDelete;
    private java.awt.Button btnEdit;
    private java.awt.Button btnExit;
    private java.awt.Button btnFile;
    private java.awt.Button btnOpenFile;
    private java.awt.Button btnSave;
    private java.awt.Button btnSaveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDate;
    private javax.swing.JTextField jTFMssv;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTable jTbListStudent;
    // End of variables declaration//GEN-END:variables
}
