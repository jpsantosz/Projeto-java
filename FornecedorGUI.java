package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FornecedorGUI extends JFrame {
    private JTextField cnpjField, nomeField, logradouroField, numeroField, cidadeField, telefoneField;
    private JComboBox<String> estadoComboBox;
    private JButton limparButton, enviarButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public FornecedorGUI() {
        setTitle("Cadastro de Fornecedor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("CNPJ:"), gbc);
        gbc.gridx = 1;
        cnpjField = new JTextField(15);
        inputPanel.add(cnpjField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        nomeField = new JTextField(15);
        inputPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Logradouro:"), gbc);
        gbc.gridx = 1;
        logradouroField = new JTextField(15);
        inputPanel.add(logradouroField, gbc);

        gbc.gridx = 15;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Número:"), gbc);
        gbc.gridx = 20;
        numeroField = new JTextField(5);
        inputPanel.add(numeroField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("Cidade:"), gbc);
        gbc.gridx = 1;
        cidadeField = new JTextField(15);
        inputPanel.add(cidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(new JLabel("Estado:"), gbc);
        gbc.gridx = 1;
        String[] estados = {"RJ", "SP", "MG", "ES"};
        estadoComboBox = new JComboBox<>(estados);
        inputPanel.add(estadoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        telefoneField = new JTextField(15);
        inputPanel.add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        limparButton = new JButton("Limpar");
        inputPanel.add(limparButton, gbc);
        gbc.gridx = 1;
        enviarButton = new JButton("Enviar");
        inputPanel.add(enviarButton, gbc);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        tableModel.addColumn("CNPJ");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Logradouro");
        tableModel.addColumn("Número");
        tableModel.addColumn("Cidade");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Telefone");

        JScrollPane scrollPane = new JScrollPane(dataTable);
        tablePanel.add(new JLabel("Fornecedores Cadastrados:"), BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFornecedor();
            }
        });
    }

    private void limparCampos() {
        cnpjField.setText("");
        nomeField.setText("");
        logradouroField.setText("");
        numeroField.setText("");
        cidadeField.setText("");
        estadoComboBox.setSelectedIndex(0);
        telefoneField.setText("");
    }

    private void cadastrarFornecedor() {
        String cnpj = cnpjField.getText();
        String nome = nomeField.getText();
        String logradouro = logradouroField.getText();
        String numero = numeroField.getText();
        String cidade = cidadeField.getText();
        String estado = (String) estadoComboBox.getSelectedItem();
        String telefone = telefoneField.getText();

        if (!cnpj.isEmpty() && !nome.isEmpty() && !logradouro.isEmpty() && !numero.isEmpty() &&
                !cidade.isEmpty() && !telefone.isEmpty()) {
            tableModel.addRow(new Object[]{cnpj, nome, logradouro, numero, cidade, estado, telefone});
            JOptionPane.showMessageDialog(this, "DADOS CADASTRADOS COM SUCESSO!", "Dados cadastrados", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

