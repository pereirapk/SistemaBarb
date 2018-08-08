package views;
/*
 * TelaAgendamento.java
 *
 * Created on 27 de Novembro de 2002, 16:34
 */

import controls.ModeloTabela;
import java.util.*;
import java.lang.*;
import java.text.*;
import negocios.*;
import dialogos.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
/**
 *
 * @author  leme
 */
public class TelaAgendamento extends javax.swing.JDialog {
    Paciente paciente = null;
    Consulta consulta = null;
    ArrayList servicos = new ArrayList();
    Vector vetor;
    ConexaoBD conex = new ConexaoBD();

    
    /** Creates new form TelaConsulta */
    public TelaAgendamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
      conex.conexao();
        //preencherTabela("select * from aluno order by nome");
  
        vetor = new Vector();
        initComponents();
        
        //jComboBoxTratamento = new javax.swing.JComboBox(dcb);
        carregaPacientes ();
        setLocationRelativeTo(parent);       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jComboBoxPacientes = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();
        jTextField2Horai = new javax.swing.JTextField();
        jTextField2Horaf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAtividade = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jCheckBoxEmergencial = new javax.swing.JCheckBox();
        jTextFieldPacEmerg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTratamento = new javax.swing.JComboBox(vetor);
        jLabel2 = new javax.swing.JLabel();
        jButtonAdServico = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxServicos = new javax.swing.JComboBox();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamento de consulta");
        setName("telaConsulta"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painel.setPreferredSize(new java.awt.Dimension(430, 430));
        painel.setLayout(null);
        painel.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 2, 2);

        jComboBoxPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPacientesActionPerformed(evt);
            }
        });
        painel.add(jComboBoxPacientes);
        jComboBoxPacientes.setBounds(60, 10, 350, 20);

        jLabel1.setText("Cliente");
        painel.add(jLabel1);
        jLabel1.setBounds(20, 10, 90, 14);

        jLabel3.setText("Horário Inicial");
        painel.add(jLabel3);
        jLabel3.setBounds(220, 200, 110, 14);

        jTextFieldDia.setToolTipText("dia");
        painel.add(jTextFieldDia);
        jTextFieldDia.setBounds(260, 160, 130, 30);
        painel.add(jTextField2Horai);
        jTextField2Horai.setBounds(220, 220, 70, 20);
        painel.add(jTextField2Horaf);
        jTextField2Horaf.setBounds(310, 220, 70, 20);

        jLabel4.setText("Horário Final");
        painel.add(jLabel4);
        jLabel4.setBounds(310, 200, 100, 14);

        jLabel5.setText("Descrição da Atividade");
        painel.add(jLabel5);
        jLabel5.setBounds(20, 290, 180, 14);
        painel.add(jTextFieldAtividade);
        jTextFieldAtividade.setBounds(20, 310, 390, 40);

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        painel.add(jButtonOk);
        jButtonOk.setBounds(30, 360, 90, 23);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        painel.add(jButtonCancelar);
        jButtonCancelar.setBounds(275, 360, 120, 23);

        jCheckBoxEmergencial.setText("Emergencial:");
        jCheckBoxEmergencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEmergencialActionPerformed(evt);
            }
        });
        painel.add(jCheckBoxEmergencial);
        jCheckBoxEmergencial.setBounds(20, 50, 110, 23);

        jTextFieldPacEmerg.setEnabled(false);
        jTextFieldPacEmerg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPacEmergActionPerformed(evt);
            }
        });
        painel.add(jTextFieldPacEmerg);
        jTextFieldPacEmerg.setBounds(140, 50, 270, 20);

        jLabel7.setText("Tratamento");
        painel.add(jLabel7);
        jLabel7.setBounds(20, 80, 100, 14);

        jComboBoxTratamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTratamentoActionPerformed(evt);
            }
        });
        painel.add(jComboBoxTratamento);
        jComboBoxTratamento.setBounds(140, 80, 270, 20);

        jLabel2.setText("Data");
        painel.add(jLabel2);
        jLabel2.setBounds(220, 160, 52, 14);

        jButtonAdServico.setText("Adiciona Serviço");
        jButtonAdServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdServicoActionPerformed(evt);
            }
        });
        painel.add(jButtonAdServico);
        jButtonAdServico.setBounds(290, 120, 120, 23);

        jLabel6.setText("Serviços");
        painel.add(jLabel6);
        jLabel6.setBounds(20, 120, 60, 14);

        jComboBoxServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxServicosActionPerformed(evt);
            }
        });
        painel.add(jComboBoxServicos);
        jComboBoxServicos.setBounds(140, 120, 140, 20);
        painel.add(jCalendar1);
        jCalendar1.setBounds(20, 150, 191, 153);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        painel.add(jButtonVoltar);
        jButtonVoltar.setBounds(150, 360, 90, 23);

        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxServicosActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_jComboBoxServicosActionPerformed

    private void jButtonAdServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdServicoActionPerformed
        // Add your handling code here:
        DialogoServico ds = new DialogoServico(new javax.swing.JFrame(), true);
        ds.show();
        Servico serv = ds.getServico();
        servicos.add(serv);
        jComboBoxServicos.addItem(serv);
    }//GEN-LAST:event_jButtonAdServicoActionPerformed

    private void jComboBoxTratamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTratamentoActionPerformed
        // Add your handling code here:
        Object obj = jComboBoxTratamento.getSelectedItem();
        if (obj == null || obj.toString().equals("Nova consulta")) {
            consulta = null;
        } else {
            consulta = (Consulta) obj;
        }
    }//GEN-LAST:event_jComboBoxTratamentoActionPerformed
    
    private void jComboBoxPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPacientesActionPerformed
        paciente = (Paciente) jComboBoxPacientes.getSelectedItem();
        ArrayList lista = paciente.getConsultas();
        jComboBoxTratamento.removeAllItems();
        
        vetor.add(new String("Nova consulta"));

        for (int i = 0; i < lista.size(); i++) {
            // jComboBoxTratamento.addItem(lista.get(i));
            vetor.add (lista.get(i));
        }
    }//GEN-LAST:event_jComboBoxPacientesActionPerformed

    private void carregaPacientes () {
        Consultorio cons = Consultorio.Instance();
        ArrayList lista = cons.getPacientes();       
        for (int i = 0; i < lista.size(); i++) {
            jComboBoxPacientes.addItem(lista.get(i));
        }
    }
    
    private void jCheckBoxEmergencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEmergencialActionPerformed
        // Add your handling code here:
        if (jTextFieldPacEmerg.isEnabled()) {
            jTextFieldPacEmerg.disable();
            jTextFieldPacEmerg.setText("");
            jComboBoxPacientes.enable();
            jComboBoxTratamento.enable();
        } else {
            jTextFieldPacEmerg.enable();
            jTextFieldPacEmerg.setText("digite aqui");
            jComboBoxPacientes.disable();
            jComboBoxTratamento.disable();
            consulta = null;
        }
    }//GEN-LAST:event_jCheckBoxEmergencialActionPerformed

    private void jTextFieldPacEmergActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPacEmergActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_jTextFieldPacEmergActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // Add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setLenient(false);
        boolean dadosValidos = true;
        boolean consultaMarcada = false;
        Consulta novaConsulta = null;
        
        String di = jTextFieldDia.getText() + " " + jTextField2Horai.getText();
        String df = jTextFieldDia.getText() + " " + jTextField2Horaf.getText();
        
        Date dataInic = sdf.parse(di,new ParsePosition(0));
        if (dataInic == null)
        {
            new DialogoConfirmacao(new javax.swing.JFrame(), true, "Erro: data inv\u00e1lida",
                                   "Formato de data inv\u00e1lido.").show();
            dadosValidos = false;
        }

        Date dataFim = sdf.parse(df,new ParsePosition(0));
        if (dataFim == null)
        {
            new DialogoConfirmacao(new javax.swing.JFrame(), true, "Erro: data inv\u00e1lida",
                                   "Formato de data inv\u00e1lido.").show();
            dadosValidos = false;
        }

        if (dadosValidos && dataFim.before(dataInic)) {
            new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Hor�rios inv�lidos.").show();
            dadosValidos = false;
        }

        
        if (dadosValidos) {
            if (jTextFieldPacEmerg.isEnabled()) {
                paciente = new PacienteEmergencial(jTextFieldPacEmerg.getText());
                consulta = null;
            } 
            else if (paciente == null) {
                // Di�logo para selecionar paciente
                new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Selecione Paciente").show();
                return;
            }

            
            if (consulta == null) {
                if (servicos == null) {
                    novaConsulta = paciente.marcaConsulta(new DateRange(dataInic, dataFim), 
                                               jTextFieldAtividade.getText());
                    if (novaConsulta != null) {
                        new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Consulta marcada").show();
                        consultaMarcada = true;
                        setVisible(false);
                        dispose();
                    }                     
                } else {
                        novaConsulta = paciente.marcaConsulta(new DateRange(dataInic, dataFim),
                                               jTextFieldAtividade.getText(),
                                               servicos);
                        if (novaConsulta != null) {
                        new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Consulta marcada").show();
                        consultaMarcada = true;
                        setVisible(false);
                        dispose();
                    } 
                }
            } else {
                if (servicos == null) {
                    novaConsulta = paciente.marcaConsulta(consulta, 
                                           new DateRange(dataInic, dataFim), 
                                           jTextFieldAtividade.getText());
                    if (novaConsulta != null) {
                        new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Consulta marcada").show();
                        consultaMarcada = true;
                        setVisible(false);
                        dispose();
                    } 
                } else {
                    novaConsulta = paciente.marcaConsulta(consulta, new DateRange(dataInic, dataFim), 
                                           jTextFieldAtividade.getText(),servicos);
                    if (novaConsulta != null) {
                        new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Consulta marcada").show();
                        consultaMarcada = true;
                        setVisible(false);
                        dispose();
                    }                     
                }
            }
        }
        if (consultaMarcada) {
           // new TelaReceita(new java.awt.Frame(),true, novaConsulta).show();
            setVisible(false);
            dispose();

        } else {
            new DialogoConfirmacao(new javax.swing.JFrame(), true, "", "Erro: Consulta n�o marcada").show();
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
         Agendamento l = new Agendamento();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed
    
    /**
     * @param args the command line arguments
     */
       /*public void preencherTabela(String SQL){
       ArrayList dados= new ArrayList();
        
        String [] Colunas = new String[]{"CODIGO PESSOA","NOME","IDADE","SEXO","ENDEREÇO","NUMERO","CIDADE","ESTADO"};
        
        conex.executaSql(SQL);;
        try {
            conex.rs.first();
            do{
                dados.add(new Object[]{conex.rs.getInt("id"),conex.rs.getString("nome"),conex.rs.getInt("idade"),conex.rs.getString("sexo"),conex.rs.getString("rua"),conex.rs.getInt("numero"),conex.rs.getString("cidade"),conex.rs.getInt("id"),conex.rs.getString("uf")});
            }while(conex.rs.next());
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"erro ao preencher o ArrayList"+ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        resul.setModel(modelo);
        resul.getColumnModel().getColumn(0).setPreferredWidth(50);
        resul.getColumnModel().getColumn(0).setResizable(false);
        resul.getColumnModel().getColumn(1).setPreferredWidth(110);
        resul.getColumnModel().getColumn(1).setResizable(true);
        resul.getColumnModel().getColumn(2).setPreferredWidth(50);
        resul.getColumnModel().getColumn(2).setResizable(false);
        resul.getColumnModel().getColumn(3).setPreferredWidth(50);
        resul.getColumnModel().getColumn(3).setResizable(false);
        resul.getColumnModel().getColumn(4).setPreferredWidth(80);
        resul.getColumnModel().getColumn(4).setResizable(false);
        resul.getColumnModel().getColumn(5).setPreferredWidth(80);
        resul.getColumnModel().getColumn(5).setResizable(true);
        resul.getColumnModel().getColumn(6).setPreferredWidth(100);
        resul.getColumnModel().getColumn(6).setResizable(false);
        resul.getColumnModel().getColumn(7).setPreferredWidth(50);
        resul.getColumnModel().getColumn(7).setResizable(false);
       
        resul.getTableHeader().setReorderingAllowed(false);
        resul.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        resul.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
          
       */
    
    public static void main(String args[]) {
        new TelaAgendamento(new javax.swing.JFrame(), true).show();        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdServico;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonVoltar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBox jCheckBoxEmergencial;
    private javax.swing.JComboBox jComboBoxPacientes;
    private javax.swing.JComboBox jComboBoxServicos;
    private javax.swing.JComboBox jComboBoxTratamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2Horaf;
    private javax.swing.JTextField jTextField2Horai;
    private javax.swing.JTextField jTextFieldAtividade;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldPacEmerg;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
    
}
