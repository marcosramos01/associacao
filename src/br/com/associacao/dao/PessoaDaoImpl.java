/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Pessoa;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa(nome, email, telefone) "
                + "VALUES(?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //utiliza quando usar outra tabela para gerar o id quando salvar
            preparando.setString(1, pessoa.getNome());
            preparando.setString(2, pessoa.getEmail());
            preparando.setString(3, pessoa.getTelefone());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys(); //utilizar quando usar outra tabela para pegar a chave primaria
            resultSet.next(); //acessar resultset para verificar se tem registro
            pessoa.setId(resultSet.getInt(1)); //retorna o primeiro valor de resultset

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar pessoa " + eSQL.getMessage());
        }
    }

    public void alterar(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, pessoa.getNome());
            preparando.setString(2, pessoa.getEmail());
            preparando.setString(3, pessoa.getTelefone());
            preparando.setDouble(4, pessoa.getId());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar pessoa " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}
