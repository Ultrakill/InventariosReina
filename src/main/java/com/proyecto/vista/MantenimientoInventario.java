/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.vista;

import com.proyecto.beans.Ambiente;
import com.proyecto.beans.Bien;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import com.proyecto.control.AbstractControlador;
import com.proyecto.control.BienControlador;
import com.proyecto.control.InventarioControlador;
import com.proyecto.control.PeriodoControlador;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.commons.beanutils.BeanUtils;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Documentos
 */
public class MantenimientoInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoInventario
     */
    private static MantenimientoInventario instancia;
    
    public MantenimientoInventario() {
        initComponents();
        cargarCombo();
        listar();
    }
    
    public static MantenimientoInventario getInstancia() {
        if (instancia == null) {
            instancia = new MantenimientoInventario();
        }
        return instancia;
    }

    private int accion;
    private List<Inventario> lista;
    private final BienControlador bienControlador = new BienControlador();
    private final InventarioControlador inventarioControlador = new InventarioControlador();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        precioField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        ambienteIdLabel = new javax.swing.JLabel();
        ambienteIdField = new javax.swing.JTextField();
        periodoIdLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        stockField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbestado = new javax.swing.JComboBox();
        cmbperiodo = new javax.swing.JComboBox();
        idLabel1 = new javax.swing.JLabel();
        serieField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bienIdField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        proveedorIdField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Mantenimiento Inventario");

        jLabel1.setText("Buscar: ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        jPanel1.setToolTipText("");

        idLabel.setText("Precio: ");

        nombreLabel.setText("Estado:");

        ambienteIdLabel.setText("Ambiente:");

        ambienteIdField.setEditable(false);

        periodoIdLabel.setText("Periodo:");

        jLabel5.setText("Stock: ");

        jLabel6.setText("Unidades");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccionar --", "BUENO", "REGULAR", "MALO" }));

        cmbperiodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbperiodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbperiodoActionPerformed(evt);
            }
        });

        idLabel1.setText("Serie:");

        jLabel2.setText("Bien: ");

        jLabel3.setText("Proveedor: ");

        bienIdField.setEditable(false);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        proveedorIdField.setEditable(false);

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ambienteIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(periodoIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ambienteIdField)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(serieField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 26, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(13, 13, 13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(proveedorIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(bienIdField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(proveedorIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bienIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(precioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ambienteIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(ambienteIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodoIdLabel)
                    .addComponent(cmbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        jPanel2.setToolTipText("");

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btnmodificar)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblInventario);

        jButton4.setText("Buscar");

        jLabel4.setText("Lista de Inventarios: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DlgAmbienteBusqueda ambienteDialogo = new DlgAmbienteBusqueda(this, true);
        ambienteDialogo.setVisible(true);
        ambienteDialogo.setModal(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        btnguardar.setEnabled(true);
        precioField.setEditable(true);
        ambienteIdField.setEnabled(true);
        cmbperiodo.setEnabled(true);
        cmbestado.setEditable(true);

        btnnuevo.setEnabled(false);
        accion = AbstractControlador.NUEVO;
        bienControlador.prepararCrear();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String palabra = "";
        String palabra2 = "";
        if (accion == 1) {
            palabra = "registrar";
            palabra2 = "registrado";

            if (JOptionPane.showConfirmDialog(this, "¿Desea " + palabra + " el Bien?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                inventarioControlador.getSeleccionado().setPrecio(Integer.valueOf(precioField.getText()));
                //MODIFICAR COMBOBOX
                inventarioControlador.getSeleccionado().setEstado(title);

                inventarioControlador.getSeleccionado().setSerie(Integer.valueOf(serieField.getText()));
                
                bienControlador.buscarPorId(ui);
                this.setAmbiente(null);
                
                inventarioControlador.accion(accion);
                
                System.out.println("se guardo");
                lista.add(inventarioControlador.getSeleccionado());
                if (accion == 1) {
                    JOptionPane.showMessageDialog(this, "Bien " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    precioField.setText(null);
                    cmbestado.setSelectedIndex(0);
                    serieField.setText(null);
                    ambienteIdField.setText(null);
                    cmbperiodo.setSelectedIndex(0);
                    stockField.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Bien no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                precioField.setText(null);
                cmbestado.setSelectedIndex(0);
                serieField.setText(null);
                ambienteIdField.setText(null);
                cmbperiodo.setSelectedIndex(0);
                stockField.setText(null);
                JOptionPane.showMessageDialog(this, "Bien no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        } else if (accion == 2) {
            palabra = "modificar";
            palabra2 = "modificado";

            if (JOptionPane.showConfirmDialog(this, "¿Desea " + palabra + " el Bien?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                if (accion == 2) {
                    JOptionPane.showMessageDialog(this, "Bien " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    precioField.setText(null);
                    cmbestado.setSelectedIndex(0);
                    serieField.setText(null);
                    ambienteIdField.setText(null);
                    cmbperiodo.setSelectedIndex(0);
                    stockField.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Bien no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                precioField.setText(null);
                    cmbestado.setSelectedIndex(0);
                    serieField.setText(null);
                    ambienteIdField.setText(null);
                    cmbperiodo.setSelectedIndex(0);
                    stockField.setText(null);
                JOptionPane.showMessageDialog(this, "Bien no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }

        btnguardar.setEnabled(false);
        precioField.setEnabled(false);
        cmbestado.setEnabled(false);
        ambienteIdField.setEnabled(false);
        cmbperiodo.setEnabled(false);
        stockField.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnmodificar.setEnabled(true);
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:
        accion = AbstractControlador.MODIFICAR;
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        accion = AbstractControlador.ELIMINAR;
        if (tblInventario.getSelectedRow() != -1) {
            Integer codigo = (Integer) tblInventario.getModel().getValueAt(tblInventario.getSelectedRow(), 0);

            Inventario inventario = inventarioControlador.buscarPorId(codigo);

            if (inventario != null) {
                if (JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el Inventario?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    int[] filas = tblInventario.getSelectedRows();
                    for (int i = 0; i < filas.length; i++) {
                        Inventario inventario2 = lista.get(filas[0]);
                        lista.remove(inventario2);
                        inventarioControlador.setSeleccionado(inventario2);
                        inventarioControlador.accion(accion);
                    }
                    if (inventarioControlador.accion(accion) == 3) {
                        JOptionPane.showMessageDialog(this, "Inventario eliminado correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(this, "Inventario no eliminado", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Inventario no eliminado", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbperiodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbperiodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbperiodoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ambienteIdField;
    private javax.swing.JLabel ambienteIdLabel;
    private javax.swing.JTextField bienIdField;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox cmbestado;
    private javax.swing.JComboBox cmbperiodo;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel periodoIdLabel;
    private javax.swing.JTextField precioField;
    private javax.swing.JTextField proveedorIdField;
    private javax.swing.JTextField serieField;
    private javax.swing.JTextField stockField;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    private void listar() {
        lista = inventarioControlador.buscarTodos();
        lista = ObservableCollections.observableList(lista);
        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tblInventario);

        BeanProperty bId = BeanProperty.create("id");
        BeanProperty bPrecio = BeanProperty.create("precio");
        BeanProperty bEstado = BeanProperty.create("estado");        
        BeanProperty bSerie = BeanProperty.create("serie");
        BeanProperty bProveedorId = BeanProperty.create("ProveedorId");
        BeanProperty bBienId = BeanProperty.create("BienId");
        BeanProperty bAmbienteId = BeanProperty.create("AmbienteId");
        BeanProperty bPeriodoId = BeanProperty.create("PeriodoId");

        binding.addColumnBinding(bId).setColumnName("ID").setEditable(false);
        binding.addColumnBinding(bPrecio).setColumnName("PRECIO").setEditable(false);
        binding.addColumnBinding(bEstado).setColumnName("ESTADO").setEditable(false);
        binding.addColumnBinding(bSerie).setColumnName("SERIE_ID").setEditable(false);
        binding.addColumnBinding(bProveedorId).setColumnName("PROVEEDOR_ID").setEditable(false);
        binding.addColumnBinding(bBienId).setColumnName("BIEN_ID").setEditable(false);
        binding.addColumnBinding(bAmbienteId).setColumnName("AMBIENTE_ID").setEditable(false);
        binding.addColumnBinding(bPeriodoId).setColumnName("PERIODO_ID").setEditable(false);

        binding.bind();

    }

    public void setAmbiente(Ambiente ambiente) {
        this.inventarioControlador.getSeleccionado().setAmbiente(ambiente);
        this.ambienteIdField.setText(this.inventarioControlador.getSeleccionado().getAmbiente().getNombre());
    }

    public void setElemento(String propiedad, Object valor) {
        try {
            BeanUtils.setProperty(this.inventarioControlador.getSeleccionado(), propiedad, valor);
            this.mostrar(propiedad);

        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(MantenimientoBien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar(String propiedad) {
        if (propiedad.equals("ambienteId")) {
            this.ambienteIdField.setText(this.inventarioControlador.getSeleccionado().getAmbiente().getNombre());
        }else if(propiedad.equals("bienId")){
            this.bienIdField.setText(this.inventarioControlador.getSeleccionado().getBien().getNombre());
        }else if(propiedad.equals("proveedorId")){
            this.proveedorIdField.setText(this.inventarioControlador.getSeleccionado().getProveedor().getNombreProveedor());
        }
    }
    
     private void cargarCombo() {
         DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
         PeriodoControlador periodoControlador = new PeriodoControlador();
         List<Periodo> periodo = periodoControlador.buscarTodos();
         modeloCombo.addElement("-- Seleccionar --");
         for (int i = 0; i < periodo.size(); i++) {
             modeloCombo.addElement(periodo.get(i).getPeriodo());
         }
         cmbperiodo.setModel(modeloCombo);
     }
}
