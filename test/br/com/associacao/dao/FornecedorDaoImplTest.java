/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Endereco;
import br.com.associacao.entidade.Fornecedor;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author HP
 */
public class FornecedorDaoImplTest {
    
    private Fornecedor fornecedor;
    private FornecedorDaoImpl fornecedorDaoImpl;
    
    public FornecedorDaoImplTest() {
        fornecedorDaoImpl = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        
        List<Endereco> enderecos = new ArrayList<>();
        fornecedor = new Fornecedor(null, UtilGerador.gerarNumero(8),
                UtilGerador.gerarNumero(9),
                UtilGerador.gerarNome(),
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo());
        
        for (int i = 0; i < 2; i++) {
            enderecos.add(gerarEndereco());
        }
        
        fornecedor.setEnderecos(enderecos);
        fornecedorDaoImpl.salvar(fornecedor);
        
    }
    
//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
         fornecedor = fornecedorDaoImpl.pesquisarPorId(38);
         fornecedor.setNome("Nome alterado");
         fornecedor.setCnpj("302.236.555-0001-88");
         for (int i = 0; i < fornecedor.getEnderecos().size(); i++) {
             fornecedor.getEnderecos().get(i).setLogradouro("log alterado 0" +i);
        }
      fornecedorDaoImpl.alterar(fornecedor);
    }
//    @Test
    private Endereco gerarEndereco() {
        Endereco endereco = new Endereco(null, "Rua " + UtilGerador.gerarCaracter(10), UtilGerador.gerarNumero(3),
                "Bairro " + UtilGerador.gerarCaracter(10), "Cidade " + UtilGerador.gerarCaracter(10), "Estado " + UtilGerador.gerarCaracter(2),
                "CEP " + UtilGerador.gerarNumero(5) + "-" + UtilGerador.gerarNumero(3));
        return endereco;
    }

//    @Test
    public void testExcluir() throws Exception {
        fornecedorDaoImpl.excluir(40);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        fornecedor = fornecedorDaoImpl.pesquisarPorId(40);
        mostraFornecedor(fornecedor);
        
    }
    
    private void mostraFornecedor(Fornecedor fornecedor) {
        System.out.println("id Fornecedor: " + fornecedor.getId());
        System.out.println("Fornecedor: " + fornecedor.getNome());
        System.out.println("E-mail: " + fornecedor.getEmail());
        System.out.println("Telefone: " + fornecedor.getTelefone());
        System.out.println("CNPJ: " + fornecedor.getCnpj());
        System.out.println("IE: " + fornecedor.getInscricaoEstadual());
        for (Endereco endereco : fornecedor.getEnderecos()) {
            System.out.println("");
            System.out.println("id Endereco: " + endereco.getId());
            System.out.println("Logradouro: " + endereco.getLogradouro());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println("CEP: " + endereco.getCep());
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("Cidade: " + endereco.getCidade());
            System.out.println("Estado: " + endereco.getEstado());
            
        }
        System.out.println("");
    }
    
//    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        List<Fornecedor> fornecedores = fornecedorDaoImpl.pesquisarPorNome("");
        for (Fornecedor forn : fornecedores) {
            mostraFornecedor(forn);
            
        }
        
    }

    
}
