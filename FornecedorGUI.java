package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FornecedorGUI extends JFrame {
     // Campos de entrada de dados
    private JTextField cnpjField, nomeField, logradouroField, numeroField, cidadeField, telefoneField;
    // Componentes de seleção
    private JComboBox<String> estadoComboBox;
    // Botões
    private JButton limparButton, enviarButton;
    // Tabela e modelo de tabela
    private JTable dataTable;
    private DefaultTableModel tableModel;

    // Construtor da classe
    public FornecedorGUI() {
         // Configuração da janela principal
        setTitle("Cadastro de Fornecedor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal usando layout BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

         // Painel de entrada de dados usando layout GridBagLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Adiciona componentes ao painel de entrada de dados
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

         // Adiciona botões ao painel de entrada de dados
        gbc.gridx = 0;
        gbc.gridy = 7;
        limparButton = new JButton("Limpar");
        inputPanel.add(limparButton, gbc);
        gbc.gridx = 1;
        enviarButton = new JButton("Enviar");
        inputPanel.add(enviarButton, gbc);

        // Painel da tabela usando layout BorderLayout
        JPanel tablePanel = new JPanel(new BorderLayout());
        // Criação e configuração da tabela e modelo de tabela
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

        // Adiciona os painéis ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Adiciona o painel principal ao conteúdo da janela
        getContentPane().add(mainPanel);

        // Adiciona ouvintes de ação aos botões
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

    // Método para limpar os campos de entrada
    private void limparCampos() {
        cnpjField.setText("");
        nomeField.setText("");
        logradouroField.setText("");
        numeroField.setText("");
        cidadeField.setText("");
        estadoComboBox.setSelectedIndex(0);
        telefoneField.setText("");
    }

    // Método para cadastrar um fornecedor na tabela
    private void cadastrarFornecedor() {
        // Obtém os valores dos campos de entrada
        String cnpj = cnpjField.getText();
        String nome = nomeField.getText();
        String logradouro = logradouroField.getText();
        String numero = numeroField.getText();
        String cidade = cidadeField.getText();
        String estado = (String) estadoComboBox.getSelectedItem();
        String telefone = telefoneField.getText();

        // Verifica se todos os campos obrigatórios estão preenchidos
        if (!cnpj.isEmpty() && !nome.isEmpty() && !logradouro.isEmpty() && !numero.isEmpty() &&
                !cidade.isEmpty() && !telefone.isEmpty()) {
            // Adiciona uma nova linha à tabela com os dados do fornecedor
            tableModel.addRow(new Object[]{cnpj, nome, logradouro, numero, cidade, estado, telefone});
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(this, "DADOS CADASTRADOS COM SUCESSO!", "Dados cadastrados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Exibe uma mensagem de erro se algum campo estiver vazio
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}